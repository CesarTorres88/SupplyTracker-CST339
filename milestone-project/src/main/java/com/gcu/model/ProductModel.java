package com.gcu.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ProductModel {

    private int id;

    @NotBlank(message = "Product name is required")
    private String name;

    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0.00")
    private double price;

    @NotBlank(message = "Description is required")
    private String description;

    @Min(value = 0, message = "Current quantity cannot be negative")
    private int currentQuantity;

    @NotBlank(message = "Vendor is required")
    private String vendor;

    @NotBlank(message = "Category is required")
    private String category;

    @Min(value = 0, message = "Reorder point cannot be negative")
    private int reorder_point;

    @Min(value = 1, message = "Reorder amount must be at least 1")
    private int reorder_amt;

    @DecimalMin(value = "0.00", inclusive = false, message = "Cost must be greater than 0.00")
    private double cost;

    public ProductModel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReorder_point() {
        return reorder_point;
    }

    public void setReorder_point(int reorder_point) {
        this.reorder_point = reorder_point;
    }

    public int getReorder_amt() {
        return reorder_amt;
    }

    public void setReorder_amt(int reorder_amt) {
        this.reorder_amt = reorder_amt;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}

