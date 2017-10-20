package com.karma.gema.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "company")
public class Company extends BaseEntity {

	private Long id;
	private String companyName;
	private String rif;
	private String description;
	private List<User> employees;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@Column(name = "companyname")
	public String getCompanyName() {
		return companyName;
	}

	@Column(name = "rif")
	public String getRif() {
		return rif;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="employer")
	@JsonManagedReference
	public List<User> getEmployees() {
		return employees;
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

	public void setEmployees(List<User> employees) {
		this.employees = employees;
	}

	
}
