/**
 * 
 */
package com.karma.gema.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Alejandro Tarazona Permisos de almacenamientos quimicos para las
 *         bodegas
 *
 */

@Entity
@Table(name = "permit")
public class Permit extends BaseEntity {

	private Long id;
	private String state;
	private String description;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@Column(name="state")
	public String getState() {
		return state;
	}

	@Column(name="description")
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
