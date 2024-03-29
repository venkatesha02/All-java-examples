package com.tyss.employeemanagementsystem.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.tyss.employeemanagementsystem.dto.LeaveInfoBean;

import lombok.extern.java.Log;

@Log
@Repository
public class LeaveDaoImpl implements LeaveDao {

	@PersistenceUnit
	private EntityManagerFactory factory;
		
	@Override
	public boolean applyLeave(LeaveInfoBean bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			
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
		
	}// end of applyLeave()
	
	

}// end of class
