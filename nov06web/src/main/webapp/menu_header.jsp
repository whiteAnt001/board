<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% String id = (String)session.getAttribute("USER"); %>
<div align="center">
	<table border="1">
		<tr><td><a href="chapter0601.jsp">�� 1�� ��������</a></td>
		<td><a href="chapter0604.jsp">�� 4�� ��������</a></td>
		<td><a href="chapter0605.jsp">�� 5�� ��������</a></td>
		<td><a href="loginCheck.do">�� �Խñ� ����</a></td>
		<td><a href="boardList.do">�� �Խñ� ���</a></td>
		<td><a href="index.jsp">�� Ȩ����</a></td>
		<td>
		<%
			if(id == null){
		%>
		<a href="login.jsp">�� �α���</a>
		<%}else { %>
			<a href="logout.do">�� �α׾ƿ�</a>
			<font color="red">ȯ���մϴ� <%= id %>��</font>
		<% } %>
		</td></tr>
	</table>
</div>