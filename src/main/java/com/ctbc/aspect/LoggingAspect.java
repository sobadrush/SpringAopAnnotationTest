package com.ctbc.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.ctbc.selfdefannotation.InteceptedByAOP;

@Aspect
@Component
public class LoggingAspect {

	@Before(value = "execution(* com.ctbc.service.TestAopSample.testBefore(..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println(">>>>>>>>>>>>>>>>>>>> logBefore() is running! <<<<<<<<<<<<<<<<<<<<<<");
		System.out.println("joinPoint.getSignature().getName() >>> " + joinPoint.getSignature().getName());
		System.out.println("*******************************************************************");
	}

	@After("execution(* com.ctbc.service.TestAopSample.testAfter(..))")
	public void logAfter(JoinPoint joinPoint) {
		System.out.println(">>>>>>>>>>>>>>>>>>>> logAfter() is running! <<<<<<<<<<<<<<<<<<<<<<");
		System.out.println("joinPoint.getSignature().getName() >>> " + joinPoint.getSignature().getName());
		System.out.println("*******************************************************************");
	}

	@AfterReturning(pointcut = "execution(* com.ctbc.service.TestAopSample.testReturnValue(..))", returning = "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
		System.out.println(">>>>>>>>>>>>>>>>>>>> logAfterReturning() is running! <<<<<<<<<<<<<<<<<<<<<<");
		System.out.println("joinPoint.getSignature().getName() >>> " + joinPoint.getSignature().getName());
		System.out.println("result >>> " + result);
		System.out.println("*******************************************************************");
	}

	@AfterThrowing(pointcut = "execution(* com.ctbc.service.TestAopSample.testThrowException(..))", throwing = "error")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
		System.out.println(">>>>>>>>>>>>>>>>>>>> logAfterThrowing() is running! <<<<<<<<<<<<<<<<<<<<<<");
		System.out.println("joinPoint.getSignature().getName() >>> " + joinPoint.getSignature().getName());
		System.out.println("error >>> " + error);
		System.out.println("*******************************************************************");
	}

//	@Around("execution(* com.ctbc.service..*.*(..))")
	@Around("@annotation(com.ctbc.selfdefannotation.InteceptedByAOP)")
	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println(">>>>>>>>>>>>>>>>>>>> logAround() is running! <<<<<<<<<<<<<<<<<<<<<<");
		
		// ========= 取得 @InteceptedByAOP上傳入的值 Start ===========
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method method = methodSignature.getMethod();
		InteceptedByAOP myAnnotation = method.getAnnotation(InteceptedByAOP.class);
		System.out.println("myAnnotation >>> " + myAnnotation);
		System.out.println("myAnnotation.actionName() >>> " + myAnnotation.actionName());
		System.out.println("myAnnotation.level().getValue() >>> " + myAnnotation.level().getValue());
		// ========= 取得 @InteceptedByAOP上傳入的值 End ===========
		
		System.out.println("joinPoint.getSignature().getName() >>> " + joinPoint.getSignature().getName());
		System.out.println("joinPoint.getArgs() >>> " + Arrays.toString(joinPoint.getArgs()));
		System.out.println(" === Around before is running! === ");
		
		Object callNext = joinPoint.proceed();
		
		System.out.println(" callNext = " + callNext);
		System.out.println(" === Around after is running! === ");
		System.out.println("*******************************************************************");
	}

}









