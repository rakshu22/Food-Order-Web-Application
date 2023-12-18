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
<title>Yummy - Admin Home</title>
</head>
<body>
<%String email=(String)request.getAttribute("email"); %>
	<%@include file="$admin_header.jsp"%>

	<div>
		<h1 style="text-align: center;">Welcome Admin!</h1>
		
		<div id="admin_opt">
			<img src="https://cdn-icons-png.flaticon.com/512/4201/4201057.png"
				alt="pic1" style="height: 200px; width: 200px;"> <br> <a
				href="viewmenu"><button id="admin_opt1">Modify
					Menu</button></a>
		</div>
		<div id="admin_opt">
			<img
				src="https://play-lh.googleusercontent.com/QSVQEebMXXK09ASTbxd0lEiUxXJMaO7nQrzJpbySJyFDGJiRTpGHmPQQVNoO7TDTl6NO"
				alt="pic2" style="height: 150px; width: 150px;"> <br> <a
				href="vieworder"><button id="admin_opt1">View
					Orders</button></a>
		</div>
		<div id="admin_opt">
			<img
				src="https://cdn0.iconfinder.com/data/icons/business-and-finance-54/100/2-512.png"
				alt="pic3" style="height: 150px; width: 150px;"> <br> <a
				href="viewfeed"><button id="admin_opt1">View
					Feedbacks</button></a>
		</div>
	</div>
</body>
</html>