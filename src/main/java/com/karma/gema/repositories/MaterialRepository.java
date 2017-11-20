package com.karma.gema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karma.gema.model.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {

}
