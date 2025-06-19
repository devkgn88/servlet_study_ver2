<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키, 세션</title>
</head>
<body>
	<ul>
		<li>
			<a href="/makeCookie">쿠키 생성</a>
		</li>
		<li>
			<a href="/editCookie">쿠키 수정</a>
		</li>
		<li>
			<a href="/deleteCookie">쿠키 삭제</a>
		</li>
	</ul>
	<h3>현재 쿠키 값 확인</h3>

	<%
		Cookie[] cookies = request.getCookies();
		String userId = "쿠키 없음";

		if (cookies != null) {
			for (Cookie c : cookies) {
				if ("user_id".equals(c.getName())) {
					userId = c.getValue();
					break;
				}
			}
		}
	%>

	<p>user_id 쿠키 값 : <%= userId %></p>	
</body>
</html>