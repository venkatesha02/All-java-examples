package com.tyss.hibernate.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.tyss.hibernateapp.dto.Emp_Primary_Info;

public class ReadDemo1 {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
		EntityManager manager = factory.createEntityManager();
		String jpql = "select emp.emp_name from Emp_Primary_Info emp";
		//Query query = manager.createQuery(jpql);
		TypedQuery<Emp_Primary_Info> query = manager.createQuery(jpql, Emp_Primary_Info.class);
		System.out.println(query);
		List<Emp_Primary_Info> record = query.getResultList();
		System.out.println(record);
		for (int i=0;i<record.size();i++) {
			
			System.out.println("Employee Name : "+record.get(i));
			System.out.println("=============================");

		}
		
	}// end of main()

}// end of class
