package com.testyantra.shopping_cart.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testyantra.shopping_cart.bean.ProductBean;
import com.testyantra.shopping_cart.dao.ShoppingDAO;
import com.testyantra.shopping_cart.dao.ShoppingDaoImpl;

@SuppressWarnings("serial")
@WebServlet("/showProduct")
public class ShowProductServlet extends HttpServlet {
	
	ShoppingDAO dao = new ShoppingDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		ProductBean bean = dao.showProduct();
		out.print("<html>");
		out.print("<body>");
		if(bean!=null) {
			//for (int i = 0; i <; i++) {
				
				out.println(bean.getProductName()+"<h1> Product Name</h1>");
				out.println(bean.getBrand()+" <h1>Brand Name</h1>");
				//bean.getProductName();
			//}
		}
		else {
			out.println(" <h1>No Item found</h1>");
		}
		out.print("</body>");
		out.print("</html>");
	}

}
