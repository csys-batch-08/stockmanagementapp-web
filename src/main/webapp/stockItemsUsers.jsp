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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"
></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"
	></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<style>
body {
	background: linear-gradient(lightblue, lightgreen);
}

.h1 {
	position: absolute;
	left: 10px;
	top: 100px;
	width: 100%
}

ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
	margin-top: -10px;
}

.ones {
	margin-left: 50px;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover:not(.active) {
	background-color: #111;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 20px;
}

.search {
	margin-top: 100px;
	margin-left: 480px;
}

table {
	width: 80%;
	margin-left: 100px;
	margin-top: 100px;
}
</style>
<body>


	<div class="h1">

		<h1>STOCK INVENTORY MANAGEMENT</h1>

	</div>
	<br>
	<ul>
		<li><a href="stockItemsUser">Stock Item</a></li>
		<li><a href="usercart"> My Cart</a></li>
		<li><a href="userview">My Profile</a></li>
		<li style="float: right;"><a href="index.jsp">Logout</a></li>
		<li style="float: right;"><a href="walletRecharge.jsp">Wallet</a></li>
		<li><a href="userpurchaselist">My Order List</a></li>
		<li><a href="userinvoice"> Invoice </a></li>
		<li><a href="#help">Help</a></li>

	</ul>
	<div class="search">
		<form action="searchitem" method="post" class="ones">
			<br> <input type="text" name="proname" id="proname"
				placeholder="search Product">

			<button type="submit">search</button>
		</form>
	</div>


	<br>
	<table>
	<caption></caption>
		<tr>

			<th scope="col">Product Id</th>
			<th scope="col">Product Name</th>
			<th scope="col">Product Quantity</th>
			<th scope="col">Price</th>
			<th scope="col">Choice</th>
		</tr>



		<c:forEach items="${products}" var="product">

			<tbody>
				<tr>

					<td>${product.productId}</td>
					<td>${product.productName}</td>
					<td>${product.quantity}</td>
					<td>${product.unitPrice}</td>

					<td><a href="product?pname=${product.productName}">

							<button type="button" class="btn btn-primary">select</button>
					</a></td>
				</tr>
		</c:forEach>
	</table>
</body>
</html>