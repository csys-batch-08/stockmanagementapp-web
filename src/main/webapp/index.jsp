<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login page</title>
  <style>
		.con1 {
			position: absolute;
			left: 500px;
			top: 100px;
			background-color: antiquewhite;
			padding: 40px;
		}

		body {
		background-image: url("https://media.gettyimages.com/photos/forklift-driver-in-warehouse-picture-id513380898?k=20&m=513380898&s=612x612&w=0&h=t0QGiHyqw_6ktkiiRQwOFfmiINLPY9NHxlwLnZHKUuQ=");
    background-repeat: no-repeat;
    background-size: cover;

		}

		button {
			padding: 8px;
			background-color:burlywood;
			border-radius: 4PX;
		}
	</style>
</head>

<body>
  <div class="con1">

    <h1>Login</h1>
    <form action="login" method="post">
      <label for="">Email </label><br>
      <input type="text" name="email" placeholder="Enter your email" required><br><br>
      <label for="">Password </label><br>
      <input type="password" name="password" placeholder="Enter your password" required><br><br>
      <button type="submit">Submit</button><br>
      <a href="forgetPassword.jsp">Forgot Password</a><br>
      <a href="register.jsp">Register</a>

</form>

     </div>
</body>

</html>