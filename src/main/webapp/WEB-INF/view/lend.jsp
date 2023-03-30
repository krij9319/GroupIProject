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
	<div class="lend">
		<form action="LendInputServlet">
			<input type="submit" value="貸出" class="button1">
		</form>
		<form action="ReturnServlet">
			<input type="submit" value="返却" class="button2">
		</form>
	</div>
	<div class="end">
		<a href="ReturnAdmenuServlet">メニューに戻る</a>
	</div>
</body>
</html>