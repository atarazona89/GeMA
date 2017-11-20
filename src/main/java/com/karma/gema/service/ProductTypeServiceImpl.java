package com.karma.gema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.karma.gema.model.ProductType;
import com.karma.gema.repositories.ProductTypeRepository;
import com.karma.gema.request.ProductTypeRequest;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

	@Autowired ProductTypeRepository productTypeRepository; 
	
	@Override
	public ProductType findById(Long id) {
		return productTypeRepository.findById(id).get();
	}

	@Override
	public List<ProductType> findAll() {
		return productTypeRepository.findAll();
	}

	@Override
	public ProductType saveProductType(ProductTypeRequest entityRequest) {
		return productTypeRepository.saveAndFlush(fromReq(new ProductType(), entityRequest));
	}

	@Override
	public ProductType updateProductType(Long id, ProductTypeRequest entityRequest) {
		return productTypeRepository.saveAndFlush(fromReq(findById(id), entityRequest));
	}

	@Override
	public ResponseEntity<Object> deleteProductType(Long id) {
		try{
			productTypeRepository.deleteById(id);
			productTypeRepository.flush();
			return new ResponseEntity<Object>(null,HttpStatus.OK);
		}catch (Exception ex){
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private ProductType fromReq(ProductType productType, ProductTypeRequest productTypeRequest) {
		productType.setName(productTypeRequest.getName());
				
		return productType;
	}

}
