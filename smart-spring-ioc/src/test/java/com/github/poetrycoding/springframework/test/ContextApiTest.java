package com.github.poetrycoding.springframework.test;

import com.github.poetrycoding.springframework.context.support.ClassPathXmlApplicationContext;
import com.github.poetrycoding.springframework.factory.support.DefaultListableBeanFactory;
import com.github.poetrycoding.springframework.factory.xml.XmlBeanDefinitionReader;
import com.github.poetrycoding.springframework.test.processor.MyBeanFactoryPostProcessor;
import com.github.poetrycoding.springframework.test.processor.MyBeanPostProcessor;
import com.github.poetrycoding.springframework.test.service.StudentService;
import org.junit.Test;

/**
 * Description: 上下文测试类
 * <br/>
 * ContextApiTest
 *
 * @author laiql
 * @date 2023/4/28 21:46
 */
public class ContextApiTest {

    @Test
    public void contextTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        context.registerShutdownHook();

        StudentService studentService = context.getBean("studentService", StudentService.class);
        studentService.study();
    }

    @Test
    public void test_BeanFactoryPostProcessorAndBeanPostProcessor() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. BeanDefinition 加载完成 & Bean实例化之前，修改 BeanDefinition 的属性值
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        // 4. Bean实例化之后，修改 Bean 属性信息
        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        // 5. 获取Bean对象调用方法
        StudentService studentService = beanFactory.getBean("studentService", StudentService.class);
        String result = studentService.getName();
        System.out.println("测试结果：" + result);
        studentService.study();
    }

    @Test
    public void test_hook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("close！")));
    }
}
