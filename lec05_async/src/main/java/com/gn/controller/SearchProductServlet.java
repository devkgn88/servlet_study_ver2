package com.gn.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.gn.dto.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/searchProduct")
public class SearchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchProductServlet() {
        super();
    }

    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));

        String categoryName = "";
        switch(categoryCode) {
            case 1: categoryName = "전자제품"; break;
            case 2: categoryName = "생활용품"; break;
            case 3: categoryName = "패션"; break;
        }

        List<Product> list = new ArrayList<>();
        list.add(new Product("전자제품", "노트북", 1200000));
        list.add(new Product("전자제품", "스마트폰", 800000));
        list.add(new Product("생활용품", "물티슈", 3000));
        list.add(new Product("생활용품", "세제", 10000));
        list.add(new Product("패션", "티셔츠", 25000));

        JSONArray arr = new JSONArray();
        for(Product p : list) {
            if(p.getCategory().equals(categoryName)) {
                JSONObject obj = new JSONObject();
                obj.put("name", p.getName());
                obj.put("price", p.getPrice());
                arr.add(obj);
            }
        }

        JSONObject result = new JSONObject();
        result.put("products", arr);

        response.setContentType("application/json; charset=utf-8");
        response.getWriter().print(result);
    }
}
