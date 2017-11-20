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

import com.karma.gema.model.ProductType;
import com.karma.gema.request.ProductTypeRequest;
import com.karma.gema.service.ProductTypeService;

@Controller
@RequestMapping(value = "/producttype")
public class ProductTypeController {
@Autowired
	ProductTypeService productTypeService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	ProductType getProductType(@PathVariable("id") Long id) {
		return productTypeService.findById(id);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public @ResponseBody
	List<ProductType> getProductTypes() {
		return productTypeService.findAll();
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public @ResponseBody
	ProductType createProductType(@RequestBody ProductTypeRequest productTypeRequest) {
		return productTypeService.saveProductType(productTypeRequest);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody
	ProductType updateProductType(@PathVariable("id") Long id,
			@RequestBody ProductTypeRequest productTypeRequest) {
		return productTypeService.updateProductType(id, productTypeRequest);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	ResponseEntity<Object> deleteProductType(@PathVariable("id") Long id) {
		return productTypeService.deleteProductType(id);
	}
}
