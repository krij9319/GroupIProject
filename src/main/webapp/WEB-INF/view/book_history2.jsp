<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.BookDto3" %>
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
			List<BookDto3> book = (ArrayList<BookDto3>)request.getAttribute("book");
			for(BookDto3 all : book){
			%>
				<tr>
					<td><%=all.getId() %></td>
					<td><%=all.getAccount_id() %></td>
					<td><%=all.getBook_id() %></td>
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
		<a href="WEB-INF/view/adminmenu.jsp">戻る</a>
	</div>
</body>
</html>