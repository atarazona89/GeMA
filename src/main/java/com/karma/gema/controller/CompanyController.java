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

import com.karma.gema.model.Company;
import com.karma.gema.request.CompanyRequest;
import com.karma.gema.service.CompanyService;

@Controller
@RequestMapping(value = "/company")
public class CompanyController {
	
	@Autowired CompanyService companyService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Company getCompany(@PathVariable("id") Long id) {
		//return userService.findById(id);
		return companyService.findById(id);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public @ResponseBody
	List<Company> getCompanies() {
		return companyService.findAll();
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public @ResponseBody
	Company createCompany(@RequestBody CompanyRequest userRequest) {
		return companyService.saveCompany(userRequest);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody
	Company updateCompany(@PathVariable("id") Long id,
			@RequestBody CompanyRequest userRequest) {
		return companyService.updateCompany(id, userRequest);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	ResponseEntity<Object> deleteCompany(@PathVariable("id") Long id) {
		return companyService.deleteCompany(id);
	}
	
	@RequestMapping(value = "/byuser/{id}", method = RequestMethod.GET)
	public @ResponseBody Company getByUser(@PathVariable("id") Long id) {
		return companyService.findByIdUser(id);
	}
}
