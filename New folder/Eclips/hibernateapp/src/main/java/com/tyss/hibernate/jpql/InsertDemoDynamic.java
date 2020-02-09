package com.tyss.hibernate.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class InsertDemoDynamic {

	public static void main(String[] args) {
		EntityManagerFactory factory=null;
		EntityTransaction transaction =null;
		EntityManager manager=null;

		try {
			factory = Persistence.createEntityManagerFactory("test");
			manager = factory.createEntityManager();

			transaction = manager.getTransaction();
			transaction.begin();
			
			String jpql = "insert into emp_primary_info values(:eid,:name,"
					+ ":sal,:dept_id,:jdate,"
					+ ":phn,:mail,:des,:dob,"
					+ ":mgr,:exp)";
			Query query = manager.createNativeQuery(jpql);
			
			query.setParameter("eid", 8);
//			query.setParameter("name", "venki");
//			query.setParameter("sal", 20000);
//			query.setParameter("dept_id", 20);
//			query.setParameter("jdate", "1998-06-20");
//			query.setParameter("phn", 987987897l);
//			query.setParameter("mail", "venki@gmail.com");
//			query.setParameter("des", "SE");
//			query.setParameter("dob", "2019-20-20");
//			query.setParameter("mgr", 52);
//			query.setParameter("exp", 6.3);
//			
			
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
