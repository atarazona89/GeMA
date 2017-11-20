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

import com.karma.gema.model.Product;
import com.karma.gema.request.ProductRequest;
import com.karma.gema.service.ProductService;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
	@Autowired
	ProductService productService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Product getProduct(@PathVariable("id") Long id) {
		return productService.findById(id);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public @ResponseBody List<Product> getProducts() {
		return productService.findAll();
	}
	
	@RequestMapping(value = "/bywharehouse/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Product> getProductsByWharehouseid(@PathVariable("id") Long id) {
		return productService.findByWharehouseId(id);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public @ResponseBody Product createProduct(@RequestBody ProductRequest productRequest) {
		return productService.saveProduct(productRequest);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody Product updateProduct(@PathVariable("id") Long id,
			@RequestBody ProductRequest productRequest) {
		return productService.updateProduct(id, productRequest);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Object> deleteProduct(@PathVariable("id") Long id) {
		return productService.deleteProduct(id);
	}
}
