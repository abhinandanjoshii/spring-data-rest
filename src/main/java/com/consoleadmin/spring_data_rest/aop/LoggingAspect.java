package com.consoleadmin.spring_data_rest.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
    private void logMethodCall(){
        LOGGER.info("Method Called");
    }
}
