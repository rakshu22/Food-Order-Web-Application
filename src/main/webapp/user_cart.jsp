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
#opt_cart {
	font-weight: bold;
	color: #0488b9;
}
</style>
<title>Yummy - User Cart</title>
</head>
<body>
	<%
	User user = (User) request.getAttribute("user");
	%>
	<%
	List<UserCart> dbCarts = (List) request.getAttribute("itemlist");
	%>
	<%
	String message = (String) request.getAttribute("message");
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

		<a href="uservieworder?id=<%=user.getUser_id() %>" id="opt_order">ORDERS</a> <a
			href="#cart" id="opt_cart">CART</a> <a
			href="usermenu?id=<%=user.getUser_id()%>" id="opt_menu">MENU</a> <a
			href="userhome?id=<%=user.getUser_id()%>" id="opt_home">HOME</a>
	</header>

	

    <div style="margin-top: 115px; margin-bottom: 100px;">
    <%
	if (message != null) {
	%>
	<div id="green_msg">
		<p style="margin-top: 0;"><%=message%></p>
	</div>
	<%
	}
	%>
	<%
	if (dbCarts != null) {
		float subtotal = 0;
		String umail = null;
		for (UserCart cart : dbCarts) {
	%>
		<table id="carttable">
			<tr>
				<td colspan="3"><img src="getimage?id=<%=cart.getFid() %>" width="100%" height="100%"></td>
			</tr>
			<tr>
				<td id="cart_td" colspan="2"><%=cart.getFname()%></td>
				<td id="cart_td">Rs <%=cart.getFprice()%></td>
			</tr>

			<tr id="quan">
				<td id="cart_td"><a id="dec"
					href="setquantity?action=dec&id=<%=cart.getCart_id()%>&umail=<%=cart.getUmail()%>"><i
						class="fas fa-minus-square" ></i></a></td>
				<td id="cart_td"><input id="inpquant" type="number" name="quantity"
					value="<%=cart.getFquantity()%>" readonly="readonly"></td>
				<td id="cart_td"><a id="inc"
					href="setquantity?action=inc&id=<%=cart.getCart_id()%>&umail=<%=cart.getUmail()%>"><i
						class="fas fa-plus-square" ></i></a></td>
			</tr>

			<tr>
				<td id="cart_td" colspan="3"><a
					href="deletefromcart?id=<%=cart.getCart_id()%>&uid=<%=user.getUser_id()%>"><input
						type="button" value="Delete from cart" id="del"></a></td>
			</tr>
		</table>
		<%
		subtotal = subtotal + (cart.getFprice() * cart.getFquantity());
		umail = cart.getUmail();
		}
		if (subtotal > 0) {
		%>
		<div style="position: fixed; bottom: 0;background-color:#9fdedf; width: 100%; height: 140px;">
			<h2 style="margin-left: 100px; ">
				Your subtotal is <b style="color: #0b7196;"><%=subtotal%></b>
			</h2>
			<a href="ordernow?umail=<%=umail%>"><input id="ordersubmit" type="submit" value="Order now" style="margin-left: 100px; width: 150px; height: 40px;"></a>
		</div>
		<%
		}
		}
		%>
	</div>

	<%
	if (dbCarts.isEmpty()) {
	%>
	<div style="text-align: center;">
		<img src="https://golden4tic.com/front/assets/img/empty-cart.png"
			style="height: 500px; width: 500px; margin-top: 80px;">
	</div>
	<%
	}
	%>

</body>
</html>