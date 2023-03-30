<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.LendDto1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="favicon/library.jpg">
<title>貸出画面</title>
</head>
<body>
	<div class="main">
	<%
		request.setCharacterEncoding("UTF-8");
		String errorCode = request.getParameter("error");
		if(errorCode != null && errorCode.equals("1")){
		LendDto1 book = (LendDto1)session.getAttribute("input_data");
	%>
		<h3 style="color:red">貸出ができませんでした</h3>
		<form action="LendPushServlet">
			<h1>以下の項目を入力してください</h1><br>
			ユーザーID<input type="text" name="account_id"><br>
			図書ID<input type="text" name="book_id"><br>
			<input type="submit" value="貸出" class="button2">
		</form>
	<%
		}else{
	%>
		<form action="LendPushServlet">
			<h1>以下の項目を入力してください</h1><br>
			ユーザーID<input type="text" name="account_id"><br>
			図書ID<input type="text" name="book_id"><br>
			<input type="submit" value="貸出" class="button1">
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