package com.karma.gema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.karma.gema.model.IncomeStorage;
import com.karma.gema.repositories.IncomeStorageRepository;
import com.karma.gema.request.IncomeStorageRequest;

@Service
public class IncomeStorageServiceImpl implements IncomeStorageService {

	@Autowired
	IncomeStorageRepository incomeStorageRepository;
	
	@Override
	public IncomeStorage findById(Long id) {
		return incomeStorageRepository.findById(id).get();
	}

	@Override
	public List<IncomeStorage> findAll() {
		return incomeStorageRepository.findAll();
	}

	@Override
	public IncomeStorage saveIncomeStorage(IncomeStorageRequest entityRequest) {
		return incomeStorageRepository.saveAndFlush(fromReq(new IncomeStorage(), entityRequest));
	}

	@Override
	public IncomeStorage updateIncomeStorage(Long id, IncomeStorageRequest entityRequest) {
		return incomeStorageRepository.saveAndFlush(fromReq(findById(id), entityRequest));
	}

	@Override
	public ResponseEntity<Object> deleteIncomeStorage(Long id) {
		try {
			incomeStorageRepository.deleteById(id);
			incomeStorageRepository.flush();
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private IncomeStorage fromReq(IncomeStorage incomeStorage, IncomeStorageRequest incomeStorageRequest) {
		incomeStorage.setIncome(incomeStorageRequest.getIncome());
		incomeStorage.setMaterial(incomeStorageRequest.getMaterial());
		incomeStorage.setQuantity(incomeStorageRequest.getQuantity());
		incomeStorage.setWraping(incomeStorageRequest.getWraping());
		
		return incomeStorage;
	}

}
