package com.example.mongo.users;

import com.example.mongo.core.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Getter
@NoArgsConstructor
@Document(collection = "members")
@Entity
public class Member extends BaseEntity {
	
	private String name;
	@ManyToOne
	@JoinColumn(name = "addresses_id")
	private Address addresses;
	
	public Member(String name, Address addresses) {
		this.name = name;
		this.addresses = addresses;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Member member)) return false;
		return Objects.equals(name, member.name) && Objects.equals(addresses, member.addresses);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, addresses);
	}
}
