package com.tyss.webapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet({"/life-cycle","/life/cycle","/life-cycle.html","*.venki"})// we can access like any type of those methods
// all the objectes are one and all same
// the *.somthing means pattern matching
public class LifeCycleServlet extends HttpServlet {

	public LifeCycleServlet() {
		
		System.out.println("Object created");
	
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("init");
	}
	
	@Override
	public void destroy() {
		
		System.out.println("Destroy");
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Service");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Service Hello Hi</h1>");
		out.println("</body>");
		out.println("</html>");
	}
}
