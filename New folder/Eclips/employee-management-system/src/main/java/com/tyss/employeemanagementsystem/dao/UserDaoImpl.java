package com.tyss.employeemanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.tyss.employeemanagementsystem.dto.UserInfoBean;
import com.tyss.employeemanagementsystem.dto.OtherInfoBean;

import lombok.extern.java.Log;

@Log
@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceUnit
	private EntityManagerFactory factory;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public boolean addUser(UserInfoBean bean) {
		//int a = bean.getUserId();
		//bean.getInfoBean().setId(a);
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
	
			bean.setPassword(encoder.encode(bean.getPassword()));
			manager.persist(bean);
			transaction.commit();
			return true;

		} catch (Exception e) {

			log.info(e.getMessage());

			for (StackTraceElement element : e.getStackTrace()) {

				log.info(element.toString());

			}
			return false;
		}
	}// End of addUser()

	@Override
	public UserInfoBean auth(String email, String password) {

		String jpql = "select e from UserInfoBean e where e.email=:email";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<UserInfoBean> query = manager.createQuery(jpql,UserInfoBean.class);
		//log.info("email "+email);
		//log.info("password "+password);
		query.setParameter("email", email);
		try {

			UserInfoBean bean =  query.getSingleResult();
			//log.info("Password "+password);
			//log.info("bean password "+bean.getPassword());
			if(encoder.matches(password, bean.getPassword())) {
				
				return bean;
		
			}else {
			
				return null;
			
			}

		}catch (Exception e) {
			log.info(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				log.info(element.toString());
			}
			return null;
		}

	}// end of auth()

	@Override
	public List<UserInfoBean> getAllEmp() {
		EntityManager manager = factory.createEntityManager();
		String jpql="select a from UserInfoBean a";
		TypedQuery<UserInfoBean> query = manager.createQuery(jpql,UserInfoBean.class);
		return query.getResultList();
	}

	@Override
	public boolean updateUser(UserInfoBean infoBean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			UserInfoBean bean = manager.find(UserInfoBean.class, infoBean.getUserId());
			bean.setFirstName(infoBean.getFirstName());
			bean.setLastName(infoBean.getLastName());
			bean.setEmail(infoBean.getEmail());
			bean.setPassword(encoder.encode(infoBean.getPassword()));
			bean.setUserType(infoBean.getUserType());

			manager.persist(bean);
			transaction.commit();
			return true;
			
		}catch (Exception e) {
			
			log.info(e.getMessage());

			for (StackTraceElement element : e.getStackTrace()) {

				log.info(element.toString());

			}
			return false;
		}
		
	}// end of userUpdate();

	@Override
	public List<UserInfoBean> userSearch(String firstName) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "select e from UserInfoBean e where e.firstName=:firstName";
		TypedQuery< UserInfoBean> query = manager.createQuery(jpql,UserInfoBean.class);
		query.setParameter("firstName", firstName);
		return query.getResultList();
		
	}// end of userSearch()

	@Override
	public OtherInfoBean find(int id) {
		
		EntityManager manager = factory.createEntityManager();
//		String jpql="select a from UserInfoBean a where a.userId=:id";
		
//		TypedQuery<UserInfoBean> query = manager.createQuery(jpql,UserInfoBean.class);
		//UserOtherInfoBean info = manager.find(UserOtherInfoBean.class, id);
//		System.out.println(info.getEmail());
		//System.out.println(getDateOfBirth());
		//query.setParameter("userId", bean.getUserId());
		return manager.find(OtherInfoBean.class, id);
	}
	

	

}// End of class
