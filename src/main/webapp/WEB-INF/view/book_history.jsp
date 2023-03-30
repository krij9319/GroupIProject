<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.BookDto5" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="favicon/library.jpg">
<title>貸出履歴</title>
</head>
<body>
	<div class="main">
		<table border="1">
			<tr>
				<th>ID</th>
				<th>利用者ID</th>
				<th>図書ID</th>
				<th>貸出日</th>
				<th>返却予定日</th>
				<th>返却日</th>
			</tr>
			<%
			List<BookDto5> book = (ArrayList<BookDto5>)request.getAttribute("book");
			for(BookDto5 all : book){
			%>
				<tr>
					<td><a href="SelectHyoukaServlet"><%=all.getId() %></a></td>
					<td><a href="SelectHyoukaServlet"><%=all.getAccount_id() %></a></td>
					<td><a href="SelectHyoukaServlet"><%=all.getBook_id() %></a></td>
					<td><a href="SelectHyoukaServlet"><%=all.getLendday() %></a></td>
					<td><a href="SelectHyoukaServlet"><%=all.getScheduledday() %></a></td>
					<td><a href="SelectHyoukaServlet"><%=all.getReturnday() %></a></td>
				</tr>
			<%
			}
			%>
		</table>
	</div>
	<div class="main-end">
		<a href="ReturnMenuServlet">メニューに戻る</a>
	</div>
</body>
</html>