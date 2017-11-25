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
@Table(name = "product")
public class Product extends BaseEntity {

	private Long id;
	private String name;
	private String description;
	private ProductType type;
	private Material material;
	private Storage storage;
	private Measurement measurement;
	private Classification classification;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "idtype", referencedColumnName = "id")
	@JsonManagedReference
	public ProductType getType() {
		return type;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "idmaterial", referencedColumnName = "id")
	@JsonManagedReference
	public Material getMaterial() {
		return material;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "idstorage", referencedColumnName = "id")
	@JsonManagedReference
	public Storage getStorage() {
		return storage;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "idmeasurement", referencedColumnName = "id")
	@JsonManagedReference
	public Measurement getMeasurement() {
		return measurement;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "idclassification", referencedColumnName = "id")
	@JsonManagedReference
	public Classification getClassification() {
		return classification;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	public void setMeasurement(Measurement measurement) {
		this.measurement = measurement;
	}

	public void setClassification(Classification classification) {
		this.classification = classification;
	}

	
}
