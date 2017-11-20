package com.karma.gema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.karma.gema.model.Storage;
import com.karma.gema.repositories.StorageRepository;
import com.karma.gema.request.StorageRequest;

@Service
public class StorageServiceImpl implements StorageService {

	@Autowired
	StorageRepository storageRepository;

	@Override
	public Storage findById(Long id) {
		return storageRepository.findById(id).get();
	}

	@Override
	public List<Storage> findAll() {
		return storageRepository.findAll();
	}

	@Override
	public Storage saveStorage(StorageRequest entityRequest) {
		return storageRepository.saveAndFlush(fromReq(new Storage(), entityRequest));
	}

	@Override
	public Storage updateStorage(Long id, StorageRequest entityRequest) {
		return storageRepository.saveAndFlush(fromReq(findById(id), entityRequest));
	}

	@Override
	public ResponseEntity<Object> deleteStorage(Long id) {
		try{
			storageRepository.deleteById(id);
			storageRepository.flush();
			return new ResponseEntity<Object>(null,HttpStatus.OK);
		}catch (Exception ex){
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private Storage fromReq(Storage storage, StorageRequest storageRequest) {
		storage.setType(storageRequest.getType());

		return storage;
	}

}
