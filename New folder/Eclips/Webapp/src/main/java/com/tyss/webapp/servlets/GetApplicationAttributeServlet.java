package com.tyss.webapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/get-app-attr")
public class GetApplicationAttributeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		Object obj =context.getAttribute("context-attr");
		PrintWriter out = resp.getWriter();
		out.println("<html><body><h1>");
		out.println(obj);
		out.println("</h1></body></html>");
		
		
	}
	
}
