package com.tyss.hibernateapp.many_to_one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.hibernateapp.dto.Emp_Address_Info;
import com.tyss.hibernateapp.dto.Emp_Address_Pk;
import com.tyss.hibernateapp.dto.Emp_Primary_Info;

public class Test_ManytoOne {

	public static void main(String[] args) {

		Emp_Primary_Info emp = new Emp_Primary_Info();

		emp.set_id(127);
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

		Emp_Address_Pk address_pk = new Emp_Address_Pk();
		address_pk.setEmp_id(127);
		address_pk.setAddrs_type("permanent");

		Emp_Address_Info address =  new Emp_Address_Info();
		address.setComposite(address_pk);
		address.setHouse_no(21);
		address.setAddrs1("Blore");
		address.setAddrs2("mlore");
		address.setCity("BDVT");
		address.setLandmark("SMG");
		address.setPincode(524854);
		address.setPrimary(emp);


		EntityManagerFactory factory =null;
		EntityManager manager = null;
		EntityTransaction transaction =null;

		try {
			factory= Persistence.createEntityManagerFactory("test");
			manager=factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
//			Emp_Primary_Info info = manager.find(Emp_Primary_Info.class, 127);
//			address.setPrimary(info);
			Emp_Primary_Info info = manager.find(Emp_Primary_Info.class, 127);
			//manager.persist(address);
			System.out.println(info.getAddressinfo().get(0).getAddrs1());

			System.out.println("saved");
			transaction.commit();

		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();

		}finally {
			factory.close();
			manager.close();

		}


	}

}
