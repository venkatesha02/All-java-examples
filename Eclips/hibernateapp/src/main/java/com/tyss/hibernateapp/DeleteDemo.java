package com.tyss.hibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.hibernateapp.dto.Emp_Primary_Info;

public class DeleteDemo {

	public static void main(String[] args) {

		EntityManagerFactory factory =null;
		EntityManager manager = null;
		EntityTransaction transaction =null;

		try {
			factory= Persistence.createEntityManagerFactory("test");
			manager=factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Emp_Primary_Info record =manager.find(Emp_Primary_Info.class,110);
			manager.remove(record);
			System.out.println("deleted");
			transaction.commit();
			
		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
		}finally {
			factory.close();
			manager.close();

		}
		
	}// end of main()

}//end of class
