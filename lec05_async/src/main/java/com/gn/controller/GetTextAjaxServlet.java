package com.gn.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/getTextAjax")
public class GetTextAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetTextAjaxServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		// 1-1. HTML 형태로 응답
		// response.setContentType("text/html; charset=utf-8");
		// 1-2. 연결통로 생성 후 문구 추가
		// PrintWriter out = response.getWriter();
		// out.append("<p>입력된 아이디 "+userId+"의 길이는 "+userId.length()+"입니다.</p>");
	
		// 2-1. 문자 형태로 응답
		response.setContentType("text/plain; charset=utf-8");
		// 2-2. 연결통로 생성후 문구 추가
		PrintWriter out = response.getWriter();
		out.append("입력된 아이디 "+userId+"의 길이는 "+userId.length()+"입니다.");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
