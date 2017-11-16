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

import com.karma.gema.model.Sector;
import com.karma.gema.request.SectorRequest;
import com.karma.gema.service.SectorService;

@Controller
@RequestMapping(value = "/sector")
public class SectorController {
	
	@Autowired
	SectorService sectorService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Sector getSector(@PathVariable("id") Long id) {
		//return sectorService.createSector(new Sector());
		return sectorService.findById(id);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public @ResponseBody
	List<Sector> getSectors() {
		return sectorService.findAll();
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public @ResponseBody
	Sector createSector(@RequestBody SectorRequest sectorRequest) {
		return sectorService.saveSector(sectorRequest);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody
	Sector updateSector(@PathVariable("id") Long id,
			@RequestBody SectorRequest sectorRequest) {
		return sectorService.updateSector(id, sectorRequest);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	ResponseEntity<Object> deleteSector(@PathVariable("id") Long id) {
		return sectorService.deleteSector(id);
	}

}
