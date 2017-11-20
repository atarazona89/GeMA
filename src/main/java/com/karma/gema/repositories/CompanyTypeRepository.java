package com.karma.gema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karma.gema.model.CompanyType;

@Repository
public interface CompanyTypeRepository extends JpaRepository<CompanyType, Long> {

}
