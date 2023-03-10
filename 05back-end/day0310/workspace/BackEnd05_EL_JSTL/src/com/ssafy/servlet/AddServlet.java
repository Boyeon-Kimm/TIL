package com.ssafy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		int num1 = 10;
		int num2 = 20;
		int add = num1 + num2;
		
		request.setAttribute("num1", num1);
		request.setAttribute("num2", num2);
		request.setAttribute("add", add);
		
		request.getRequestDispatcher("06_addResult.jsp").forward(request, response);
	}
}
