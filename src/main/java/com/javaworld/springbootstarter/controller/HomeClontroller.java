package com.javaworld.springbootstarter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeClontroller {

	@RequestMapping("/")
	public String sayHello() {
		return "hello world";
	}
}
