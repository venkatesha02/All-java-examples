package com.testyantra.shopping_cart.test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.testyantra.shopping_cart.bean.UserBean;
import com.testyantra.shopping_cart.dao.ShoppingDAO;
import com.testyantra.shopping_cart.dao.ShoppingDaoImpl;

@SuppressWarnings("serial")
@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet{
	
	private ShoppingDAO dao = new ShoppingDaoImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
		out.print("<html>");
		out.print("<body>");

		
		String user_Name = req.getParameter("user_Name");
		String email = req.getParameter("email");
		long mobile = Long.parseLong(req.getParameter("mobile"));
		int age = Integer.parseInt(req.getParameter("age"));
		String role = req.getParameter("role");
		String password= req.getParameter("password");

		UserBean userBean = new UserBean();
		
		userBean.setUser_Name(user_Name);
		userBean.setEmail(email);
		userBean.setMobile(mobile);
		userBean.setAge(age);
		userBean.setRole(role);
		userBean.setPassword(password);

		if(dao.addUser(userBean)){
			out.println("<h2> Record Inserted Successfully...</h2>");
			out.println("<h3> thank you  to added record </h3>");
		}
		else {
			out.println("<h2 style='color:red;'> Unable to Insert record...</h2>");
		}

		out.print("</body>");
		out.print("</html>");

	}//end of doPost()

}// end of class
