package com.karma.gema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.karma.gema.model.Wraping;
import com.karma.gema.repositories.WrapingRepository;
import com.karma.gema.request.WrapingRequest;

@Service
public class WrapingServiceImpl implements WrapingService {

	@Autowired WrapingRepository wrapingRepository;
	
	@Override
	public Wraping findById(Long id) {
		return wrapingRepository.getOne(id);
	}
	
	

	@Override
	public Wraping findByIdIncomeStorage(Long id) {
		return wrapingRepository.getByIncomeId(id);
	}

	@Override
	public List<Wraping> findAll() {
		return wrapingRepository.findAll();
	}

	@Override
	public Wraping saveWraping(WrapingRequest entityRequest) {
		return wrapingRepository.saveAndFlush(fromReq(new Wraping(), entityRequest));
	}

	@Override
	public Wraping updateWraping(Long id, WrapingRequest entityRequest) {
		return wrapingRepository.saveAndFlush(fromReq(findById(id), entityRequest));
	}

	@Override
	public ResponseEntity<Object> deleteWraping(Long id) {
		try {
			wrapingRepository.deleteById(id);
			wrapingRepository.flush();
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private Wraping fromReq(Wraping wraping, WrapingRequest request) {
		wraping.setName(request.getName());
		
		return wraping;
	}

}
