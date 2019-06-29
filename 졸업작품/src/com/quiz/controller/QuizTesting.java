package com.quiz.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quiz.dao.QuizDaoImpl;
import com.quiz.dto.QuizDto;
import com.server.function.QuizCode;

/**
 * Servlet implementation class CodeTesting
 */
@WebServlet("/quizTesting")
public class QuizTesting extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		int codeno = Integer.parseInt(request.getParameter("codeno"));
		String code = request.getParameter("code");
		String answerClassName = request.getParameter("answerclassname");
		String testClassName = request.getParameter("testclassname");
		String title = request.getParameter("title");
		String regid = request.getParameter("executeId");
		ArrayList<String> res = new ArrayList<String>();
		String result = "";
		
		QuizCode qc = new QuizCode();
		qc.fileWrite(code, answerClassName);
		qc.compile(testClassName);
		res = qc.resultData(testClassName);
		qc.remove(answerClassName);
		
		QuizDto dto = new QuizDto();
		QuizDaoImpl qi = new QuizDaoImpl();
		if(res.get(0).equals("true")) {
			result = "SUCCESS!!";
			qi.qUpdate(codeno, result);
		} else {
			result = "FAIL...";
			qi.qUpdate(codeno, result);
		}
		
		dto.setTitle(title);
		dto.setResult(result);
		
		qi.qInsert(dto, regid);
		
		
		response.sendRedirect("quizResult?pageNo=1&regid="+regid);
	}

}
