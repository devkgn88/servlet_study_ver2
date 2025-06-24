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
	
	<h1>2. EL로 객체 다루기</h1>
	<%@ page import="com.gn.dto.Person" %>
	<%
		request.setAttribute("person", new Person("김철수", 77));
	%>
	<h2>(1) JSP 방식</h2>
	<%
		Person p = (Person)request.getAttribute("person");
	%>
	<p>이름: <%= p.getName() %></p>
	<p>나이: <%= p.getAge() %>세</p>
	<h2>(2) EL 방식</h2>
	<p>이름: ${person.name}</p>
	<p>나이: ${person.age}세</p>
	
	<h1>3. EL 객체 출력 연습</h1>
	<%@ page import="com.gn.dto.Planet" %>
	<%
	    Planet planet = new Planet("지구", 1.5, true);
	    request.setAttribute("planet", p);
	%>
	<p>이름: ${planet.name}</p>
	<p>태양으로부터의 거리: ${planet.distance}억 km</p>
	<p> 
		거주 가능 여부 : ${planet.habitable ? "O" : "X"} %>
	</p>
</body>
</html>