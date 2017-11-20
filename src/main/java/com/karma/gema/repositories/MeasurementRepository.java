package com.karma.gema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karma.gema.model.Measurement;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {

}
