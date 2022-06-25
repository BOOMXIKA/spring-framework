package com.boomxika.annotationAndAop;

import java.lang.annotation.*;

/**
 * 我的log注解
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyLog {
	/**
	 * 功能模块
	 * @return
	 */
	String title() default "";

	/**
	 * 操作人
	 * @return
	 */
	String operator() default "";
}
