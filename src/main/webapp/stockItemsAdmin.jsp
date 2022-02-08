<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Stock item</title>
<style>
body {
	margin: 0;
	font-family: Arial;
	background: linear-gradient(to right, #8e9eab, #eef2f3);
}

.topnav {
	overflow: hidden;
	background-color: #333;
	margin-top: -150px;
}

.topnav a {
	float: left;
	display: block;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

.active {
	background-color: #04AA6D;
	color: white;
}

.topnav .icon {
	display: none;
}

.dropdown {
	float: left;
	overflow: hidden;
}

.dropdown .dropbtn {
	font-size: 17px;
	border: none;
	outline: none;
	color: white;
	padding: 14px 16px;
	background-color: inherit;
	font-family: inherit;
	margin: 0;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	float: none;
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	text-align: left;
}

.topnav a:hover, .dropdown:hover .dropbtn {
	background-color: #555;
	color: white;
}

.dropdown-content a:hover {
	background-color: #ddd;
	color: black;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.topnav a.icon {
	float: right;
	display: block;
}

.h1 {
	background-color: #7c9ce5;
	margin-top: 100px;
}

table {border=1 style="width: 80%; margin-left: 100px;
}
</style>
</head>
<body>


	<div class="h1">
		<h1>STOCK INVENTORY MANAGEMENT</h1>
	</div>
	<div class="topnav" id="myTopnav">
		<a href="stockItemsadmin">Stock</a> <a href="adminuserview">UserDetails</a>
		<a href="invoiceview">Invoice</a> <a href="index.jsp"
			style="float: right">Logout</a> <a href="Admincart">Cart</a>
		<div class="dropdown">
			<button class="dropbtn">
				StockItem Add <em class="fa fa-caret-down"></em>
			</button>
			<div class="dropdown-content">
				<a href="addItem.jsp">Add New Product</a>

			</div>
		</div>
		<a href="admin" style="float: right">Order Delivery Date</a> <a
			href="Allpurchaselist">PurchaseList</a>

	</div>
	<div class="container">
		<table>
		<caption></caption>
			<tr>

				<th scope="col">Product Id</th>
				<th scope="col">Product Name</th>
				<th scope="col">Product Quantity</th>
				<th scope="col">Price</th>
				<th>Update Quantity</th>
				<th>Remove Product</th>
			</tr>





			<c:forEach items="${products}" var="product">

				<tbody>
					<tr>

						<td>${product.productId}</td>
						<td>${product.productName}</td>
						<td>${product.quantity}</td>
						<td>${product.unitPrice}</td>


						<td><a href="updateitem?name=${product.productName}"><button
									type="button" class="btn btn-primary">Update Quantity</button></a></td>

						<td><a href="deleteproduct?proid=${product.productId}"><button
									type="button" class="btn btn-dark">Delete Product</button></a></td>


					</tr>
			</c:forEach>
			</tbody>


		</table>

	</div>
</body>
</html>