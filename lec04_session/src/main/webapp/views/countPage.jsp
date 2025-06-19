<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
    // 방문 횟수를 저장할 변수
    int visitCount = 0;
    
    // 쿠키 가져오기
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie c : cookies) {
            if ("visit_count".equals(c.getName())) {
                visitCount = Integer.parseInt(c.getValue());
            }
        }
    }
    
    // 방문 횟수 증가
    visitCount++;

    // 쿠키 생성 및 갱신 (유효기간: 1일)
    Cookie visitCookie = new Cookie("visit_count", String.valueOf(visitCount));
    visitCookie.setMaxAge(60 * 60 * 24); // 1일 (초 단위)
    response.addCookie(visitCookie);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방문 횟수 확인</title>
</head>
<body>
	<h2>방문 횟수 확인</h2>
	 <p>당신은 이 페이지를 
	 	<strong><%= visitCount %></strong> 
 		번 방문했습니다.
 	</p>
</body>
</html>