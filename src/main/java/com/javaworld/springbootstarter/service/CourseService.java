package com.javaworld.springbootstarter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaworld.springbootstarter.model.Course;
import com.javaworld.springbootstarter.repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository repository;
	
	public List<Course> getAllCourses(String topicId) {
		List<Course> courses = new ArrayList<Course>();
		repository.findByTopicId(topicId)
				.forEach(courses :: add);
		return courses;
	}
//	
	public Course getCourse(String topicId) {
		return repository.findOne(topicId);
		 //return topics.stream().filter(t -> t.getId().equalsIgnoreCase(topicId)).findFirst().get();
	}
	
	public void addCourse(Course course) {
		repository.save(course);
	}

	public Course updateCourse(Course topic, String id) {
		repository.save(topic);
		return repository.findOne(id);
	}

	public void deleteTopic(String id) {
		repository.delete(id);
		//topics.removeIf(t -> t.getId().equalsIgnoreCase(id));
		//return topics;
	}
	

}
