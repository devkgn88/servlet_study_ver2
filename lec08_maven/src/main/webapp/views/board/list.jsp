<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>
	<%@ include file="/views/include/nav.jsp" %>

	<h3>게시판 목록</h3>
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<c:forEach var="b" items="${boardList}" varStatus="vs">
			<tr>
				<%-- <td>${b.boardNo}</td> --%>
				<td>${(paging.nowPage-1)*(paging.numPerPage) + (vs.index+1) }</td>
				<td>${b.boardTitle}</td>
				<td>${b.memberId}</td>
				<td>${b.regDate}</td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${not empty paging }">
		<div>
			<c:if test="${paging.prev }">
				<a href="<c:url value='/boardList?nowPage=${paging.pageBarStart-1 }'/>">
					&laquo;
				</a>
			</c:if>
			<c:forEach var="i" begin="${paging.pageBarStart }" end="${paging.pageBarEnd }">
				<a href="<c:url value='/boardList?nowPage=${i }'/>">
					${i }
				</a>
			</c:forEach>
			<c:if test="${paging.next }">
				<a href="<c:url value='/boardList?nowPage=${paging.pageBarEnd+1 }'/>">
					&raquo;
				</a>
			</c:if>			
		</div>
	</c:if>
	<a href="<c:url value='/boardWrite'/>">게시글 등록</a>
</body>
</html>
