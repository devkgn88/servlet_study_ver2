package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/scoreAjax")
public class ScoreAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ScoreAjaxServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 문자 인코딩
		request.setCharacterEncoding("utf-8");

		// 파라미터 수집
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int math = Integer.parseInt(request.getParameter("math"));

		// 연산 처리
		int total = kor + eng + math;
		double avg = total / 3.0;
		String avgStr = String.format("%.2f", avg);
		
		String result;
		if (kor >= 40 && eng >= 40 && math >= 40 && avg >= 60) {
			result = "합격";
		} else {
			result = "불합격";
		}

		// 응답 설정
		response.setContentType("text/plain; charset=utf-8");
		response.getWriter().write("총점: " + total + ", 평균: " + avgStr + ", 결과: " + result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
