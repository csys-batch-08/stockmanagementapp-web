<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

.content {
	margin-top: 150px;
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
</head>
<body>
	<div class="content">

		<form action="wallet" method="get">
			Current wallet amount ${walletamount}<br>
			<br> EnterRecharge amount<br> <input type="number"
				name="amount" id="number" list="amount" autofocus required
				placeholder="enter amount" min="0"><br>
			<br> Enter your password<br> <input type="password"
				name="password" id="password"><br>
			<br>

			<button type="submit" class="btn btn-success">WalletRecharge</button>


		</form>
		<br>
		<br> <a href="stockItemsUsers.jsp"><button
				class="btn btn-info">Cancel</button></a>
	</div>


</body>
</html>