<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="dto.Account" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認</title>
</head>
<body>
	<h1><p>下記の内容で登録します。よろしいですか？</p></h1>
	<%
		Account account = (Account)session.getAttribute("input_data");
	%>
	名前<br><%=account.getName() %><br>
	メール<br><%=account.getEmail() %><br>
	パスワード<br>********</p><br>
	電話番号<br><%=account.getTel() %><br>
	<a href="adminExecuteServlet">OK</a><br>
	<a href="adminFormServlet">戻る</a>
</body>
</html>