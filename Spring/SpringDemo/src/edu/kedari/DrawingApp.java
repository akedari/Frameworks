package edu.kedari;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//		context.registerShutdownHook(); // this need AbstractApplicationContext instead of ApplicationContext
		Shape shape = (Shape) context.getBean("circle");
		shape.draw();
		
		System.out.println("getmessage: "+ context.getMessage("greeting", null, "defaultGreeting", null));
		
		
//		context.close();
		
//		Triangle obj = (Triangle) context.getBean("triangle");
//	    obj.draw();
		
	}

}	
