package com.karma.gema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karma.gema.model.Classification;

@Repository
public interface ClassificationRepository extends JpaRepository<Classification, Long> {

}
