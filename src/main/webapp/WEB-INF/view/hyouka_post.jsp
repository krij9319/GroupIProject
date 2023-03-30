<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>口コミ機能</title>
</head>
<body>
	<% 
		String error = request.getParameter("error");
		if(error != null){
			
	%>
	<h1>口コミ</h1>
		<h1 style="color:red">投稿できませんでした</h1>
		
		<form action="RegisterHyoukaServlet" method="post">
			口コミ<br>
			<textarea name="kuchikomi" rows="10" cols="50" placeholder="口コミを入力"><%=request.getParameter("kuchikomi") %></textarea><br>
			<input type="submit" value="投稿">
		
		</form>
	<%	
		} else {
	%>
	<h1>口コミ</h1>
	<form action="RegisterHyoukaServlet" method="post">
		<textarea name="kuchikomi" rows="10" cols="50" placeholder="口コミを入力"></textarea><br>
		<input type="submit" value="投稿">
	
	</form>
	<% } %>
</body>
</html>