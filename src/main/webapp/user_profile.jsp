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
input[readonly]
{
text-indent: 10px;
}
</style>
<title>Yummy - User Profile</title>
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
		<a href="userhome?id=<%=user.getUser_id()%>" id="opt_home">HOME</a>

</header>

<%String message = (String) request.getAttribute("message");%>
	<%if (message != null) {%>
		<div id="green_msg">
			<p><%=message%></p>
		</div>
	<%} %>

	<form action="editprofile" id="userprofile" method="post">
		<h1 style="text-align: center;">User Profile</h1>
		<br>
		<table>
			<tr>
				<td>Id</td>
				<td><input value="<%=user.getUser_id() %>" type="number" name="id" readonly></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input value="<%=user.getName() %>" type="text" name="name" readonly></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input value="<%=user.getEmail() %>" type="email" name="email" readonly></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input value="<%=user.getPassword() %>" type="text" name="password" readonly></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input value="<%=user.getPhone() %>" type="tel" name="phone" readonly></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input value="<%=user.getAddress() %>" type="text" name="address" readonly></td>
			</tr>
		</table>
		<br>
		<div style="text-indent: 30px;">
			<input id="loginsubmit" type="submit" value="Edit profile"
				style="background-color: #0488b9; width: 85%;">
		</div>

	</form>
</body>
</html>