package com.tyss.hibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tyss.hibernateapp.dto.Emp_Primary_Info;

public class GetReference {

	public static void main(String[] args) {

		Emp_Primary_Info emp = new Emp_Primary_Info();
		EntityManagerFactory factory =null;
		EntityManager manager = null;

		factory =Persistence.createEntityManagerFactory("test");
		manager=factory.createEntityManager();
//		emp = manager.find(Emp_Primary_Info.class, 110);// to get the data
		
		emp = manager.getReference(Emp_Primary_Info.class, 110); // to get the data
		System.out.println("Employee Id : "+emp.get_id());
		System.out.println("Employee Name : "+emp.getEmp_name());
		System.out.println("Department Id : "+emp.getDepartment_id());
		System.out.println("Designation : "+emp.getDesignation());
		System.out.println("Date of Birth : "+emp.getDob());
		System.out.println("Experience : "+emp.getExperience());
		System.out.println("Joining date : "+emp.getJoining_date());
		System.out.println("Official Mail : "+emp.getOfficial_mail());
		System.out.println("Phone Number : "+emp.getPhone_number());
		System.out.println("Salary : "+emp.getSalary());
		System.out.println("Manager Id : "+emp.getManager_id());

		manager.close();
		factory.close();

		
		
	}//end of main()

}//end of Class
