<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Filter 학습</title>
</head>
<body>
	<h1>1. 필터 공부하기</h1>
	<form action="/receive/data" method="post">
		<input type="text" name="test_data">
		<input type="submit" value="데이터 전송">
	</form>
	<form action="/receive/msg" method="post">
	    <fieldset>
	        <legend>메시지 작성</legend>
	        <textarea cols="20" rows="3" name="msg"></textarea>
	        <input type="submit" value="보내기">
	    </fieldset>
	</form>
</body>
</html>