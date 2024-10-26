package com.gcu.model;

public class ProductModel {
	private int id;
	private String name;
	private double price;
	private String description;
	private int currentQuantity;
	private String vendor;
	private String category;
	private int reorder_point;
	private int reorder_amt;
	private double cost;
	
	public int getId() {
		return id;
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
