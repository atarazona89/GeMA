/**
 * 
 */
package com.karma.gema.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author Alejandro Bodegas de almacenamiento de productos con sus respectivos
 *         permisos y áreas asociadas
 *
 */
@Entity
@Table(name = "wharehouse")
public class Wharehouse extends BaseEntity {

	private Long id;
	private String name;
	private String code;
	private Sector sector;
	private Permit permit;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	@Column(name = "identificador")
	public String getCode() {
		return code;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "idarea", referencedColumnName = "id")
	@JsonManagedReference
	public Sector getSector() {
		return sector;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "idpermit", referencedColumnName = "id")
	@JsonBackReference
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

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public void setPermit(Permit permit) {
		this.permit = permit;
	}

}
