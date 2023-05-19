package com.github.poetrycoding.springframework.context.annotation;

import cn.hutool.core.util.ClassUtil;
import com.github.poetrycoding.springframework.factory.config.BeanDefinition;
import com.github.poetrycoding.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Description: 扫描Component注解
 * * A component provider that scans the classpath from a base package. It then
 * * applies to exclude and include filters to the resulting classes to find candidates.
 * <br/>
 * ClassPathScanningCandidateComponentProvider
 *
 * @author laiql
 * @date 2023/5/19 13:57
 */
public class ClassPathScanningCandidateComponentProvider {
    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }
}
