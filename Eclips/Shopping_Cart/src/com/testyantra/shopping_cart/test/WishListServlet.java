package com.testyantra.shopping_cart.test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testyantra.shopping_cart.bean.WishBean;
import com.testyantra.shopping_cart.dao.ShoppingDAO;
import com.testyantra.shopping_cart.dao.ShoppingDaoImpl;

@SuppressWarnings("serial")
@WebServlet("/wishList")
public class WishListServlet extends HttpServlet {

	ShoppingDAO dao = new ShoppingDaoImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<body>");
		
		int customer_Id = Integer.parseInt(req.getParameter("customer_Id"));
		int product_Id = Integer.parseInt(req.getParameter("product_Id"));

		WishBean wishBean = new WishBean();

		wishBean.setCustomer_Id(customer_Id);
		wishBean.setProduct_Id(product_Id);

		if(dao.addWishList(wishBean)) {
			
			out.println("<h2> Record inserted succesfully....<h2>");
			
		}
		else {
			
			out.println("<h2> unable to inserted Record....<h2>");
			
		}	


		out.println("</body>");
		out.println("</html>");

	}

}
