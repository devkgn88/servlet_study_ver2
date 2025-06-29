package com.gn.controller;

import java.io.IOException;
import java.util.List;

import com.gn.dto.Category;
import com.gn.service.CategoryService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/category/list")
public class CategoryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryService service = new CategoryService();
       
    public CategoryListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> list = service.getCategoryList();
        System.out.println(list);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
