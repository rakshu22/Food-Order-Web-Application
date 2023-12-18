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
<title>Yummy - Menu</title>
</head>
<body>

	<header style="position: fixed; top: 0;">
	<%@include file="$admin_header2.jsp"%>
	</header>
	
	
	
	<%List<AdminMenu> list=(List)request.getAttribute("listofitems"); %>
	
	<div style="position: fixed; top:100px; background-color: white; width: 100%; height: 100px;">
		<table style="width: 90%; ">
			<tr>
				<td style="width: 900px;"><h1>Menu</h1></td>
				<td style="text-align: right;"><a href="admin_add_item.jsp"><button
							id="admin_add_opt">Add Item</button></a></td>
			</tr>
		</table>
	</div>
	<div>
		<table style="width: 90%; text-align: center; margin-top:250px; margin-bottom: 100px;" id="menu_table">
			<tr style="height: 30px;">
			<td colspan="6">
			<%String message = (String) request.getAttribute("message");%>
	        <%if (message != null) {%>
		    <div id="green_msg">
			<p><%=message%></p>
		    </div>
	        <%} %>
			</td>
			</tr>
			
			<tr style="height: 50px;">
				<th id="menu_th">Item Id</th>
				<th id="menu_th">Image</th>
				<th id="menu_th">Name</th>
				<th id="menu_th">Price</th>
				<th id="menu_th">Edit</th>
				<th id="menu_th">Delete</th>
			</tr>
			
			<%if(list!=null){ %>
			<%for(AdminMenu menu:list){ %>
			<tr style="height: 100px;">
				<td id="menu_td"><%=menu.getItem_id() %></td>
				<td id="menu_td"><img src="getimage?id=<%=menu.getItem_id() %>" width="100%" height="100%"></td>
				<td id="menu_td"><%=menu.getName() %></td>
				<td id="menu_td">Rs <%=menu.getPrice() %></td>
				<td id="menu_td"><a href="edititem?id=<%=menu.getItem_id() %>"><button
							id="admin_edit_opt" style="width: 80px;">Edit</button></a></td>
				<td id="menu_td"><a href="deleteitem?id=<%=menu.getItem_id() %>"><button id="admin_delete_opt"
							style="width: 80px;">Delete</button></a></td>
			</tr>
			<%}} %>
		</table>
	</div>
</body>
</html>