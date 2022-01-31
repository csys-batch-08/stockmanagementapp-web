   
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ page import="java.sql.ResultSet"
 import ="com.stock.impl.*" %>   
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Stock item</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <style>
    .h1{
        background-color: red;
        position: absolute; left: 10px;top: 10px;
        width: 100%;
    }
    ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
  margin-top: 70px;
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
table,th,td{
border:1px solid black;
border-collapse:collapse;
padding:20px;
}
body
{
 background:linear-gradient(lightblue,lightgreen);
}
</style>
</head>
<body>

    
    <div class="h1">
        <center><h1>STOCK INVENTORY MANAGEMENT</h1></center>
    </div>
    <br>
  <ul>
        <li><a class="active" href="stockItemsUser">Stock Item</a></li>
        <li><a class="active" href="usercart"> My Cart</a></li>
     
         <li><a class="active" href="userview">My Profile</a></li>
        
      
         <li style="float: right;"><a class="active" href="index.jsp">Logout</a></li>
        <li style="float: right;"><a class="active" href="walletrecharge.jsp">Wallet</a></li>
        <li><a  class="active" href = "userpurchaselist">My order List</a></li>
           <li> <a  class="active"href = "userinvoice">  Invoice </a></li>
             <li><a class="active" href="#help">Help</a></li>
        <br><br>
      </ul>
       <table style="width:80%;margin-left:100px;">
          <tr>
.            
             <th scope="col">OrderId</th>
            <th scope="col">ProductId</th>
            <th scope="col">UserId</th>
             <th scope="col">ProductName</th>
            <th scope="col">ProductQuantity</th>
            <th scope="col">TotalPrice</th>
            <th scope="col">Status</th>
            <th scope="col">Date</th>
           
          </tr>
       
       
          <c:forEach items="${userpurchase}" var="userpurchase"> 
       
       
          <tr>
            
            <td>${userpurchase.cartId}</td>
            <td>${userpurchase.productId}</td>
            <td>${userpurchase.userId}</td>
             <td>${userpurchase.productName}</td>
            <td>${userpurchase.orderQty}</td>
            <td>${userpurchase.totalPrice}</td>
     	    <td>${userpurchase.status}</td>
     	    <td>${userpurchase.orderDate}</td>
           		
      
          </tr>
      </c:forEach>    
     
      </table>
</body>
</html>