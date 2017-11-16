package com.karma.gema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.karma.gema.model.Permit;
import com.karma.gema.repositories.PermitRepository;
import com.karma.gema.request.PermitRequest;

@Service
public class PermitServiceImpl implements PermitService {

	@Autowired
	PermitRepository permitRepository;

	@Override
	public Permit findById(Long id) {
		return permitRepository.findById(id).get();
	}

	@Override
	public Permit findByIdWharehouse(Long id) {
		return permitRepository.findByIdWharehouse(id);
	}

	@Override
	public List<Permit> findAll() {
		return permitRepository.findAll();
	}

	@Override
	public Permit savePermit(PermitRequest entityRequest) {
		return permitRepository.save(fromReq(new Permit(), entityRequest));
	}

	@Override
	public Permit updatePermit(Long id, PermitRequest entityRequest) {
		return permitRepository.save(fromReq(findById(id), entityRequest));
	}

	@Override
	public ResponseEntity<Object> deletePermit(Long id) {
		try {
			permitRepository.deleteById(id);
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private Permit fromReq(Permit permit, PermitRequest permitRequest) {
		permit.setState(permitRequest.getState());
		permit.setDescription(permitRequest.getDescription());
		return permit;
	}

}
