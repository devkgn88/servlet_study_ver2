<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이바티스</title>
</head>
<body>
	<ol>
		<li>
			<a href="/student/list">
				학생 목록 조회
			</a>
		</li>
		<li>
			<a href="/category/list">
				카테고리 목록 조회
			</a>
		</li>
	</ol>
	<form action="/product/search" method="get">
	    <label>상품명:</label>
	    <input type="text" name="productName"><br>
	    
	    <label>카테고리:</label>
	    <input type="number" name="productCategory"><br>
	    
        <label>정렬 기준:</label>
	    <select name="sort">
	        <option value="">선택하세요</option>
	        <option value="price">가격순</option>
	        <option value="category">카테고리순</option>
	    </select>
	    <input type="submit" value="검색">
	</form>
	
</body>
</html>