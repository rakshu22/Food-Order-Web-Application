<%@page import="food_order_webapp.dto.UserOrderItems"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
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
<title>Yummy - Orders List</title>
<style type="text/css">
table{
	border: 1px solid black;
	border-collapse: collapse;
	width: 90%;
}
th{
border: 1px;
border-style: solid;
background-color: #dddddd;
width: 100px;
}
td{
border: 1px;
border-style: solid;
}
tr{
height: 35px;
}
</style>
</head>
<body>

<%List<UserOrder> dbOrders=(List) request.getAttribute("user orders");%>

	<header style="position: fixed; top: 0;">
		<%@include file="$admin_header2.jsp"%>
		<%
		String message = (String) request.getAttribute("message");
		%>
		<%
		if (message != null) {
		%>
		<div id="green_msg">
			<p><%=message%></p>
		</div>
		<%
		}
		%>
	</header>

	<div style="margin-top: 140px; width: 100%">
		<h1 style="margin-left: 50px;">Orders</h1>
		
	<%for (UserOrder order : dbOrders) {
		LocalDateTime date = order.getDatetime();  
	    DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm");  
	    String dbDate = date.format(dateformat); 
	%>
	<table style="text-indent: 20px; margin-left: 50px;">
	<tr>
	<th>Order Id</th>
	<td id="ordertd">#<%=order.getOrder_id() %></td>
	</tr>
	<tr>
	<th>Ordered On</th>
	<td id="ordertd"><%=dbDate %></td>
	</tr>
	<tr>
	<th>Customer</th>
	<td id="ordertd"><%=order.getUname() %></td>
	</tr>
	<tr>
	<th>Address</th>
	<td id="ordertd"><%=order.getUaddress() %></td>
	</tr>
	<tr>
	<th>Phone</th>
	<td id="ordertd"><%=order.getUphone() %></td>
	</tr>
	<tr>
	<th>Products</th>
	<td id="ordertd">
	<table style="width: 100%; text-align: center;">
	<%
	List<UserOrderItems> uiItems= order.getUserOrderItems();
	%>
	<tr>
	<th>Product</th>
	<th>Price</th>
	<th>Quantity</th>
	<th>Subtotal</th>
	</tr>
	<%for(UserOrderItems items: uiItems){ %>
	<tr style="text-align: center;">
	<td><%=items.getFname() %></td>
	<td>Rs <%=items.getFprice() %></td>
	<td>x<%=items.getFquantity() %></td>
	<td>Rs <%=items.getSubtotal() %></td>
	</tr>
	<%} %>
	</table>
	</td>
	</tr>
	<tr>
	<th>Total Bill</th>
	<td id="ordertd">Rs <%=order.getTotalbill() %></td>
	</tr>
	<tr>
	<th>Payment Mode</th>
	<td id="ordertd"><%=order.getPayment_mode() %></td>
	</tr>
	<tr>
	<th>Payment Status</th>
	<td id="ordertd"><%=order.getPayment_status() %></td>
	</tr>
	<tr>
	<th>Order Status</th>
	<td id="ordertd"><%=order.getOrder_status() %></td>
	</tr>
	<tr>
	<td id="ordertd" colspan="2" style="text-align: center;background-color: #0E0E0E;font-size: 18px;"><a href="editstatus?orderid=<%=order.getOrder_id()%>" >Edit Status</a></td>
	</tr>
	</table>
	<br><br><br>
	<hr style="border-style:dashed;">
	<br><br><br>
	<%} %>	
</body>
</html>