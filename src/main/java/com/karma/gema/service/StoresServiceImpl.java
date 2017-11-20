package com.karma.gema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.karma.gema.model.Stores;
import com.karma.gema.repositories.StoresRepository;
import com.karma.gema.request.StoresRequest;

@Service
public class StoresServiceImpl implements StoresService {

	@Autowired
	StoresRepository storesRepository;

	@Override
	public Stores findById(Long id) {
		return storesRepository.findById(id).get();
	}

	@Override
	public List<Stores> findAll() {
		return storesRepository.findAll();
	}

	@Override
	public List<Stores> findByWharehouseId(Long id) {
		return storesRepository.findByWharehouseId(id);
	}

	@Override
	public Stores saveStores(StoresRequest entityRequest) {
		return storesRepository.saveAndFlush(fromReq(new Stores(), entityRequest));
	}

	@Override
	public Stores updateStores(Long id, StoresRequest entityRequest) {
		return storesRepository.saveAndFlush(fromReq(findById(id), entityRequest));
	}

	@Override
	public ResponseEntity<Object> deleteStores(Long id) {
		try {
			storesRepository.deleteById(id);
			storesRepository.flush();
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private Stores fromReq(Stores stores, StoresRequest storesRequest) {
		stores.setAmount(storesRequest.getAmount());
		stores.setProduct(storesRequest.getProduct());
		stores.setWharehouse(storesRequest.getWharehouse());

		return stores;
	}

}