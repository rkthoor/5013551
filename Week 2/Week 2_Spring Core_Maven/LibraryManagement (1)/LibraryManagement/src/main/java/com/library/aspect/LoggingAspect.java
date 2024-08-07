package com.library.aspect;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
    @Pointcut("execution(* com.library.management.*.*(..))")
    private void selectAll(){}

    @Before("selectAll()")
    public void beforeAdvice() {
        System.out.println("Before method: Logging Start");
    }

    @After("selectAll()")
    public void afterAdvice() {
        System.out.println("After method: Logging End");
    }
}
