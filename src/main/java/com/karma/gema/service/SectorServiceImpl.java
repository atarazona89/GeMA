package com.karma.gema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.karma.gema.model.Sector;
import com.karma.gema.repositories.SectorRepository;
import com.karma.gema.request.SectorRequest;

@Service
public class SectorServiceImpl implements SectorService {

	@Autowired SectorRepository sectorRepository;
	
	@Override
	public Sector findById(Long id) {
		return sectorRepository.findById(id).get();
	}

	@Override
	public Sector findByWharehouseId(Long id) {
		return sectorRepository.findByWharehouseId(id);
	}

	@Override
	public List<Sector> findAll() {
		return sectorRepository.findAll();
	}

	@Override
	public Sector saveSector(SectorRequest entityRequest) {
		return sectorRepository.save(fromReq(new Sector(), entityRequest));
	}

	@Override
	public Sector updateSector(Long id, SectorRequest entityRequest) {
		return sectorRepository.save(fromReq(findById(id), entityRequest));
	}

	@Override
	public ResponseEntity<Object> deleteSector(Long id) {
		try{
			sectorRepository.deleteById(id);
			sectorRepository.flush();
			return new ResponseEntity<Object>(null,HttpStatus.OK);
		}catch (Exception ex){
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}	}
	
	private Sector fromReq(Sector sector, SectorRequest sectorRequest) {
		sector.setName(sectorRequest.getName());
		
		return sector;
	}

}
