<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록 페이지</title>
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
     		<tr onclick="location.href='/student/detail?no=${s.studentNo}'" style="cursor:pointer;">
	            <td>${s.studentNo}</td>
	            <td>${s.studentName}</td>
	            <td>${s.studentAge}</td>
	        </tr>
	    </c:forEach>
	</table>
	<a href="/student/insert">학생 등록</a>
</body>
</html>