package com.tyss.hibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.hibernateapp.dto.Emp_Primary_Info;

public class Reattach {

	public static void main(String[] args) {

		EntityManagerFactory factory =null;
		EntityManager manager = null;
		EntityTransaction transaction =null;

		try {
			factory= Persistence.createEntityManagerFactory("test");
			manager=factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Emp_Primary_Info record =manager.find(Emp_Primary_Info.class,127);
//			System.out.println("before Detach ----->  "+manager.contains(record));
//			manager.detach(record);
//			System.out.println("After Detach -----> "+manager.contains(record));
			record.setEmp_name("test");
//			Emp_Primary_Info emp =manager.merge(record);
			System.out.println("update");
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