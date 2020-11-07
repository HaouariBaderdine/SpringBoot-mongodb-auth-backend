package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.example.demo.model.ERole;
//import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepository;

@SpringBootApplication
public class SpringBootJwtMongodbApplication/* implements CommandLineRunner*/ {

	@Autowired
	RoleRepository r ;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJwtMongodbApplication.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		Role e = new Role(ERole.SERVEUILLANTE_GENERALE);
		Role e2 = new Role(ERole.SERVEUILLANTE);
		
		r.save(e);
		r.save(e2);
	}*/
	
	
}
