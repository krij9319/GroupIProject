<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="favicon/library.jpg">
<title>図書編集完了</title>
</head>
<body>
	<div class="main">
		<h1>編集完了！</h1>
	</div>
	<div class="main-end">
		<form action="./">
			<input type="submit" value="メニューに戻る">
		</form>
		<form action="Book_UpdateServlet">
			<input type="submit" value="続けて編集">
		</form>
	</div>
</body>
</html>