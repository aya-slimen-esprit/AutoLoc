package tn.esprit.autoloc.autoloc.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("execution(* tn.esprit.autoloc.autoloc.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        String methodeName = joinPoint.getSignature().getName();
        Object[] parameters = joinPoint.getArgs();
        log.info("Before - Méthode appelée : "
                + methodeName
                + " avec les paramètres : "
                + Arrays.toString(parameters));
    }

    @After("execution(* tn.esprit.autoloc.autoloc.service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {

        String methodeName = joinPoint.getSignature().getName();

        log.info("After - Méthode terminée : " + methodeName);
    }
}