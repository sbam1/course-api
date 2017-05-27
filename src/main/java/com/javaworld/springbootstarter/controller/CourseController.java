package com.javaworld.springbootstarter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javaworld.springbootstarter.model.Course;
import com.javaworld.springbootstarter.model.Topic;
import com.javaworld.springbootstarter.service.CourseService;
import com.javaworld.springbootstarter.service.TopicService;

@RestController
public class CourseController {
	
	@Autowired
	CourseService service;
	
	@Autowired
	TopicService topicService;
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		
		return service.getAllCourses(id);
	}
	
	@RequestMapping("/topics/{courseId}/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		return service.getCourse(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(getTopic(topicId));
		service.addCourse(course);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
	public Course updateCourse(@PathVariable String topicId, @PathVariable String id,  @RequestBody Course course) {
		course.setTopic(getTopic(topicId));
		return service.updateCourse(course, id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		service.deleteTopic(id);
	}
	
	private Topic getTopic(String id) {
		return topicService.getTopic(id);
	}

}
