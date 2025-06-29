package com.gn.controller;

import java.io.IOException;

import com.gn.dto.Student;
import com.gn.service.StudentService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/student/update")
public class StudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentService service = new StudentService();

    public StudentUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentNo = Integer.parseInt(request.getParameter("studentNo"));

        Student student = service.getStudentDetail(studentNo);
        request.setAttribute("student", student);
        request.getRequestDispatcher("/views/studentUpdate.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentNo = Integer.parseInt(request.getParameter("studentNo"));
        String studentName = request.getParameter("studentName");
        int studentAge = Integer.parseInt(request.getParameter("studentAge"));

        Student student = new Student();
        student.setStudentNo(studentNo);
        student.setStudentName(studentName);
        student.setStudentAge(studentAge);

        int result = service.updateStudent(student);

        if(result > 0) {
            response.sendRedirect("/student/list");
        } else {
            response.sendRedirect("/student/update?studentNo=" + studentNo);
        }
	}

}
