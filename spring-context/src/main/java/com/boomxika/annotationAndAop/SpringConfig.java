package com.boomxika.annotationAndAop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @EnableAspectJAutoProxy
 * Aop框架接入的总起点
 *
 * 而触发时机是通过BeanPostProcessor实现的
 * 实现类AbstractAutoProxyCreator
 * #postProcessAfterInitialization
 * #postProcessBeforeInitialization
 */
@EnableAspectJAutoProxy
@Configuration
@ComponentScan("com.boomxika.annotationAndAop")
public class SpringConfig {
	@Bean
	public BaseService baseService() {
		return new BaseServiceImpl();
	}
	//简单总结主要流程：
	//1.实现类AbstractAutoProxyCreator#postProcessBeforeInstantiation
	//这里会解析出所有的Advisor即@Aspect注解类下的东西
	//2.实现类AbstractAutoProxyCreator#postProcessAfterInitialization
	//这里就是每个bean都会遍历到，用上面第一步的所有Advisor来匹配每个bean里的方法，对上了就生成代理
}
