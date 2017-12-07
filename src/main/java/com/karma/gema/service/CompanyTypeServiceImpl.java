package com.karma.gema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.karma.gema.model.CompanyType;
import com.karma.gema.repositories.CompanyTypeRepository;
import com.karma.gema.request.CompanyTypeRequest;

@Service
public class CompanyTypeServiceImpl implements CompanyTypeService {
	
	@Autowired CompanyTypeRepository companyTypeRepository;

	@Override
	public CompanyType findById(Long id) {
		return companyTypeRepository.findById(id).get();
	}
	
	

	@Override
	public CompanyType findByCompanyId(Long id) {
		return companyTypeRepository.findByCompanyId(id);
	}



	@Override
	public List<CompanyType> findAll() {
		return companyTypeRepository.findAll();
	}

	@Override
	public CompanyType saveCompanyType(CompanyTypeRequest entityRequest) {
		return companyTypeRepository.saveAndFlush(fromReq(new CompanyType(), entityRequest));
	}

	@Override
	public CompanyType updateCompanyType(Long id, CompanyTypeRequest entityRequest) {
		return companyTypeRepository.saveAndFlush(fromReq(findById(id), entityRequest));
	}

	@Override
	public ResponseEntity<Object> deleteCompanyType(Long id) {
		try {
			companyTypeRepository.deleteById(id);
			companyTypeRepository.flush();
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private CompanyType fromReq(CompanyType companyType, CompanyTypeRequest companyTypeRequest) {
		companyType.setName(companyTypeRequest.getName());
		companyType.setName(companyTypeRequest.getName());
		
		return companyType;
	}

}
