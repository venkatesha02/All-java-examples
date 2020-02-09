package com.tyss.springbootproduct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.springbootproduct.dao.ProductDao;
import com.tyss.springbootproduct.dto.ProductInfo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;
	
	@Override
	public boolean addProduct(ProductInfo info) {
		return dao.addProduct(info);
		
	}

}
