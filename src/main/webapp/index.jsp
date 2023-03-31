<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ホーム</title>
<link rel="icon" href="favicon/library.jpg">
<link rel ="stylesheet"href="css/index.css">
</head>
<body>
	<div class="login-page">
  <div class="form">
	<%
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("error") != null){	
	%>

		<p style="color:red">ログイン失敗</p>
	<form class="login-form" action="loginServlet" method="post">
		<input type="email" name="mail" placeholder="メールアドレス" value="<%=request.getParameter("mail") %>"><br>
		<input type="password" name="pw" placeholder="パスワード"><br>  
		<input type="submit" value="ログイン" class="button">
	<p class="message">初めて登録の方はこちら<a href="formServlet">新規登録</a>
	</p>
	</form>
	<%
		} else {
	%>
	<form  class="login-form" action="loginServlet" method="post">
		<input type="email" name="mail" placeholder="メールアドレス"><br>
		<input type="password" name="pw" placeholder="パスワード"><br>
		<input type="submit" value="ログイン">
	<p class="message">初めて登録の方はこちら<a href="formServlet">新規登録</a>
	</p>
	</form>
	</div>
	</div>
	<%
		}
	%>
</body>
</html>