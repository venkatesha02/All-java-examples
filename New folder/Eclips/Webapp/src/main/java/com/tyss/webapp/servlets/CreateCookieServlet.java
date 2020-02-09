package com.tyss.webapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/cookie")
public class CreateCookieServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		Cookie cookie1=new Cookie("Girl", "SunnyLeone");
		resp.addCookie(cookie1);
		cookie1.setMaxAge(60*60*24*7);
		
		Cookie cookie2=new Cookie("Boy", "Surya");
		resp.addCookie(cookie2);

		out.println("<html>"+
				"<body>"+
				"<h1>Cookie A Created</h1>"+ 
				"</body>"+
				"</html>");

	}
}
