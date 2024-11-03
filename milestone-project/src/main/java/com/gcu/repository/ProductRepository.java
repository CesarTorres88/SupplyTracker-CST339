package com.gcu.repository;

import org.springframework.data.repository.CrudRepository;

import com.gcu.model.ProductModel;

public interface ProductRepository extends CrudRepository<ProductModel, Integer> {

}
