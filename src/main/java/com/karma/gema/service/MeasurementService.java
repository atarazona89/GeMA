package com.karma.gema.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.karma.gema.model.Measurement;
import com.karma.gema.request.MeasurementRequest;

public interface MeasurementService {
	public Measurement findById(Long id);
	public Measurement findByProductId(Long id);
	public List<Measurement> findAll();
	public Measurement saveMeasurement(MeasurementRequest entityRequest);
	public Measurement updateMeasurement(Long id, MeasurementRequest entityRequest);
	public ResponseEntity<Object> deleteMeasurement(Long id);

}
