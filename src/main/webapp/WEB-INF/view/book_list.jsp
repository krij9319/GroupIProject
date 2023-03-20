<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.BookDto1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>本の一覧</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>ISBN</th>
			<th>タイトル</th>
			<th>著者</th>
			<th>出版社</th>
			<th>発効日</th>
			<th>貸出状況</th>
		</tr>
			<%
		List<BookDto1> list = (List<BookDto1>)request.getAttribute("list");
		int index = 1;
		for(BookDto1 ee : list){
	%>
		<tr>
			<td><%=ee.getId() %></td>
			<td><%=ee.getIsbn()%></td>
			<td><%=ee.getName() %></td>
			<td><%=ee.getAuther() %></td>
			<td><%=ee.getPublisher() %></td>
		</tr>
		<%} %>
</body>
<a href="./">戻る</a>
</html>