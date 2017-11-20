package com.karma.gema.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.karma.gema.model.ProductType;
import com.karma.gema.request.ProductTypeRequest;

public interface ProductTypeService {
	public ProductType findById(Long id);
	public List<ProductType> findAll();
	public ProductType saveProductType(ProductTypeRequest entityRequest);
	public ProductType updateProductType(Long id, ProductTypeRequest entityRequest);
	public ResponseEntity<Object> deleteProductType(Long id);

}
