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

import com.karma.gema.model.Stores;
import com.karma.gema.request.StoresRequest;
import com.karma.gema.service.StoresService;

@Controller
@RequestMapping(value = "/stores")
public class StoresController {
	@Autowired
	StoresService storesService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Stores getStores(@PathVariable("id") Long id) {
		return storesService.findById(id);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public @ResponseBody List<Stores> getStoress() {
		return storesService.findAll();
	}

	@RequestMapping(value = "/bywharehouse/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Stores> getStoress(@PathVariable("id") Long id) {
		return storesService.findByWharehouseId(id);
	}

	@RequestMapping(value = "/inventory", method = RequestMethod.POST, consumes = {"application/json;charset=UTF-8"}, produces={"application/json;charset=UTF-8"})
	public @ResponseBody Boolean addToInventory(@RequestBody StoresRequest storesRequest) {
		System.out.println("\t\taddToInventory");
		return storesService.addToInventory(storesRequest);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody Stores updateStores(@PathVariable("id") Long id, @RequestBody StoresRequest storesRequest) {
		return storesService.updateStores(id, storesRequest);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Object> deleteStores(@PathVariable("id") Long id) {
		return storesService.deleteStores(id);
	}
}
