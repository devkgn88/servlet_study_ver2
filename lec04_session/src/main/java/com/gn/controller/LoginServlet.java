package com.gn.controller;

import java.io.IOException;

import com.gn.dto.Account;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String inputId = request.getParameter("id");
		String inputPw = request.getParameter("pw");
		
		// 하드코딩된 계정 정보
		String correctId = "admin";
		String correctPw = "admin1234";
		String name = "관리자";
		
		if (inputId.equals(correctId) && inputPw.equals(correctPw)) {
			HttpSession session = request.getSession(true);
			Account account = new Account(inputId,name);
			session.setAttribute("account", account);
			session.setMaxInactiveInterval(60*30);
			
		} else {
			response.sendRedirect("/");
		}
			
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
