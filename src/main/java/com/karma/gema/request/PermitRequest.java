package com.karma.gema.request;

public class PermitRequest {

	private Long id;
	private String state;
	private String description;

	public Long getId() {
		return id;
	}

	public String getState() {
		return state;
	}

	public String getDescription() {
		return description;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
