package com.testyantra.shopping_cart.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testyantra.shopping_cart.bean.CartBean;
import com.testyantra.shopping_cart.dao.ShoppingDAO;
import com.testyantra.shopping_cart.dao.ShoppingDaoImpl;

@SuppressWarnings("serial")
@WebServlet("/addCart")
public class AddCartServlet extends HttpServlet {
	
	private ShoppingDAO dao = new ShoppingDaoImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		PrintWriter out=resp.getWriter();

		int customerId=Integer.parseInt(req.getParameter("customerId"));
		int wishId=Integer.parseInt(req.getParameter("wishId"));

		CartBean bean= new CartBean();

		bean.setCustomerId(customerId);;
		bean.setWishId(wishId);
		
		out.print("<html>");
		out.print("<body>");

		if(dao.addCart(bean)) {
			out.println("<h2> Cart Inserted Successfully...</h2>");
			out.println("<h3> thank you  to added Cart </h3>");
		}
		else {
			out.println("<h2 style='color:red;'> Unable to Insert Cart...</h2>");
		}

		out.print("</body>");
		out.print("</html>");
	
	}
	
}// end of class
