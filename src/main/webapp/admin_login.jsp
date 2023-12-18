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
<title>Yummy - Admin Login</title>
</head>
<body>

	<%@include file="$policy_header.jsp"%>
	
	<%String message = (String) request.getAttribute("message");%>
	<%if (message != null) {%>
		<div id="red_msg">
			<p><%=message%></p>
		</div>
	<%} %>
	
	<form action="adminlogin" id="adminloginform" method="post">
		<div id="title_cancel">
			<h1>Admin Login</h1>
			<a href="index.jsp"
				style="color: black; font-size: 40px; font-weight: 100;">&times;</a>
		</div>
		<br> <br>
		<table>
			<tr>
				<td>Email</td>
				<td><input type="email" name="email" required></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" required></td>
			</tr>
			<tr>
				<td>Security Code</td>
				<td><input type="password" name="code" required></td>
			</tr>
		</table>
		<br>
		<div style="text-indent: 30px;">
			<input id="loginsubmit" type="submit" value="Login"
				style="background-color: green; width: 85%;">
		</div>

	</form>

</body>
</html>