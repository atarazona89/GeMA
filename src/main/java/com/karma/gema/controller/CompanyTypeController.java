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

import com.karma.gema.model.CompanyType;
import com.karma.gema.request.CompanyTypeRequest;
import com.karma.gema.service.CompanyTypeService;

@Controller
@RequestMapping(value="/companytype")
public class CompanyTypeController {
	
	@Autowired
	CompanyTypeService companyTypeService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	CompanyType getCompanyType(@PathVariable("id") Long id) {
		return companyTypeService.findById(id);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public @ResponseBody
	List<CompanyType> getCompanyTypes() {
		return companyTypeService.findAll();
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public @ResponseBody
	CompanyType createCompanyType(@RequestBody CompanyTypeRequest companyTypeRequest) {
		return companyTypeService.saveCompanyType(companyTypeRequest);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody
	CompanyType updateCompanyType(@PathVariable("id") Long id,
			@RequestBody CompanyTypeRequest companyTypeRequest) {
		return companyTypeService.updateCompanyType(id, companyTypeRequest);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	ResponseEntity<Object> deleteCompanyType(@PathVariable("id") Long id) {
		return companyTypeService.deleteCompanyType(id);
	}

}
