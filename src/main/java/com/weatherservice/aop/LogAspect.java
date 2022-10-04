package com.weatherservice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Before("execution(* com.weatherservice.*.*.*())")
    public void logMethod(JoinPoint joinPoint) {
        System.out.println("xxxxxx");
        System.out.println("Details: " + joinPoint.getSignature().getName());
        System.out.println("xxxxxx");
        logger.info("LOG.INFO FROM LOG ASPECT Method " + joinPoint.getSignature().getName() + " started");
    }
}
