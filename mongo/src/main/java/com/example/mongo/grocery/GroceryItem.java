package com.example.mongo.grocery;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document("groceryitems")
public class GroceryItem {
	
	@Id
	private String id;
	
	private String name;
	private int quantity;
	private String category;
	
	public GroceryItem(String id, String name, int quantity, String category) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.category = category;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof GroceryItem that)) return false;
		return Objects.equals(id, that.id) && Objects.equals(name, that.name);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
}
