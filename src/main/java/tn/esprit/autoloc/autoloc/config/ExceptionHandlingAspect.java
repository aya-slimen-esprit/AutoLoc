package tn.esprit.autoloc.autoloc.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ExceptionHandlingAspect {

    @AfterThrowing(
            pointcut = "execution(* tn.esprit.autoloc.autoloc.service.*.*(..))",
            throwing = "exception"
    )
    public void handleException(JoinPoint joinPoint, Throwable exception) {

        String methodeName = joinPoint.getSignature().getName();

        log.error("Exception - Méthode concernée : " + methodeName);

        log.error("Type d'exception : " + exception.getClass().getName());

        log.error("Message d'erreur : " + exception.getMessage());
    }
}
