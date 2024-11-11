package com.gcu.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.gcu.model.ProductModel;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;

public interface ProductRepository extends CrudRepository<ProductModel, Integer> {

	public ProductModel getProductById(int id);

	@Modifying
	@Transactional
	@Query("DELETE FROM product WHERE id = :id")
	void deleteById(@Param("id") int id);

}
