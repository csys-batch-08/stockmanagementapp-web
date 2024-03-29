<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="java.sql.ResultSet" import="com.stock.impl.*"
	import="javax.servlet.http.HttpSession"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Stock item</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
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

table {
	width: 80%;
	margin-left: 100px;
}

table, th, td {
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

	<form action="cart" method="post">
		<table>
		<caption></caption>
			<tr>

				<th scope="col">Product Id</th>
				<th scope="col">Product Name</th>
				<th scope="col">Product Quantity</th>
				<th scope="col">Price</th>

			</tr>

			<c:forEach items="${productdetails}" var="products">

				<tbody>
					<tr>

						<td>${products.productId}</td>
						<td>${products.productName}</td>
						<td>${products.quantity}</td>
						<td>${products.unitPrice}</td>

						<c:set var="productid" value="${products.productId}"
							scope="session" />
						<c:set var="productname" value="${products.productName}"
							scope="session" />
						<c:set var="proqty" value="${products.quantity}" scope="session" />
						<c:set var="unitprice" value="${products.unitPrice}"
							scope="session" />


					</tr>
			</c:forEach>
		</table>

		How much do you want to buy <input type="number" name="quantity"
			id="quantity" list="quantity" autofocus required
			placeholder="enter quantity" min="1"> Expected no of days <input
			type="Date" name="date" id="datefield" list="date" autofocus required
			placeholder="expected no of days">
		<button type="submit">submit</button>

	</form>



</body>
<script type="text/javascript">
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth() + 1;
	var yyyy = today.getFullYear();
	if (dd < 10) {
		dd = '0' + dd
	}
	if (mm < 10) {
		mm = '0' + mm
	}

	today = yyyy + '-' + mm + '-' + dd;
	document.getElementById("datefield").setAttribute("min", today);
</script>
</html>
