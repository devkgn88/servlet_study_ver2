<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>EL�� JSTL</title>
</head>
<body>
	<h1>1. EL�� ���尴ü</h1>
	<%
		pageContext.setAttribute("test", "������");
		request.setAttribute("test", "������Ʈ");
		session.setAttribute("test", "����");
		application.setAttribute("test", "�������̼�");
	%>
	
	<h2>(1) JSP ���</h2>
	<p><%= pageContext.getAttribute("test") %></p>
	<p><%= request.getAttribute("test") %></p>
	<p><%= session.getAttribute("test") %></p>
	<p><%= application.getAttribute("test") %></p>
	
	<h2>(2) EL ���</h2>
	<p>${pageScope.test }</p>
	<p>${requestScope.test }</p>
	<p>${sessionScope.test }</p>
	<p>${applicationScope.test }</p>
	<p>${test }</p>
	
	<h1>2. EL�� ��ü �ٷ��</h1>
	<%@ page import="com.gn.dto.Person" %>
	<%
		request.setAttribute("person", new Person("��ö��", 77));
	%>
	<h2>(1) JSP ���</h2>
	<%
		Person p = (Person)request.getAttribute("person");
	%>
	<p>�̸�: <%= p.getName() %></p>
	<p>����: <%= p.getAge() %>��</p>
	<h2>(2) EL ���</h2>
	<p>�̸�: ${person.name}</p>
	<p>����: ${person.age}��</p>
	
	<h1>3. EL ��ü ��� ����</h1>
	<%@ page import="com.gn.dto.Planet" %>
	<%
	    Planet planet = new Planet("����", 1.5, true);
	    request.setAttribute("planet", planet);
	%>
	<p>�̸�: ${planet.name}</p>
	<p>�¾����κ����� �Ÿ�: ${planet.distance}�� km</p>
	<p> 
		���� ���� ���� : ${planet.habitable ? "O" : "X"} %>
	</p>
	<h1>4. EL ������</h1>
	<%@page import="java.util.*"%>
	<%
	    request.setAttribute("num1", 7);
	    request.setAttribute("num2", 2);
	    request.setAttribute("str1", "�ܹ���");
	    request.setAttribute("str2", "����");
	
	    List<String> menu = new ArrayList<>();
	    menu.add("¥���");
	    menu.add("«��");
	    request.setAttribute("menuList", menu);
	%>
	<p>${num1 + num2}</p>
	<p>${num1 - num2}</p>
	<p>${num1 * num2}</p>
	<p>${num1 div num2}</p>
	<p>${num1 mod num2}</p>
	
	<p>${str1}${str2}</p>
	<p>${str1 eq str2}</p>
	<p>${str1 eq "�ܹ���"}</p>
	
	<p>${empty menuList}</p>
	<p>${not empty menuList}</p>
		
	<p>${num1 gt num2}</p>
	<p>${num1 lt num2}</p>
	<p>${num1 gt num2 and not empty menuList}</p>
	
	<h1>5. JSTL Core Library</h1>
	<h2>(1) ���� ����</h2>
	<c:set var="num1" value="10"/>
	<c:set var="num2" value="20"/>
	<c:set var="result" value="${num1 + num2}"/>
	
	<h2>(2) ���� ���</h2>
	<c:set var="result" value="<b>�ȳ��ϼ���!</b>"/>
	<!-- �⺻ ���: <b>�ȳ��ϼ���!</b>�� �±װ� �ƴ϶� ���ڷ� ���� -->
	<c:out value="${result}"/><br>
	
	<!-- escapeXml="false" ����: <b>�ȳ��ϼ���!</b>�� ������ ���� ǥ�õ� -->
	<c:out value="${result}" escapeXml="false"/>
	
	<h2>(3) ���ǹ�:if</h2>
	<c:if test="${num1 le num2}">
		<p>num1�� num2���� �۰ų� ����.</p>
	</c:if>
	
	<h2>(4) ���ǹ�:choose</h2>
	<c:choose>
		<c:when test="${num1 gt 20 }">
			<p>10�� 20���� Ů�ϱ�?</p>
		</c:when>
		<c:when test="${num1 ge 10 }">
			<p>num1�� 10���� ũ�ų� �����鼭, 20���� �۰ų� ������?</p>
		</c:when>
		<c:otherwise>
			<p>num1�� 10���� �۽��ϱ�?</p>
		</c:otherwise>
	</c:choose>
	
	<h1>6. ����Ʈ �׸� ����</h1>
	<form method="post" action="/setTheme">
	    <button type="submit" name="theme" value="dark">��ũ���</button>
	    <button type="submit" name="theme" value="light">����Ʈ���</button>
	</form>
	<h1>(5) JSTL Core �ݺ���</h1> 
	<c:forEach var="i" begin="1" end="10" step="2">
		<p>�ݺ� ����: ${i}</p>
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
	      ����: ${num}<br>
	      �ε���: ${status.index}<br>
	      ī��Ʈ: ${status.count}<br>
	      ù��°�ΰ���? ${status.first}<br>
	      �������ΰ���? ${status.last}
	  </p>
	</c:forEach>
	<h1>7. ����� �� ���</h1>
	<form method="post" action="/printStar">
	    <label>����� �� ���� �����ϼ��� : </label>
	    <select name="count">
	        <option value="3">3��</option>
	        <option value="5">5��</option>
	        <option value="7">7��</option>
	    </select>
	    <button type="submit">����ϱ�</button>
	</form>
	<h2>(6) JSTL Core ��� ���� </h2>
	<a href="<%= request.getContextPath() %>/boardList">�Խ���</a>
	<script src="<%= request.getContextPath() %>/resources/js/jquery-3.7.1.js"></script>
	
	<a href="<c:url value='/boardList' />">�Խ���</a>
	<script src="<c:url value='/resources/js/jquery-3.7.1.js' />"></script>

	<c:url var="testUrl" value="/boardList">
	    <c:param name="nowPage" value="1" />
	    <c:param name="boardTitle" value="�׽�Ʈ" />
	</c:url>
	
	<a href="${testUrl}">�Խ��� �̵�</a>
	
	<h1>8. JSTL Formatting Library</h1>
	<h1>JSTL Formatting</h1>
	<fmt:formatNumber value="1234.567" type="number"/><br>
	<fmt:formatNumber value="0.875" type="percent"/><br>
	
	<fmt:formatNumber value="1234.567" pattern="#,###.##"/> <br>
	<fmt:formatNumber value="1234.5" pattern="00000.00"/> <br>
	<fmt:formatNumber value="1234.5" pattern="#,###.000"/> <br>
</body>
</html>