package com.karma.gema.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.karma.gema.model.Product;
import com.karma.gema.request.ProductRequest;

public interface ProductService {
	public Product findById(Long id);
	public List<Product> findAll();
	public List<Product> findByWharehouseId(Long id);
	public Product saveProduct(ProductRequest entityRequest);
	public Product updateProduct(Long id, ProductRequest entityRequest);
	public ResponseEntity<Object> deleteProduct(Long id);

}
