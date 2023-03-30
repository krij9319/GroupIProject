<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Account3" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="favicon/library.jpg">
<title>管理者・利用者一覧</title>
</head>
<body>
	<div class="main">
		<table border="1">
		<tr>
			<th>ID</th>
			<th>名前</th>
			<th>メールアドレス</th>
		</tr>
	<%
	List<Account3> list = (ArrayList<Account3>)request.getAttribute("account");
	for(Account3 s : list) {
	%>
		<tr>
			<td><%=s.getId() %></td>
			<td><%=s.getName() %></td>
			<td><%=s.getEmail() %></td>
		</tr>
	<%
	} 
	%>
	</table>
	</div>
	<div class="main-end">
		<a href="ReturnAdmenuServlet">メニューに戻る</a>
	</div>
</body>
</html>