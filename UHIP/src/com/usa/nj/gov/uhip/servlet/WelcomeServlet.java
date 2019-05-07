package com.usa.nj.gov.uhip.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
      
		String ss = null;
		String engine = null;
		String url = null;
		
		ss=request.getParameter("ss");
		engine = request.getParameter("engine");
		
		if (engine.equals("google")) {
			url="https://www.google.com/search?source="+ss;
		} else {
            url="https://in.search.yahoo.com/search?p="+ss;
		}
		 
		response.sendRedirect(url);
		RequestDispatcher rd = request.getRequestDispatcher("input.html");
		rd.include(request, response);
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
