package com.microsip.synch.hooks;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Technogi 2016. Todos los derechos reservados
 * Created by carlos_technogi on 3/13/17.
 */
@Aspect
@Component
public class ChangeNotificator {

  @AfterReturning("execution(* com.microsip.synch.controllers.*Controller.save*(..))")
  public void logServiceAccess(JoinPoint joinPoint) {
    System.out.println("Completed: " + joinPoint);
    System.out.println("Se guardó grupo"+joinPoint.getArgs()[0] );
    System.out.println(joinPoint.getSignature());
  }
}
