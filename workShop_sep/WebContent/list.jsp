<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.ShohinBean"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<%
   ArrayList<ShohinBean> shohinList = (ArrayList<ShohinBean>) request.getAttribute("shohinList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="content">
		<% for(ShohinBean result : shohinList){ %>
			<div><img src="<%=result.getImageUrl()%>"></div>
			<div class="box">
				<span>商品名：<%=result.getName() %></span>
				<span>金額：<%=result.getPrice() %></span>
			</div>
			<form action="/workShop/detail" method="get">
				<input type="hidden" name="id" value="<%=result.getId() %>">
				<input type="submit" value="商品ページへ">
			</form>
		<%} %>
	</div>
</body>
</html>