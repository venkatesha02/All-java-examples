package com.tyss.jdbcapp.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class RecordUpdate2 {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt= null;

		try {
			// 1.Load the driver
			Class.forName("com.mysql.jdbc.Driver");
			// 2. Establishe Connection via Driver
			String url="jdbc:mysql://localhost:3306/Employee_Management_DB";
			con = DriverManager.getConnection(url,"root","root");

			// 3.Issue a SQL query 
			String query ="update Emp_Primary_info set designation='Software Developer' where emp_id=2";

			stmt =con.createStatement();
			// 4. Process the Result
			int n =stmt.executeUpdate(query);
			//System.out.println("N is "+n);
			if(n!=0) {
				System.out.println("Updated");
			}else {
				System.out.println("Unable to Update");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			// 5. Close all JDBC connection
			try {
				if(con!=null) {
					con.close();
				}
				if(stmt!=null) {
					stmt.close();
				}

			} catch (Exception e2) {

				e2.printStackTrace();
			}
		}

	}//end of main()

}// end of class
