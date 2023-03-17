<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="favicon/library.jpg">
<title>図書削除完了</title>
</head>
<body>
	<div class="main">
		<h1>削除完了！</h1>
	</div>
	<div class="main-end">
		<form action="./">
			<input type="submit" value="メニューに戻る">
		</form>
		<form action="Book_DeleteServlet">
			<input type="submit" value="続けて削除">
		</form>
	</div>
</body>
</html>