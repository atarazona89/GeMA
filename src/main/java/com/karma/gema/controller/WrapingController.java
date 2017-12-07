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

import com.karma.gema.model.Wraping;
import com.karma.gema.request.WrapingRequest;
import com.karma.gema.service.WrapingService;

@Controller
@RequestMapping(value="/wraping")
public class WrapingController {
	
	@Autowired
	WrapingService wrapingService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Wraping getWraping(@PathVariable("id") Long id) {
		return wrapingService.findById(id);
	}
	
	@RequestMapping(value = "/byincome/{id}" , method = RequestMethod.GET)
	public @ResponseBody Wraping getByIncomeStorage(@PathVariable("id") Long id) {
		return wrapingService.findByIdIncomeStorage(id);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public @ResponseBody
	List<Wraping> getWrapings() {
		return wrapingService.findAll();
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public @ResponseBody
	Wraping createWraping(@RequestBody WrapingRequest wrapingRequest) {
		return wrapingService.saveWraping(wrapingRequest);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody
	Wraping updateWraping(@PathVariable("id") Long id,
			@RequestBody WrapingRequest wrapingRequest) {
		return wrapingService.updateWraping(id, wrapingRequest);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	ResponseEntity<Object> deleteWraping(@PathVariable("id") Long id) {
		return wrapingService.deleteWraping(id);
	}

}
