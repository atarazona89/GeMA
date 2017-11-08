package com.karma.gema.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.karma.gema.model.User;
import com.karma.gema.request.UserRequest;

public interface UserService {

	public User findById(Long id);
	public List<User> findAll();
	public User saveUser(UserRequest userRequest);
	public List<User> createUsers();
	public User updateUser(Long id, UserRequest userRequest);
	public ResponseEntity<Object> deleteUser(Long id);
}
