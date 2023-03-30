<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.Account" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>利用者管理者一覧</title>
</head>
<body>
<h1>利用者及び管理者一覧</h1>

 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel ="stylesheet"href="css/hamburger.css">

<title>Insert title here</title>
</head>
<body>
	<header id="header">
 	<p>
 	 <img src="./img/グループ 9.png" alt="タイトル" width="400" height="65">
	</header>

 	<button type="button" class="menu-btn">
      <i class="fa fa-bars" aria-hidden="true"></i>
    </button>
    
    <div class="menu">
      <div class="menu__item"><a href="AdominTopServlet">TOP</a></div>
      <div class="menu__item"><a href="AccountManagementServlet">アカウント管理</a></div>
      <div class="menu__item"><a href="BookManagementServlet">図書管理</a></div>
      <div class="menu__item"><a href="Book_HistoryServlet2">履歴</a></div>
      <div class="menu__item"><a href="LogoutServlet">ログアウト</a></div>
    </div>

<h1>管理者一覧</h1>

	<table>
		<tr>
			<th>ID</th>
			<th>名前</th>
			<th>メールアドレス</th>
			
		</tr>
			<%
	List<Account> list = (ArrayList<Account>)request.getAttribute("list");
	for(Account s : list) {
	%>
		<tr>
			<td><%=s.getId() %></td>
			<td><%=s.getName() %></td>
			<td><%=s.getMail() %></td>
		</tr>
	<%} %>
	</table>

	<a href="AccountManagementServlet">戻る</a>

	<script src="./JavaScript/hamburger.js"></script>

</body>
</html>