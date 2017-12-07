package com.karma.gema.request;

import com.karma.gema.model.Product;
import com.karma.gema.model.Wharehouse;

public class TransferRequest {

	private Wharehouse wharehouseFrom;
	private Product product;
	private Wharehouse wharehouseTo;
	private double quantity;

	public Wharehouse getWharehouseFrom() {
		return wharehouseFrom;
	}

	public Product getProduct() {
		return product;
	}

	public Wharehouse getWharehouseTo() {
		return wharehouseTo;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setWharehouseFrom(Wharehouse wharehouseFrom) {
		this.wharehouseFrom = wharehouseFrom;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setWharehouseTo(Wharehouse wharehouseTo) {
		this.wharehouseTo = wharehouseTo;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

}
