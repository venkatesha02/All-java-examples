package com.tyss.hibernateapp.many_to_many;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.hibernateapp.dto.Emp_Primary_Info;

public class Test_Many_to_Many {

	public static void main(String[] args) {

		Emp_Primary_Info emp = new Emp_Primary_Info();

		emp.set_id(333);
		emp.setEmp_name("venki");
		emp.setDepartment_id(12);
		emp.setDesignation("jhgjhg");
		emp.setDob("1997-02-02");
		emp.setJoining_date("1998-02-06");
		emp.setExperience("20.5");
		emp.setManager_id(20);
		emp.setOfficial_mail("venki.com");
		emp.setPhone_number(854585454l);
		emp.setSalary(2.3);
		
		Emp_Primary_Info emp1 = new Emp_Primary_Info();

		emp1.set_id(334);
		emp1.setEmp_name("vinay testyantra");
		emp1.setDepartment_id(12);
		emp1.setDesignation("jhgjhg");
		emp1.setDob("1997-02-02");
		emp1.setJoining_date("1998-02-06");
		emp1.setExperience("20.5");
		emp1.setManager_id(20);
		emp1.setOfficial_mail("vinay.com");
		emp1.setPhone_number(854585454l);
		emp1.setSalary(2.3);
		
		ArrayList<Emp_Primary_Info> arraylist = new ArrayList<Emp_Primary_Info>();
		arraylist.add(emp);
		arraylist.add(emp1);
		
		Project_info project = new Project_info();
		project.setProject_id(22);
		project.setProject_name("Varma");
		project.setTechnology("C and C++");
		project.setLocation("banglore");
		project.setStart_date("2019-01-01");
		project.setEnd_date("2020-01-01");
		project.setPrimaryinfo(arraylist);
		
		Project_info project1 = new Project_info();
		project1.setProject_id(33);
		project1.setProject_name("Varma");
		project1.setTechnology("C and C++");
		project1.setLocation("banglore");
		project1.setStart_date("2019-01-01");
		project1.setEnd_date("2020-01-01");
		project1.setPrimaryinfo(arraylist);
		
		ArrayList<Project_info> arraylist1 = new ArrayList<Project_info>();
		arraylist1.add(project);
		arraylist1.add(project1);

		EntityManagerFactory factory =null;
		EntityManager manager = null;
		EntityTransaction transaction =null;

		try {
			factory= Persistence.createEntityManagerFactory("test");
			manager=factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(project);
			System.out.println("saved");
			transaction.commit();
			
		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
			
		}
		finally {
			factory.close();
			manager.close();

		}

	}// end of main

}// end of class 
