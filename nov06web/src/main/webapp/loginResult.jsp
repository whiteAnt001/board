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
<%
	if(id == null){ //�α��� ����
%>
	<h3 align="center">�α��� ����. ������ ��ȣ�� Ȯ���ϼ���.</h3>
<%	
	}else { //�α��� ����
%>
	<h3 align="center">�α��� ����. ȯ���մϴ�. <%= id %>��</h3>
<% 
	}
%>
</section>
<footer>
	<h3 align="center">���������� �� ���� ������Ʈ. Copyright 2024.</h3>
</footer>
</body>
</html>