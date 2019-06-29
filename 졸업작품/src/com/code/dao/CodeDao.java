package com.code.dao;

import java.util.ArrayList;

import com.code.dto.CodeDto;

public interface CodeDao {
	public ArrayList<CodeDto> cList(int startNo);
	public ArrayList<CodeDto> cList(int startNo, String regid);
	public CodeDto cSelect(int codeno);
	public CodeDto cSelect(int codeno, String regid);
	public int cInsert(CodeDto dto);
	public int cInsert(CodeDto dto, String regid);
	public int cDelete(int codeno, String regid);
	public int getTotalCount();
	public int getTotalCount(String regid);
}
