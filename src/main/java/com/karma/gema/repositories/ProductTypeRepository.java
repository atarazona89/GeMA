package com.karma.gema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karma.gema.model.ProductType;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {

}
