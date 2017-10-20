package com.karma.gema.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.karma.gema.request.LoginRequest;

public interface AuthenticationService {
	
	public Map<String, Object> login(LoginRequest loginRequest);
	public ResponseEntity<Object> logout();

}
