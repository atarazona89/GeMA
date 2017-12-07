package com.karma.gema.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.karma.gema.model.Income;
import com.karma.gema.request.IncomeRequest;

public interface IncomeService {

	public Income findById(Long id);
	public List<Income> findAll();
	public Income saveIncome(IncomeRequest entityRequest);
	public Income updateIncome(Long id, IncomeRequest entityRequest);
	public ResponseEntity<Object> deleteIncome(Long id);

}
