package com.em.test.entitymanagertest.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * <p></p>
 * @author teena
 *
 */
@Aspect
@Component
@Slf4j
public class LoggingAspect {

	/**
	 * <p>
	 * Pointcut that matches all controllers, services and repositories.
	 * </p>
	 */
	@Pointcut("within(com.em.test.entitymanagertest.controller..*)"
			+ " || within(com.em.test.entitymanagertest.service..*)"
			+ " || within(com.em.test.entitymanagertest.repository.impl..*)"
			+ " || within(com.em.test.entitymanagertest.security..*)")
	public void applicationPackagePointcut() {
	}

	@Before(value = "applicationPackagePointcut()")
	public void before(JoinPoint joinPoint) {
		log.info("Entering: {}", joinPoint.getSignature());
	}

	@After(value = "applicationPackagePointcut()")
	public void after(JoinPoint joinPoint) {
		log.info("Exiting {}", joinPoint.getSignature());
	}

	@AfterReturning(value = "applicationPackagePointcut()", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		log.info("Exiting {} with value {}", joinPoint.getSignature(), result);
	}
	
	@AfterThrowing(pointcut = "applicationPackagePointcut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        log.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringTypeName(),
            joinPoint.getSignature().getName(), e.getCause() != null ? e.getCause() : "NULL");
    }

}
