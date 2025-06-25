<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>⭐ 계단형 별 출력 결과</h2>
	<c:forEach var="i" begin="1" end="${count}">
	    <c:forEach var="j" begin="1" end="${i}">
	        <span style="font-size: 1.5rem;">⭐</span>
	    </c:forEach>
	    <br>
	</c:forEach>
</body>
</html>