package com.karma.gema.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.karma.gema.model.Sector;
import com.karma.gema.request.SectorRequest;

public interface SectorService {
	
	public Sector findById(Long id);
	public Sector findByWharehouseId(Long id);
	public List<Sector> findAll();
	public Sector saveSector(SectorRequest entityRequest);
	public Sector updateSector(Long id, SectorRequest entityRequest);
	public ResponseEntity<Object> deleteSector(Long id);

}