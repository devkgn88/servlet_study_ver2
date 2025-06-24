<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>EL�� JSTL</title>
</head>
<body>
	<h1>1. EL�� ���尴ü</h1>
	<%
		pageContext.setAttribute("test", "������");
		request.setAttribute("test", "������Ʈ");
		session.setAttribute("test", "����");
		application.setAttribute("test", "�������̼�");
	%>
	
	<h2>(1) JSP ���</h2>
	<p><%= pageContext.getAttribute("test") %></p>
	<p><%= request.getAttribute("test") %></p>
	<p><%= session.getAttribute("test") %></p>
	<p><%= application.getAttribute("test") %></p>
	
	<h2>(2) EL ���</h2>
	<p>${pageScope.test }</p>
	<p>${requestScope.test }</p>
	<p>${sessionScope.test }</p>
	<p>${applicationScope.test }</p>
	<p>${test }</p>
	
	<h1>2. EL�� ��ü �ٷ��</h1>
	<%@ page import="com.gn.dto.Person" %>
	<%
		request.setAttribute("person", new Person("��ö��", 77));
	%>
	<h2>(1) JSP ���</h2>
	<%
		Person p = (Person)request.getAttribute("person");
	%>
	<p>�̸�: <%= p.getName() %></p>
	<p>����: <%= p.getAge() %>��</p>
	<h2>(2) EL ���</h2>
	<p>�̸�: ${person.name}</p>
	<p>����: ${person.age}��</p>
	
	<h1>3. EL ��ü ��� ����</h1>
	<%@ page import="com.gn.dto.Planet" %>
	<%
	    Planet planet = new Planet("����", 1.5, true);
	    request.setAttribute("planet", p);
	%>
	<p>�̸�: ${planet.name}</p>
	<p>�¾����κ����� �Ÿ�: ${planet.distance}�� km</p>
	<p> 
		���� ���� ���� : ${planet.habitable ? "O" : "X"} %>
	</p>
</body>
</html>