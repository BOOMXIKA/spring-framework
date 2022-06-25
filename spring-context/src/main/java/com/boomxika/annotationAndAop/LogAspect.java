package com.boomxika.annotationAndAop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 切面类
 *
 * 下面完整列举一下 Pointcut 的匹配方式：
 *
 * execution：匹配方法签名
 * 这个最简单的方式就是上面的例子，"execution(* testExecution(..))"表示的是匹配名为testExecution的方法，*代表任意返回值，(..)表示零个或多个任意参数。
 *
 * **within：**指定所在类或所在包下面的方法（Spring AOP 独有）
 *     // service 层
 *     // ".." 代表包及其子包
 *     @Pointcut("within(ric.study.demo.aop.svc..*)")
 *     public void inSvcLayer() {}
 *
 * @annotation：方法上具有特定的注解
 *     // 指定注解
 *     @Pointcut("@annotation(ric.study.demo.aop.HaveAop)")
 *     public void withAnnotation() {}
 *
 * bean(idOrNameOfBean)：匹配 bean 的名字（Spring AOP 独有）
 *     // controller 层
 *     @Pointcut("bean(testController)")
 *     public void inControllerLayer() {}
 *
 */
@Aspect
@Component
public class LogAspect {
//	@Pointcut("@annotation(com.boomxika.annotationAndAop.MyLog)")
	@Pointcut("execution(* justDoIt(..))")
	public void logPointCut() {

	}

	@After(value = "logPointCut()")
	public void after(JoinPoint joinPoint) {
		MyLog myLog = getAnnotationLog(joinPoint);
		System.out.println(myLog);
		System.out.println("------after方法------");
	}

	@Before(value = "logPointCut()")
	public void before(JoinPoint joinPoint) {
		MyLog myLog = getAnnotationLog(joinPoint);
		System.out.println("------before方法------");
	}

	/**
	 * 是否存在MyLog注解，如果有就返回
	 *
	 * @param joinPoint
	 * @return
	 */
	private MyLog getAnnotationLog(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		if (method != null) {
			return method.getAnnotation(MyLog.class);
		}
		return null;
	}
}
