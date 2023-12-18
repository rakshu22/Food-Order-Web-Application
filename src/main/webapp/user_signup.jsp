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
<title>Yummy - User Signup</title>
</head>
<body>
	<%@include file="$policy_header.jsp"%>
	
	<%String message = (String) request.getAttribute("message");%>
	<%if (message != null) {%>
		<div id="red_msg">
			<p><%=message%></p>
		</div>
	<%} %>
	
	<form action="signup" id="signupform" method="post">
		<div id="title_cancel">
			<h1>Sign Up</h1>
			<a href="index.jsp"
				style="color: black; font-size: 40px; font-weight: 100;">&times;</a>
		</div>
		<br> <br>
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
				<td>Password</td>
				<td><input type="password" name="password" required></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input type="tel" name="phone" required pattern="[6789][0-9]{9}" title="Please enter a valid phone number"></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><textarea name="address" cols="26" rows="3" required></textarea></td>
			</tr>
		</table>

		<div style="text-indent: 30px; font-size: small;">
			<p>
				<input id="checkbox" type="checkbox" required> I
				agree to Yummy's <a href="tnc.jsp" target="_blank"
					style="color: red;">T&Cs</a>, <a href="privacy_policy.jsp"
					target="_blank" style="color: red;">Privacy</a> and <a
					href="cookie_policy.jsp" target="_blank" style="color: red;">Cookie</a>
				Policies
			</p>
			<br> <input id="signupsubmit" type="submit"
				value="Create account"
				style="background-color: green; margin-left: 30px; width: 85%;">
			<p>
				Already have an account? <a href="user_login.jsp"
					style="color: blue;">Login</a>
			</p>
		</div>

	</form>
</body>
</html>