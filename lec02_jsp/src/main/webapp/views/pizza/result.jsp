<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userName = (String)request.getAttribute("name");
	String userPhone = (String)request.getAttribute("phone");
	String userEmail = (String)request.getAttribute("email");
	String size = (String)request.getAttribute("size"); 
	String[] toppings = (String[])request.getAttribute("toppings");
	int price = (int)request.getAttribute("price");
	String time = (String)request.getAttribute("time");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>피자 주문서</title>
</head>
<body>
	<h1>주문내역</h1>
	<h4>[고객정보]</h4>
	<ul>
		<li>성함 : <%=userName%></li>
		<li>전화번호 : <%=userPhone %></li>
		<li>이메일 : <%=userEmail%></li>
	</ul>
	<h4>[주문정보]</h4>
	<ul>
		<li>
			사이즈 : <%=size %>
		</li>
		<li>
			토핑 : 
			<ul>
				<%for(int i = 0 ; i < toppings.length ; i++) {%>
					<li><%=toppings[i]%></li>
				<%}%>
			</ul>
		</li>
	</ul>
	<h4>위와 같이 주문하셨습니다.</h4>
	<h3>총 가격 : <%=price%>원</h3>
	<h4>즐거운 식사 시간되세요~</h4>
</body>
</html>