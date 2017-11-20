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

import com.karma.gema.model.Classification;
import com.karma.gema.request.ClassificationRequest;
import com.karma.gema.service.ClassificationService;

@Controller
@RequestMapping(value="/classification")
public class ClassificationController {
@Autowired
	ClassificationService classificationService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Classification getClassification(@PathVariable("id") Long id) {
		return classificationService.findById(id);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public @ResponseBody
	List<Classification> getClassifications() {
		return classificationService.findAll();
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public @ResponseBody
	Classification createClassification(@RequestBody ClassificationRequest classificationRequest) {
		return classificationService.saveClassification(classificationRequest);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody
	Classification updateClassification(@PathVariable("id") Long id,
			@RequestBody ClassificationRequest classificationRequest) {
		return classificationService.updateClassification(id, classificationRequest);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	ResponseEntity<Object> deleteClassification(@PathVariable("id") Long id) {
		return classificationService.deleteClassification(id);
	}
}
