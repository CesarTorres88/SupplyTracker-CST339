package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.SessionScope;

import com.gcu.service.ProductsInterface;
import com.gcu.service.ProductsService;

@Configuration
public class SpringConfig {
	@Bean(name="prodService")
	public ProductsInterface getProductsService() {
		return new ProductsService();
	}
}
