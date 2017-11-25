package com.karma.gema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.karma.gema.model.Sector;

@Repository
public interface SectorRepository extends JpaRepository<Sector, Long> {
	
	@Query("Select s from Wharehouse w join w.sector s where w.id = (:idwharehouse)")
	public Sector findByWharehouseId(@Param("idwharehouse") Long id);

}
