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


@WebServlet("/codeInput")
public class CodeInput extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		String code = request.getParameter("code");		
		String language = request.getParameter("language");
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

		String title = "";
	    String possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	    for(int i=0; i < 5; i++ )
	        title += possible.charAt((int) Math.floor(Math.random() * possible.length()));
		System.out.println(title);
		CodeDaoImpl ci = new CodeDaoImpl(); 
		CodeDto dto = new CodeDto();
		dto.setCode(code);
		dto.setLanguage(language);
		dto.setTitle("#"+title);
		
		ci.cInsert(dto);
		
		request.setAttribute("Compile", compile);
		request.setAttribute("Result", result);
		request.setAttribute("Code", code);
		request.setAttribute("Language", language);
		
		RequestDispatcher rd = request.getRequestDispatcher("codeResult.jsp");
		rd.forward(request, response);
		
	}

}
