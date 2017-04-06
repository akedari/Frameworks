package io.kedari.springbootstarter.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course,String> {
	
	public List<Course> getCoursesByTopic(String topicId);
	
	//JPA will implement the method called findByName() which will take name as a parameter
	// then we can use this method directly in our CoursesService.java (i.e. CoursesService class)
	// JPA will map the parameter called "name" with Course class member-varoable and implement the 
	// required function.
	public List<Course> findByName(String name);
	
	
	public List<Course> findByTopicId(String topicId);
	
}
