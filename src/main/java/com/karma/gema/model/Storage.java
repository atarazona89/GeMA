package com.karma.gema.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "storage")
public class Storage extends BaseEntity {

	private Long id;
	private String type;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@Column(name = "type")
	public String getType() {
		return type;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}

}
