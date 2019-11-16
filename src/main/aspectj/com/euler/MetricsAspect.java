package com.euler;

import com.euler.metrics.ProblemMetrics;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MetricsAspect {
  @Around("execution(* com.euler.*.main(..))")
  public void metricsForProblemExecutions(ProceedingJoinPoint joinPoint) {
    ProblemMetrics.measure(() -> {
      try {
        joinPoint.proceed();
      } catch (Throwable t) {
        throw new RuntimeException(t);
      }
    });
  }
}