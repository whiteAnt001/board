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
	<h2 align="center">SQL 6�� �������� ��������</h2>
</header>
<menu>
<%@ include file = "/menu_header.jsp" %>
</menu>
<section>
<h3 align="center">6�� �������� 4���� ���</h3>
<%
	ArrayList<Chapter0604DTO> al = (ArrayList<Chapter0604DTO>)request.getAttribute("AL");
%>
	<table border="1">
		<tr><th>�� �� ��</th><th>�μ� ��ȣ</th><th>���� ��ȣ</th></tr>
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
	<h3 align="center">���������� �� ���� ������Ʈ. Copyright 2024.</h3>
</footer>
</body>
</html>