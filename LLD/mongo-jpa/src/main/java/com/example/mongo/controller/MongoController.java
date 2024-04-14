package com.example.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongo.model.User;
import com.example.mongo.service.MongoService;

@RestController
public class MongoController {

	@Autowired
	private MongoService mongoService;
	

	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		return mongoService.saveUser(user);

	}

	@GetMapping("/user")
	public List<User> findAllUsers() {
		return mongoService.findAllUser();

	}

}
