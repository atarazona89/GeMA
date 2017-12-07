package com.karma.gema.request;

import com.karma.gema.model.Company;
import com.karma.gema.model.Product;
import com.karma.gema.model.Wharehouse;

public class IncomeRequest {

	private Wharehouse wharehouse;
	private Product product;
	private Company producer;
	private Company distributor;
	private double quantity;
	private boolean storage;

	public Wharehouse getWharehouse() {
		return wharehouse;
	}

	public Product getProduct() {
		return product;
	}

	public Company getProducer() {
		return producer;
	}

	public Company getDistributor() {
		return distributor;
	}

	public double getQuantity() {
		return quantity;
	}

	public boolean isStorage() {
		return storage;
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

}
