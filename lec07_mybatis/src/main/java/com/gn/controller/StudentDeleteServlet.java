package com.gn.controller;

import java.io.IOException;

import com.gn.service.StudentService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StudentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService service = new StudentService();
       
    public StudentDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentNo = Integer.parseInt(request.getParameter("studentNo"));

        int result = service.deleteStudent(studentNo);

        if(result > 0) {
            response.sendRedirect("/student/list");
        } else {
            response.sendRedirect("/student/detail?studentNo=" + studentNo);
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
