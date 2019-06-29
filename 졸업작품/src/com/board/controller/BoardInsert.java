package com.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardImpl;
import com.board.dto.BoardDto;

/**
 * Servlet implementation class BoardInsert
 */
@WebServlet("/boardInsert")
public class BoardInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;      

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardImpl bi = new BoardImpl();
		BoardDto dto = new BoardDto();
		
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		
		dto.setTitle(request.getParameter("title"));
		dto.setRegid(request.getParameter("regid"));
		dto.setContent(request.getParameter("content"));
		
		bi.bInsert(dto);
		
		response.sendRedirect("boardList?pageNo=1");
	}

}

