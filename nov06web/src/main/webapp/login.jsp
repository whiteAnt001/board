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
	<p>계정과 암호를 입력하고 로그인 버튼을 누르세요.</p>
	<form action="login.do" method="post">
	계정 : <input type="text" name="ID" size="10"/><br/>
	암호 : <input type="password" name="PWD" size="10"><br/>
	<input type="submit" value="로그인"/>
	<input type="reset" value="취 소"/>
	</form>
</section>
<footer>
	<h3 align="center">명지전문대 웹 개발 프로젝트. Copyright 2024.</h3>
</footer>
</body>
</html>