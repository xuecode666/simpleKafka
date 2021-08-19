package com.example.demo2;

import com.example.demo2.consumer.Receiver;
import com.example.demo2.consumer.SpringContextUtil;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Demo2Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Demo2Application.class, args);
		SpringContextUtil.setApplicationContext(run);
		ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) SpringContextUtil.getApplicationContext();
		// 获取bean工厂并转换为DefaultListableBeanFactory
		DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) configurableApplicationContext.getBeanFactory();
		// 通过BeanDefinitionBuilder创建bean定义,创建bean信息
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(Receiver.class);
		// 设置属性userService,此属性引用已经定义的bean:userService,这里userService已经被spring容器管理了.
//        beanDefinitionBuilder.addPropertyReference("topic", "testService");
		// 注册bean
		defaultListableBeanFactory.registerBeanDefinition("testController", beanDefinitionBuilder.getBeanDefinition());
		Receiver receiver = (Receiver) SpringContextUtil.getBean("testController");

	}

}
