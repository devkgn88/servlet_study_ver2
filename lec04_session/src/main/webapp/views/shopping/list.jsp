<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.gn.dto.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
</head>
<body>
	<form action="/addToCart" method="post">
		<label for="selected_product">상품 선택 : </label>
	    <select name="selected_product" id="selected_product">
	        <% 
	        List<Product> resultList = (List<Product>) request.getAttribute("resultList");
	        for (Product p : resultList) {
	        %>
	        <option value="<%= p.getCode() %>"><%= p.getName() %> - <%= p.getPrice() %>원</option>
	        <% } %>
	    </select>
	    <button type="submit">장바구니에 추가</button>
	</form>
</body>
</html>