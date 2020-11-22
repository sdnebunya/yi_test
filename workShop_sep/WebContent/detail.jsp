<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="bean.ShohinBean"%>

<%
    ShohinBean shohinData = (ShohinBean) request.getAttribute("shohinDetail");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="content">
		<div><img src="<%=shohinData.getImageUrl() %>"></div>
		<div>
			<span>商品名：<%=shohinData.getName() %></span>
			<span>金額：<%=shohinData.getPrice() %></span>
			<span>在庫数：<%=shohinData.getStock() %></span>
			<form action="/workShop/result" method="post">
				<input type="hidden" name="id" value="<%=shohinData.getId() %>">
				<input type="hidden" name="stock" value="<%=shohinData.getStock() %>">
				<input type="submit" value="購入する">
			</form>
		</div>
	</div>
</body>
</html>