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

import com.karma.gema.model.Permit;
import com.karma.gema.request.PermitRequest;
import com.karma.gema.service.PermitService;

@Controller
@RequestMapping(value="/permit")
public class PermitController {
	
	@Autowired PermitService permitService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Permit findPermit(@PathVariable("id")Long id) {
		return permitService.findById(id);
	}
	
	@RequestMapping(value="", method = RequestMethod.GET)
	public @ResponseBody List<Permit> findPermits(){
		return permitService.findAll();
	}
	
	@RequestMapping(value="", method = RequestMethod.POST)
	public @ResponseBody Permit createPermit(@RequestBody PermitRequest permitRequest) {
		return permitService.savePermit(permitRequest);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public @ResponseBody Permit updatePermit(@PathVariable("id") Long id,
									@RequestBody PermitRequest permitRequest) {
		return permitService.updatePermit(id, permitRequest);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Object> deletePermit(@PathVariable("id") Long id){
		return permitService.deletePermit(id);
	}
	
	@RequestMapping(value = "/bywharehouse/{id}", method = RequestMethod.GET)
	public @ResponseBody Permit findByIdWharehouse(@PathVariable("id") Long id) {
		return permitService.findByIdWharehouse(id);
	}

}
