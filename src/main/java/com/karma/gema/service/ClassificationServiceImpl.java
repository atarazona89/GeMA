package com.karma.gema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.karma.gema.model.Classification;
import com.karma.gema.repositories.ClassificationRepository;
import com.karma.gema.request.ClassificationRequest;

@Service
public class ClassificationServiceImpl implements ClassificationService {

	@Autowired 
	ClassificationRepository classificationRepository;
	
	@Override
	public Classification findById(Long id) {
		return classificationRepository.findById(id).get();
	}

	@Override
	public List<Classification> findAll() {
		return classificationRepository.findAll();
	}

	@Override
	public Classification saveClassification(ClassificationRequest entityRequest) {
		return classificationRepository.saveAndFlush(fromReq(new Classification(), entityRequest));
	}

	@Override
	public Classification updateClassification(Long id, ClassificationRequest entityRequest) {
		return classificationRepository.saveAndFlush(fromReq(findById(id), entityRequest));
	}

	@Override
	public ResponseEntity<Object> deleteClassification(Long id) {
		try {
			classificationRepository.deleteById(id);
			classificationRepository.flush();
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private Classification fromReq(Classification classification, ClassificationRequest classificationRequest) {
		classification.setName(classificationRequest.getName());
		
		return classification;
	}
}
