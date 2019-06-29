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
 * Servlet implementation class ReplyUpdate
 */
@WebServlet("/replyUpdate")
public class ReplyUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bseq = Integer.parseInt(request.getParameter("bseq"));
		int replyNo = Integer.parseInt(request.getParameter("replyNo"));
		String replyText = request.getParameter("replyText");
		
		ReplyDto dto = new ReplyDto();
		ReplyDaoImpl ri = new ReplyDaoImpl();
		JSONObject obj = new JSONObject();
		PrintWriter out = response.getWriter();
		
		dto.setBseq(bseq);
		dto.setReplyNo(replyNo);;
		dto.setReplyText(replyText);
		
		ri.rUpdate(dto);
		obj.put("message", "modSuccess");
		out.println(obj);
		out.flush();
		out.close();
	}

}
