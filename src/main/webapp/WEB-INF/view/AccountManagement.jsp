<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー</title>
<meta name="viewport" content="width=device-width">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel ="stylesheet"href="css/AccountManagement.css">
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
      <div class="menu__item"><a href="AdominTopServlet">TOP</a></div>
      <div class="menu__item"><a href="AccountManagementServlet">アカウント管理</a></div>
      <div class="menu__item"><a href="BookManagementServlet">図書管理</a></div>
    </div>
    
  <!--メニュー画面-->
  <div class="haba">
	<a href="adminFormServlet">
  		<img class="img4" src="./img/画像 5.png" alt="管理者登録">
	</a>
    <a href="">
  		<img class="img5" src="./img/一覧.png" alt="管理者・利用者の一覧">
	</a>
	<a href="accountdelServlet">
  		<img class="img6" src="./img/画像 8.png" alt="管理者・利用者の削除">
	</a>
</div>
    <span>管理者登録</span>
    <span>管理者・利用者の一覧</span>
    <span>管理者・利用者の削除</span>
    <br>
    <div class="back"><a href="AdominTopServlet">戻る</a></div>
	<script src="./JavaScript/hamburger.js"></script>
</body>
</html>