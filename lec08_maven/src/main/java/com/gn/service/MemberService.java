package com.gn.service;

import com.gn.dao.MemberDao;
import com.gn.dto.Member;

public class MemberService {
	private MemberDao dao = new MemberDao();
	
	public int insertMember(Member param) {
		return dao.insert(param);
	}
	
	public Member selectMember(String id, String pw) {
		Member param = new Member();
		param.setMemberId(id);
		param.setMemberPw(pw);
		
		Member member = dao.selectMember(param);
		return member;
	}
}
