<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키, 세션</title>
</head>
<body>
	<h1>Cookie</h1>
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
		<li>
			<a href="/practiceCookie">쿠키 연습하기</a>
		</li>
		<li>
			<a href="/changePage">방문 횟수 추적하기</a>
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
	
	<h1>Session</h1>
	<ol>
		<li>
			<a href="/createSession">세션 생성</a>
		</li>
		<li>
			<a href="/editSession">세션 수정</a>
		</li>
		<li>
			<a href="/removeSession">세션 삭제</a>
		</li>
	</ol>
	<%
		String memberId = "세션 없음";
		if(session != null){
			if(session.getAttribute("member_id") != null){
				memberId = (String)session.getAttribute("member_id");
			}
		}
	%>
	<p>세션 정보 : <%=memberId %></p>
</body>
</html>