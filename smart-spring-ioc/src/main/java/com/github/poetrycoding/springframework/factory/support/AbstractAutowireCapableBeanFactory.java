package com.github.poetrycoding.springframework.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.github.poetrycoding.springframework.factory.DisposableBean;
import com.github.poetrycoding.springframework.factory.InitializingBean;
import com.github.poetrycoding.springframework.factory.config.AutowireCapableBeanFactory;
import com.github.poetrycoding.springframework.factory.config.BeanDefinition;
import com.github.poetrycoding.springframework.factory.config.BeanPostProcessor;
import com.github.poetrycoding.springframework.factory.config.BeanReference;
import com.github.poetrycoding.springframework.property.PropertyValue;
import com.github.poetrycoding.springframework.property.PropertyValues;
import com.github.poetrycoding.springframework.exception.BeansException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Description: 综合AbstractBeanFacto1y 并对接口AutowireCapableBeanFactory 进行实现。
 * <br/>
 * AbstractAutowireCapableBeanFactory
 *
 * @author laiql
 * @date 2023/4/26 10:25
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {
    private InstantiationStrategy instanceStrategy = new JdkSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition bd, Object[] args) throws BeansException {
        Object bean;
        try {
            bean = createBeanInstance(beanName, bd, args);
            //Bean属性填充
            applyPropertyValues(beanName, bean, bd);
            //执行Bean的初始化方法和BeanPostProcessor的前置和后置处理方法
            bean = initializeBean(bean, beanName, bd);
        } catch (Exception e) {
            throw new BeansException("Failed to instantiate Bean object", e);
        }
        // 注册实现了 DisposableBean 接口的 Bean 对象
        registerDisposableBeanIfNecessary(beanName, bean, bd);

        //注册到单例容器中
        registerSingleton(beanName, bean);
        return bean;
    }

    /**
     * 注册实现了 DisposableBean 接口的 Bean 对象
     *
     * @param beanName bean名称
     * @param bean     bean对象
     * @param bd       bean定义信息
     */
    private void registerDisposableBeanIfNecessary(String beanName, Object bean, BeanDefinition bd) {
        if (bean instanceof DisposableBean || StrUtil.isNotEmpty(bd.getDestroyMethodName())) {
            registerDisposableBean(beanName, new DisposableBeanAdapter(bean, beanName, bd));
        }
    }

    /**
     * 执行Bean的初始化方法
     *
     * @param bean     bean对象
     * @param beanName 名称
     * @param bd       bean定义对象
     * @return 实例对象
     */
    private Object initializeBean(Object bean, String beanName, BeanDefinition bd) throws Exception {
        // 1. 执行 BeanPostProcessor Before 处理
        Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean, beanName);

        // 2. 执行初始化化方法
        invokeInitMethods(beanName, wrappedBean, bd);
        // 3. 执行 BeanPostProcessor After 处理
        wrappedBean = applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
        return wrappedBean;
    }

    private void invokeInitMethods(String beanName, Object wrappedBean, BeanDefinition bd) throws Exception {
        // 1. 检查bean是否实现了initializingBean
        if (wrappedBean instanceof InitializingBean) {
            ((InitializingBean) wrappedBean).afterPropertiesSet();
        }
        // 2. 注解配置 init-method {判断是为了避免二次执行初始化}
        String initMethodName = bd.getInitMethodName();
        if (StrUtil.isNotEmpty(initMethodName) && !(wrappedBean instanceof InitializingBean)) {
            Method initMethod = bd.getBeanClass().getMethod(initMethodName);
            if (null == initMethod) {
                throw new BeansException("Could not find an init method named '" + initMethodName + "' on bean with name '" + beanName + "'");
            }
            initMethod.invoke(wrappedBean);
        }
    }

    private void applyPropertyValues(String beanName, Object singletonBeanInstance, BeanDefinition bd) {
        try {
            PropertyValues propertyValues = bd.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                //获取属性Name
                String propertyValueName = propertyValue.getName();
                //获取属性Value
                Object propertyValueValue = propertyValue.getValue();
                if (propertyValueValue instanceof BeanReference) {
                    // A 依赖 B，获取 B 的实例化
                    BeanReference beanReference = (BeanReference) propertyValueValue;
                    //提前触发引用对象创建
                    propertyValueValue = getBean(beanReference.getBeanName());
                }
                //属性填充
                BeanUtil.setFieldValue(singletonBeanInstance, propertyValueName, propertyValueValue);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }

    }

    private Object createBeanInstance(String beanName, BeanDefinition bd, Object[] args) {
        Constructor constructorToUse = null;
        Class<?> beanClass = bd.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            //对比构造函数长度是否一样来匹配指定的构造器，在Spring中会更复杂，会进行参数类型比较等，比较失败则会进行抛出异常
            if (null != args && declaredConstructor.getParameterTypes().length == args.length) {
                constructorToUse = declaredConstructor;
                break;
            }
        }
        //调用创建实例创建对象
        return getInstanceStrategy().instance(beanName, bd, constructorToUse, args);
    }

    @Override
    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException {
        //bean初始化后 都会调用 注册的BeanPostProcessor的postProcessorAfterInitialization方法进行处理
        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessAfterInitialization(result, beanName);
            if (current == null) {
                return result;
            }
            result = current;
        }
        return result;
    }

    @Override
    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException {
        //bean初始化前 都会调用 注册的BeanPostProcessor的postProcessorBeforInitialization方法进行处理
        Object result = existingBean;
        for (BeanPostProcessor beanPostProcessor : getBeanPostProcessors()) {
            Object current = beanPostProcessor.postProcessBeforeInitialization(result, beanName);
            if (current == null) {
                return result;
            }
            result = current;
        }
        return result;
    }

    public InstantiationStrategy getInstanceStrategy() {
        return instanceStrategy;
    }

    public void setInstanceStrategy(InstantiationStrategy instanceStrategy) {
        this.instanceStrategy = instanceStrategy;
    }

}
