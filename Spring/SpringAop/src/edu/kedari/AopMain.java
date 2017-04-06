package edu.kedari;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.kedari.service.ShapeService;

public class AopMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		ShapeService shapeService = (ShapeService) context.getBean("shapeService",ShapeService.class);
		System.out.println(shapeService.getCircle().getName());
		shapeService.getCircle().setName("abhi");
		
	}

}
