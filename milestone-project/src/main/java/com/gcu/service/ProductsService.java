package com.gcu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.model.ProductModel;
import com.gcu.repository.ProductRepository;

@Service
public class ProductsService implements ProductsInterface {
	
	private final ProductRepository productRepository;
	
	@Autowired
	public ProductsService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Override
	public ProductModel createProduct(ProductModel pm) {
		return productRepository.save(pm);
	}

	@Override
	public Iterable<ProductModel> getAllProducts() {
		return productRepository.findAll();
	}

}
