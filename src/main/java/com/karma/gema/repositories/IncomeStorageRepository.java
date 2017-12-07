package com.karma.gema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karma.gema.model.IncomeStorage;

@Repository
public interface IncomeStorageRepository extends JpaRepository<IncomeStorage, Long> {

}
