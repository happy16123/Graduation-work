package com.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardImpl;
import com.board.dto.BoardDto;
import com.paging.Paging;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/boardList")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardImpl bi = new BoardImpl();
		Paging page = new Paging();
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		int totalCount = bi.getTotalCount();
		
		page.setPageNo(pageNo);
		page.setTotalCount(totalCount);	
		
		ArrayList<BoardDto> list = bi.bList(page.getStartNo());
		request.setAttribute("List", list);
		request.setAttribute("Page", page);	
		
		RequestDispatcher rd = request.getRequestDispatcher("boardList.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
