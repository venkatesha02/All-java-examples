package com.tyss.springboot.dao;

import java.util.List;

import com.tyss.springboot.dto.ProductInfoBean;

public interface ProductDao {

	public boolean addProduct(ProductInfoBean bean);

	public boolean updateProduct(int id, String productName);

	public List<ProductInfoBean> search(String productName);

	public boolean deleteProduct(int id);
	
	public List<ProductInfoBean> getAllProduct();

}
	