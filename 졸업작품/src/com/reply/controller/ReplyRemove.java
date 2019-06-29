package com.reply.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reply.dao.ReplyDaoImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class ReplyRemove
 */
@WebServlet("/replyRemove")
public class ReplyRemove extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bseq = Integer.parseInt(request.getParameter("bseq"));
		int replyno = Integer.parseInt(request.getParameter("replyNo"));
		
		ReplyDaoImpl ri = new ReplyDaoImpl();
		
		ri.rDelete(bseq, replyno);
		
		JSONObject obj = new JSONObject();
		PrintWriter out = response.getWriter();
		
		obj.put("message", "delSuccess");
		out.println(obj);
		out.flush();
		out.close();
	}

}
