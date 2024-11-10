package com.gcu.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.gcu.model.ProductModel;

public interface ProductRepository extends CrudRepository<ProductModel, Integer> {

	public ProductModel getProductById(int id);

	/*@Modifying
	@Query(value="UPDATE product SET name=:name, price=:price, description=:description, id=:id, qty=:qty, vendor=:vendor, category=:category, reorder_point=:reorder_point, reorder_amt=:reorder_amt, cost=:cost WHERE id=:id")
	public ProductModel updateProduct(@Param("name") String name, 
			@Param("price") double price, 
			@Param("description") String description, 
			@Param("id") int id, 
			@Param("qty") int qty,
			@Param("vendor") String vendor,
			@Param("category") String category,
			@Param("reorder_point") int reorder_point,
			@Param("reorder_amt") int reorder_amt,
			@Param("cost") double cost);*/
}
