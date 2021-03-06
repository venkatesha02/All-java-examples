package com.tyss.springbootproduct.dao;

import java.util.List;

import com.tyss.springbootproduct.dto.ProductInfo;

public interface ProductDao {

	public boolean addProduct(ProductInfo info);
	
	public boolean updateProduct(int id, String productName);

	public List<ProductInfo> search(String productName);

	public boolean deleteProduct(int id);
	
	public List<ProductInfo> getAllProduct();
	
}
