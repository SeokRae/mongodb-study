package com.example.mongo.orders;

import com.example.mongo.orders.shipping.ShippingInfo;
import com.example.mongo.products.Product;
import com.example.mongo.users.Member;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 주문정보에 대한 속성
 */
@Document(collection = "orders")
public class Orders {
	// 주문 아이디
	private String orderId;
	// 주문자 아이디
	private Member member;
	// 배송 정보
	private ShippingInfo ShippingInfo;
	// 주문 상태
	private String status;
	private LocalDateTime orderDate;
	private List<Product> products;
	private BigDecimal price;
	
	public Orders() {
	}

}
