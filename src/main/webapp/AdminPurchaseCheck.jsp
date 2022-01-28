   
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
  <style>
body {
      margin: 0;
      font-family: Arial;
      background:linear-gradient( to right,#8e9eab,#eef2f3);

    }

    .topnav {
      overflow: hidden;
      background-color: #333;
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

    .topnav a:hover,
    .dropdown:hover .dropbtn {
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
    .h1
    {
    background-color:red;
    }
    table{
    margin-top:100px;
    margin-left:100px;}
</style>
</head>
<body>

    
    <div class="h1">
        <center><h1 >STOCK INVENTORY MANAGEMENT</h1></center>
    </div>
   
     <div class="topnav" id="myTopnav">
   <a href="stockItemsadmin.jsp" >Stock</a>
   
    <a href="invoice.jsp" >Invoice</a>
   
     <a href="index.jsp" style=float:right>Logout</a>
    <a href="Admincart.jsp">Cart</a>
      <div class="dropdown">
      <button class="dropbtn" >StockItem Add
        <i class="fa fa-caret-down"></i>
      </button>
      <div class="dropdown-content">
        <a href="Additems.jsp">Add New Product</a>
       
      </div>
    </div>
    <a href = "AdminPurchaseCheck.jsp" style=float:right >Order Delivery Date</a>
    <a href="purchaseList.jsp">PurchaseList</a>
  
    </div>

   
   <%-- 
      <%
      PuruchaseImpl pimpl=new  PuruchaseImpl();
      ResultSet rs=  pimpl.showPurchase();
          //(ResultSet)session.getAttribute("showProduct");
      %>
    <br>
    --%>  <table border=1; style="width:90%;margin-left:100px; border-collapse:collapse ">
          <tr>
            
            <th scope="col">OrderId</th>
            <th scope="col">ProductId</th>
            <th scope="col">UserId</th>
             <th scope="col">ProductName</th>
            <th scope="col">ProductQuantity</th>
            <th scope="col">TotalPrice</th>
            <th scope="col">Status</th>
            <th scope="col">Date</th>
              <th scope="col">Delivery</th>
            
          </tr>
       
       
        
          <c:forEach items="${purchase}" var="purchaselist"> 
       
       
          <tr>
            
            <td>${purchaselist.cartId}</td>
            <td>${purchaselist.productId}</td>
            <td>${purchaselist.userId}</td>
             <td>${purchaselist.productName}</td>
            <td>${purchaselist.orderQty}</td>
            <td>${purchaselist.totalPrice}</td>
     	    <td>${purchaselist.status}</td>
     	    <td>${purchaselist.orderDate}</td>
           		
         <td>     
              <form action="invoice">
        <input type="Date" name="deliveryDate" id="datefield"  list ="date" autofocus required placeholder="delivery no of days"  ><br><br>
              <button type="submit">Submit</button>
              
              </form></td>
              <c:set var="orderid" value="${purchaselist.cartId}" scope="session" />
              <c:set var="userid" value="${purchaselist.userId}" scope="session" />
      
          </tr>
      </c:forEach>        
              
             
       
      </table>
</body>
<script type="text/javascript">
var today = new Date();
var dd = today.getDate();
var mm = today.getMonth()+1; 
var yyyy = today.getFullYear();
if(dd<10){
  dd='0'+dd
} 
if(mm<10){
  mm='0'+mm
} 

today = yyyy+'-'+mm+'-'+dd;
document.getElementById("datefield").setAttribute("min", today);
</script>

</html>