package com.gcu.service;

import java.util.List;

import com.gcu.model.ProductModel;

public interface ProductsInterface {
	ProductModel createProduct(ProductModel pm);
	Iterable<ProductModel> getAllProducts();
	ProductModel getProductById(int id);
}
