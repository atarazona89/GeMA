package com.karma.gema.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.karma.gema.model.Wharehouse;
import com.karma.gema.request.WharehouseRequest;

public interface WharehouseService {


	public Wharehouse findById(Long id);
	public List<Wharehouse> findAll();
	public List<Wharehouse> findBySectorId(Long id);
	public Wharehouse saveWharehouse(WharehouseRequest entityRequest);
	public Wharehouse updateWharehouse(Long id, WharehouseRequest entityRequest);
	public ResponseEntity<Object> deleteWharehouse(Long id);

}
