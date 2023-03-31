<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者画面</title>
 <meta name="viewport" content="width=device-width">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel ="stylesheet"href="css/adominmenu2.css">
<link rel ="stylesheet"href="css/hamburger.css">
<link rel="icon" href="favicon/library.jpg">
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
      <div class="menu__item"><a href="Book_HistoryServlet2">履歴</a></div>
      <div class="menu__item"><a href="LogoutServlet">ログアウト</a></div>
    </div>
  
  <!-- メニュー画面 -->
  
<p> </p><br><br><br><br>

<div class="haba">
  <a href="AccountManagementServlet">
    <img class="img1" src="./img/画像 5.png" alt="アカウント管理">
  </a>
  <a href="BookManagementServlet">
    <img class="img2" src="./img/NoPath.png" alt="図書管理">
  </a>
  <a href="LendServlet">
    <img class="img3" src="./img/画像 7.png" alt="貸出・返却">
  </a>
</div>

<span>アカウント管理</span>
<span>図書管理</span>
<span>貸出・返却</span>

<div class="haba2">
  <a href="Book_HistoryServlet2">
    <img class="img4" src="./img/図3.png" alt="履歴">
  </a>
  <a href="LogoutServlet">
    <img class="img5" src="./img/画像 -1.png" alt="ログアウト">
  </a>
  
</div>
  
  <span>履歴</span>
  <span>ログアウト</span>

  <script src="./JavaScript/hamburger.js"></script>

</body>
</html>