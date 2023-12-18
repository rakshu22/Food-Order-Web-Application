<%@page import="food_order_webapp.dto.UserOrderItems"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="food_order_webapp.dto.UserOrder"%>
<%@page import="java.util.List"%>
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
#opt_order {
	font-weight: bold;
	color: #0488b9;
}
</style>
<title>Yummy - User Orders</title>
</head>
<body>
	<%
	User user = (User) request.getAttribute("user");
	%>
	<%
	List<UserOrder> dbOrders = (List) request.getAttribute("orderlist");
	%>

	<header style="position: fixed; top: 0;">
		<img src="images/yummy.png" alt="logo" id="logo">

		<div class="dropdown" style="float: right;">
			<a class="dropbtn" href="#"><i class="fas fa-user-circle"
				style="margin-top: 50px;"></i></a>
			<div class="dropdown-content">
				<a href="viewprofile?id=<%=user.getUser_id()%>">View Profile</a> <a
					href="index.jsp">Logout</a>
			</div>
		</div>

		<a href="#orders" id="opt_order">ORDERS</a> <a
			href="viewcart?id=<%=user.getUser_id()%>" id="opt_cart">CART</a> <a
			href="usermenu?id=<%=user.getUser_id()%>" id="opt_menu">MENU</a> <a
			href="userhome?id=<%=user.getUser_id()%>" id="opt_home">HOME</a>

	</header>
	
	<div style="margin-top: 150px; margin-bottom: 100px; ">
	<%
	if(dbOrders!=null){
	for (UserOrder order : dbOrders) {

		LocalDateTime date = order.getDatetime();
		DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm");
		String dbDate = date.format(dateformat);

		List<UserOrderItems> uItems = order.getUserOrderItems();
	%>
	<table id="ordertable">
		<tr style="height: 40px;">
			<th style="width: 20px;">Product</th>
			<th>Name</th>
			<th>Quantity</th>
			<th>Price</th>
			<th>Ordered On</th>
			<th>Subtotal</th>
		</tr>
		<%
		for (UserOrderItems userOrderItems : uItems) {
		%>
		<tr style="outline: thin solid black; border-radius: 10px; height: 70px;">
			<td id="ordertd" style="width: 20px;"><img src="getimage?id=<%=userOrderItems.getFid()%>" style="border-radius: 5px; width: 100%; height: 100%;"></td>
			<td id="ordertd"><%=userOrderItems.getFname()%></td>
			<td id="ordertd">x<%=userOrderItems.getFquantity()%></td>
			<td id="ordertd">Rs <%=userOrderItems.getFprice()%></td>
			<td id="ordertd"><%=dbDate%></td>
			<td id="ordertd">Rs <%=userOrderItems.getSubtotal()%></td>
		</tr>
		<%
		}
		%>
		<tr style="height: 40px;">
			<th>Order Id</th>
			<td id="ordertd" style="background-color: white;"><b>#<%=order.getOrder_id()%></b></td>
			<th>Order Status</th>
			<td id="ordertd" style="color: blue; font-weight: bolder; background-color: white;"><%=order.getOrder_status()%></td>
			<th>TOTAL</th>
			<td id="ordertd" style="background-color: white;"><b>Rs <%=order.getTotalbill()%></b></td>
		</tr>
	</table>
	<br>
	<br>
	<br>
	<hr style="border-style: dashed;">
	<br>
	<br>
	<br>
	<%}} %>
	
	<%if(dbOrders.isEmpty()){ %>
	<div style="text-align: center;">
		<img src="https://cdni.iconscout.com/illustration/premium/thumb/empty-cart-2130356-1800917.png"
			style="height: 300px; width: 500px; margin-top: 140px;">
	</div>
	<%} %>
	</div>
	
</body>
</html>