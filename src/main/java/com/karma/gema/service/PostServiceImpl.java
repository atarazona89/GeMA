package com.karma.gema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.karma.gema.model.Post;
import com.karma.gema.repositories.PostRepository;
import com.karma.gema.request.PostRequest;
@Service
public class PostServiceImpl implements PostService {

	@Autowired PostRepository postRepository;
	
	@Override
	public Post findById(Long id) {
		return postRepository.findById(id).get();
	}

	@Override
	public List<Post> findAll() {
		return postRepository.findAll();
	}
	
	

	@Override
	public Post findByUser(Long idUser) {
//		return postRepository.findByIdUser(idUser);
		return null;
	}

	@Override
	public Post savePost(PostRequest postRequest) {
		return postRepository.save(fromReq(new Post(), postRequest));
	}

	@Override
	public Post updatePost(Long id, PostRequest postRequest) {
		return postRepository.save(fromReq(findById(id), postRequest));
	}

	@Override
	public ResponseEntity<Object> deletePost(Long id) {
		try{
			postRepository.deleteById(id);
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex){
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private Post fromReq(Post post, PostRequest postRequest){
		if(postRequest.getId() != null) post.setId(postRequest.getId());
		post.setDescription(postRequest.getDescription());
		post.setName(postRequest.getName());
		return post;
	}

}
