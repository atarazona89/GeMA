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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "incomestorage")
public class IncomeStorage extends BaseEntity {

	private Long id;
	private double quantity;
	private Income income;
	private Wraping wraping;
	private Material material;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@Column(name= " quantity")
	public double getQuantity() {
		return quantity;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "idincome", referencedColumnName = "id")
	@JsonManagedReference
	public Income getIncome() {
		return income;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "idwraping", referencedColumnName = "id")
	@JsonManagedReference
	public Wraping getWraping() {
		return wraping;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "idmaterial", referencedColumnName = "id")
	@JsonManagedReference
	public Material getMaterial() {
		return material;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public void setIncome(Income income) {
		this.income = income;
	}

	public void setWraping(Wraping wraping) {
		this.wraping = wraping;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

}
