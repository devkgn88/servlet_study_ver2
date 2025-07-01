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
import jakarta.servlet.http.HttpSession;

@WebServlet("/memberLogin")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberService service = new MemberService();
	
    public MemberLoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view 
			= request.getRequestDispatcher("/views/member/login.jsp");
		view.forward(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		// 전달받은 아이디와 비밀번호가 일치하는 회원 정보 반환
		Member member = service.selectMember(memberId,memberPw);
		JSONObject obj = new JSONObject();
		obj.put("res_code", "500");
		obj.put("res_msg","로그인 중 오류가 발생하였습니다.");
		
		if(member != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("loginMember", member);
			session.setMaxInactiveInterval(60*30);
			
			obj.put("res_code", "200");
			obj.put("res_msg","정상적으로 로그인되었습니다.");			
		}
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print(obj);

	}

}
