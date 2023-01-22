package com.example.mongo.grocery;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataMongoTest
class ItemRepositoryTest {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@BeforeEach
	void setUp() {
		itemRepository.save(new GroceryItem("1", "Milk", 1, "Dairy"));
	}
	
	@AfterEach
	void tearDown() {
		itemRepository.deleteAll();
	}
	
	@DisplayName("몽고 DB 데이터 저장 및 건수 확인 테스트")
	@Test
	void testCase1() {
		long count = itemRepository.count();
		assertThat(count).isOne();
	}
	
	@DisplayName("몽고 DB 데이터 저장 및 조회 데이터 동일성 테스트")
	@Test
	void testCase2() {
		GroceryItem milk = itemRepository.findItemByName("Milk");
		GroceryItem expected = new GroceryItem("1", "Milk", 1, "Dairy");
		assertThat(milk).isEqualTo(expected);
	}
}