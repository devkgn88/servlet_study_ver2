<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userNick = null;
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		for(Cookie c : cookies){
			if("user_nick".equals(c.getName())){
				userNick = c.getValue();
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 페이지</title>
</head>
<body>
	<h2>🍪 쿠키 닉네임 실습</h2>
	<p>닉네임 : <strong><%=userNick == null ? "_____" : userNick %></strong></p>
	<form action="/saveNick" method="post">
		<label for="user_nick">닉네임 : </label>
		<input type="text" id="user_nick" name="user_nick" placeholder="닉네임 입력" required>
	  	<button>닉네임 저장</button>
	</form>
	<br>
	<form action="/removeNick" method="post">
	  <button>닉네임 삭제</button>
	</form>
</body>
</html>