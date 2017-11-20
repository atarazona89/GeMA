package com.karma.gema.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.karma.gema.model.Material;
import com.karma.gema.request.MaterialRequest;

public interface MaterialService {
	public Material findById(Long id);
	public List<Material> findAll();
	public Material saveMaterial(MaterialRequest entityRequest);
	public Material updateMaterial(Long id, MaterialRequest entityRequest);
	public ResponseEntity<Object> deleteMaterial(Long id);

}
