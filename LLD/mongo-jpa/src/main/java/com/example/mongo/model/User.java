package com.example.mongo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class User {

	private Integer id;

	private String name;

	private Integer age;

	private String email;

}
