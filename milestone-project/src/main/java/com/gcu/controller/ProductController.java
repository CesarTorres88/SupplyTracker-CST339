package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.model.ProductModel;
import com.gcu.service.ProductsService;

import jakarta.validation.Valid;

@Controller
public class ProductController {

    private final ProductsService productsService;
    
    @Autowired
    public ProductController(ProductsService productsService) {
    	this.productsService = productsService;
    }
    
    @GetMapping("/products")
    public String displayProducts(Model model) {
        System.out.println("Displaying product page");
        List<ProductModel> productList = new ArrayList<ProductModel>();
        Iterable<ProductModel> products = productsService.getAllProducts();
        for (ProductModel product: products) {
        	productList.add(product);
        }
        model.addAttribute("products", productList);
        return "product"; // Return to product.html in templates
    }

    @GetMapping("/createproduct")
    public String displayCreateProductForm(Model model) {
        model.addAttribute("product", new ProductModel()); // Create an empty product model for the form
        return "createproduct"; // Return to createproduct.html
    }

    @PostMapping("/createproduct")
    public String createProduct(@Valid @ModelAttribute ProductModel product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            //If an error is return to the from with errors
            return "createproduct"; //Returns to creating form
        }

        ProductModel newProduct = productsService.createProduct(product);
        model.addAttribute("productData", newProduct);
        return "redirect:/products"; // Redirect to the products page
    }
}
