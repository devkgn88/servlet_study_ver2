package com.gn.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editCookie")
public class EditCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditCookieServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 기존 user_id 쿠키를 덮어쓸 새 쿠키 생성
		Cookie c = new Cookie("user_id", "admin");

		// 기존과 동일한 유지 시간 설정 (선택)
		c.setMaxAge(60 * 60 * 24); // 1일 유지

		// 브라우저에 쿠키 전달
		response.addCookie(c);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
