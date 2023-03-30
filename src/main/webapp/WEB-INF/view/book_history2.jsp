<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.BookHistoryDto1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="favicon/library.jpg">
<link rel="icon" href="favicon/library.jpg">
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel ="stylesheet"href="css/list.css">
  <link rel ="stylesheet"href="css/hamburger.css">
<title>貸出履歴</title>
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


<p> </p><br><br><br><br><br>

	<div class="main">
		<table id="hyou" border="1" style="width: 800px; font-size: 14px;">
			<tr>
				<th>メールアドレス</th>
				<th>ID</th>
				<th>利用者ID</th>
				<th>図書ID</th>
				<th>貸出日</th>
				<th>返却予定日</th>
				<th>返却日</th>
			</tr>
			<%
			List<BookHistoryDto1> book = (ArrayList<BookHistoryDto1>)request.getAttribute("book");
			for(BookHistoryDto1 all : book){
			%>
				<tr>
					<td><%=all.getEmail() %></td>
					<td><%=all.getId() %></td>
					<td><%=all.getId() %></td>
					<td><%=all.getIsbn() %></td>
					<td><%=all.getLendday() %></td>
					<td><%=all.getScheduledday() %></td>
					<td><%=all.getReturnday() %></td>
				</tr>
			<%
			}
			%>
		</table>
	</div>
	<div class="main-end">
		<div class="back"><a href="ReturnAdmenuServlet">戻る</a></div>
		<a></a>
	</div>
	 <script src="./JavaScript/hamburger.js"></script>
	
</body>
</html>