package com.karma.gema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.karma.gema.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
