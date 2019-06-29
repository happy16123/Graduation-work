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
import com.paging.Paging;

/**
 * Servlet implementation class CodeList
 */
@WebServlet("/codeAllList")
public class CodeAllList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		CodeDaoImpl ci = new CodeDaoImpl();
		Paging page = new Paging();
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		int totalCount = ci.getTotalCount();
		
		page.setPageNo(pageNo);
		page.setTotalCount(totalCount);
		
		ArrayList<CodeDto> list = ci.cList(page.getStartNo());
		request.setAttribute("List", list);
		request.setAttribute("Page", page);

		RequestDispatcher rd = request.getRequestDispatcher("codeAllList.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
