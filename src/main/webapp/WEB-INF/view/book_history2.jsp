<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.BookHistoryDto1" %>
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
				<th>メールアドレス</th>
				<th>ID</th>
				<th>利用者ID</th>
				<th>図書ID</th>
				<th>貸出日</th>
				<th>返却予定日</th>
				<th>返却日</th>
			</tr>
			<%
			List<BookHistoryDto1> book = (ArrayList<BookHistoryDto1>)request.getAttribute("book");
			for(BookHistoryDto1 all : book){
			%>
				<tr>
					<td><%=all.getEmail() %></td>
					<td><%=all.getId() %></td>
					<td><%=all.getId() %></td>
					<td><%=all.getIsbn() %></td>
					<td><%=all.getLendday() %></td>
					<td><%=all.getScheduledday() %></td>
					<td><%=all.getReturnday() %></td>
				</tr>
			<%
			}
			%>
		</table>
	</div>
	<div class="main-end">
		<a href="ReturnAdmenuServlet">戻る</a>
		<a></a>
	</div>
</body>
</html>