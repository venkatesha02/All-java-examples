package com.testyantra.shopping_cart.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testyantra.shopping_cart.bean.OrderBean;
import com.testyantra.shopping_cart.dao.ShoppingDAO;
import com.testyantra.shopping_cart.dao.ShoppingDaoImpl;

@SuppressWarnings("serial")
@WebServlet("/orderItems")
public class OrderServlet extends HttpServlet{

	ShoppingDAO dao = new ShoppingDaoImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out=resp.getWriter();
		
		int customerId = Integer.parseInt(req.getParameter("customerId"));
		int productId = Integer.parseInt(req.getParameter("productId"));

		OrderBean orderBean = new OrderBean();
		orderBean.setCustomerId(customerId);
		orderBean.setProductId(productId);
		
		out.println("<html>");
		out.println("<body>");
		
		if (dao.createOrder(orderBean)) {
			out.println("<h2> Order Inserted Successfully...</h2>");
			out.println("<h3> thank you  to added Order </h3>");
		}
		else {
			out.println("<h2 style='color:red;'> Unable to Insert Order...</h2>");
		}

		out.println("</html>");
		out.println("</body>");

	}

}
