<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.BookDto1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="favicon/library.jpg">
<title>図書編集</title>
</head>
<body>
	<div class="main-title">
		<h1>図書編集</h1>
	</div>
	<div class="main">
	<%
		request.setCharacterEncoding("UTF-8");
		String errorCode = request.getParameter("error");
		if(errorCode != null && errorCode.equals("1")){
			BookDto1 book = (BookDto1)session.getAttribute("input_data");
	%>
		<h3 style="color:red">編集に失敗しました</h3>
		<form action="Book_UpdatePushServlet">
			<p>編集したい図書IDと項目を入力してください</p>
			ID<input type="text" name="id"><br>
			ISBN<input type="text" name="isbn"><br>
			タイトル<input type="text" name="name"><br>
			著者<input type="text" name="auther"><br>
			出版社<input type="text" name="publisher"><br>
			<input type="submit" value="編集" class="button1">
		</form>
		<%
			}else{
		%>
		<form action="Book_UpdatePushServlet">
			<p>編集したい図書IDと項目を入力してください</p>
			ID<input type="text" name="id"><br>
			ISBN<input type="text" name="isbn"><br>
			タイトル<input type="text" name="name"><br>
			著者<input type="text" name="auther"><br>
			出版社<input type="text" name="publisher"><br>
			<input type="submit" value="編集" class="button1">
		</form>
		<%
			}
		%>
	</div>
	<div class="button-left">
		<form action="./">
			<input type="submit" value="戻る" class="button2">
		</form>
	</div>
</body>
</html>