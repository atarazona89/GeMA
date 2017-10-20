package com.karma.gema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.karma.gema.model.User;
import com.karma.gema.repositories.UserRepository;
import com.karma.gema.request.UserRequest;

@Service
public class UserServiceImpl implements UserService{

	@Autowired UserRepository userRepository;
	
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}

	public User saveUser(UserRequest userRequest){
		return userRepository.saveAndFlush(fromReq(new User(), userRequest));
	}
	
	public User createUser(User user){
		user.setFirstName("Alejandro");
		user.setLastName("Tarazona");
		user.setEmail("alejandrotarazona@gmail.com");
		user.setPhoneNumber("04121341842");
		user.setUsername("atarazona");
		user.setPassword("4242");
		user.setAddress("Caracas");
		user.setCi(Long.valueOf("424242"));
		user.setRif(Long.valueOf(21212121));
		userRepository.save(user);
		return user;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
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
		user.setRif(userRequest.getRif());
		user.setAddress(userRequest.getAddress());
		user.setEmail(userRequest.getEmail());
		user.setFirstName(userRequest.getFirstName());
		user.setLastName(userRequest.getLastName());
		user.setPhoneNumber(userRequest.getPhoneNumber());
		
		return user;
	}
}
