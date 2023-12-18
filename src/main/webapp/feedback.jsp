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
<title>Yummy - Feedback</title>
</head>
<body>

	<%@include file="$policy_header.jsp"%>
	
	<%String message = (String) request.getAttribute("message");%>
	<%if (message != null) {%>
		<div id="green_msg">
			<p><%=message%></p>
		</div>
	<%} %>
		
		<form action="feedback" id="feedform" method="post">
		<h1>Feedback</h1>
		<br>
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" required></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="email" name="email" required></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input type="tel" name="phone" required pattern="[6789][0-9]{9}" title="Please enter a valid phone number"></td>
			</tr>
			<tr>
				<td>Feedback</td>
				<td><textarea name="feedback" cols="26" rows="3" required></textarea></td>
			</tr>
		</table>
		<br> <input id="feedsubmit" type="submit" value="Submit feedback">
	</form>
	
	
</body>
</html>