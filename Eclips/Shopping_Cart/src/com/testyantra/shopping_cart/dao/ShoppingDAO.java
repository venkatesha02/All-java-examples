package com.testyantra.shopping_cart.dao;

import com.testyantra.shopping_cart.bean.CartBean;
import com.testyantra.shopping_cart.bean.OrderBean;
import com.testyantra.shopping_cart.bean.ProductBean;
import com.testyantra.shopping_cart.bean.UserBean;
import com.testyantra.shopping_cart.bean.WishBean;

public interface ShoppingDAO {

	public boolean addProduct(ProductBean productBean);
	
	public boolean addUser(UserBean userBean);
	
	boolean addWishList(WishBean wishBean);
	
	boolean addCart(CartBean cartBean );
	
	public boolean createOrder(OrderBean orderBean);
	
	public ProductBean showProduct();
	
}