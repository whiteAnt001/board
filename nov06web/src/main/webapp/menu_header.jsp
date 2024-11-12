<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% String id = (String)session.getAttribute("USER"); %>
<div align="center">
	<table border="1">
		<tr><td><a href="chapter0601.jsp">■ 1번 연습문제</a></td>
		<td><a href="chapter0604.jsp">■ 4번 연습문제</a></td>
		<td><a href="chapter0605.jsp">■ 5번 연습문제</a></td>
		<td><a href="loginCheck.do">■ 게시글 쓰기</a></td>
		<td><a href="boardList.do">■ 게시글 목록</a></td>
		<td><a href="index.jsp">■ 홈으로</a></td>
		<td>
		<%
			if(id == null){
		%>
		<a href="login.jsp">■ 로그인</a>
		<%}else { %>
			<a href="logout.do">■ 로그아웃</a>
			<font color="red">환영합니다 <%= id %>님</font>
		<% } %>
		</td></tr>
	</table>
</div>