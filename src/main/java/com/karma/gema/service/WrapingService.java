package com.karma.gema.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.karma.gema.model.Wraping;
import com.karma.gema.request.WrapingRequest;

public interface WrapingService {
	public Wraping findById(Long id);
	public Wraping findByIdIncomeStorage(Long id);
	public List<Wraping> findAll();
	public Wraping saveWraping(WrapingRequest entityRequest);
	public Wraping updateWraping(Long id, WrapingRequest entityRequest);
	public ResponseEntity<Object> deleteWraping(Long id);

}
