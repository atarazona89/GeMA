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

import com.karma.gema.model.Material;
import com.karma.gema.request.MaterialRequest;
import com.karma.gema.service.MaterialService;

@Controller
@RequestMapping(value="/material")
public class MaterialController {
	@Autowired
	MaterialService materialService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Material getMaterial(@PathVariable("id") Long id) {
		return materialService.findById(id);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public @ResponseBody
	List<Material> getMaterials() {
		return materialService.findAll();
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public @ResponseBody
	Material createMaterial(@RequestBody MaterialRequest materialRequest) {
		return materialService.saveMaterial(materialRequest);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody
	Material updateMaterial(@PathVariable("id") Long id,
			@RequestBody MaterialRequest materialRequest) {
		return materialService.updateMaterial(id, materialRequest);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	ResponseEntity<Object> deleteMaterial(@PathVariable("id") Long id) {
		return materialService.deleteMaterial(id);
	}

}
