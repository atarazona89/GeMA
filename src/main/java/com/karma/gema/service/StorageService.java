package com.karma.gema.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.karma.gema.model.Storage;
import com.karma.gema.request.StorageRequest;

public interface StorageService {
	public Storage findById(Long id);
	public List<Storage> findAll();
	public Storage saveStorage(StorageRequest entityRequest);
	public Storage updateStorage(Long id, StorageRequest entityRequest);
	public ResponseEntity<Object> deleteStorage(Long id);

}
