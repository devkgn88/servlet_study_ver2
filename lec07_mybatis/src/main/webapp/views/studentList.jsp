<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학생 목록</h1>
	<table border="1">
	    <tr>
	        <th>번호</th>
	        <th>이름</th>
	        <th>나이</th>
	    </tr>
	    <c:forEach var="s" items="${list}">
	        <tr>
	            <td>${s.studentNo}</td>
	            <td>${s.studentName}</td>
	            <td>${s.studentAge}</td>
	        </tr>
	    </c:forEach>
	</table>
	
</body>
</html>