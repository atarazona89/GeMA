package com.karma.gema.request;

import java.util.List;

import com.karma.gema.model.Classification;
import com.karma.gema.model.Material;
import com.karma.gema.model.Measurement;
import com.karma.gema.model.ProductType;
import com.karma.gema.model.Storage;
import com.karma.gema.model.Stores;

public class ProductRequest {
	
	private String name;
	private String description;
	private ProductType type;
	private Material material;
	private Storage storage;
	private Measurement measurement;
	private Classification classification;
	
	private List<Stores> stores;

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public ProductType getType() {
		return type;
	}

	public Material getMaterial() {
		return material;
	}

	public Storage getStorage() {
		return storage;
	}

	public Measurement getMeasurement() {
		return measurement;
	}

	public Classification getClassification() {
		return classification;
	}

	public List<Stores> getStores() {
		return stores;
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

	public void setStores(List<Stores> stores) {
		this.stores = stores;
	}
	
	

}
