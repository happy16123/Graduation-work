package com.code.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.code.dao.CodeDaoImpl;

/**
 * Servlet implementation class CodeRemove
 */
@WebServlet("/codeRemove")
public class CodeRemove extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String regid = request.getParameter("regid");
		int codeno = Integer.parseInt(request.getParameter("codeno"));
		System.out.println(regid);
		
		CodeDaoImpl ci = new CodeDaoImpl();
		ci.cDelete(codeno, regid);
		
		response.sendRedirect("codeIndivList?pageNo=1&regid="+regid);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
