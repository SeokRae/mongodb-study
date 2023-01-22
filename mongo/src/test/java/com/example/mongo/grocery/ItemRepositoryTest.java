package com.example.mongo.grocery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataMongoTest
class ItemRepositoryTest {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Test
	void testCase1() {
		itemRepository.save(new GroceryItem("1", "Milk", 1, "Dairy"));
		long count = itemRepository.count();
		System.out.println("count = " + count);
	}
	
	@Test
	void testCase2() {
		GroceryItem milk = itemRepository.findItemByName("Milk");
		GroceryItem expected = new GroceryItem("1", "Milk", 1, "Dairy");
		assertThat(milk).isEqualTo(expected);
	}
}