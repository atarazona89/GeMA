package com.karma.gema.request;


public class CompanyRequest {

	private Long id;
	private String companyName;
	private String rif;
	private String description;
	
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
}
