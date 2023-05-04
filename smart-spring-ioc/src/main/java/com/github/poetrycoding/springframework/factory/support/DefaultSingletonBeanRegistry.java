package com.github.poetrycoding.springframework.factory.support;

import cn.hutool.core.lang.Assert;
import com.github.poetrycoding.springframework.exception.BeansException;
import com.github.poetrycoding.springframework.factory.DisposableBean;
import com.github.poetrycoding.springframework.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description: 默认单例bean对象注册
 * <br/>
 * DefaultSingletonBeanRegistry
 *
 * @author laiql
 * @date 2023/4/26 10:07
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    /**
     * 存储单例Bean对象容器
     * 在Spring中是一级缓存，真正存放对象容器
     */
    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);

    /**
     * Internal marker for a null singleton object:
     * used as marker value for concurrent Maps (which don't support null values).
     */
    protected static final Object NULL_OBJECT = new Object();

    /**
     * 存储实现了DisposableBean接口的Bean对象
     */
    private final Map<String, DisposableBean> disposableBeans = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    public void registerDisposableBean(String beanName, DisposableBean bean) {
        disposableBeans.put(beanName, bean);
    }

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        Assert.notNull(beanName, "Bean name must not be null");
        Assert.notNull(singletonObject, "Singleton object must not be null");
        //因为singletonObjects是全局变量，这里定会存在并发访问的情况
        synchronized (this.singletonObjects) {
            //判断Bean是否已经存在一级缓存容器中
            Object oldBeanObject = singletonObjects.get(beanName);
            if (oldBeanObject != null) {
                throw new IllegalStateException("Could not register object [" + singletonObject +
                        "] under bean name '" + beanName + "': there is already object [" + oldBeanObject + "] bound");
            }
            //添加进一级缓存容器，后续涉及三级缓存需要解决同步问题
            this.singletonObjects.put(beanName, singletonObject);
        }
    }

    public void destroySingletons() {
        Set<String> keySet = disposableBeans.keySet();
        Object[] disposableBeanNames = keySet.toArray();
        for (int i = disposableBeanNames.length - 1; i >= 0; i--) {
            Object beanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeans.remove(beanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
            }
        }
    }
}
