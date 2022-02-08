
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Forget Password</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"
></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"
	></script>
<style>
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
	margin-top: -16px;
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

.active {
	background-color: #04AA6D;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 20px;
}

body {
	background: linear-gradient(lightblue, lightgreen);
}

.pass {
	margin-top: 100px;
	margin-left: 600px;
}
</style>
</head>
<body>


	<div class="h1">
		<h1>
			STOCK INVENTORY MANAGEMENT
		</h1>
	</div>
	<br>
	<ul>
		<li style="float: right;"><a href="index.jsp">Login</a></li>
		<li style="float: right;"><a href="register.jsp">Register</a></li>
</ul>

	<div class="pass">
		<form action="forgetpassword" method="get">
			Enter new password<br> <input type="text" name="pass" id="pass"
				placeholder="Enter your new password" required><br>
			Enter your mobileNumber<br> <input type="number" name="mobnum"
				id="mobnum" placeholder="Enter your mobile number" required><br>
			<br>

			<button type="submit">change password</button>

		</form>
	</div>
</body>
</html>