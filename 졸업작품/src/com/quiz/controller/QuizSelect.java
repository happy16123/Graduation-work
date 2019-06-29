package com.quiz.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quiz.dao.QuizDaoImpl;
import com.quiz.dto.QuizDto;

@WebServlet("/quizSelect")
public class QuizSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		int codeno = Integer.parseInt(request.getParameter("codeno"));
			
		QuizDaoImpl qi = new QuizDaoImpl();
		QuizDto dto = qi.qSelect(codeno);
		System.out.println(codeno);
		dto.setCodeno(codeno);
		
		request.setAttribute("List", dto);
		
		RequestDispatcher rd = request.getRequestDispatcher("quizView.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
