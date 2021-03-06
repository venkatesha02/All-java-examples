package com.tyss.springbootproduct.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.tyss.springbootproduct.dto.ProductInfo;
import com.tyss.springbootproduct.exception.EmailAlreadyExistException;

import lombok.extern.java.Log;

@Log
@Repository
public class ProductDaoImpl implements ProductDao{

	@PersistenceUnit
	private EntityManagerFactory factory;
	
	@Override
	public boolean addProduct(ProductInfo info) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(info);
			transaction.commit();
			return true;
			
		}catch (Exception e) {
			log.info(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				log.info(element.toString());
			}
		}
		throw new EmailAlreadyExistException("Choose Another Email");
	}

	@Override
	public boolean updateProduct(int id, String productName) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		ProductInfo bean = manager.find(ProductInfo.class, id);
		bean.setName(productName);
		manager.persist(bean);
		transaction.commit();
		return true;
	}

	@Override
	public List<ProductInfo> search(String productName) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "select e from ProductInfoBean e where e.productName=:productName";
		TypedQuery<ProductInfo> query = manager.createQuery(jpql,ProductInfo.class);
		query.setParameter("productName", productName);
		return query.getResultList();
	}

	@Override
	public boolean deleteProduct(int id) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		ProductInfo bean= manager.find(ProductInfo.class, id);
		manager.remove(bean);
		transaction.commit();
		return true;
	}

	@Override
	public List<ProductInfo> getAllProduct() {
		EntityManager manager = factory.createEntityManager();
		String jpql="select a from ProductInfoBean a";
		TypedQuery<ProductInfo> query = manager.createQuery(jpql,ProductInfo.class);
		return query.getResultList();
	}
	
}
