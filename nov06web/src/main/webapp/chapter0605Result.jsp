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
	<h2 align="center">SQL 6�� �������� �������� 5��</h2>
</header>
<menu>
<%@ include file = "/menu_header.jsp" %>
</menu>
<section>
<h3 align="center">6�� �������� 5���� ���</h3>
<%
	ArrayList<Chapter0605DTO> al = (ArrayList<Chapter0605DTO>)request.getAttribute("AL"); 
%>
	<table border="1">
		<tr><th>�� �� ��</th><th>�޿�</th></tr>
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
	<h3 align="center">���������� �� ���� ������Ʈ. Copyright 2024.</h3>
</footer>
</body>
</html>