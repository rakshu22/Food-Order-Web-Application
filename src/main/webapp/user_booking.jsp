<%@page import="food_order_webapp.dto.User"%>
<%@page import="food_order_webapp.dto.UserCart"%>
<%@page import="java.util.List"%>
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
h2 {
	background-color: silver;
}

input {
	font-family: monospace;
	font-size:large;
	border:none;
	background-color: transparent;
}
</style>
<title>Yummy - User Order Booking</title>
</head>
<body>
	<%
	List<UserCart> dbCarts = (List) request.getAttribute("itemlist");
	%>
	<%
	User user = (User) request.getAttribute("user");
	%>
	<%
	String message = (String) request.getAttribute("message");
	%>
	<header style="position: fixed; top:0;"><%@include file="$policy_header.jsp"%></header>
	
	<div style=" text-indent: 30px; margin-top: 115px;">
	<%
	if (message != null) {
	%>
	<div id="green_msg">
		<p style="margin-top: 0;"><%=message%></p>
	</div>
	<%
	}
	%>
		<form action="bookorder" method="post">
			<input type="hidden" name="umail" value="<%=user.getEmail()%>">
			<h2>Your Order</h2>
			<table border="1px" id="booktable">
				<tr style="background-color: #C0D1FF; text-align: left;">
					<th>Id</th>
					<th>Name</th>
					<th>Price</th>
					<th>Quantity</th>
					<th style="text-align: right;">Subtotal</th>
				</tr>
				<%
				float subtotal = 0, total = 0;
				%>
				<%
				for (UserCart cart : dbCarts) {
				%>
				<tr>
					<%
					subtotal = cart.getFprice() * cart.getFquantity();
					%>
					<%
					total = total + (cart.getFprice() * cart.getFquantity());
					%>
					<td id="booktd"><input type="number" name="fid" readonly="readonly"
						value="<%=cart.getFid()%>"></td>
					<td id="booktd"><input type="text" name="fname" readonly="readonly"
						value="<%=cart.getFname()%>"></td>
					<td id="booktd"><input type="number" name="fprice" readonly="readonly"
						value="<%=cart.getFprice()%>"></td>
					<td id="booktd"><input type="number" name="quantity" readonly="readonly"
						value="<%=cart.getFquantity()%>"></td>
					<td id="booktd"><input type="number" name="subtotal" readonly="readonly"
						value="<%=subtotal%>" style="text-align: right;"></td>
				</tr>

				<%
				}
				%>
				<tr style="background-color: #FFF686; text-align: right;">
					<td id="booktd" colspan="4">TOTAL</td>
					<td id="booktd"><input type="number" name="total" readonly="readonly"
						value="<%=total%>"
						style="text-align: right; background-color: #FFF686; color: black;"></td>
				</tr>
			</table>


			<h2>Delivery Details</h2>
			<table border="1px" id="booktable">
				<tr>
					<th>Address</th>
					<td id="booktd"><input type="text" name="address"
						value="<%=user.getAddress()%>" readonly="readonly"></td>
				</tr>
				<tr>
					<th>Phone</th>
					<td id="booktd"><input type="tel" name="phone"
						value="<%=user.getPhone()%>" readonly="readonly"></td>
				</tr>
				<tr>
					<td id="booktd" colspan="2"><a
						href="editaddress&phone?userid=<%=user.getUser_id()%>"><input
							type="button" value="Edit" id="bookedit"></a></td>
				</tr>
			</table>


			<h2>Payment Method</h2>
			<input style="margin-left: 30px;" type="radio" name="pay_mode" value="cash on delivery"
				required="required"> <label for="cash">Cash on
				delivery</label> <br>
			<input style="margin-left: 30px;" type="radio" name="pay_mode"
				value="online payment" required="required"> <label
				for="online">Online payment</label> <br>
			<br>
			<input type="submit" value="Book order" id="bookbutton">
			<a href="viewcart?id=<%=user.getUser_id() %>"><input type="button" value="Cancel order" id="cancelbutton"></a>
		</form>
	</div>

</body>
</html>