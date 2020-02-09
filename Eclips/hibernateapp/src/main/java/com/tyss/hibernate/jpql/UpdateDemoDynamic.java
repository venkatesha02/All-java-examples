package com.tyss.hibernate.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UpdateDemoDynamic {

	public static void main(String[] args) {

		EntityManagerFactory factory=null;
		EntityTransaction transaction =null;
		EntityManager manager=null;

		try {
			factory = Persistence.createEntityManagerFactory("test");
			manager = factory.createEntityManager();

			transaction = manager.getTransaction();
			transaction.begin();
			
			String jpql = "update Emp_Primary_Info e set e.emp_name=:name where e.id=:eid";
			Query query = manager.createQuery(jpql);
			query.setParameter("eid", 2);
			query.setParameter("name", "venki");
			int result = query.executeUpdate();
			System.out.println("No of count ------> "+result);
			transaction.commit();
			
		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
			
		}finally {
			
			manager.close();
			factory.close();
			
		}

	}//end of main()
	
}//end of class
