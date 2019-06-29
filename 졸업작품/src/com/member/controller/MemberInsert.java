package com.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.dao.MemberDaoImpl;
import com.member.dto.MemberDto;

/**
 * Servlet implementation class MemberInsert
 */
@WebServlet("/memberInsert")
public class MemberInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDaoImpl mi = new MemberDaoImpl();
		MemberDto dto = new MemberDto();
		
		dto.setId(request.getParameter("idInput"));
		dto.setPassword(request.getParameter("passwordInput"));
		
		mi.userInsert(dto);
		
		response.sendRedirect("home.jsp");
	}

}
