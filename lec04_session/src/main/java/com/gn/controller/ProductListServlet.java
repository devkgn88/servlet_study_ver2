package com.gn.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.gn.dto.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/productList")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = new ArrayList<Product>();
        list.add(new Product(1001, "키보드", 25000));
        list.add(new Product(1002, "마우스", 15000));
        list.add(new Product(1003, "모니터", 180000));
        request.setAttribute("resultList", list);
        request.getRequestDispatcher("/views/shopping/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
