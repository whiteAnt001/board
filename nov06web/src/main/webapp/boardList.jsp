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
	<h2 align="center">SQL 6�� �������� ��������</h2>
</header>
<menu>
<%@ include file = "/menu_header.jsp" %>
</menu>
<section>
	<% ArrayList<BoardDTO> al = (ArrayList<BoardDTO>)request.getAttribute("BOARD"); %>
	<h3 align="center">�Խñ� ���</h3>
	<div align="center">
		<table border="1">
			<tr><th>�ۼ���</th><th>����</th><th>�ۼ���</th></tr>
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
	<h3 align="center">���������� �� ���� ������Ʈ. Copyright 2024.</h3>
</footer>
</body>
</html>