package com.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.dao.MemberDaoImpl;

/**
 * Servlet implementation class MemberCheck
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String currentURL = request.getParameter("current_url");
		//System.out.println("id : " + id + " password : " + password);
		
		HttpSession session = null;
		MemberDaoImpl di = new MemberDaoImpl();
		boolean userCheck = di.userCheck(id, password);
		
		if(userCheck == true) {
			session = request.getSession();
			session.setAttribute("sessionId", id);
			System.out.println(id + "세션 로그인 성공");
			response.sendRedirect(currentURL);
		} else {
			System.out.println("아이디 없음");
			response.sendRedirect(currentURL);
		}
		
	}

}
