<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="favicon/library.jpg">
<title>貸出画面</title>
</head>
<body>
	<div class="main">
		<h1>貸出完了！</h1>
	</div>
	<div class="main-end">
		<form action="./">
			<input type="submit" value="メニューへ戻る" class="button1">
		</form>
		<form action="LendInputServlet">
			<input type="submit" value="続けて借りる" class="button2">
		</form>
	</div>
</body>
</html>