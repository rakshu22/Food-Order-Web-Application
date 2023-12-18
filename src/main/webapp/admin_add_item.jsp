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
<title>Yummy - Add Item</title>
</head>
<body>
	
	<%@include file="$policy_header.jsp" %>

	<form action="additem" id="adminadditemform" method="post" enctype="multipart/form-data">
		<div id="title_cancel">
			<h1>Add Item</h1>
			<a href="viewmenu"
				style="color: black; font-size: 40px; font-weight: 100;">&times;</a>
		</div>
		<br> <br>
		<table>
			<tr>
				<td>Image</td>
				<td><input type="file" name="image" required></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" required></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input type="number" step="0.01" name="price" required></td>
			</tr>
		</table>
		<br>
		<div style="text-indent: 30px;">
			<input id="loginsubmit" type="submit" value="Add +"
				style="background-color: green; width: 85%;">
		</div>

	</form>
</body>
</html>