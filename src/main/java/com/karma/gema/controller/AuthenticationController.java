package com.karma.gema.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.karma.gema.request.LoginRequest;
import com.karma.gema.service.AuthenticationService;

@Controller
@RequestMapping(value = "/")
public class AuthenticationController {

	@Autowired AuthenticationService authenticationService;
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> login(@RequestBody LoginRequest loginRequest){
		return authenticationService.login(loginRequest);
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Object> logout(){
		return authenticationService.logout();
	}

}
