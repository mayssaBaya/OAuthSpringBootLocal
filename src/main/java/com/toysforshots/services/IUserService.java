package com.toysforshots.services;

import com.toysforshots.dto.UserDTO;
import com.toysforshots.entities.User;

public interface IUserService {
	public User findUserByUsername(String email);
	public User registerNewUserAccount(UserDTO accountDto);
}
