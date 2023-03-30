<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Account3" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="favicon/library.jpg">
<title>管理者及び利用者削除</title>
</head>
<body>
	<h1>管理者及び利用者の削除</h1>
  	<form action= "RegisteraccountDel"method="get">
		削除する管理者及び利用者のメールアドレスを入力してください<br>
		<input type="email" name="email"><br>
		このメールアドレスの管理者及び利用者を削除しますか？<br>
		<input type="submit" value="削除"><br>
	</form>
			<table border="1">
		<tr>
			<th>ID</th>
			<th>名前</th>
			<th>メールアドレス</th>
		</tr>
	<%
	List<Account3> list = (ArrayList<Account3>)request.getAttribute("account");
	for(Account3 s : list) {
	%>
		<tr>
			<td><%=s.getId() %></td>
			<td><%=s.getName() %></td>
			<td><%=s.getEmail() %></td>
		</tr>
	<%
	} 
	%>
	</table>
	<a href="ReturnAdmenuServlet">戻る</a>

</body>
</html>