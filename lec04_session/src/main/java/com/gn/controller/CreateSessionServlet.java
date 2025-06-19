package com.gn.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/createSession")
public class CreateSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateSessionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션 객체 생성
		HttpSession session = request.getSession(true);
		// 새 세션이거나 member_id가 비어있을 경우
		if (session.isNew() || session.getAttribute("member_id") == null) {
			session.setAttribute("member_id", "user01");   // 세션에 값 저장
			session.setMaxInactiveInterval(60* 30);             // 유지 시간 30분
		}
		response.sendRedirect("/");  // 홈 화면으로 이동
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
