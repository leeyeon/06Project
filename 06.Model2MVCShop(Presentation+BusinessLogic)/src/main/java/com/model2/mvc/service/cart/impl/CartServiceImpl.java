package com.model2.mvc.service.cart.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.cart.CartDao;
import com.model2.mvc.service.cart.CartService;
import com.model2.mvc.service.domain.Cart;

@Repository("cartServiceImpl")
public class CartServiceImpl implements CartService {

	@Autowired
	@Qualifier("cartDaoImpl")
	CartDao cartDao;
	
	public CartServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addCart(Cart cart) throws Exception {
		
		if(!cartDao.checkCart(cart.getProdNo())) {
			cartDao.addCart(cart);
			return true;
		}

		return false;
	}

	@Override
	public Cart getCart(int cartNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cart> getCartList(Search search, String userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateCartStatus(int cartNo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
