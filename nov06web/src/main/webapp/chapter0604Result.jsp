<%@page import="nov06.Chapter0604DTO"%>
<%@page import="java.util.ArrayList"%>
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
	<h2 align="center">SQL 6장 서브쿼리 연습문제</h2>
</header>
<menu>
<%@ include file = "/menu_header.jsp" %>
</menu>
<section>
<h3 align="center">6장 연습문제 4번의 결과</h3>
<%
	ArrayList<Chapter0604DTO> al = (ArrayList<Chapter0604DTO>)request.getAttribute("AL");
%>
	<table border="1">
		<tr><th>사 원 명</th><th>부서 번호</th><th>업무 번호</th></tr>
		<%
			for( Chapter0604DTO dto : al ){
		%>
		<tr><td><%= dto.getName() %></td><td><%= dto.getDept_id() %></td><td><%= dto.getJob_id() %></td></tr>
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