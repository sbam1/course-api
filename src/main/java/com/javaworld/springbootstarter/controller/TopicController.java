package com.javaworld.springbootstarter.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javaworld.springbootstarter.model.Topic;
import com.javaworld.springbootstarter.service.TopicService;


@RestController
public class TopicController {

	@Autowired
	TopicService service;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		
		return service.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return service.getTopic(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopic(@RequestBody Topic topic) {
		service.addTopic(topic);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public Topic updateTopic(@PathVariable String id,  @RequestBody Topic topic) {
		return service.updateTopic(topic, id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	public List<Topic> deleteTopic(@PathVariable String id) {
		return service.deleteTopic(id);
	}
}
