package com.reply.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reply.dao.ReplyDaoImpl;
import com.reply.dto.ReplyDto;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class ReplyInsert
 */
@WebServlet("/replyInsert")
public class ReplyInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bseq = Integer.parseInt(request.getParameter("bseq"));
		String replyWriter = request.getParameter("replyWriter");
		String replyText = request.getParameter("replyText");
		
		ReplyDaoImpl ri = new ReplyDaoImpl();
		ReplyDto dto = new ReplyDto();
		
		JSONObject obj = new JSONObject();
		PrintWriter out = response.getWriter();
		
		dto.setBseq(bseq);
		dto.setReplyWriter(replyWriter);
		dto.setReplyText(replyText);
		
		ri.rInsert(dto);
		obj.put("message", "regSuccess");
		out.println(obj);
		out.flush();
		out.close();
	}

}
