package com.karma.gema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.karma.gema.model.Measurement;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {

	@Query("select m from Product p join p.measurement m where p.id = (:idproduct)")
	public Measurement getByProductId(@Param("idproduct") Long id);
}
