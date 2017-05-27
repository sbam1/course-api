package com.javaworld.springbootstarter.repository;

import org.springframework.data.repository.CrudRepository;

import com.javaworld.springbootstarter.model.Topic;

public interface TopicRepository extends CrudRepository<Topic, String>{

}
