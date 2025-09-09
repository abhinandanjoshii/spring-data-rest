package com.consoleadmin.spring_data_rest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    // return type, class-name.method-name(arguments)
    @Before("execution(* com.consoleadmin.spring_data_rest.service.JobService.*(..))")
//    @Before("execution(* com.consoleadmin.spring_data_rest.service.JobService(..))")
    private void logMethodCall(JoinPoint jp){
        LOGGER.info("Method Called " + jp.getSignature().getName());
    }

    // irresespective of exception, finally kinda
    @After("execution(* com.consoleadmin.spring_data_rest.service.JobService.*(..))")
    private void logMethodExecuted(JoinPoint jp){
        LOGGER.info("Method Leaved Thread " + jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.consoleadmin.spring_data_rest.service.JobService.*(..))")
    private void logMethodExecutedSuccess(JoinPoint jp){
        LOGGER.info("Method Executed Successfully " + jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.consoleadmin.spring_data_rest.service.JobService.*(..))")
    private void logMethodCrash(JoinPoint jp){
        LOGGER.info("Method Crashed " + jp.getSignature().getName());
    }
}
