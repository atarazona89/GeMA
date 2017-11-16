package com.karma.gema.request;

import com.karma.gema.model.Permit;
import com.karma.gema.model.Sector;

public class WharehouseRequest {
	private Long id;
	private String name;
	private String code;
	private String address;
	private Sector sector;
	private Permit permit;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}

	public String getAddress() {
		return address;
	}

	public Sector getSector() {
		return sector;
	}

	public Permit getPermit() {
		return permit;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public void setPermit(Permit permit) {
		this.permit = permit;
	}
	
}
