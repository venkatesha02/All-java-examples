package com.tyss.jdbcapp.common;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyFirst {

	public static void main(String[] args) {

		Connection conn =null;
		Statement stmt=null;
		ResultSet rs=null;

		try {
//			Driver driver = new Driver();//  
//			DriverManager.registerDriver(driver);
			Class.forName("com.mysql.jdbc.Driver");
//			String dbUrl="jdbc:mysql://localhost:3306/elf_employee_info?user=root&password=root";
			String dbUrl ="jdbc:mysql://localhost:3306/Employee_Management_DB";
//			conn =DriverManager.getConnection(dbUrl);
			conn =DriverManager.getConnection(dbUrl, "root", "root");
			String query ="select * from Emp_Primary_info";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				
				int id= rs.getInt("emp_id");
				String name = rs.getString("emp_name");
				int dept_id= rs.getInt("department_id");
				double salary= rs.getDouble("salary");
				Date join_date =rs.getDate("joining_date");
				Date dob =rs.getDate("dob");
				String email = rs.getString("official_mail");
				String designation= rs.getString("designation");
				int mgr_id = rs.getInt("manager_id");
				long mobile= rs.getLong("phone_number");
				double experience = rs.getDouble("experience");

				System.out.println("Employee Id: "+id);
				System.out.println("Name: "+name);
				System.out.println("Age : "+dept_id);
				System.out.println("Salary : "+salary);
				System.out.println("Joining Date : "+join_date);
				System.out.println("Date of birth : "+dob);
				System.out.println("email : "+email);
				System.out.println("manager Id : "+mgr_id);
				System.out.println("Designation: "+designation);
				System.out.println("Mobile Number: "+mobile);
				System.out.println("experience: "+experience);
				System.out.println("----------------------------------------");
			}

		}
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(conn!=null) {
					conn.close();
					
				}
				if(stmt!=null) {
					stmt.close();
					
				}
				if(rs!=null) {
					rs.close();
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}

	}// End of main()

}//End of MyFirst
