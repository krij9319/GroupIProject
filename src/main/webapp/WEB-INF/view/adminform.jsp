<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="dto.Account" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者登録</title>
<link rel ="stylesheet"href="css/index.css">
</head>
<body>
	<div class="login-page">
  <div class="form">
	<%
		request.setCharacterEncoding("UTF-8");
		String errorCode = request.getParameter("error");
		if(errorCode != null && errorCode.equals("1")){
			Account ac = (Account)session.getAttribute("input_data");
	%>
		<h1><p style="color:red">登録に失敗しました。<p></h1>
		<h3>管理者登録</h3>
		<form  class="login-form"action="adminConfirmServlet" method="post">
			<input type="text" name="name" placeholder="名前" value="<%=ac.getName()%>"><br>
			<input type="text" name="tell" placeholder="電話番号"><br>
			<input type="email" name="mail"placeholder="メールアドレス" value="<%=ac.getMail()%>"><br>
			<input type="password" name="pw"placeholder="パスワード"><br>
			<input type="submit" value="次へ">
		</form>
	<%
		} else {
	%>
	<h3>管理者登録</h3>
	<form  class="login-form"action="adminConfirmServlet" method="post">
			<input type="text" name="name" placeholder="名前"><br>
			<input type="text" name="tell" placeholder="電話番号"><br>
			<input type="email" name="mail"placeholder="メールアドレス"><br>
			<input type="password" name="pw"placeholder="パスワード"><br>
		<input type="submit" value="次へ">
	</form>
	</div>
	</div>
	<%
		}
	%>
		<a href="AccountManagementServlet">戻る</a>
</body>
</html>