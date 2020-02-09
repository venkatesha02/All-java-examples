package com.tyss.jdbcapp.assignment.dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RecordInsert1 {

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement pstmt= null;

		try {
			// 1.Load the driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// 2. Establishe Connection via Driver
			String url="jdbc:mysql://localhost:3306/Employee_Management_DB";
			con = DriverManager.getConnection(url,"root","root");

			// 3.Issue a SQL query 
			String query ="insert into Emp_Project_info values(?,?);";

			pstmt =con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(args[0]));
			pstmt.setInt(2, Integer.parseInt(args[1]));

			// 4. Process the Result
			int n =pstmt.executeUpdate(query);
			
			//System.out.println("N is "+n);
			if(n!=0) {
				System.out.println("Inserted");
			}else {
				System.out.println("Error");
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
				if(pstmt!=null) {
					pstmt.close();
				}

			} catch (Exception e2) {

				e2.printStackTrace();
			}
		}

		
	}

}
