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

@Entity
@Table(name = "stores")
public class Stores extends BaseEntity {

	private Long id;
	private Wharehouse wharehouse;
	private Product product;
	private double amount;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
		return id;
	}
    
    public void setId(Long id) {
		this.id = id;
	}
	
    @JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "idwharehouse", referencedColumnName = "id")
	@JsonBackReference
	public Wharehouse getWharehouse() {
		return wharehouse;
	}

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "idproduct", referencedColumnName = "id")
	public Product getProduct() {
		return product;
	}

	@Column(name="amount")
	public double getAmount() {
		return amount;
	}

	public void setWharehouse(Wharehouse wharehouse) {
		this.wharehouse = wharehouse;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
