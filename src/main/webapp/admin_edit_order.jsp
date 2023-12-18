<%@page import="food_order_webapp.dto.UserOrder"%>
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
<title>Yummy - Edit Order Status</title>
</head>
<body>
<%List<UserOrder> dbOrder = (List) request.getAttribute("orderlist");%>
	<%@include file="$policy_header.jsp"%>

	<form action="updatestatus" id="admineditorder">
		<div id="title_cancel">
			<h1>Edit Order Status</h1>
			<a href="vieworder"
				style="color: black; font-size: 40px; font-weight: 100;">&times;</a>
		</div>
		<br> <br>
		<table>
		<%for (UserOrder order : dbOrder) {%>
			<tr>
				<td>Order Id</td>
				<td><input type="number" name="order_id" readonly value="<%=order.getOrder_id()%>"></td>
			</tr>
			<tr>
				<td>Payment Mode</td>
				<td><input type="text" name="pay_mode" readonly value="<%=order.getPayment_mode()%>"></td>
			</tr>
			<tr>
				<td>Payment Status</td>
				<td><input type="text" name="pay_status" required value="<%=order.getPayment_status()%>"></td>
			</tr>
			<tr>
				<td>Order Status</td>
				<td><input type="text" name="order_status" required value="<%=order.getOrder_status() %>"></td>
			</tr>
			<%} %>
		</table>
		<br>
		<div style="text-indent: 30px;">
			<input id="loginsubmit" type="submit" value="Update"
				style="background-color: #0488b9; width: 85%;">
		</div>

	</form>
</body>
</html>