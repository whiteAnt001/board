<%@page import="board.BoardDTO"%>
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
<% BoardDTO dto = (BoardDTO)request.getAttribute("DTO"); %>
<h3 align="center">�Խñ� �� ����</h3>
<div align="center">
<form action="boardModifiy.do" method="post">
	<table border="1">
		<tr><th>������</th>
			<td><input type="hidden" name="TITLE" value="<%= dto.getTitle() %>"/><%= dto.getTitle() %></td></tr>
		<tr><th>�ۼ���</th><td><%= dto.getWriter() %></td></tr>
		<tr><th>�ۼ���</th><td><%= dto.getWrite_date() %></td></tr>
		<tr><th>�۳���</th>
			<td><textarea rows="4" cols="50" name="CONTENT"><%= dto.getContent() %></textarea></td></tr>
			<%
			if(id != null && id.equals(dto.getWriter())) {
			%>
			<tr><td colspan="2" align="center">
			<input type="submit" value="����" name="BTN"/>
			<input type="submit" value="����" name="BTN" /></td></tr>
			<%
			}
			%>
	</table>
	</form>
</div>
</section>
<footer>
	<h3 align="center">���������� �� ���� ������Ʈ. Copyright 2024.</h3>
</footer>
</body>
</html>