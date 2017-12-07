package com.karma.gema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.karma.gema.model.Income;
import com.karma.gema.repositories.IncomeRepository;
import com.karma.gema.request.IncomeRequest;

@Service
public class IncomeServiceImpl implements IncomeService {

	@Autowired IncomeRepository incomeRepository;
	
	@Override
	public Income findById(Long id) {
		return incomeRepository.findById(id).get();
	}

	@Override
	public List<Income> findAll() {
		return incomeRepository.findAll();
	}

	@Override
	public Income saveIncome(IncomeRequest entityRequest) {
		return incomeRepository.saveAndFlush(fromReq(new Income(), entityRequest));
	}

	@Override
	public Income updateIncome(Long id, IncomeRequest entityRequest) {
		return incomeRepository.saveAndFlush(fromReq(findById(id), entityRequest));
	}

	@Override
	public ResponseEntity<Object> deleteIncome(Long id) {
		try {
			incomeRepository.deleteById(id);
			incomeRepository.flush();
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private Income fromReq(Income income, IncomeRequest incomeRequest) {
		income.setQuantity(incomeRequest.getQuantity());
		income.setStorage(incomeRequest.isStorage());
		income.setWharehouse(incomeRequest.getWharehouse());
		income.setProduct(incomeRequest.getProduct());
		income.setProducer(incomeRequest.getProducer());
		income.setDistributor(incomeRequest.getDistributor());
		
		return income;
	}

}
