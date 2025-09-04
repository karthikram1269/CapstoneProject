package com.bank.notification.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect  //extra logic
@Component //object creation
@Slf4j
public class LoggingAspect {

	@Before("execution(* com.bank.notification.controllers.PatientController.registerPatient(..))")
	public void logBeforeAddDoctor(JoinPoint joinpoint) 
	{
		log.warn("loging something before registering Patient endpoint"+joinpoint.getArgs());
	}
	
}