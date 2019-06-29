package com.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardImpl;
import com.board.dto.BoardDto;

/**
 * Servlet implementation class BoardEdit
 */
@WebServlet("/boardEdit")
public class BoardEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bseq = Integer.parseInt(request.getParameter("bseq"));
		String regid = request.getParameter("regid");
		String sessionId = request.getParameter("id");
		
		BoardImpl bi = new BoardImpl();
		BoardDto dto = bi.bSelect(bseq);
		
		request.setAttribute("List", dto);
		
		RequestDispatcher rd = request.getRequestDispatcher("boardEdit.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
