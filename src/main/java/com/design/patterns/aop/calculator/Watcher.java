package com.design.patterns.aop.calculator;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Aspect
@Component
public class Watcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(Watcher.class);

    @Before("execution(* com.design.patterns.aop.calculator.Calculator.factorial(..)) && args(theNumber) && target(object)")
    public void logEvent(BigDecimal theNumber, Object object) {
        LOGGER.info("Class: " + object.getClass().getName() + ", Args: " + theNumber);
    }

    @Around("execution(* com.design.patterns.aop.calculator.Calculator.factorial(..))")
    public Object measureTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        try {
            long begin = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            LOGGER.info("Time consumed: " + (end  - begin) + "ms.");
        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage());
            throw throwable;
        }
        return result;
    }

    @Around("execution(* com.design.patterns.facade.api.OrderFacade.processOrder(..))")
    public Object facadeMeasureTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object resultMethod;
        try {
            long startProcess = System.currentTimeMillis();
            resultMethod = proceedingJoinPoint.proceed();
            long endProcess = System.currentTimeMillis();
            LOGGER.info("Time consumed to Order Process: " + (endProcess - startProcess) + "ms.");
        } catch (Throwable throwable) {
            System.out.println("I`m here");
            LOGGER.error(throwable.getMessage());
            throw throwable;
        }
        return resultMethod;
    }
}
