package com.model2.mvc.service.cart.test;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model2.mvc.service.cart.CartService;
import com.model2.mvc.service.domain.Cart;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/context-*.xml" })
public class CartServiceTest {

	@Autowired
	@Qualifier("cartServiceImpl")
	CartService cartService;
	
	int prodNo = 10008;
	int cartNo = 10000;
	String userId = "testUserId";
	
	//@Test
	public void testAddCart() throws Exception {
		
		System.out.println("여기여기");
		Cart cart = new Cart();
		cart.setProdNo(prodNo);
		cart.setUserId(userId);
		cart.setCartDate(new Date(System.currentTimeMillis()));
		
		boolean result = cartService.addCart(cart);
		System.out.println("결과 :: "+result);
	
	}
	
	public void testGetCart() throws Exception {
		 
	}

}
