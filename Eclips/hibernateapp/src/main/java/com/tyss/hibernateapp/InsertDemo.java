package com.tyss.hibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.hibernateapp.dto.Emp_Primary_Info;

public class InsertDemo {
	public static void main(String[] args) {

		Emp_Primary_Info emp = new Emp_Primary_Info();

		emp.set_id(2);
		emp.setEmp_name("venki");
		emp.setDepartment_id(12);
		emp.setDesignation("jhgjhg");
		emp.setDob("1997-02-02");
		emp.setJoining_date("1998-02-06");
		emp.setExperience("20.5");
		emp.setManager_id(20);
		emp.setOfficial_mail("vhhhh.com");
		emp.setPhone_number(854585454l);
		emp.setSalary(2.3);
		
		EntityManagerFactory factory =null;
		EntityManager manager = null;
		EntityTransaction transaction =null;

		try {
			
			factory= Persistence.createEntityManagerFactory("test");
			manager=factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(emp);
			System.out.println("saved");
			transaction.commit();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			transaction.rollback();
			
		}finally {
			
			factory.close();
			manager.close();

		}

	}// end of main

}// end of class 
