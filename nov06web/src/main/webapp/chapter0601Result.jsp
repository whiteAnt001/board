<%@page import="nov06.Chapter0601DTO"%>
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
	<h2 align="center">SQL 6�� �������� ��������</h2>
</header>
<menu>
<%@ include file = "/menu_header.jsp" %>
</menu>
<section>
<h3 align="center">6�� �������� 1���� ���</h3>
<%
	ArrayList<Chapter0601DTO> al = (ArrayList<Chapter0601DTO>)request.getAttribute("AL");
%>
<div align="center">
<table border="1">
	<tr><th>��� �̸�</th><th>�� �� ��</th><th>�μ� ��ȣ</th></tr>
	<%
		for( Chapter0601DTO dto : al ){
	%>
	<tr><td><%= dto.getName() %></td><td><%= dto.getHire_date() %></td><td><%= dto.getDept_id() %></td></tr>
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