package com.karma.gema.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.karma.gema.model.Classification;
import com.karma.gema.request.ClassificationRequest;

public interface ClassificationService {
	public Classification findById(Long id);
	public List<Classification> findAll();
	public Classification saveClassification(ClassificationRequest entityRequest);
	public Classification updateClassification(Long id, ClassificationRequest entityRequest);
	public ResponseEntity<Object> deleteClassification(Long id);

}
