package com.gn.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteCookie")
public class DeleteCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteCookieServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 삭제할 쿠키와 같은 key로 쿠키 생성 (값은 빈 문자열)
		Cookie c = new Cookie("user_id", "");

		// 유효시간을 0으로 설정 → 즉시 삭제
		c.setMaxAge(0);

		// 응답에 추가 → 브라우저가 쿠키 삭제
		response.addCookie(c);
		
		response.sendRedirect("/");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
