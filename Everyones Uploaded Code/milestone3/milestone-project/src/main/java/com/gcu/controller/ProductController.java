package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.model.ProductModel;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class ProductController {

    private List<ProductModel> products = new ArrayList<>(); // Array List used to store products in memory

    @GetMapping("/products")
    public String displayProducts(HttpServletRequest request, Model model) {
        System.out.println("Displaying product page");
    
        if (products.isEmpty()) { // Sample products
            ProductModel product1 = new ProductModel();
            product1.setId(1);
            product1.setName("Product 1");
            product1.setDescription("Description for Product 1");
            product1.setPrice(19.99);
            product1.setCurrentQuantity(100);
            product1.setVendor("Vendor A");
            product1.setCategory("Category 1");
            product1.setReorder_point(10);
            product1.setReorder_amt(50);
            product1.setCost(15.00);

            products.add(product1);
            // Add more products to the list...
        }
        model.addAttribute("products", products);
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
            model.addAttribute("product", product);
            return "createproduct"; //Returns to creating form
        }

        product.setId(products.size() + 1); // ID Generator
        products.add(product); // Save product to the list
        return "redirect:/products"; // Redirect to the products page
    }
}
