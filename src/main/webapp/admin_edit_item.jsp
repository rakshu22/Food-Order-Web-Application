<%@page import="food_order_webapp.dto.AdminMenu"%>
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
<title>Yummy - Edit Item</title>
</head>
<body>
	<%AdminMenu dbItem= (AdminMenu)request.getAttribute("item"); %>
	
	<%@include file="$policy_header.jsp" %>

	<form action="updateitem" id="adminedititemform" method="post" enctype="multipart/form-data">
        <div id="title_cancel">
            <h1>Edit Item</h1>
            <a href="viewmenu" style="color: black; font-size: 40px; font-weight: 100;">&times;</a>
        </div>
        <br>
        <br>
        <table>
            <tr>
                <td>Id</td>
                <td><input type="number" name="id" readonly="readonly" value=<%=dbItem.getItem_id() %> ></td>
            </tr>
            <tr>
                <td>Image</td>
                <td><input type="file" name="image" required="required" value=<%=dbItem.getImage() %> ></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" required="required" value=<%=dbItem.getName() %> ></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><input type="number" step="0.01" name="price" required="required" value=<%=dbItem.getPrice() %> ></td>
            </tr>
        </table>
        <br>
        <div style="text-indent: 30px;">
            <input id="loginsubmit" type="submit" value="Update" style="background-color: #0488b9; width: 85%; ">
        </div>
        
    </form>
</body>
</html>