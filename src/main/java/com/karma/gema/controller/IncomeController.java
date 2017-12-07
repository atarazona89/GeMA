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

import com.karma.gema.model.Income;
import com.karma.gema.request.IncomeRequest;
import com.karma.gema.service.IncomeService;

@Controller
@RequestMapping(value= "/income")
public class IncomeController {
	
	@Autowired
	IncomeService incomeService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Income getIncome(@PathVariable("id") Long id) {
		return incomeService.findById(id);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public @ResponseBody
	List<Income> getIncomes() {
		return incomeService.findAll();
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public @ResponseBody
	Income createIncome(@RequestBody IncomeRequest incomeRequest) {
		return incomeService.saveIncome(incomeRequest);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody
	Income updateIncome(@PathVariable("id") Long id,
			@RequestBody IncomeRequest incomeRequest) {
		return incomeService.updateIncome(id, incomeRequest);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	ResponseEntity<Object> deleteIncome(@PathVariable("id") Long id) {
		return incomeService.deleteIncome(id);
	}

}
