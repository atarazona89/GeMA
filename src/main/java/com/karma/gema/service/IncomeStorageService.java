package com.karma.gema.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.karma.gema.model.IncomeStorage;
import com.karma.gema.request.IncomeStorageRequest;

public interface IncomeStorageService {
	public IncomeStorage findById(Long id);
	public List<IncomeStorage> findAll();
	public IncomeStorage saveIncomeStorage(IncomeStorageRequest entityRequest);
	public IncomeStorage updateIncomeStorage(Long id, IncomeStorageRequest entityRequest);
	public ResponseEntity<Object> deleteIncomeStorage(Long id);

}
