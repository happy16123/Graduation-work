package com.code.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.code.dao.CodeDaoImpl;
import com.code.dto.CodeDto;

/**
 * Servlet implementation class CodeSave
 */
@WebServlet("/codeSave")
public class CodeSave extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		String result = "";
		String compile = "";
		String regid = request.getParameter("id");
		String title = request.getParameter("title");
		String code = request.getParameter("code");
		String language = request.getParameter("language");
		if(!request.getParameter("result").isEmpty()) { 
			result = request.getParameter("result");
		} else if(!request.getParameter("compile").isEmpty()) {
			compile = request.getParameter("compile");
		}
		
		CodeDto dto = new CodeDto();
		dto.setCode(code);
		dto.setLanguage(language);
		dto.setResult(result);
		dto.setRegid(regid);
		dto.setTitle(title);
		
		CodeDaoImpl ci = new CodeDaoImpl();
		ci.cInsert(dto, regid);
		
		RequestDispatcher rd = request.getRequestDispatcher("codeIndivList?pageNo=1&regid="+regid);
		rd.forward(request, response);
	}

}

