package com.karma.gema.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.karma.gema.model.Company;
import com.karma.gema.model.Post;
import com.karma.gema.model.User;
import com.karma.gema.repositories.CompanyRepository;
import com.karma.gema.repositories.PostRepository;
import com.karma.gema.repositories.UserRepository;
import com.karma.gema.request.UserRequest;

@Service
public class UserServiceImpl implements UserService{

	@Autowired UserRepository userRepository;
	@Autowired PostRepository postRepository;
	@Autowired CompanyRepository companyRepository;
	
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}

	public User saveUser(UserRequest userRequest){
		return userRepository.saveAndFlush(fromReq(new User(), userRequest));
	}
	
	@Override
	public List<User> createUsers(){
		
		List<User> ltUsers = new LinkedList<User>();
		User user = new User();
		//Company company = companyRepository.findById((long) 1).get();
		
		user.setFirstName("Alejandro");
		user.setLastName("Tarazona");
		user.setEmail("alejandrotarazona@gmail.com");
		user.setPhoneNumber("04121341842");
		user.setUsername("atarazona");
		user.setPassword("4242");
		user.setAddress("Caracas");
		user.setCi(Long.valueOf("424242"));
		
		ltUsers.add(userRepository.save(user));
		
		user.setFirstName("Karma");
		user.setLastName("Admin");
		user.setEmail("karma@karma.com");
		user.setPhoneNumber("123123123");
		user.setUsername("Karma");
		user.setPassword("123123");
		user.setAddress("Chile");
		user.setCi(Long.valueOf("123123123"));
		
		ltUsers.add(userRepository.save(user));
		
		return ltUsers;
	}

	@Override
	public List<User> findAll() {
		List<User> ltUsers = userRepository.findAll();
		
		for (User user : ltUsers) {
			user.setPassword("");
		}
		
		return ltUsers;
	}

	@Override
	public User updateUser(Long id, UserRequest userRequest) {
		return userRepository.save(fromReq(findById(id),userRequest));						
	}

	@Override
	public ResponseEntity<Object> deleteUser(Long id) {
		try{
			userRepository.deleteById(id);
			userRepository.flush();
			return new ResponseEntity<Object>(null,HttpStatus.OK);
		}catch (Exception ex){
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	private User fromReq(User user, UserRequest userRequest){
		user.setUsername(userRequest.getUsername());
		user.setPassword(userRequest.getPassword());
		user.setCi(userRequest.getCi());
		user.setAddress(userRequest.getAddress());
		user.setEmail(userRequest.getEmail());
		user.setFirstName(userRequest.getFirstName());
		user.setLastName(userRequest.getLastName());
		user.setPhoneNumber(userRequest.getPhoneNumber());
		
		return user;
	}
}
