<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.Account" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>管理者一覧</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>名前</th>
			<th>メールアドレス</th>
		</tr>
			<%
	List<Account> list = (ArrayList<Account>)request.getAttribute("list");
	for(Account s : list) {
	%>
		<tr>
			<td><%=s.getId() %></td>
			<td><%=s.getName() %></td>
			<td><%=s.getMail() %></td>
		</tr>
	<%} %>
	</table>
</body>
</html>