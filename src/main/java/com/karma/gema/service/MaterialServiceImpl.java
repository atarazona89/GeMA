package com.karma.gema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.karma.gema.model.Material;
import com.karma.gema.repositories.MaterialRepository;
import com.karma.gema.request.MaterialRequest;

@Service
public class MaterialServiceImpl implements MaterialService {

	@Autowired
	MaterialRepository materialRepository;

	@Override
	public Material findById(Long id) {
		return materialRepository.findById(id).get();
	}

	@Override
	public List<Material> findAll() {
		return materialRepository.findAll();
	}

	@Override
	public Material saveMaterial(MaterialRequest entityRequest) {
		return materialRepository.saveAndFlush(fromReq(new Material(), entityRequest));
	}

	@Override
	public Material updateMaterial(Long id, MaterialRequest entityRequest) {
		return materialRepository.saveAndFlush(fromReq(findById(id), entityRequest));
	}

	@Override
	public ResponseEntity<Object> deleteMaterial(Long id) {
		try {
			materialRepository.deleteById(id);
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private Material fromReq(Material material, MaterialRequest materialRequest) {
		material.setDescription(materialRequest.getDescription());
		material.setName(materialRequest.getName());

		return material;
	}

}
