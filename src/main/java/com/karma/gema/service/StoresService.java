package com.karma.gema.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.karma.gema.model.Stores;
import com.karma.gema.request.StoresRequest;
import com.karma.gema.request.TransferRequest;

public interface StoresService {
	public Stores findById(Long id);
	public List<Stores> findAll();
	public List<Stores> findByWharehouseId(Long id);
	public Boolean addToInventory(StoresRequest entityRequest);
	public ResponseEntity<Object> transferInventory(TransferRequest transferRequest);
	public Stores updateStores(Long id, StoresRequest entityRequest);
	public ResponseEntity<Object> deleteStores(Long id);

}
