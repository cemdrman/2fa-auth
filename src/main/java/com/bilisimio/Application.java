package com.bilisimio;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bilisimio.model.User;
import com.bilisimio.repository.UserRepository;

@SpringBootApplication
public class Application {
	
	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@PostConstruct
	private void saveUser() {
		User user = new User();
		user.setName("cem");
		user.setLastName("dirman");
		user.setEmail("cem@gmail.com");
		user.setPassword("password");
		user.setPhone("");
		repository.save(user);
	}

}
