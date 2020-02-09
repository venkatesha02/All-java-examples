package com.tyss.webapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@SuppressWarnings("serial")
@WebServlet("/home")
public class HomeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession(false);
		
		if(session!=null) {
			
			out.println("<html><body>");
			out.println("<h1 style=color:blue;>This is Home Page</h1><a href='./logout'>Logout</a>");
			out.println("</body></html>");
			
		}else {
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/Login.html");
			dispatcher.forward(req, resp);
			
		}
		
	}
}
