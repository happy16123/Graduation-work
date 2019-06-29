package com.reply.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.paging.Paging;
import com.reply.dao.ReplyDaoImpl;
import com.reply.dto.ReplyDto;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class ReplyList
 */
@WebServlet("/replyList")
public class ReplyList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bseq = Integer.parseInt(request.getParameter("bseq"));
		int pageNo = Integer.parseInt(request.getParameter("replyPageNum"));
		response.setCharacterEncoding("UTF-8");
		
		JSONObject obj = new JSONObject();		
		JSONArray arr = new JSONArray();
		ReplyDaoImpl ri = new ReplyDaoImpl();
		Paging page = new Paging();
		
		int totalCount = ri.getTotalCount(bseq);
		page.setPageNo(pageNo);
		page.setTotalCount(totalCount);
		
		ArrayList<ReplyDto> list = ri.rList(bseq, page.getStartNo());
		
		
		for(int i=0; i<list.size(); i++) {
			JSONObject json = new JSONObject();
			json.put("bseq", list.get(i).getBseq());
			json.put("replyno", list.get(i).getReplyNo());
			json.put("replytext", list.get(i).getReplyText());
			json.put("replywriter", list.get(i).getReplyWriter());
			json.put("regdate", list.get(i).getRegDate());
			json.put("updatedate", list.get(i).getUpdateDate());
			arr.add(json);
		}
		
		PrintWriter out = response.getWriter();
		obj.put("replies", arr);
		obj.put("pageMaker", page);
		out.print(obj);
		out.flush();
		out.close();
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
