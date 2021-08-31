package com.sonata;
import java.io.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String user=request.getParameter("t1");
		String pass=request.getParameter("t2");
		//out.println("<h1> welcome to sonata</h1>"+user+" "+pass);
		HttpSession s1=request.getSession(true);
		s1.setAttribute("uname", user);
		
		if(user.equals("admin")) {
			response.sendRedirect("./LoginSuccess");
		}else {
			RequestDispatcher rd=request.getRequestDispatcher("./Login.html");
			rd.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
