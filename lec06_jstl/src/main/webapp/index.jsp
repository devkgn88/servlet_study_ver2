<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>EL과 JSTL</title>
</head>
<body>
	<h1>1. EL의 내장객체</h1>
	<%
		pageContext.setAttribute("test", "페이지");
		request.setAttribute("test", "리퀘스트");
		session.setAttribute("test", "세션");
		application.setAttribute("test", "애플케이션");
	%>
	
	<h2>(1) JSP 방식</h2>
	<p><%= pageContext.getAttribute("test") %></p>
	<p><%= request.getAttribute("test") %></p>
	<p><%= session.getAttribute("test") %></p>
	<p><%= application.getAttribute("test") %></p>
	
	<h2>(2) EL 방식</h2>
	<p>${pageScope.test }</p>
	<p>${requestScope.test }</p>
	<p>${sessionScope.test }</p>
	<p>${applicationScope.test }</p>
	<p>${test }</p>
	
	<h1>2. EL로 객체 다루기</h1>
	<%@ page import="com.gn.dto.Person" %>
	<%
		request.setAttribute("person", new Person("김철수", 77));
	%>
	<h2>(1) JSP 방식</h2>
	<%
		Person p = (Person)request.getAttribute("person");
	%>
	<p>이름: <%= p.getName() %></p>
	<p>나이: <%= p.getAge() %>세</p>
	<h2>(2) EL 방식</h2>
	<p>이름: ${person.name}</p>
	<p>나이: ${person.age}세</p>
	
	<h1>3. EL 객체 출력 연습</h1>
	<%@ page import="com.gn.dto.Planet" %>
	<%
	    Planet planet = new Planet("지구", 1.5, true);
	    request.setAttribute("planet", planet);
	%>
	<p>이름: ${planet.name}</p>
	<p>태양으로부터의 거리: ${planet.distance}억 km</p>
	<p> 
		거주 가능 여부 : ${planet.habitable ? "O" : "X"} %>
	</p>
	<h1>4. EL 연산자</h1>
	<%@page import="java.util.*"%>
	<%
	    request.setAttribute("num1", 7);
	    request.setAttribute("num2", 2);
	    request.setAttribute("str1", "햄버거");
	    request.setAttribute("str2", "피자");
	
	    List<String> menu = new ArrayList<>();
	    menu.add("짜장면");
	    menu.add("짬뽕");
	    request.setAttribute("menuList", menu);
	%>
	<p>${num1 + num2}</p>
	<p>${num1 - num2}</p>
	<p>${num1 * num2}</p>
	<p>${num1 div num2}</p>
	<p>${num1 mod num2}</p>
	
	<p>${str1}${str2}</p>
	<p>${str1 eq str2}</p>
	<p>${str1 eq "햄버거"}</p>
	
	<p>${empty menuList}</p>
	<p>${not empty menuList}</p>
		
	<p>${num1 gt num2}</p>
	<p>${num1 lt num2}</p>
	<p>${num1 gt num2 and not empty menuList}</p>
	
	<h1>5. JSTL Core Library</h1>
	<h2>(1) 변수 선언</h2>
	<c:set var="num1" value="10"/>
	<c:set var="num2" value="20"/>
	<c:set var="result" value="${num1 + num2}"/>
	
	<h2>(2) 변수 출력</h2>
	<c:set var="result" value="<b>안녕하세요!</b>"/>
	<!-- 기본 출력: <b>안녕하세요!</b>가 태그가 아니라 글자로 보임 -->
	<c:out value="${result}"/><br>
	
	<!-- escapeXml="false" 설정: <b>안녕하세요!</b>가 실제로 굵게 표시됨 -->
	<c:out value="${result}" escapeXml="false"/>
	
	<h2>(3) 조건문:if</h2>
	<c:if test="${num1 le num2}">
		<p>num1이 num2보다 작거나 같다.</p>
	</c:if>
	
	<h2>(4) 조건문:choose</h2>
	<c:choose>
		<c:when test="${num1 gt 20 }">
			<p>10이 20보다 큽니까?</p>
		</c:when>
		<c:when test="${num1 ge 10 }">
			<p>num1이 10보다 크거나 같으면서, 20보다 작거나 같나요?</p>
		</c:when>
		<c:otherwise>
			<p>num1이 10보다 작습니까?</p>
		</c:otherwise>
	</c:choose>
	
	<h1>6. 사이트 테마 설정</h1>
	<form method="post" action="/setTheme">
	    <button type="submit" name="theme" value="dark">다크모드</button>
	    <button type="submit" name="theme" value="light">라이트모드</button>
	</form>
	<h1>(5) JSTL Core 반복문</h1> 
	<c:forEach var="i" begin="1" end="10" step="2">
		<p>반복 숫자: ${i}</p>
	</c:forEach>
	<% 
	    String[] colors = {"red", "green", "blue"};
	    request.setAttribute("colors", colors);
	%>
	<ul>
	    <c:forEach var="color" items="${colors}">
	        <li style="color:${color}">${color}</li>
	    </c:forEach>
	</ul>
	<c:forEach var="num" begin="0" end="5" varStatus="status">
	  <p>
	      숫자: ${num}<br>
	      인덱스: ${status.index}<br>
	      카운트: ${status.count}<br>
	      첫번째인가요? ${status.first}<br>
	      마지막인가요? ${status.last}
	  </p>
	</c:forEach>
	<h1>7. 계단형 별 찍기</h1>
	<form method="post" action="/printStar">
	    <label>출력할 줄 수를 선택하세요 : </label>
	    <select name="count">
	        <option value="3">3줄</option>
	        <option value="5">5줄</option>
	        <option value="7">7줄</option>
	    </select>
	    <button type="submit">출력하기</button>
	</form>
	<h2>(6) JSTL Core 경로 설정 </h2>
	<a href="<%= request.getContextPath() %>/boardList">게시판</a>
	<script src="<%= request.getContextPath() %>/resources/js/jquery-3.7.1.js"></script>
	
	<a href="<c:url value='/boardList' />">게시판</a>
	<script src="<c:url value='/resources/js/jquery-3.7.1.js' />"></script>

	<c:url var="testUrl" value="/boardList">
	    <c:param name="nowPage" value="1" />
	    <c:param name="boardTitle" value="테스트" />
	</c:url>
	
	<a href="${testUrl}">게시판 이동</a>
	
	<h1>8. JSTL Formatting Library</h1>
	<h1>JSTL Formatting</h1>
	<fmt:formatNumber value="1234.567" type="number"/><br>
	<fmt:formatNumber value="0.875" type="percent"/><br>
	
	<fmt:formatNumber value="1234.567" pattern="#,###.##"/> <br>
	<fmt:formatNumber value="1234.5" pattern="00000.00"/> <br>
	<fmt:formatNumber value="1234.5" pattern="#,###.000"/> <br>
</body>
</html>