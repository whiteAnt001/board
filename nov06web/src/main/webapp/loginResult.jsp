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
<%
	if(id == null){ //로그인 실패
%>
	<h3 align="center">로그인 실패. 계정과 암호를 확인하세요.</h3>
<%	
	}else { //로그인 성공
%>
	<h3 align="center">로그인 성공. 환영합니다. <%= id %>님</h3>
<% 
	}
%>
</section>
<footer>
	<h3 align="center">명지전문대 웹 개발 프로젝트. Copyright 2024.</h3>
</footer>
</body>
</html>