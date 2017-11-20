package com.karma.gema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karma.gema.model.Storage;

@Repository
public interface StorageRepository extends JpaRepository<Storage, Long> {

}
