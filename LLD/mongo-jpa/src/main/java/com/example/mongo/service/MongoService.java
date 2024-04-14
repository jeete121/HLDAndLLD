package com.example.mongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mongo.model.User;
import com.example.mongo.repo.MongoRepositoryJPA;

@Service
public class MongoService {

	@Autowired
	private MongoRepositoryJPA mongoRepositoryJPA;

	public List<User> findAllUser() {

		return mongoRepositoryJPA.findAll();
	}

	public User saveUser(User user) {
		return mongoRepositoryJPA.save(user);
	}

}
