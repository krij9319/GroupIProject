<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.KuchikomiDto1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>口コミ</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>口コミ</th>
		</tr>
			<%
		List<KuchikomiDto1> list = (List<KuchikomiDto1>)request.getAttribute("list");
		int index = 1;
		for(KuchikomiDto1 k : list){

	%>
		<tr>
			<td><%=k.getId() %></td>
			<td><%=k.getKuchikomi() %></td>
		</tr>
		<%} %>
		</table>
		<a href="Hyouka_postServlet">口コミを投稿する</a>
		<a href="ReturnMenuServlet">戻る</a>
</body>
</html>