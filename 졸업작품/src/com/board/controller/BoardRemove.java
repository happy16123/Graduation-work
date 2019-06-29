package com.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardImpl;

/**
 * Servlet implementation class BoardRemove
 */
@WebServlet("/boardRemove")
public class BoardRemove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardImpl bi = new BoardImpl();
		
		int bseq = Integer.parseInt(request.getParameter("bseq"));
		
		bi.bDelete(bseq);
		
		response.sendRedirect("boardList?pageNo=1");
	}

}
