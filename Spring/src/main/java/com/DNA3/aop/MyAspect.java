package com.DNA3.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/20 21:29
 */

@Component("myAspect")
@Aspect //标志当前类是一个切面类
public class MyAspect {

    @Before("MyAspect.pointcut()")
    public void before() {
        System.out.println("前置增强");
    }

    @After("MyAspect.pointcut()")
    public void after() {
        System.out.println("最终增强");
    }

    @AfterReturning("MyAspect.pointcut()")
    public void afterReturning() {
        System.out.println("后置增强");
    }

    @Around("MyAspect.pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕前增强");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("环绕后增强");
        return proceed;
    }

    @AfterReturning("MyAspect.pointcut()")
    public void afterThrowing() {
        System.out.println("异常抛出增强");
    }

    @Pointcut("execution(* com.DNA3.aop.*.*(..))")
    public void pointcut(){}
}
