<%@page import="food_order_webapp.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Yummy - Edit Delivery Details</title>
</head>
<body>
<%User user=(User)request.getAttribute("user"); %>
<%@include file="$policy_header.jsp"%>

<form action="updateaddress&phone" id="adph_form" method="get">
		<div id="title_cancel">
			<h1>Edit Delivery Info</h1>
			<a href="ordernow?umail=<%=user.getEmail()%>"
				style="color: black; font-size: 40px; font-weight: 100;">&times;</a>
		</div>
		<br> <br>
		<input type="hidden"  name="userid" value="<%=user.getUser_id()%>">
		<table>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address" required="required" value="<%=user.getAddress()%>"></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input type="tel" name="phone" required="required" value="<%=user.getPhone()%>"></td>
			</tr>
		</table>
		<br>
		<div style="text-indent: 30px;">
			<input id="loginsubmit" type="submit" value="Update"
				style="background-color: green; width: 85%;">
		</div>

	</form>

</form>
</body>
</html>