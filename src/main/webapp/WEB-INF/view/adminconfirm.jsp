<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="dto.Account" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="favicn/library.jpg">
<title>確認</title>
</head>
<body>
	<p>下記の内容で登録します。よろしいですか？</p>
	<%
		Account account = (Account)session.getAttribute("input_data");
	%>

	名前<br><%=account.getName() %><br>
	メール<br><%=account.getMail() %><br>
	パスワード<br>********<br>
	電話番号<br><%=account.getTell() %><br>

	<a href="adminExecuteServlet">OK</a><br>
	<a href="adminFormServlet">戻る</a>
</body>
</html>