package com.gn.mapping;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/joinMember")
public class SendGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SendGetServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("user_name");
		String gender = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("user_age"));
		String[] hobby = request.getParameterValues("hobby");
		
		System.out.println("이름 : " + name);
		System.out.println("성별 : " + gender);
		System.out.println("나이 : " + age);
		Map<String,String> map = new HashMap<String,String>();
		map.put("1", "야구");
		map.put("2", "농구");
		map.put("3", "축구");
		
		if(hobby == null) {
			System.out.println("취미 : 없음");
		} else {
			String[] arr = new String[hobby.length];
			System.arraycopy(hobby, 0, arr, 0, hobby.length);
			for(int i = 0 ; i < arr.length ; i++) {
				arr[i] = map.get(arr[i]);
			}
			System.out.println("취미 : "+String.join(",", arr));
		}
		
		RequestDispatcher view 
			= request.getRequestDispatcher("views/joinSuccess.jsp");
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		view.forward(request, response);
		
//		response.setContentType("text/html; charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		
//		out.println("<html lang='en'>");
//		out.println("<head>");
//		out.println("<meta charset='UTF-8'>");
//		out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
//		out.println("<title>회원가입 결과화면</title>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<h1>"+name+"님, 환영합니다</h1>");
//		out.println("<h2>앞으로도 자주 와주실꺼죠?</h2>");
//		out.println("<a href='/'>홈페이지로 이동</a>");
//		out.println("</body>");
//		out.println("</html>");
//		
//		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
