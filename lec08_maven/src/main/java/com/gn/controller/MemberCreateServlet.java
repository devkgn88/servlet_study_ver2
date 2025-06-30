package com.gn.controller;

import java.io.IOException;

import org.json.simple.JSONObject;

import com.gn.dto.Member;
import com.gn.service.MemberService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/memberCreate")
public class MemberCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service = new MemberService();
       
    public MemberCreateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view 
			= request.getRequestDispatcher("/views/member/create.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
				
		Member param = new Member();
		param.setMemberId(memberId);
		param.setMemberPw(memberPw);
		
		// 데이터베이스에 저장
		int result = service.insertMember(param);
		
		JSONObject obj = new JSONObject();
		obj.put("res_code", "500");
		obj.put("res_msg", "회원가입 중 오류가 발생했습니다.");
		
		if(result > 0) {
			obj.put("res_code", "200");
			obj.put("res_msg", "회원가입 성공!! 로그인하시겠습니까?");
		}
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(obj);
	}

}
