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

import com.karma.gema.model.Storage;
import com.karma.gema.request.StorageRequest;
import com.karma.gema.service.StorageService;

@Controller
@RequestMapping(value="/storage")
public class StorageController {
@Autowired
	StorageService storageService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Storage getStorage(@PathVariable("id") Long id) {
		return storageService.findById(id);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public @ResponseBody
	List<Storage> getStorages() {
		return storageService.findAll();
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public @ResponseBody
	Storage createStorage(@RequestBody StorageRequest storageRequest) {
		return storageService.saveStorage(storageRequest);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody
	Storage updateStorage(@PathVariable("id") Long id,
			@RequestBody StorageRequest storageRequest) {
		return storageService.updateStorage(id, storageRequest);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	ResponseEntity<Object> deleteStorage(@PathVariable("id") Long id) {
		return storageService.deleteStorage(id);
	}
}
