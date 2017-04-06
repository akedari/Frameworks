package edu.kedari;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;


public class Circle implements Shape, ApplicationEventPublisherAware {

	Point center;
	@Autowired
	private MessageSource messageSource;
	private ApplicationEventPublisher publisher;
	
	public Point getCenter() {
		return center;
	}

	//@Resource(name="point3") this is JSR250 annotation. we just need to remove property 
	//<property name="center" ref = "point1"/> from circle  bean in Spring.xml becasue we 
	// are setting property using annotations in class itself. Other JSR250 annotatios are
	// @PostConstruct @PreDestroy
	@Resource(name="point3")
	public void setCenter(Point center) {
		this.center = center;
	}
	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	

	@Override
	public void draw() {
//		System.out.println("Circle:  (" + center.getX() + ", "+center.getY()+")");
		System.out.println("Using MessageProp: "+ this.messageSource.getMessage("drawmig.point", new Object[] {center.getX(), center.getY()}, "default Point message", null));
		System.out.println("greeting from Circle: "+ this.messageSource.getMessage("greeting", null, "defaultGreeting", null));
		DrawEvent drawevent = new DrawEvent(this);
		publisher.publishEvent(drawevent);
		
		
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}


}
