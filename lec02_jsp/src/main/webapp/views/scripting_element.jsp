<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립팅 요소 연습</title>
</head>
<body>
	<%-- Scriptlet : 일반적인 자바 코드 --%>
	<% 
		int sum = 0;
		for(int i = 0 ; i <= 10 ; i++){
			sum += i;
		}
		out.println("총합 : "+sum);
	%>
	<br>
	<%-- Expression : (화면에)출력 --%>
	<%= "총합 : " + sum %>
	<% out.println("총합 : " + sum);%>
	<br>
	<%-- Declaration : 선언 --%>
	<%! int visitCount = 0; %>
	<%
	    int tempCount = 0;
	    visitCount++;
	    tempCount++;
	%>
	
	<p>visitCount (Declaration): <%= visitCount %></p>
	<p>tempCount (Scriptlet): <%= tempCount %></p>
	
</body>
</html>