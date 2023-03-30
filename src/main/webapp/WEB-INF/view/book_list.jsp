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
		for(BookDto1 b : list){

	%>
		<tr>
			<td><%=b.getId() %></td>
			<td><%=b.getIsbn()%></td>
			<td><%=b.getName() %></td>
			<td><%=b.getAuther() %></td>
			<td><%=b.getPublisher() %></td>
            <td><%=b.getRegister_day() %></td>
            <td><%=b.getBooksitu() %></td>
		</tr>
		<%} %>
		</table>
	<div class="main-end">
		<a href="ReturnMenuServlet">メニューに戻る</a>
	</div>
</body>
</html>