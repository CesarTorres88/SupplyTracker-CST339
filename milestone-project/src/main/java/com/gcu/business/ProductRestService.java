package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.model.ProductModel;
import com.gcu.service.ProductsInterface;

@RestController
@RequestMapping("/service")
public class ProductRestService {
	@Autowired
	private ProductsInterface service;
	
	@GetMapping(path="/test", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<ProductModel> getProductsAsJson() {
		return Streamable.of(service.getAllProducts()).toList();
	}
}