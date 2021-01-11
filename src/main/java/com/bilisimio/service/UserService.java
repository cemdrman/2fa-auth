package com.bilisimio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bilisimio.input.UserInput;
import com.bilisimio.model.User;
import com.bilisimio.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public User getUserById(Long id) {
		return repository.findById(id).get();	
	}

	public User getUserByEmailAndPassword(UserInput userInput) {
		return repository.findByEmailAndPassword(userInput.getEmail(), userInput.getPassword());
	}

}
