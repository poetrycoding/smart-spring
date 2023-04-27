package com.github.poetrycoding.springframework.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.github.poetrycoding.springframework.factory.config.BeanDefinition;
import com.github.poetrycoding.springframework.factory.config.BeanReference;
import com.github.poetrycoding.springframework.property.PropertyValue;
import com.github.poetrycoding.springframework.property.PropertyValues;
import com.github.poetrycoding.springframework.exception.BeansException;

import java.lang.reflect.Constructor;

/**
 * Description: 综合AbstractBeanFacto1y 并对接口AutowireCapableBeanFactory 进行实现。
 * <br/>
 * AbstractAutowireCapableBeanFactory
 *
 * @author laiql
 * @date 2023/4/26 10:25
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    private InstantiationStrategy instanceStrategy = new JdkSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition bd, Object[] args) throws BeansException {
        Object singletonBeanInstance;
        try {
            singletonBeanInstance = createBeanInstance(beanName, bd, args);
            //Bean属性填充
            applyPropertyValues(beanName, singletonBeanInstance, bd);
        } catch (Exception e) {
            throw new BeansException("Failed to instantiate Bean object", e);
        }
        //注册到单例容器中
        registerSingleton(beanName, singletonBeanInstance);
        return singletonBeanInstance;
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

    public InstantiationStrategy getInstanceStrategy() {
        return instanceStrategy;
    }

    public void setInstanceStrategy(InstantiationStrategy instanceStrategy) {
        this.instanceStrategy = instanceStrategy;
    }
}
