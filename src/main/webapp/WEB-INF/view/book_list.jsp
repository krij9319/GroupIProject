<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.BookDto1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel ="stylesheet"href="css/list.css">
  <link rel ="stylesheet"href="css/hamburger.css">
<title>本の一覧</title>
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


<p> </p><br><br><br><br><br>

<div class="center">
    <table id="hyou" border="1" style="width: 800px; font-size: 14px;">
        <tr>
            <th>ID</th>
            <th>ISBN</th>
            <th>タイトル</th>
            <th>著者</th>
            <th>出版社</th>
            <th>発効日</th>
            <th>貸出状況</th>
        </tr>
        <% List<BookDto1> list = (List<BookDto1>)request.getAttribute("list"); int index = 1; for(BookDto1 b : list){ %>
        <tr>
            <td><%=b.getId() %></td>
            <td><%=b.getIsbn()%></td>
            <td><%=b.getName() %></td>
            <td><%=b.getAuther() %></td>
            <td><%=b.getPublisher() %></td>
            <td><%=b.getRegister_day() %></td>
            <td><%=b.getBooksitu() %></td>
        </tr>
        <%} %>
    </table>
</div>

	<div class="main-end">
		<div class="back"><a href="AdominTopServlet">戻る</a></div>
	</div>
	<script src="./JavaScript/hamburger.js"></script>
</body>
</html>