package com.quiz.controller;

import java.io.IOException;

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
@WebServlet("/quizMake")
public class QuizMake extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String answerClassName = request.getParameter("answer_className");
		String testClassName = request.getParameter("test_className");
		String codeframe = request.getParameter("frame_code");
		String testCode = request.getParameter("test_code");
		
		System.out.println(answerClassName);
		System.out.println(testClassName);
		
		QuizDto dto = new QuizDto();
		dto.setTitle(title);
		dto.setContent(content);
		dto.setAnswerClassName(answerClassName);
		dto.setTestClassName(testClassName);
		dto.setCodeframe(codeframe);
		
		QuizDaoImpl qi = new QuizDaoImpl();
		qi.qInsert(dto);
		
		QuizCode qc = new QuizCode();
		qc.fileWrite(testCode, testClassName);
		
		response.sendRedirect("quizList?pageNo=1");
		
	}

}
