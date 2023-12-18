<%@page import="food_order_webapp.dto.Feedback"%>
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
<title>Yummy - Admin Feed</title>
</head>
<body>
<%List<Feedback> list=(List)request.getAttribute("feedbacks"); %>
	<header style="position: fixed; top: 0;">
	<%@include file="$admin_header2.jsp"%>
	</header>

	<div style="margin-top: 120px;">
		<table style="width: 90%;">
			<tr>
				<td style="width: 900px;"><h1>Feedbacks</h1></td>
			</tr>
		</table>
		
		<table style="width: 90%; text-align: center; margin-bottom: 100px;" id="menu_table">
			<tr style="height: 50px;">
				<th id="menu_th">Id</th>
				<th id="menu_th">Name</th>
				<th id="menu_th">Email</th>
				<th id="menu_th">Phone</th>
				<th id="menu_th">Feedback</th>
			</tr>
			<%for(Feedback feedback: list){ %>
			<tr style="height: 100px;">
				<td id="menu_td"><%=feedback.getFeed_id() %></td>
				<td id="menu_td"><%=feedback.getName() %></td>
				<td id="menu_td"><%=feedback.getEmail() %></td>
				<td id="menu_td"><%=feedback.getPhone() %></td>
				<td id="menu_td" style="width: 200px;"><%=feedback.getFeedback() %></td>
			</tr>
			<%} %>
		</table>
	</div>
</body>
</html>