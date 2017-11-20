package com.karma.gema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.karma.gema.model.Measurement;
import com.karma.gema.request.MeasurementRequest;
import com.karma.gema.service.MeasurementService;

@Controller
@RequestMapping(value="/measurement")
public class MeasurementController {

	@Autowired
	MeasurementService measurementService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Measurement getMeasurement(@PathVariable("id") Long id) {
		return measurementService.findById(id);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public @ResponseBody
	List<Measurement> getMeasurements() {
		return measurementService.findAll();
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public @ResponseBody
	Measurement createMeasurement(@RequestBody MeasurementRequest measurementRequest) {
		return measurementService.saveMeasurement(measurementRequest);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody
	Measurement updateMeasurement(@PathVariable("id") Long id,
			@RequestBody MeasurementRequest measurementRequest) {
		return measurementService.updateMeasurement(id, measurementRequest);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	ResponseEntity<Object> deleteMeasurement(@PathVariable("id") Long id) {
		return measurementService.deleteMeasurement(id);
	}
}
