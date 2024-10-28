package com.gcu.service;

import java.util.ArrayList;
import java.util.List;

import com.gcu.model.ProductModel;

public class ProductsService implements ProductsInterface {

	@Override
	public List<ProductModel> getProducts() {
		List<ProductModel> products = new ArrayList<ProductModel>();
		products.add(new ProductModel(1, "Product 1", 1.00, "Product 1", 1, "vend1", "cat1", 1, 1, 1.00));
		products.add(new ProductModel(2, "Product 2", 1.00, "Product 1", 1, "vend1", "cat1", 1, 1, 1.00));
		products.add(new ProductModel(3, "Product 3", 1.00, "Product 1", 1, "vend1", "cat1", 1, 1, 1.00));
		products.add(new ProductModel(4, "Product 4", 1.00, "Product 1", 1, "vend1", "cat1", 1, 1, 1.00));
		products.add(new ProductModel(5, "Product 5", 1.00, "Product 1", 1, "vend1", "cat1", 1, 1, 1.00));
		return products;
	}

}
