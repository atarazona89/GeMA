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

import com.karma.gema.model.IncomeStorage;
import com.karma.gema.request.IncomeStorageRequest;
import com.karma.gema.service.IncomeStorageService;

@Controller
@RequestMapping(value = "/incomestorage")
public class IncomeStorageController {
	@Autowired
	IncomeStorageService incomeStorageService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody IncomeStorage getIncomeStorage(@PathVariable("id") Long id) {
		return incomeStorageService.findById(id);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public @ResponseBody List<IncomeStorage> getIncomeStorages() {
		return incomeStorageService.findAll();
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public @ResponseBody IncomeStorage createIncomeStorage(@RequestBody IncomeStorageRequest incomeStorageRequest) {
		return incomeStorageService.saveIncomeStorage(incomeStorageRequest);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody IncomeStorage updateIncomeStorage(@PathVariable("id") Long id,
			@RequestBody IncomeStorageRequest incomeStorageRequest) {
		return incomeStorageService.updateIncomeStorage(id, incomeStorageRequest);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Object> deleteIncomeStorage(@PathVariable("id") Long id) {
		return incomeStorageService.deleteIncomeStorage(id);
	}
}
