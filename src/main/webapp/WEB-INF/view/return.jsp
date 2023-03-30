<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.ReturnDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="favicon/library.jpg">
<title>返却画面</title>
</head>
<body>
	<div class="main">
	<%
		request.setCharacterEncoding("UTF-8");
		String errorCode = request.getParameter("error");
		if(errorCode != null && errorCode.equals("1")){
		ReturnDto book = (ReturnDto)session.getAttribute("input_data");
	%>
		<h3 style="color:red">返却できませんでした</h3><br>
		<form action="ReturnPushServlet">
			<h1>返却する本のIDを入力してください</h1><br>
			<input type="text" name="book_id"><br>
			<input type="submit" value="返却" class="button1"><br>
		</form>
	<%
		}else{
	%>
		<form action="ReturnPushServlet">
			<h1>返却する本のIDを入力してください</h1><br>
			<input type="text" name="book_id"><br>
			<input type="submit" value="返却" class="button1"><br>
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