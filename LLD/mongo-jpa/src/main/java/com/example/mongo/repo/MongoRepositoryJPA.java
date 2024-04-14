package com.example.mongo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongo.model.User;

public interface MongoRepositoryJPA extends MongoRepository<User,Integer>{

}
