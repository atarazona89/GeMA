package com.karma.gema.request;

import com.karma.gema.model.Product;
import com.karma.gema.model.Wharehouse;

public class StoresRequest {
	private Wharehouse wharehouse;
	private Product product;
	private Long amount;

	public Wharehouse getWharehouse() {
		return wharehouse;
	}

	public Product getProduct() {
		return product;
	}

	public Long getAmount() {
		return amount;
	}

	public void setWharehouse(Wharehouse wharehouse) {
		this.wharehouse = wharehouse;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

}
