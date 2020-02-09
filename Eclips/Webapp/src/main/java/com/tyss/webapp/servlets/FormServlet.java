package com.tyss.webapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/form")
public class FormServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String mobnum = req.getParameter("mobnum");
		
		PrintWriter out =resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		out.println("<h1> Name : "+name+"</h1>");
		
		out.println("<h1> Email : "+email+" </h1>");
		
		out.println("<h1> password : "+ password+"</h1>");
		
		out.println("<h1> Mobile Number : "+mobnum+"</h1>");
		
		out.println("</body>");
		out.println("</html>");

	}
}
