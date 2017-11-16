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

import com.karma.gema.model.Wharehouse;
import com.karma.gema.request.WharehouseRequest;
import com.karma.gema.service.WharehouseService;

@Controller
@RequestMapping(value = "/wharehouse")
public class WharehouseController {
	
	@Autowired
	WharehouseService wharehouseService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Wharehouse getWharehouse(@PathVariable("id") Long id) {
		return wharehouseService.findById(id);
	}
	
	@RequestMapping(value = "/bysector/{id}", method = RequestMethod.GET)
	public @ResponseBody
	List<Wharehouse> getBySector(@PathVariable("id") Long id) {
		return wharehouseService.findBySectorId(id);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public @ResponseBody
	List<Wharehouse> getWharehouses() {
		return wharehouseService.findAll();
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public @ResponseBody
	Wharehouse createWharehouse(@RequestBody WharehouseRequest wharehouseRequest) {
		System.out.println("------------------ createWharehouse -------------");
		return wharehouseService.saveWharehouse(wharehouseRequest);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody
	Wharehouse updateWharehouse(@PathVariable("id") Long id,
			@RequestBody WharehouseRequest wharehouseRequest) {
		return wharehouseService.updateWharehouse(id, wharehouseRequest);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	ResponseEntity<Object> deleteWharehouse(@PathVariable("id") Long id) {
		return wharehouseService.deleteWharehouse(id);
	}

}
