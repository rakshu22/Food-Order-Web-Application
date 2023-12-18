<%@page import="food_order_webapp.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon"
	href="https://cdn-icons-png.flaticon.com/128/2187/2187430.png"
	type="image/x-icon">
<!--tab icon-->
<link rel="stylesheet" href="css/cstyle.css">
<!--external stylesheet-->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
<!--icons stylesheet-->
<title>Yummy - Order Success</title>
</head>
<body>
<%
	User user = (User) request.getAttribute("user");
	%>
	<%@include file="$policy_header.jsp"%>
	<div id="mid" style="height: 480px; text-align: center;">
		<br>
		<br>
		<br>
		<br> <img
			src="https://cdn.dribbble.com/users/2185205/screenshots/7886140/02-lottie-tick-01-instant-2.gif"
			style="height: 250px; width: 500px;">
		<h1 style="color: rgb(10, 156, 83);">Your order was successful</h1>
		<br> <a href="uservieworder?id=<%=user.getUser_id()%>"><input id="ordersuccess" type="submit" value="View my order" style="width: 200px; background-color: #0a9c53;"></a>
	</div>
</body>
</html>