<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.gn.dto.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>장바구니</h3>
	<%
	    List<Product> cart = (List<Product>) session.getAttribute("cart");
	    if (cart == null || cart.isEmpty()) {
	%>
	    <p>장바구니가 비어 있습니다.</p>
	<%
	    } else {
	        for (Product p : cart) {
	%>
	    <p><%= p.getName() %> - <%= p.getPrice() %>원</p>
	<%
	        }
	    }
	%>
	<a href="/productList">상품 더 보기</a>
</body>
</html>