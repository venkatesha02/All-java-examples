package com.tyss.hibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tyss.hibernateapp.dto.Emp_Primary_Info;

public class FindDemo {

	public static void main(String[] args) {

		Emp_Primary_Info emp = new Emp_Primary_Info();
		EntityManagerFactory factory =null;
		EntityManager manager = null;

		factory =Persistence.createEntityManagerFactory("test");
		manager=factory.createEntityManager();
		emp = manager.find(Emp_Primary_Info.class, 110);
		System.out.println(emp.get_id());
		System.out.println(emp.getEmp_name());
		System.out.println(emp.getDepartment_id());
		emp.getDesignation();
		emp.getDob();
		emp.getExperience();
		emp.getJoining_date();
		emp.getOfficial_mail();
		emp.getPhone_number();
		emp.getSalary();
		emp.getManager_id();

		manager.close();
		factory.close();

	}// end of main()

}// end of class
