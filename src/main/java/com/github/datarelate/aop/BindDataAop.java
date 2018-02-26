package com.github.datarelate.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class BindDataAop {

    /**
     * 日志
     */
    public static final Logger LOGGER = LogManager.getLogger(BindDataAop.class);

    @Around("execution(* com.minivision.*.controller..*.*(..))")  
    public Object bindData(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();  
        try {  
            return proceedingJoinPoint.proceed(args);  
        } catch (Throwable e) {  
            LOGGER.error("BindDataAop has an error", e);
            throw e;
        }  
    }
}
