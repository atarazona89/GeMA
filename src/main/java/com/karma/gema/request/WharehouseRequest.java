package com.karma.gema.request;

import com.karma.gema.model.Permit;
import com.karma.gema.model.Sector;

public class WharehouseRequest {
	private Long id;
	private String name;
	private Sector sector;
	private Permit permit;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
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

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public void setPermit(Permit permit) {
		this.permit = permit;
	}

}
