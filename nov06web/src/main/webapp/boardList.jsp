<%@page import="board.BoardDTO"%>
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
	<% ArrayList<BoardDTO> al = (ArrayList<BoardDTO>)request.getAttribute("BOARD"); %>
	<h3 align="center">게시글 목록</h3>
	<div align="center">
		<table border="1">
			<tr><th>작성자</th><th>제목</th><th>작성일</th></tr>
			<%
				for(BoardDTO dto : al){
			%>
			<tr><td><%= dto.getWriter() %></td><td><a href="boardDetail.do?TITLE=<%= dto.getTitle() %>"><%= dto.getTitle() %></a></td><td><%= dto.getWrite_date() %></td></tr>
			<%
				}
			%>
		</table>
	</div>
</section>
<footer>
	<h3 align="center">명지전문대 웹 개발 프로젝트. Copyright 2024.</h3>
</footer>
</body>
</html>