<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="favicon/library.jpg">
<title>返却画面</title>
</head>
<body>
	<div class="main">
		<h1>返却成功！</h1>
	</div>
	<div class="main-end">
		<form action="WEB-INF/view/adminmenu.jsp">
			<input type="submit" value="メニューへ戻る" class="button1">
		</form>
		<form action="ReturnServlet">
			<input type="submit" value="続けて返却" class="button2">
		</form>
	</div>
</body>
</html>