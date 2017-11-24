package com.karma.gema.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.karma.gema.model.Stores;
import com.karma.gema.request.StoresRequest;

public interface StoresService {
	public Stores findById(Long id);
	public List<Stores> findAll();
	public List<Stores> findByWharehouseId(Long id);
	public boolean addToInventory(StoresRequest entityRequest);
	public Stores updateStores(Long id, StoresRequest entityRequest);
	public ResponseEntity<Object> deleteStores(Long id);

}
