
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
table{width: 80%; margin-left: 100px;}

table, th, td {
	margin-top: 200px;
	border: 1px solid black;
	border-collapse: collapse;
	padding: 20px;
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

	<table>
	<caption></caption>
		<tr>

			<th scope="col">Cart Id</th>
			<th scope="col">User Id</th>
			<th scope="col">Product Id</th>
			<th scope="col">Product Quantity</th>
			<th scope="col">Total Price</th>
			<th scope="col">Date</th>

			<th>Purchase</th>
		</tr>
		<c:forEach items="${usercartview}" var="userview">

			<fmt:parseDate pattern="yyyy-MM-dd" value="${userview.expectedDate}"
				var="parsedExpectedDate" />

			<tr>

				<td>${userview.cartId}</td>
				<td>${userview.userId}</td>
				<td>${userview.productId}</td>
				<td>${userview.qunatity}</td>
				<td>${userview.totalPrice}</td>
				<td><fmt:formatDate pattern="dd-MM-yyyy"
						value="${parsedExpectedDate}" /></td>

				<td><a href="purchase1?cartid=${userview.cartId}"><button
							type="button" class="btn btn-primary">Buy</button></a></td>


				<c:set var="cartid" value="${userview.cartId}" scope="session" />
				<c:set var="userid" value="${userview.userId}" scope="session" />
				<c:set var="proid" value="${userview.productId}" scope="session" />
				<c:set var="proqty" value="${userview.qunatity}" scope="session" />
				<c:set var="price" value="${userview.totalPrice}" scope="session" />
				<c:set var="date" value="${userview.expectedDate}" scope="session" />


			</tr>

		</c:forEach>
	</table>
</body>
</html>