package com.karma.gema.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.karma.gema.model.CompanyType;
import com.karma.gema.request.CompanyTypeRequest;

public interface CompanyTypeService {
	public CompanyType findById(Long id);
	public CompanyType findByCompanyId(Long id);
	public List<CompanyType> findAll();
	public CompanyType saveCompanyType(CompanyTypeRequest entityRequest);
	public CompanyType updateCompanyType(Long id, CompanyTypeRequest entityRequest);
	public ResponseEntity<Object> deleteCompanyType(Long id);

}
