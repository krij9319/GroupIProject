<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.BookDto2" %>
<%@ page import="dto.BookDto3" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="favicon/library.jpg">
<title>図書削除</title>
</head>
<body>
	<div class="main-title">
		<h1>登録済み図書削除</h1>
	</div>
<div class="main">
	<%
		request.setCharacterEncoding("UTF-8");
		String errorCode = request.getParameter("error");
		if(errorCode != null && errorCode.equals("1")){
			BookDto2 book = (BookDto2)session.getAttribute("input_data");
	%>
		<h3 style="color:red">削除に失敗しました</h3>
		<p>削除する図書IDを入力してください</p>
		<form action="Book_DeletePushServlet">
			<input type="text" name="id"><br>
			<p>このIDの図書を削除しますか？</p>
			<input type="submit" value="削除" class="button1">
		</form>
		<%
			}else{
		%>
		<p>削除する図書IDを入力してください</p>
		<form action="Book_DeletePushServlet">
			<input type="text" name="id"><br>
			<p>このIDの図書を削除しますか？</p>
			<input type="submit" value="削除" class="button1">
		</form>
		<%
			}
		%>
	</div>
	<div class="book">
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
		<a href="ReturnAdmenuServlet">メニューに戻る</a>
	</div>
</body>
</html>