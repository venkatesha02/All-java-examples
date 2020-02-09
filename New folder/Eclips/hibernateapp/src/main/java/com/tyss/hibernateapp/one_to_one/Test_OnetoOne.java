package com.tyss.hibernateapp.one_to_one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.hibernateapp.dto.Emp_Primary_Info;
import com.tyss.hibernateapp.dto.Emp_Secondary_info;


public class Test_OnetoOne {

	public static void main(String[] args) {
		
		Emp_Primary_Info emp = new Emp_Primary_Info();

		emp.set_id(18);
		emp.setEmp_name("venki");
		emp.setDepartment_id(12);
		emp.setDesignation("jhgjhg");
		emp.setDob("1997-02-02");
		emp.setJoining_date("1998-02-06");
		emp.setExperience("20.5");
		emp.setManager_id(20);
		emp.setOfficial_mail("vhgfhgfhgfhg.com");
		emp.setPhone_number(854585454l);
		emp.setSalary(2.3);
		
		
		Emp_Secondary_info secondary = new Emp_Secondary_info();

		secondary.setPrimary(emp);
		secondary.setBlood_group("A+");
		secondary.setEmargancy_no(6546546654l);
		secondary.setGender("male");
		secondary.setGovt_id("BV346");
		secondary.setGuardian_name("Somthing");
		secondary.setGuardian_number(6546798798l);
		secondary.setIs_married(true);
		secondary.setIs_phycally_challenged(false);
		secondary.setJob_location("banglore");
		secondary.setNationality("india");
		secondary.setPersonal_email("avcd@gsdh.com");
		
		EntityManagerFactory factory =null;
		EntityManager manager = null;
		EntityTransaction transaction =null;

		try {
			factory= Persistence.createEntityManagerFactory("test");
			manager=factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(secondary);
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
