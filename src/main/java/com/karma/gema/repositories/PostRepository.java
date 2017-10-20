package com.karma.gema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karma.gema.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
	
//	@Query("select p from User u join u.post p where u.id = (:iduser)")
//	public Post findByUser(@Param("iduser") Long idUser);

}
