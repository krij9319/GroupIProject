<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>図書管理メニュー</title>
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
  
 <div class="haba">
	<a href="">
  		<img class="img1" src="./img/NoPath.png" alt="本の登録">
	</a>
    <a href="">
  		<img class="img2" src="./img/図1.png" alt="図書一覧">
	</a>
	<a href="">
  		<img class="img3" src="./img/画像 8.png" alt="図書削除">
	</a>
    <a href="">
        <img class="img4" src="./img/画像 9.png" alt="本の編集">
  </a>
</div>

   <span>本の登録</span>
   <span>図書一覧</span>
   <span>図書削除</span>
   <span>本の編集</span>
   <br>
   <div class="back"><a href="">戻る</a></div>
   
	<script src="./JavaScript/hamburger.js"></script>
</body>
</html>