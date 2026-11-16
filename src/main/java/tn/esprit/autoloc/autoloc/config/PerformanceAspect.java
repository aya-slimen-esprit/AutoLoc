package tn.esprit.autoloc.autoloc.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class PerformanceAspect {

    @Around("execution(* tn.esprit.autoloc.autoloc.service.*.*(..))")
    public Object measurePerformance(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();

        long executionTime = endTime - startTime;

        String methodeName = joinPoint.getSignature().getName();

        log.info("Performance - Méthode : " + methodeName
                + " | Temps d'exécution : " + executionTime + " ms");

        if (executionTime > 1000) {
            log.warn("WARNING - La méthode " + methodeName
                    + " a dépassé 1000 ms !");
        }

        return result;
    }
}
