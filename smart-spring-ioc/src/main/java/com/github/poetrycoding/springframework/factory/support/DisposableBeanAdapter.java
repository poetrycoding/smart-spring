package com.github.poetrycoding.springframework.factory.support;

import cn.hutool.core.util.StrUtil;
import com.github.poetrycoding.springframework.exception.BeansException;
import com.github.poetrycoding.springframework.factory.DisposableBean;
import com.github.poetrycoding.springframework.factory.config.BeanDefinition;

import java.lang.reflect.Method;

/**
 * Description: 统一销毁接口适配器
 * <br/>
 * DisposableBeanAdapter
 *
 * @author laiql
 * @date 2023/5/2 15:31
 */
public class DisposableBeanAdapter implements DisposableBean {

    private final Object bean;
    private final String beanName;
    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        // 1. 对实现接口 DisposableBean 判断
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }
        // 2. 注解配置 destroy-method {判断是为了避免二次执行销毁}
        if (StrUtil.isNotBlank(destroyMethodName) && !(bean instanceof DisposableBean
                && "destroy".equals(this.destroyMethodName))) {
            Method destroyMethod = bean.getClass().getMethod(destroyMethodName);
            if (null == destroyMethod) {
                throw new BeansException("Couldn't find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
            }
            destroyMethod.invoke(bean);
        }
    }
}
