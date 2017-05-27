package com.javaworld.springbootstarter.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaworld.springbootstarter.model.Topic;
import com.javaworld.springbootstarter.repository.TopicRepository;


@Service
public class TopicService {
	
	@Autowired
	TopicRepository repository;
	
	private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(
			new Topic("spring boot", "spring_12443", "this is an tutorial for spring boot"),
			new Topic("spring mvc", "spring_mvc_123", "this is an tutorial for spring mvc"),
			new Topic("spring data", "spring_data_123", "this is a tutorial for spring data ")
			));
	
	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<Topic>();
		repository.findAll()
				.forEach(topics :: add);
		return topics;
	}
	
	public Topic getTopic(String topicId) {
		return repository.findOne(topicId);
		 //return topics.stream().filter(t -> t.getId().equalsIgnoreCase(topicId)).findFirst().get();
	}
	
	public void addTopic(Topic topic) {
		repository.save(topic);
	}

	public Topic updateTopic(Topic topic, String id) {
		repository.save(topic);
		return repository.findOne(id);
	}

	public List<Topic> deleteTopic(String id) {
		repository.delete(id);
		return getAllTopics();
		//topics.removeIf(t -> t.getId().equalsIgnoreCase(id));
		//return topics;
	}
	
	

}
