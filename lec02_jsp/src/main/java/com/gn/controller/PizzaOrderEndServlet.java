package com.gn.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/pizzaOrderEnd")
public class PizzaOrderEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PizzaOrderEndServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("user_name");
		String userPhone = request.getParameter("user_phone");
		String userEmail = request.getParameter("user_email");
		String pizzaSize = request.getParameter("pizza_size");
		String[] pizzaToppings = request.getParameterValues("pizza_toppings");
		String deliveryTime = request.getParameter("delivery_time");
		
//		System.out.println(userName);
//		System.out.println(userPhone);
//		System.out.println(userEmail);
//		System.out.println(pizzaSize);
//		for(String t : pizzaToppings) {
//			System.out.print(t+" ");
//		}
//		System.out.println(deliveryTime);
		
		
		int price = 0;
		switch(pizzaSize) {
			case "1" : price = 15900;
					pizzaSize = "small"; break;
			case "2" : price = 21000;
					pizzaSize = "medium"; break;
			case "3" : price = 27900;
					pizzaSize = "large"; break;
		}
		
		if(pizzaToppings != null) {
			for(int i = 0 ; i < pizzaToppings.length ; i++) {
				String check = pizzaToppings[i];	
				switch(check) {
					case "1" : price += 2000;
							pizzaToppings[i] = "새우";break;
					case "2" : price += 1000;
							pizzaToppings[i] = "고구마";break;
					case "3" : price += 1000;
							pizzaToppings[i] = "감자";break;
					case "4" : price += 1000;
							pizzaToppings[i] = "파인애플";break;
				}
			}
		}
		
		
//		System.out.println(price);
		
		RequestDispatcher view 
		= request.getRequestDispatcher("views/pizza/result.jsp");
		request.setAttribute("name", userName);
		request.setAttribute("phone", userPhone);
		request.setAttribute("email", userEmail);
		request.setAttribute("size", pizzaSize);
		request.setAttribute("toppings", pizzaToppings);
		request.setAttribute("price", price);
		request.setAttribute("time", deliveryTime);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
