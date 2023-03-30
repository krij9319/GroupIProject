<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者及び利用者削除</title>
</head>
<body>
	<h1>管理者及び利用者の削除</h1>
  	<form action= "RegisteraccountDel"method="get">
		削除する管理者及び利用者のメールアドレスを入力してください<br>
		<input type="email" name="email"><br>
		このメールアドレスの管理者及び利用者を削除しますか？<br>
		<input type="submit" value="削除"><br>
	　　<a href="AccountManagementServlet">戻る</a>
</body>
</html>