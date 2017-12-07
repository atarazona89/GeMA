package com.karma.gema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karma.gema.model.Income;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {

}
