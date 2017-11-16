package com.karma.gema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karma.gema.model.Sector;

@Repository
public interface SectorRepository extends JpaRepository<Sector, Long> {

}
