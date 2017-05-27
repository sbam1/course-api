package com.javaworld.springbootstarter.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.javaworld.springbootstarter.model.Course;

public interface CourseRepository extends CrudRepository<Course, String> {
	
	public List<Course> findByTopicId(String topicId);
	
	public List<Course> findByName(String name);
	
	public List<Course> findByDescription(String description);
}
