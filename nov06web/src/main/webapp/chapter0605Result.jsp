<%@page import="nov06.Chapter0605DTO"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<header>
	<h2 align="center">SQL 6장 서브쿼리 연습문제 5번</h2>
</header>
<menu>
<%@ include file = "/menu_header.jsp" %>
</menu>
<section>
<h3 align="center">6장 연습문제 5번의 결과</h3>
<%
	ArrayList<Chapter0605DTO> al = (ArrayList<Chapter0605DTO>)request.getAttribute("AL"); 
%>
	<table border="1">
		<tr><th>사 원 명</th><th>급여</th></tr>
		<%
			for( Chapter0605DTO dto : al ){
		%>
			<tr><td><%= dto.getName() %></td><td><%= dto.getSalary() %></td></tr>
		<%
			}
		%>
	</table>
</section>
<footer>
	<h3 align="center">명지전문대 웹 개발 프로젝트. Copyright 2024.</h3>
</footer>
</body>
</html>