<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>EL과 JSTL</title>
</head>
<body>
	<h1>1. EL의 내장객체</h1>
	<%
		pageContext.setAttribute("test", "페이지");
		request.setAttribute("test", "리퀘스트");
		session.setAttribute("test", "세션");
		application.setAttribute("test", "애플케이션");
	%>
	
	<h2>(1) JSP 방식</h2>
	<p><%= pageContext.getAttribute("test") %></p>
	<p><%= request.getAttribute("test") %></p>
	<p><%= session.getAttribute("test") %></p>
	<p><%= application.getAttribute("test") %></p>
	
	<h2>(2) EL 방식</h2>
	<p>${pageScope.test }</p>
	<p>${requestScope.test }</p>
	<p>${sessionScope.test }</p>
	<p>${applicationScope.test }</p>
	<p>${test }</p>
</body>
</html>