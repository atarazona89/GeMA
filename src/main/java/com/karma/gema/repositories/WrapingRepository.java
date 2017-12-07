package com.karma.gema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.karma.gema.model.Wraping;

@Repository
public interface WrapingRepository extends JpaRepository<Wraping, Long> {

	@Query("select w from IncomeStorage s join s.wraping w where s.id = (:idIncome)")
	public Wraping getByIncomeId(@Param("idIncome") Long id);
}
