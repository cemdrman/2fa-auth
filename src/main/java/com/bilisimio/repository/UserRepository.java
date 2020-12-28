package com.bilisimio.repository;

import org.springframework.data.repository.CrudRepository;

import com.bilisimio.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);

}
