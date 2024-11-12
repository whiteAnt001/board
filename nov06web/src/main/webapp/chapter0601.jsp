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
	<h2 align="center">SQL 6장 서브쿼리 연습문제 1번</h2>
</header>
<menu>
<%@ include file = "/menu_header.jsp" %>
</menu>
<section>
	<h3 align="center">6장 연습문제 1번</h3>
	<p>사원의 이름을 입력하고 버튼을 누르면 결과를 볼 수 있습니다.</p>
	<form action="chapter0601.do">
	사원의 이름 : <input type="text" name="NAME" size="10"/><br/>
	<input type="submit" value="결과 보기"/>
	</form>
</section>
<footer>
	<h3 align="center">명지전문대 웹 개발 프로젝트. Copyright 2024.</h3>
</footer>
</body>
</html>