<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="dto.Account" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者登録</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String errorCode = request.getParameter("error");
		if(errorCode != null && errorCode.equals("1")){
			Account ac = (Account)session.getAttribute("input_data");
	%>
		<h1><p style="color:red">登録に失敗しました。<p></h1>
		<h1>管理者登録</h1>
		<form action="adminConfirmServlet" method="post">
			名前<br><input type="text" name="name" value="<%=ac.getName()%>"><br>
			メール<br><input type="email" name="email" value="<%=ac.getEmail()%>"><br>
			パスワード<br><input type="password" name="pw"><br>
			電話番号<br><input type="text" name="age" value="<%=ac.getTel()%>"><br>
			<input type="submit" value="次へ">
		</form>
	<%
		} else {
	%>
	<h1>管理者登録</h1>
	<form action="adminConfirmServlet" method="post">
			名前<br><input type="text" name="name"><br>
			メール<br><input type="email" name="email"><br>
			パスワード<br><input type="password" name="pw"><br>
			電話番号<br><input type="text" name="tel"><br>
		<input type="submit" value="次へ">
	</form>
	<%
		}
	%>
		<a href="index.jsp">戻る</a>
</body>
</html>