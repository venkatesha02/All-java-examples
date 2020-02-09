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
@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");
		PrintWriter out = resp.getWriter();
		RequestDispatcher dispatcher;
		out.println("<html><body>");
		if(email.equals("abc@123.com") && password.equals("AA@123")) {

			HttpSession session= req.getSession(true);
			session.setAttribute("sess-attr", new Object());
			out.println("<h1 style=color:green;>Login Success</h1>");
			dispatcher = req.getRequestDispatcher("/home");
			dispatcher.forward(req, resp);


		}
		else {
			
			out.println("<h1 style=color:red;>Invalid credetials</h1>");
			dispatcher = req.getRequestDispatcher("/Login.html");
			dispatcher.forward(req, resp);
		}

		out.println("</body></html>");

	}
}
