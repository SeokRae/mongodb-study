package com.example.mongo.products;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {
	private String id;
	private String name;
	private String description;
	private String category;
	private double price;

	public Product() {
	}

	public Product(String id, String name, String description, String category, double price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
