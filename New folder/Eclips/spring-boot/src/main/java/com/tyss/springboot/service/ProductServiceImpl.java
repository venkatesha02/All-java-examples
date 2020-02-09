package com.tyss.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.springboot.dao.ProductDao;
import com.tyss.springboot.dto.ProductInfoBean;

@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	private ProductDao dao;
	
	@Override
	public boolean addProduct(ProductInfoBean bean) {
		return dao.addProduct(bean);
	}

	@Override
	public boolean updateProduct(int id, String productName) {
		return dao.updateProduct(id, productName);
	}

	@Override
	public List<ProductInfoBean> search(String productName) {
		return dao.search(productName);
	}

	@Override
	public boolean deleteProduct(int id) {
		return dao.deleteProduct(id);
	}

	@Override
	public List<ProductInfoBean> getAllProduct() {
		return dao.getAllProduct();
	}
	

}
