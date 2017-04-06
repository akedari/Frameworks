package edu.kedari.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import edu.kedari.model.Circle;

@Aspect
public class LoggingAspect {
	
	
//	@Before("execution(public String edu.kedari.model.Circle.getName())")
//	Wildcard Expression
	@Before("execution(* get*(..))")
	public void LoggingAdvice(){
		System.out.println("Advice run Get method is called");
	}
	
	// we have created pointcut name "allgetters" for expression/pattern "execution(* get*(..))" 
	// JoinPoint tell us which called that Advice like get() or set()
	@Before("allCircleMethods()")
	public void SecondAdvice(JoinPoint joinPoint){
		System.out.println(joinPoint.toString());
		
		//we can also get hold of object that called this advice. so we can work on Object
		Circle cir = (Circle)joinPoint.getTarget();
		System.out.println(cir.getName());
		
	}
	
	
	@Pointcut("execution(* get*())")
	public void allGetters(){
	}
	
	@Pointcut("within(edu.kedari.model.Circle)")
	public void allCircleMethods(){
	}
	
	@Before("args(name)")
	public void stringArgMethod(String name){
		System.out.println("Method with String paramenter called by "+ name);
	}
	
	
	
}
