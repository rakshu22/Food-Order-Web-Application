<%@page import="food_order_webapp.dto.AdminMenu"%>
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
<style type="text/css">
#opt_menu {
	font-weight: bold;
	color: #0488b9;
}
</style>
<title>Yummy - Menu</title>
</head>
<body>
	<%int uid = (Integer) request.getAttribute("userid");%>
	<%List<AdminMenu> list = (List) request.getAttribute("listofitems");%>

	<header style="position: fixed; top: 0;">
		<img src="images/yummy.png" alt="logo" id="logo">

		<div class="dropdown" style="float: right;">
			<a class="dropbtn" href="#"><i class="fas fa-user-circle"
				style="margin-top: 50px;"></i></a>
			<div class="dropdown-content">
				<a href="viewprofile?id=<%=uid%>">View Profile</a> 
				<a href="index.jsp">Logout</a>
			</div>
		</div>

		<a href="uservieworder?id=<%=uid %>" id="opt_order">ORDERS</a> 
		<a href="viewcart?id=<%=uid %>" id="opt_cart">CART</a>
		<a href="#menu" id="opt_menu">MENU</a> 
		<a href="userhome?id=<%=uid %>" id="opt_home">HOME</a>
	</header>
	
	<div style="margin-top: 150px;">
	<%for(AdminMenu menu:list){ %>
<table id="usermenu_table">
        <tr>
            <td colspan="2" style="height: 200px; width: 200px;"><img src="getimage?id=<%=menu.getItem_id() %>" width="100%" height="100%"></td>
        </tr>
        <tr>
            <td><%=menu.getName() %></td>
            <td>Rs <%=menu.getPrice() %></td>
        </tr>
        <tr>
            <td colspan="2"><a href="addtocart?id=<%=menu.getItem_id() %>&uid=<%=uid%>"><input id="usermenu_input" type="submit" value="Add to cart"></a></td>
        </tr>
 </table>
 <%} %>
	</div>
	

</body>
</html>