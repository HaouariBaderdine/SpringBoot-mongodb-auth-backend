package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "roles")
public class Role {
	
	@Id
	private String Id;
	
	private ERole name;

	public Role() {
		// TODO Auto-generated constructor stub
	}

	public Role(ERole name) {
		this.name = name;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}
	
	

}
