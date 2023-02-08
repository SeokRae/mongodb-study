package com.example.mongo.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataMongoTest
class MemberRepositoryTest {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Test
	void testCase1() {
		Address address = new Address("123 Main St", "Anytown", "CA", "12345", "USA");
		Member member = new Member("John", address);
		Member savedMember = memberRepository.save(member);
		
		assertThat(savedMember).isNotNull();
	}
}