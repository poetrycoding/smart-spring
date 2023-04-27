package com.github.poetrycoding.springframework.test;

import cn.hutool.core.io.IoUtil;
import com.github.poetrycoding.springframework.core.io.DefaultResourceLoader;
import com.github.poetrycoding.springframework.core.io.Resource;
import com.github.poetrycoding.springframework.factory.config.BeanDefinition;
import com.github.poetrycoding.springframework.factory.config.BeanReference;
import com.github.poetrycoding.springframework.factory.xml.XmlBeanDefinitionReader;
import com.github.poetrycoding.springframework.property.PropertyValue;
import com.github.poetrycoding.springframework.property.PropertyValues;
import com.github.poetrycoding.springframework.factory.support.DefaultListableBeanFactory;
import com.github.poetrycoding.springframework.test.dao.StudentDAO;
import com.github.poetrycoding.springframework.test.service.StudentService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Description: Bean注册定义测试
 * <br/>
 * BeanApiTest
 *
 * @author laiql
 * @date 2023/4/26 10:43
 */
public class BeanApiTest {
    @Test
    public void testFactory() {
        //创建IOC容器工厂
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //创建Bean定义信息
        BeanDefinition bd = new BeanDefinition(StudentService.class);
        //注册Bean
        beanFactory.registerBeanDefinition("studyService", bd);

        //从工厂获取Bean实例
        StudentService studentService1 = (StudentService) beanFactory.getBean("studyService", "张三");
        studentService1.study();
        System.out.println("studentService1.hashCode() = " + studentService1.hashCode());

        StudentService studentService2 = (StudentService) beanFactory.getBean("studyService");
        studentService2.study();
        System.out.println("studentService2.hashCode() = " + studentService2.hashCode());

    }

    private DefaultResourceLoader defaultResourceLoader;

    @Before
    public void init() {
        defaultResourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void testClassPath() throws IOException {
        Resource resource = defaultResourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String string = IoUtil.readUtf8(inputStream);
        System.out.println("string = " + string);
    }

    @Test
    public void testFile() throws IOException {
        Resource resource = defaultResourceLoader.getResource("src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void testSpringXml() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        StudentService studentService = beanFactory.getBean("studentService", StudentService.class);
        studentService.study();

    }

    @Test
    public void testPropertyValue() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //注册StudentDAO
        beanFactory.registerBeanDefinition("studentDao", new BeanDefinition(StudentDAO.class));

        //创建StudentService属性
        PropertyValues propertyValues = new PropertyValues();
        //填充属性name
        propertyValues.addPropertyValue(new PropertyValue("name", "66666"));
        //填充引用属性,
        propertyValues.addPropertyValue(new PropertyValue("studentDAO", new BeanReference("studentDao")));
        //注册StudentService
        beanFactory.registerBeanDefinition("studentService", new BeanDefinition(StudentService.class, propertyValues));

        StudentService studentService = (StudentService) beanFactory.getBean("studentService");
        studentService.study();
    }

    @Test
    public void testCglibCreateObject() {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(StudentService.class);
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        Object studyObj = enhancer.create(new Class[]{String.class}, new Object[]{"jack"});
        System.out.println(studyObj);

        Object obj = enhancer.create();
        System.out.println(obj);

    }
}
