package com.github.poetrycoding.springframework.support;

import com.github.poetrycoding.springframework.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;
import java.util.Objects;

/**
 * Description: Cglib方式实例化对象
 * <br/>
 * CglibSubclassingInstanceStrategy
 *
 * @author laiql
 * @date 2023/4/26 21:00
 */
public class CglibSubclassingInstanceStrategy implements InstanceStrategy {
    @Override
    public Object instance(String beanName, BeanDefinition bd, Constructor constructor, Object[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(bd.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (Objects.isNull(constructor)) {
            //无参构造创建对象
            return enhancer.create();
        }
        //有参构造方法创建对象
        return enhancer.create(constructor.getParameterTypes(), args);
    }
}
