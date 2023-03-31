<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.BookDto5" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
      <div class="menu__item"><a href="TopServlet">TOP</a></div>
      <div class="menu__item"><a href="SelectBookServlet">図書一覧</a></div>
      <div class="menu__item"><a href="Book_HistoryServlet">履歴</a></div>
      <div class="menu__item"><a href="LogoutServlet">ログアウト</a></div>
    </div>
    
  <!--メニュー画面-->

  <p> </p><br><br><br><br><br>
<br><br>


	<div class="main">
		<table id="hyou" border="1" style="width: 800px; font-size: 14px;">
			<tr>
				<th>ID</th>
				<th>利用者ID</th>
				<th>図書ID</th>
				<th>貸出日</th>
				<th>返却予定日</th>
				<th>返却日</th>
			</tr>
			<%
			List<BookDto5> book = (ArrayList<BookDto5>)request.getAttribute("book");
			for(BookDto5 all : book){
			%>
				<tr>
					<td><a href="SelectHyoukaServlet"><%=all.getId() %></a></td>
					<td><a href="SelectHyoukaServlet"><%=all.getAccount_id() %></a></td>
					<td><a href="SelectHyoukaServlet"><%=all.getBook_id() %></a></td>
					<td><a href="SelectHyoukaServlet"><%=all.getLendday() %></a></td>
					<td><a href="SelectHyoukaServlet"><%=all.getScheduledday() %></a></td>
					<td><a href="SelectHyoukaServlet"><%=all.getReturnday() %></a></td>
				</tr>
			<%
			}
			%>
		</table>
	</div>
	<div class="main-end">
		<div class="back"><a href="ReturnMenuServlet">戻る</a></div>
	</div>
	 <script src="./JavaScript/hamburger.js"></script>
	
</body>
</html>