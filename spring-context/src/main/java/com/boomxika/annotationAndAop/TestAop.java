package com.boomxika.annotationAndAop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAop {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		BaseService bean = context.getBean(BaseService.class);
		bean.justDoIt();
	}
}
