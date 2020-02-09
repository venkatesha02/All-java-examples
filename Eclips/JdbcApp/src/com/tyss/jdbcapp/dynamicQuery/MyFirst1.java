package com.tyss.jdbcapp.dynamicQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyFirst1 {

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/Employee_Management_DB";
			
			con=DriverManager.getConnection(url, "root", "root");

			String query="select * from Emp_Primary_info where emp_id=?";

			pstmt =con.prepareStatement(query);

			pstmt.setInt(1, Integer.parseInt(args[0]));

			int n =pstmt.executeUpdate(query);
			
			if(n!=0) {
				System.out.println("Inserted");
			}else {
				System.out.println("Error");
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
//			con=null;
//			rs=null;
//			pstmt=null;
			try {
				if(con!=null) {
					con.close();
					
				}
				if(pstmt!=null) {
					pstmt.close();
					
				}
				if(rs!=null) {
					rs.close();
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
