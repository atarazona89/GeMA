package com.karma.gema.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "income")
public class Income extends BaseEntity {

	private Long id;
	private Wharehouse wharehouse;
	private Product product;
	private Company producer;
	private Company distributor;
	private double quantity;
	private boolean storage;

	private List<IncomeStorage> ltStorage;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "idwharehouse", referencedColumnName = "id")
	@JsonManagedReference
	public Wharehouse getWharehouse() {
		return wharehouse;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "idproduct", referencedColumnName = "id")
	@JsonManagedReference
	public Product getProduct() {
		return product;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "idproducer", referencedColumnName = "id")
	@JsonManagedReference
	public Company getProducer() {
		return producer;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "iddistributor", referencedColumnName = "id")
	@JsonManagedReference
	public Company getDistributor() {
		return distributor;
	}

	@Column(name = "quantity")
	public double getQuantity() {
		return quantity;
	}

	@Column(name = "storage")
	public boolean isStorage() {
		return storage;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "income")
	@JsonManagedReference
	public List<IncomeStorage> getLtStorage() {
		return ltStorage;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setWharehouse(Wharehouse wharehouse) {
		this.wharehouse = wharehouse;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setProducer(Company producer) {
		this.producer = producer;
	}

	public void setDistributor(Company distributor) {
		this.distributor = distributor;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public void setStorage(boolean storage) {
		this.storage = storage;
	}

	public void setLtStorage(List<IncomeStorage> ltStorage) {
		this.ltStorage = ltStorage;
	}

}
