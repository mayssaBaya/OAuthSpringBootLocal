package com.toysforshots.repositories;

import org.springframework.data.repository.CrudRepository;

import com.toysforshots.entities.User;

public interface IUserRepository extends CrudRepository<User, Integer> {

	User findByUserName(String username);

}
