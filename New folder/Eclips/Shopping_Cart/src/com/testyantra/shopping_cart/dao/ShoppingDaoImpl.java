package com.testyantra.shopping_cart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.testyantra.shopping_cart.bean.CartBean;
import com.testyantra.shopping_cart.bean.OrderBean;
import com.testyantra.shopping_cart.bean.ProductBean;
import com.testyantra.shopping_cart.bean.UserBean;
import com.testyantra.shopping_cart.bean.WishBean;

@SuppressWarnings("unused")
public class ShoppingDaoImpl implements ShoppingDAO {

	@Override
	public boolean addProduct(ProductBean productBean){

		Connection con =null;
		PreparedStatement pstmt = null;
		boolean isAdded = false;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_db", "root", "root");

			String query = "insert into product_info values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,productBean.getpId() );
			pstmt.setString(2,productBean.getProductName());
			pstmt.setString(3,productBean.getBrand());
			pstmt.setDouble(4,productBean.getPrice());
			pstmt.setInt(5,productBean.getQuantity());
			pstmt.setString(6,productBean.getImage());

			int n = pstmt.executeUpdate();

			//System.out.println();
			if(n>0) {
				isAdded = true;
			}
		}
		
		catch (Exception e) {
			e.printStackTrace();

		}

		finally {

			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}//end of try catch finally
		return isAdded;
	}// end of addEmployee

	@Override
	public boolean addUser(UserBean userBean) {

		Connection con =null;
		PreparedStatement pstmt = null;
		boolean isAdded = false;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_db", "root", "root");

			String query = "insert into user_info values(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,userBean.getUser_id() );
			pstmt.setString(2,userBean.getUser_Name());
			pstmt.setString(3,userBean.getEmail());
			pstmt.setLong(4,userBean.getMobile());
			pstmt.setInt(5,userBean.getAge());
			pstmt.setString(6,userBean.getRole());
			pstmt.setString(7, userBean.getPassword());

			int n = pstmt.executeUpdate();

			//System.out.println();
			if(n>0) {
				isAdded = true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();

		}

		finally {

			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}//end of try catch finally
		return isAdded;
	}// end of addEmployee

	@Override
	public boolean addWishList(WishBean wishBean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean isAdded= false;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_db","root","root");

			String query="insert into wishlist values(?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,wishBean.getWishlist_Id());
			pstmt.setInt(2,wishBean.getCustomer_Id());
			pstmt.setInt(3,wishBean.getProduct_Id());

			int n =pstmt.executeUpdate();

			if(n>0) {
				isAdded= true;

			}

		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {


			if (pstmt != null) {

				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			if (con != null) {

				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}
		return isAdded;

	}// end of addWishList

	@Override
	public boolean addCart(CartBean cartBean) {
		Connection con=null;
		PreparedStatement pstmt=null;
		boolean isAdd=false;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_db","root","root");
			String sql="insert into cart_list values(?,?,?)";
			pstmt=con.prepareStatement(sql);

			pstmt.setInt(1, cartBean.getCartId());
			pstmt.setInt(2, cartBean.getCustomerId());
			pstmt.setInt(3, cartBean.getWishId());

			int result=pstmt.executeUpdate();

			if(result>0) {

				isAdd=true;

			}
//			boolean result=pstmt.execute();
//
//			if(result) {
//
//				isAdd=true;
//
//			}
//			else {
//				isAdd=false;
//			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return isAdd;

	}// end of addCart

	@Override
	public boolean createOrder(OrderBean orderBean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean isAdded = false;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_db","root","root");
			String sql="insert into order_info values(?,?,?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, orderBean.getOrderId());
			pstmt.setInt(2, orderBean.getCustomerId());
			pstmt.setInt(3, orderBean.getProductId());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				isAdded = true;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		finally {

			if (pstmt!=null) {

				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			if (con!=null) {

				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}
		return isAdded;

	}// end of CreateOrder

	
	@Override
	public ProductBean showProduct() {
		
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductBean bean = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_db", "root", "root");

			String query = "Select * from product_info";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			if(rs.next()) {

				bean = new ProductBean();
				bean.setpId(rs.getInt("pId"));
				bean.setProductName(rs.getString("productName"));
				bean.setBrand(rs.getString("brand"));
				bean.setImage(rs.getString("image"));
				bean.setPrice(rs.getInt("price"));
				bean.setQuantity(rs.getInt("quantity"));
				
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}//end of try catch finally
		return bean;

	}//end of showProduct


}// end of class