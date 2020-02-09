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
@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {
	
	private ShoppingDAO dao = new ShoppingDaoImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();

		out.print("<html>");
		out.print("<body>");

		//get the form data
		
		String productName =req.getParameter("productName");
		String brand = req.getParameter("brand");
		int quantity =Integer.parseInt(req.getParameter("quantity"));
		double price = Double.parseDouble(req.getParameter("price"));
		String image = req.getParameter("image");

		ProductBean productBean = new ProductBean();
		
		productBean.setProductName(productName);
		productBean.setBrand(brand);
		productBean.setPrice(price);
		productBean.setQuantity(quantity);
		productBean.setImage(image);


		if(dao.addProduct(productBean)) {
			out.println("<h2> Record Inserted Successfully...</h2>");
			out.println("<h3> thank you  to added record </h3>");
		}
		else {
			out.println("<h2 style='color:red;'> Unable to Insert record...</h2>");
		}

		out.print("</body>");
		out.print("</html>");

	}//end of doPost()

}
