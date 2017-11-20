package com.karma.gema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.karma.gema.model.Wharehouse;
import com.karma.gema.repositories.WharehouseRepository;
import com.karma.gema.request.WharehouseRequest;

@Service
public class WharehouseServiceImpl implements WharehouseService {

	@Autowired
	WharehouseRepository wharehouseRepository;

	@Override
	public Wharehouse findById(Long id) {
		return wharehouseRepository.findById(id).get();
	}

	@Override
	public List<Wharehouse> findAll() {
		return wharehouseRepository.findAll();
	}

	@Override
	public List<Wharehouse> findBySectorId(Long id) {
		return wharehouseRepository.findBySectorId(id);
	}

	@Override
	public Wharehouse saveWharehouse(WharehouseRequest entityRequest) {
		System.out.println("\tEn el servicio saveWharehouse");
		return wharehouseRepository.save(fromReq(new Wharehouse(), entityRequest));
	}

	@Override
	public Wharehouse updateWharehouse(Long id, WharehouseRequest entityRequest) {
		return wharehouseRepository.save(fromReq(findById(id), entityRequest));
	}

	@Override
	public ResponseEntity<Object> deleteWharehouse(Long id) {
		try {
			wharehouseRepository.deleteById(id);
			wharehouseRepository.flush();
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private Wharehouse fromReq(Wharehouse wharehouse, WharehouseRequest wharehouseRequest) {
		wharehouse.setName(wharehouseRequest.getName());
		wharehouse.setPermit(wharehouseRequest.getPermit());		
		wharehouse.setSector(wharehouseRequest.getSector());
		
		return wharehouse;
	}

}
