package com.gn.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/bookReserveEnd")
public class BookReserveEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookReserveEndServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String userName = request.getParameter("user_name");
		String userPhone = request.getParameter("user_phone");
		String userEmail = request.getParameter("user_email");
		String bookName = request.getParameter("book_name");
		int borrowPeriod = Integer.parseInt(request.getParameter("borrow_period"));

//		System.out.println(userName);
//		System.out.println(userPhone);
//		System.out.println(userEmail);
//		System.out.println(bookName);
//		System.out.println(borrowPeriod);
		
		// 도서 기준 대출 금액과 도서명 지정
		int bookPrice = 0;
		switch(bookName) {
		case "1" :
			bookPrice = 1500;
			bookName = "자바 프로그래밍 입문";
			break;
		case "2" : 
			bookPrice = 1800;
			bookName = "웹 개발의 기초";
			break;
		case "3" : 
			bookPrice = 2000;
			bookName = "데이터베이스 시스템";
			break;
		}
		
		// 추가 대출 금액 계산
		bookPrice = bookPrice + (borrowPeriod -1) * 500;
		
		// 대출 정보 전달
		request.setAttribute("userName", userName);
		request.setAttribute("userPhone", userPhone);
		request.setAttribute("userEmail", userEmail);
		request.setAttribute("bookTitle", bookName);
		request.setAttribute("borrowPeriod", borrowPeriod);
		request.setAttribute("totalPrice", bookPrice);

		RequestDispatcher view 
			= request.getRequestDispatcher("views/book/confirm.jsp");
		view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
