<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userNick = null;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 페이지</title>
</head>
<body>
	<h2>🍪 쿠키 닉네임 실습</h2>
	<p>닉네임 : <strong><%=userNick %></strong></p>
	
	<form action="/saveNick" method="post">
	  <input type="text" name="nick" placeholder="닉네임 입력" required>
	  <button>닉네임 저장</button>
	</form>

	<form action="/removeNick" method="post">
	  <button>닉네임 삭제</button>
	</form>
</body>
</html>