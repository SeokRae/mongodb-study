package com.example.mongo.users;

import com.example.mongo.core.domain.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@NoArgsConstructor
@Document(collection = "address")
@Entity
public class Address extends BaseEntity {
	private String street;
	private String city;
	private String state;
	private String zip;
	private String country;
	
	public Address(String street, String city, String state, String zip, String country) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
	}
	
	
}
