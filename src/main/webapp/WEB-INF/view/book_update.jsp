<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.BookDto1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="favicon/library.jpg">
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel ="stylesheet"href="css/up.css">
<link rel ="stylesheet"href="css/hamburger.css">
<title>図書編集</title>
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
    </div>
    

	<div class="main-title">
		<h1>図書編集</h1>
	</div>
	<div class="main">
	<%
		request.setCharacterEncoding("UTF-8");
		String errorCode = request.getParameter("error");
		if(errorCode != null && errorCode.equals("1")){
			BookDto1 book = (BookDto1)session.getAttribute("input_data");
	%>
		<h3 style="color:red">編集に失敗しました</h3>
		<form action="Book_UpdatePushServlet">
			<p>編集したい図書IDと項目を入力してください</p>
			ID<input type="text" name="id"><br>
			ISBN<input type="text" name="isbn"><br>
			タイトル<input type="text" name="name"><br>
			著者<input type="text" name="auther"><br>
			出版社<input type="text" name="publisher"><br>
			<input type="submit" value="編集" class="button1">
		</form>
		<%
			}else{
		%>
		<form class="haba" action="Book_UpdatePushServlet">
			<div class="size"><p>編集したい図書IDと項目を入力してください</p></div>
			<div class="basyo">
			ID<input type="text" name="id"><br>
			ISBN<input type="text" name="isbn"><br>
			タイトル<input type="text" name="name"><br>
			著者<input type="text" name="auther"><br>
			出版社<input type="text" name="publisher"><br>
		<input class="up" type="submit" value="削除" class="button1">
		
			</div>
		</form>
		<%
			}
		%>
	</div>
	<div class="main-end">
		<div class="back"><a href="ReturnAdmenuServlet">戻る</a></div>
	</div>
	<script src="./JavaScript/hamburger.js"></script>
</body>
</html>