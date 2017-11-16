package com.karma.gema.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.karma.gema.model.Wharehouse;

@Repository
public interface WharehouseRepository extends JpaRepository<Wharehouse, Long> {
	
	@Query("SELECT w FROM Wharehouse w WHERE w.id = :idSector")
	public List<Wharehouse> findBySectorId(@Param("idSector") Long id);
}
