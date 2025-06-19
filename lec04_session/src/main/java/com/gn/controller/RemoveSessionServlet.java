package com.gn.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/RemoveSessionServlet")
public class RemoveSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RemoveSessionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			// 방식 1: 특정 값만 삭제
			// session.removeAttribute("member_id");

			// 방식 2: 전체 세션 종료
			session.invalidate();
		}
		response.sendRedirect("/"); // 홈으로 이동
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
