package com.karma.gema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.karma.gema.model.Measurement;
import com.karma.gema.repositories.MeasurementRepository;
import com.karma.gema.request.MeasurementRequest;

@Service
public class MeasurementServiceImpl implements MeasurementService {

	@Autowired
	MeasurementRepository measurementRepository;

	@Override
	public Measurement findById(Long id) {
		return measurementRepository.findById(id).get();
	}

	@Override
	public Measurement findByProductId(Long id) {
		return measurementRepository.getByProductId(id);
	}



	@Override
	public List<Measurement> findAll() {
		return measurementRepository.findAll();
	}

	@Override
	public Measurement saveMeasurement(MeasurementRequest entityRequest) {
		return measurementRepository.saveAndFlush(fromReq(new Measurement(), entityRequest));
	}

	@Override
	public Measurement updateMeasurement(Long id, MeasurementRequest entityRequest) {
		return measurementRepository.saveAndFlush(fromReq(findById(id), entityRequest));
	}

	@Override
	public ResponseEntity<Object> deleteMeasurement(Long id) {
		try {
			measurementRepository.deleteById(id);
			measurementRepository.flush();
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private Measurement fromReq(Measurement measurement, MeasurementRequest measurementRequest) {
		measurement.setName(measurementRequest.getName());
		measurement.setAcronym(measurementRequest.getAcronym());

		return measurement;
	}

}
