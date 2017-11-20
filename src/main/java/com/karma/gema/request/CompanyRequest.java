package com.karma.gema.request;

import com.karma.gema.model.CompanyType;

public class CompanyRequest {

	private Long id;
	private String companyName;
	private String rif;
	private String description;
	private CompanyType companyType;

	public Long getId() {
		return id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getRif() {
		return rif;
	}

	public String getDescription() {
		return description;
	}

	public CompanyType getCompanyType() {
		return companyType;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setRif(String rif) {
		this.rif = rif;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCompanyType(CompanyType companyType) {
		this.companyType = companyType;
	}

}
