package com.consoleadmin.spring_data_rest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// Client (enter 1 to 5) -> USER entered -2 -> Convert it to 2 or raise Error here
// Validation AOP Spring
@Component
@Aspect
public class ValidationAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.consoleadmin.spring_data_rest.service.JobService.getJob(..)) && args(postId)")
    public Object validateAndUpdate(ProceedingJoinPoint jp , int postId) throws Throwable {

        if(postId < 0){
            LOGGER.info("Post id is -ve : " + postId );
            postId = -postId;
        }

        Object object = jp.proceed(new Object[]{postId});

        return object;
    }

}
