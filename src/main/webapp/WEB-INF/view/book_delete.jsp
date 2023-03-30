<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.BookDto2" %>
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
	<div class="main-end">
		<a href="ReturnAdmenuServlet">メニューに戻る</a>
	</div>
</body>
</html>