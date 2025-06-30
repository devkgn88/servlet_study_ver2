package com.gn.service;

import com.gn.dao.MemberDao;
import com.gn.dto.Member;

public class MemberService {
	private MemberDao dao = new MemberDao();
	
	public int insertMember(Member param) {
		return dao.insert(param);
	}
}
