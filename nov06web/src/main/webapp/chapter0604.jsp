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
	<h2 align="center">SQL 6장 서브쿼리 연습문제 4번</h2>
</header>
<menu>
<%@ include file = "/menu_header.jsp" %>
</menu>
<section>
	<h3 align="center">6장 연습문제 4번</h3>
	<p>부서 위치번호를 입력하고 그 위치에 있는 부서에서 근무하는 사원을 찾아라</p>
	<form action="chapter0604.do">
	부서 위치번호 : <input type="text" name="dept_id" size="10"/><br/>
	<input type="submit" value="결과 보기"/>
	</form>
</section>
<footer>
	<h3 align="center">명지전문대 웹 개발 프로젝트. Copyright 2024.</h3>
</footer>
</body>
</html>