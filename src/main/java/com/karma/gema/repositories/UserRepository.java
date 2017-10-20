package com.karma.gema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karma.gema.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByUsernameAndPassword(String username, String password);

}
