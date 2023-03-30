<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トップページ</title>

 <meta name="viewport" content="width=device-width">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel ="stylesheet"href="css/menu.css">
<link rel ="stylesheet"href="css/hamburger.css">
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
      <div class="menu__item">TOP</div>
      <div class="menu__item">ABOUT</div>
      <div class="menu__item">BLOG</div>
      <div class="menu__item">CONTACT</div>
    </div>
    
  <!--メニュー画面-->

  <img class="osirase" src="./img/グループ 10.png" alt="おしらせ">

  <div class="haba">
	<a href="SelectBook">
  		<img class="img1" src="./img/図1.png" alt="図書一覧">
	</a>
    <a href="Book_HistoryServlet">
  		<img class="img2" src="./img/図3.png" alt="履歴">
	</a>
	<a href="LogoutServlet">
  		<img class="img3" src="./img/画像 6.png" alt="ログアウト">
	</a>
</div>
    <span>図書一覧</span>
    <span>履歴</span>
    <span>ログアウト</span>

	<script src="./JavaScript/hamburger.js"></script>
</body>
</html>