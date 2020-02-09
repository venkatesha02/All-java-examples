package com.tyss.hibernate.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DeleteDemo {

	public static void main(String[] args) {

		EntityManagerFactory factory=null;
		EntityTransaction transaction =null;
		EntityManager manager=null;

		try {
			factory = Persistence.createEntityManagerFactory("test");
			manager = factory.createEntityManager();

			transaction = manager.getTransaction();
			transaction.begin();
			
			String jpql = "delete from Emp_Primary_Info e where e.id=3";

			Query query = manager.createQuery(jpql);
			int result = query.executeUpdate();
			System.out.println("No of count ------> "+result);
			transaction.commit();
			
		} catch (Exception e) {

			e.printStackTrace();
			
		}finally {
			
			manager.close();
			factory.close();
			
		}

	}//end of main()
	
}//end of class