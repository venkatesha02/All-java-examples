package com.tyss.webapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class QueryStringServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String numb=req.getParameter("phno");
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1> Name :");
		out.println(name);
		out.println("</h1>");
		out.println("<h1> Phone Number :");
		out.println(numb);
		out.println("</h1>");
		out.println("</body>");
		out.println("</html>");
		
	}
}
