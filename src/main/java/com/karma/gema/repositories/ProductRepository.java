package com.karma.gema.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.karma.gema.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("SELECT p FROM Product p join Stores s WHERE s.wharehouse.id = :id")
	public List<Product> findByWharehouseId(@Param("id") Long id);
}
