package com.karma.gema.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.karma.gema.model.Permit;
import com.karma.gema.request.PermitRequest;

public interface PermitService {
	
	public Permit findById(Long id);
	public Permit findByIdWharehouse(Long id);
	public List<Permit> findAll();
	public Permit savePermit(PermitRequest entityRequest);
	public Permit updatePermit(Long id, PermitRequest entityRequest);
	public ResponseEntity<Object> deletePermit(Long id);


}
