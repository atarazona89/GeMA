package com.karma.gema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.karma.gema.model.Product;
import com.karma.gema.repositories.ProductRepository;
import com.karma.gema.request.ProductRequest;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public Product findById(Long id) {
		return productRepository.findById(id).get();
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> findByWharehouseId(Long id) {
		return productRepository.findByWharehouseId(id);
	}

	@Override
	public Product saveProduct(ProductRequest entityRequest) {
		return productRepository.save(fromReq(new Product(), entityRequest));
	}

	@Override
	public Product updateProduct(Long id, ProductRequest entityRequest) {
		return productRepository.save(fromReq(findById(id), entityRequest));
	}

	@Override
	public ResponseEntity<Object> deleteProduct(Long id) {
		try {
			productRepository.deleteById(id);
			productRepository.flush();
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private Product fromReq(Product product, ProductRequest productRequest) {
		product.setMaterial(productRequest.getMaterial());
		product.setDescription(productRequest.getDescription());
		product.setMeasurement(productRequest.getMeasurement());
		product.setName(productRequest.getName());
		product.setStorage(productRequest.getStorage());
		product.setType(productRequest.getType());
		product.setStores(productRequest.getStores());

		return product;
	}

}
