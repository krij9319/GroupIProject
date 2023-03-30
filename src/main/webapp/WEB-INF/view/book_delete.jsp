<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.BookDto2" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="icon" href="favicon/library.jpg">
<link rel ="stylesheet"href="css/hamburger.css">
<link rel ="stylesheet"href="css/delete.css">
<title>図書削除</title>
</head>
<body>

 <header id="header">
 <p>
  <img src="./img/グループ 9.png" alt="タイトル" width="400" height="65">
  </p>
</header>

 <button type="button" class="menu-btn">
      <i class="fa fa-bars" aria-hidden="true"></i>
    </button>
      <div class="menu">
      <div class="menu__item"><a href="AdominTopServlet">TOP</a></div>
      <div class="menu__item"><a href="AccountManagementServlet">アカウント管理</a></div>
      <div class="menu__item"><a href="BookManagementServlet">図書管理</a></div>
    </div>
  <p> </p><br><br><br><br>

	<div class="main-title">
		<h1>登録済み図書削除</h1>
	</div>
<div class="main">
	<%
		request.setCharacterEncoding("UTF-8");
		String errorCode = request.getParameter("error");
		if(errorCode != null && errorCode.equals("1")){
			BookDto2 book = (BookDto2)session.getAttribute("input_data");
	%>
		<h3 style="color:red">削除に失敗しました</h3>
		<p>削除する図書IDを入力してください</p>
		<form action="Book_DeletePushServlet">
			<input type="text" name="id"><br>
			<p>このIDの図書を削除しますか？</p>
			<input type="submit" value="削除" class="button1">
		</form>
		<%
			}else{
		%>
		<div class="center">
		<p>削除する図書IDを入力してください</p>
		<form action="Book_DeletePushServlet">
			<textarea name="id" rows="2" cols="50" placeholder="内容を入力"></textarea><br>
			<p>このIDの図書を削除しますか？</p>
			<input type="submit" value="削除" class="button1">
		</form>
		<%
			}
		%>
	</div>
	</div>
	
	<div class="main-end">
		<a href="ReturnAdmenuServlet">戻る</a>
	</div>
	  <script src="./JavaScript/hamburger.js"></script>
</body>
</html>