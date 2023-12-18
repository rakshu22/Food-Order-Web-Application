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
<style type="text/css">
#opt_home{
font-weight: bold;
color: #0488b9;
}
</style>
<title>Yummy - User Home</title>
</head>
<body>
<%User user=(User)request.getAttribute("user"); %>

<header>
		<img src="images/yummy.png" alt="logo" id="logo">

		<div class="dropdown" style="float: right;">
			<a class="dropbtn" href="#"><i class="fas fa-user-circle"
				style="margin-top: 50px;"></i></a>
			<div class="dropdown-content">
				<a href="viewprofile?id=<%=user.getUser_id()%>">View Profile</a> 
				<a href="index.jsp">Logout</a>
			</div>
		</div>

		<a href="uservieworder?id=<%=user.getUser_id() %>" id="opt_order">ORDERS</a> 
		<a href="viewcart?id=<%=user.getUser_id() %>" id="opt_cart">CART</a>
		<a href="usermenu?id=<%=user.getUser_id()%>" id="opt_menu">MENU</a> 
		<a href="#home" id="opt_home">HOME</a>

</header>

	<div id="mid" style="height: 405px; text-align: center;">
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<h1>Welcome <%=user.getName() %>!</h1>
	</div>
	<%@include file="$footer.jsp"%>
</body>
</html>