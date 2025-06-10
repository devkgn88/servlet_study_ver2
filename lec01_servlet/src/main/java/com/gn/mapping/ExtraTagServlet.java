package com.gn.mapping;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/testData")
public class ExtraTagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExtraTagServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("username");
		String code = request.getParameter("user_code");
		String email = request.getParameter("email");
		
		System.out.println("이름 : "+name);
		System.out.println("코드 : "+code);
		System.out.println("주소 : "+email);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
