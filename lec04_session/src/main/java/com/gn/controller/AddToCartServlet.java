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
import jakarta.servlet.http.HttpSession;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddToCartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("selected_product"));
        
        Product selected = null;
        switch (code) {
            case 1001: selected = new Product(1001, "키보드", 25000); break;
            case 1002: selected = new Product(1002, "마우스", 15000); break;
            case 1003: selected = new Product(1003, "모니터", 180000); break;
        }

        HttpSession session = request.getSession();
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<Product>();
        }
        cart.add(selected);
        session.setAttribute("cart", cart);

        response.sendRedirect("/cartList");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
