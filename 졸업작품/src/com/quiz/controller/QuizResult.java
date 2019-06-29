package com.quiz.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.paging.Paging;
import com.quiz.dao.QuizDaoImpl;
import com.quiz.dto.QuizDto;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/quizResult")
public class QuizResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		String regid = request.getParameter("regid");
		QuizDaoImpl qi = new QuizDaoImpl();
		Paging page = new Paging();
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		int totalCount = qi.getTotalCount();
		
		page.setPageNo(pageNo);
		page.setTotalCount(totalCount);	
		
		ArrayList<QuizDto> list = qi.qList(page.getStartNo(), regid);
		request.setAttribute("List", list);
		request.setAttribute("Page", page);	
		
		RequestDispatcher rd = request.getRequestDispatcher("quizResult.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
