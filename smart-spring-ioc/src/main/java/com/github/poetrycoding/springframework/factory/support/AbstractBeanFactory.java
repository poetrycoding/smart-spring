package com.github.poetrycoding.springframework.factory.support;

import com.github.poetrycoding.springframework.exception.BeansException;
import com.github.poetrycoding.springframework.factory.FactoryBean;
import com.github.poetrycoding.springframework.factory.config.BeanDefinition;
import com.github.poetrycoding.springframework.factory.config.BeanPostProcessor;
import com.github.poetrycoding.springframework.factory.config.ConfigurableBeanFactory;
import com.github.poetrycoding.springframework.utils.ClassUtils;
import com.github.poetrycoding.springframework.utils.StringValueResolver;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * BeanDefinition注册工厂，通过模版模式方式实现创建BeanDefinition和注册BeanDefinition，
 * 以及创建BeanDefinition对应的实例
 * <br/>
 * AbstractBeanFactory
 *
 * @author laiql
 * @date 2023/4/26 10:18
 */
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {
    /** ClassLoader to resolve bean class names with, if necessary */
    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    /**
     * BeanPostProcessors to apply in createBean
     */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    /**
     * String resolvers to apply e.g. to annotation attribute values
     */
    private final List<StringValueResolver> embeddedValueResolvers = new ArrayList<>();


    @Override
    public Object getBean(String beanName) throws BeansException {
        return doGetBean(beanName, null);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return doGetBean(beanName, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }


    public <T> T doGetBean(final String beanName, Object[] args) {
        Object sharedInstance = getSingleton(beanName);
        if (sharedInstance != null) {
            // 如果是 FactoryBean，则需要调用 FactoryBean#getObject
            return (T) getObjectForBeanInstance(sharedInstance, beanName);
        }

        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        Object bean = createBean(beanName, beanDefinition, args);
        return (T) getObjectForBeanInstance(bean, beanName);
    }

    private Object getObjectForBeanInstance(Object beanInstance, String beanName) {
        if (!(beanInstance instanceof FactoryBean)) {
            return beanInstance;
        }

        Object object = getCachedObjectForFactoryBean(beanName);

        if (object == null) {
            FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
            object = getObjectFromFactoryBean(factoryBean, beanName);
        }

        return object;
    }


    /**
     * 根据名称获取 BeanDefinition 对象
     *
     * @param beanName 名称
     * @return BeanDefinition
     * @throws BeansException
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;


    /**
     * 根据名称和BeanDefinition 创建对应Bean的实例
     *
     * @param beanName Bean名称
     * @param bd       BeanDefinition
     * @param args     参数
     * @return 实例对象
     * @throws BeansException
     */
    protected abstract Object createBean(String beanName, BeanDefinition bd, Object[] args)
            throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        synchronized (this.beanPostProcessors) {
            this.beanPostProcessors.remove(beanPostProcessor);
            this.beanPostProcessors.add(beanPostProcessor);
        }
    }


    @Override
    public void addEmbeddedValueResolver(StringValueResolver valueResolver) {
        this.embeddedValueResolvers.add(valueResolver);
    }

    @Override
    public String resolveEmbeddedValue(String value) {
        String result = value;
        for (StringValueResolver resolver : this.embeddedValueResolvers) {
            result = resolver.resolveStringValue(result);
        }
        return result;
    }

    /**
     * 提供子类获取所有扩展处理器列表
     *
     * @return List<BeanPostProcessor>
     */
    public List<BeanPostProcessor> getBeanPostProcessors() {
        return beanPostProcessors;
    }

    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }
}
