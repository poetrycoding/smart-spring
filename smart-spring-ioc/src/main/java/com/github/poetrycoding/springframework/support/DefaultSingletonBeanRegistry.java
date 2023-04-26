package com.github.poetrycoding.springframework.support;

import cn.hutool.core.lang.Assert;
import com.github.poetrycoding.springframework.config.SingletonBeanRegistry;

import java.util.Map;
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

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
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
}
