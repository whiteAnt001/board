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
	<p>������ ��ȣ�� �Է��ϰ� �α��� ��ư�� ��������.</p>
	<form action="login.do" method="post">
	���� : <input type="text" name="ID" size="10"/><br/>
	��ȣ : <input type="password" name="PWD" size="10"><br/>
	<input type="submit" value="�α���"/>
	<input type="reset" value="�� ��"/>
	</form>
</section>
<footer>
	<h3 align="center">���������� �� ���� ������Ʈ. Copyright 2024.</h3>
</footer>
</body>
</html>