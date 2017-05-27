package com.javaworld.springbootstarter.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Topic {
	private String name;
	@Id
	private String id;
	private String description;
	
	public Topic() {
		super();
	}
	public Topic(String name, String id, String description) {
		this.name = name;
		this.id = id;
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
