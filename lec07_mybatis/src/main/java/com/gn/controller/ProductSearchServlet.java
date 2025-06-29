package com.gn.controller;

import java.io.IOException;
import java.util.List;

import com.gn.dto.Product;
import com.gn.service.ProductService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/product/search")
public class ProductSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService service = new ProductService();
       
    public ProductSearchServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productName = request.getParameter("productName");
		int productCategory = Integer.parseInt(request.getParameter("productCategory"));
		
		System.out.println(productName + " : "+productCategory);
		Product param = new Product();
		param.setProductName(productName);
		param.setProductCategory(productCategory);
		
		List<Product> list = service.searchProduct(param);
		System.out.println(list);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
