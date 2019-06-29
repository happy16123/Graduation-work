package com.code.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.code.dao.CodeDaoImpl;
import com.code.dto.CodeDto;
import com.server.function.CppCode;
import com.server.function.JavaCode;

/**
 * Servlet implementation class CodeSelect
 */
@WebServlet("/codeSelect")
public class CodeSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		int codeno = Integer.parseInt(request.getParameter("codeno"));
		CodeDaoImpl ci = new CodeDaoImpl();
		CodeDto dto = new CodeDto();
		
		if(request.getParameter("regid") != null) {
			String regid = request.getParameter("regid");
			dto = ci.cSelect(codeno, regid);
		} else {		
			dto = ci.cSelect(codeno);
		}
		
		String language = dto.getLanguage();
		String code = dto.getCode();
		ArrayList<String> compile = new ArrayList<String>();
		ArrayList<String> result = new ArrayList<String>();
		
		switch(language) {
		case "java":
			JavaCode jc = new JavaCode();
			jc.fileWrite(code);
			compile = jc.compile();
			result = jc.resultData();
			jc.remove();
			break;
		case "cpp":
			CppCode cc = new CppCode();
			cc.fileWrite(code);
			compile = cc.compile();
			result = cc.resultData();
			cc.remove();
			break;
		}
		
		request.setAttribute("Compile", compile);
		request.setAttribute("Result", result);
		request.setAttribute("Code", code);
		request.setAttribute("Language", language);
		
		System.out.println(code);
		
		RequestDispatcher rd = request.getRequestDispatcher("codeResult.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
