package services;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

//@Aspect is not a stereotype annotation. A bean of type LoggingAspect wont be created.
@Component
@Aspect
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    //intercepts all the methods in classes inside the services package.
    //the method parameters, return type can be anything
    @Around("execution(* services.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        //get method name of the intercepted method
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        logger.info("Method " + methodName +
                " with parameters " + Arrays.asList(args) +
                " will execute");

        logger.info("Before function call");
        Object returnedVal = joinPoint.proceed();
        logger.info("After function call");
        return returnedVal;
    }

}
