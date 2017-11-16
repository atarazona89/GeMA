package com.karma.gema.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.karma.gema.model.Post;
import com.karma.gema.request.PostRequest;

public interface PostService {
	
	public Post findById(Long id);
	public List<Post> findAll();
	public Post savePost(PostRequest postRequest);
	public Post updatePost(Long id, PostRequest postRequest);
	public ResponseEntity<Object> deletePost(Long id);

}
