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
@WebServlet("/delete-cookie")
public class DeleteCookieServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		Cookie cookie[]=req.getCookies();
		for (Cookie cookie2 : cookie) {
			if(cookie2.getName().equals("Girl")) {
				cookie2.setMaxAge(-1);
				resp.addCookie(cookie2);
			}
		}
		PrintWriter out = resp.getWriter();
		out.println("<html><body><h1>Cookie Deleted</h1></body></html>");
		
	}
	
}
