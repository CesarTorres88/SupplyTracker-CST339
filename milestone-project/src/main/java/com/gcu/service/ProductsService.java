package com.gcu.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.model.ProductModel;
import com.gcu.repository.ProductRepository;

import jakarta.validation.Valid;

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

	@Override
	public ProductModel getProductById(int id) {
		return productRepository.getProductById(id);
	}

	public ProductModel updateProduct(@Valid ProductModel product) {
		//return productRepository.updateProduct(product.getName(), product.getPrice(), product.getDescription(), product.getId(), product.getCurrentQuantity(), product.getVendor(), product.getCategory(), product.getReorder_point(), product.getReorder_amt(), product.getCost());
		Optional<ProductModel> result = productRepository.findById(product.getId());
		ProductModel prod = result.get();
		prod.setName(product.getName());
		prod.setPrice(product.getPrice());
		prod.setDescription(product.getDescription());
		prod.setCurrentQuantity(product.getCurrentQuantity());
		prod.setVendor(product.getVendor());
		prod.setCategory(product.getCategory());
		prod.setReorder_point(product.getReorder_point());
		prod.setReorder_amt(product.getReorder_amt());
		prod.setCost(product.getCost());
		productRepository.save(product);
		return product;
	}



	public void deleteProductById(int id) {
		productRepository.deleteById(id);
	}

}
