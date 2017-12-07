package com.karma.gema.request;

import com.karma.gema.model.Income;
import com.karma.gema.model.Material;
import com.karma.gema.model.Wraping;

public class IncomeStorageRequest {
	
	private double quantity;
	private Income income;
	private Wraping wraping;
	private Material material;
	public double getQuantity() {
		return quantity;
	}
	public Income getIncome() {
		return income;
	}
	public Wraping getWraping() {
		return wraping;
	}
	public Material getMaterial() {
		return material;
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
