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
 * Servlet implementation class BoardUpdate
 */
@WebServlet("/boardUpdate")
public class BoardUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardImpl bi = new BoardImpl();
		BoardDto dto = new BoardDto();
		request.setCharacterEncoding("euc-kr");
		
		int bseq = Integer.parseInt(request.getParameter("bseq"));
		String title = request.getParameter("title");
		String content = request.getParameter("content"); 
		
		System.out.println(bseq +"\n" + title);
		
		dto.setBseq(bseq);
		dto.setTitle(title);
		dto.setContent(content);
		
		bi.bUpdate(dto);
		
		response.sendRedirect("boardList?pageNo=1");
	}

}
