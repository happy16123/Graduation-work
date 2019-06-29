package com.member.dao;

import com.member.dto.MemberDto;

public interface MemberDao {
	public boolean userCheck(String id, String password);
	public int userInsert(MemberDto dto);
	public int userUpdate(MemberDto dto);
	public int userDelete(String id);
	public MemberDto getMember(String id);
}
