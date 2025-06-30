package com.gn.controller;

import java.io.IOException;

import org.json.simple.JSONObject;

import com.gn.dto.Member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/memberCreate")
public class MemberCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		
		System.out.println(param);
		
		// 데이터베이스에 저장
		JSONObject obj = new JSONObject();
		obj.put("res_code", "500");
		obj.put("res_msg", "회원가입 중 오류가 발생했습니다.");
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(obj);
	}

}
