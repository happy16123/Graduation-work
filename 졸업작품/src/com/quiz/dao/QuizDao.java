package com.quiz.dao;

import java.util.ArrayList;

import com.quiz.dto.QuizDto;

public interface QuizDao {
	public ArrayList<QuizDto> qList(int startNo);
	public ArrayList<QuizDto> qList(int startNo, String regid);
	public QuizDto qSelect(int codeno);
	public int qInsert(QuizDto dto);
	public int qInsert(QuizDto dto, String regid);
	public int getTotalCount();
	public int getTotalCount(String regid);
	int qUpdate(int codeno, String result);
}

