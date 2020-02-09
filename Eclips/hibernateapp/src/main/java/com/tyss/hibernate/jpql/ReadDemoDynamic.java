package com.tyss.hibernate.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.tyss.hibernateapp.dto.Emp_Primary_Info;

public class ReadDemoDynamic {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
		EntityManager manager = factory.createEntityManager();
		
		String jpql = "select e from Emp_Primary_Info e where e.id=:eid";
		
		TypedQuery<Emp_Primary_Info> query = manager.createQuery(jpql,Emp_Primary_Info.class);
		
		query.setParameter("eid", 2);
		Emp_Primary_Info emp = query.getSingleResult();
		
		//for (Emp_Primary_Info emp : record) {
			
			System.out.println("Employee Id : "+emp.get_id());
			System.out.println("Employee Name : "+emp.getEmp_name());
			System.out.println("Department Id : "+emp.getDepartment_id());
			System.out.println("Designation : "+emp.getDesignation());
			System.out.println("Date of Birth : "+emp.getDob());
			System.out.println("Experience : "+emp.getExperience());
			System.out.println("Joining date : "+emp.getJoining_date());
			System.out.println("=============================");

			
		//}
		
	}// end of main()

}// end of class
