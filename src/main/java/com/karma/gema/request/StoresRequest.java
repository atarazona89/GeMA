package com.karma.gema.request;

import com.karma.gema.model.Product;
import com.karma.gema.model.Wharehouse;

public class StoresRequest {
	private Wharehouse wharehouse;
	private Product product;
	private double amount;

	public Wharehouse getWharehouse() {
		return wharehouse;
	}

	public Product getProduct() {
		return product;
	}

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
