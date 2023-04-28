package com.github.poetrycoding.springframework.context.support;

import com.github.poetrycoding.springframework.context.ApplicationContext;
import com.github.poetrycoding.springframework.factory.support.DefaultListableBeanFactory;
import com.github.poetrycoding.springframework.factory.xml.XmlBeanDefinitionReader;

/**
 * Description: 用于实现XML转换Bean的上下文
 * Convenient base class for {@link ApplicationContext}
 * implementations, drawing configuration from XML documents containing bean definitions
 * understood by an {@link XmlBeanDefinitionReader}.
 * <br/>
 * AbstractXmlApplicationContext
 *
 * @author laiql
 * @date 2023/4/28 21:39
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String[] configLocations = getConfigLocations();
        if (null != configLocations) {
            //根据路径读取加载
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
