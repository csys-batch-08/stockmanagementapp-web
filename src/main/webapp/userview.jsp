   
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
     <%@ page import="java.sql.ResultSet"
 import ="com.stock.impl.*" import = "javax.servlet.http.HttpSession" %>   
 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>users Details</title>
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
body
{
 background:linear-gradient(lightblue,lightgreen);
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
.one
{
margin-left:500px;
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
         <table border=1; style="width:90%;margin-left:100px; border-collapse:collapse ">
           <tr>
            
            <th scope="col">UserId</th>
            <th scope="col">UserName</th>
            <th scope="col">Email</th>
             <th scope="col">Address</th>
            <th scope="col">Password</th>
            <th scope="col">PhoneNumber</th>
            <th scope="col">WalletAmount</th>
  
            
            
          </tr>
       
       
      <c:forEach items="${userDetail}" var="userDetailsView"> 
       
       
          <tr>
            
            <td>${userDetailsView.userId}</td>
            <td>${userDetailsView.userName}</td>
            <td>${userDetailsView.email}</td>
             <td>${userDetailsView.address}</td>
            <td>${userDetailsView.password}</td>
            <td>${userDetailsView.phoneNumber}</td>
     	    <td>${userDetailsView.wallet}</td>
     	    
           		
      
          </tr>
      </c:forEach>    
      </table>
</body>
</html>