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
input[readonly]
{
background-color: #E5E5E5;
border: 1px solid;
text-indent: 10px;
}
input[required]
{
text-indent: 10px;
}
</style>
<title>Yummy - Edit Profile</title>
</head>
<body>
<%User user=(User)request.getAttribute("user"); %>

<%@include file="$policy_header.jsp" %>

<%String message = (String) request.getAttribute("message");%>
	<%if (message != null) {%>
		<div id="red_msg">
			<p><%=message%></p>
		</div>
	<%} %>

<form action="updateprofile" id="userprofile" method="post">
        <div id="title_cancel">
            <h1>Edit Profile</h1>
            <a href="viewprofile?id=<%=user.getUser_id()%>" style="color: black; font-size: 40px; font-weight: 100;">&times;</a>
        </div>
        <br>
        <br>
        <table>
            <tr>
				<td>Id</td>
				<td><input value="<%=user.getUser_id() %>" type="number" name="id" readonly></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input value="<%=user.getName() %>" type="text" name="name" required></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input value="<%=user.getEmail() %>" type="email" name="email" required></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input value="<%=user.getPassword() %>" type="text" name="password" required></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input value="<%=user.getPhone() %>" type="tel" name="phone" required></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input value="<%=user.getAddress() %>" type="text" name="address" required></td>
			</tr>
        </table>
        <br>
        <div style="text-indent: 30px;">
            <input id="loginsubmit" type="submit" value="Update profile" style="background-color: green; width: 85%; ">
        </div>
        
    </form>
</body>
</html>