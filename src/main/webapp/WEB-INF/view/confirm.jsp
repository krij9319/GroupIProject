<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="dto.Account" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="favicon/library.jpg">
<title>登録確認</title>
</head>
<body>
	<p>下記の内容で登録します。よろしいですか？</p>
	<%
		Account account = (Account)session.getAttribute("input_data");
	%>
	メール：<%=account.getMail() %><br>
	パスワード：********<br>
	名前：<%=account.getName() %><br>
	<a href="executeServlet">OK</a><br>
	<a href="formServlet">戻る</a>
</body>
</html>