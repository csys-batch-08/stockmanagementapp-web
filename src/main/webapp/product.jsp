<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
     <%@ page import="java.sql.ResultSet"
 import ="com.stock.impl.*" import = "javax.servlet.http.HttpSession" %>   
 
  <%--   <%
    String pName=request.getParameter("pname");
    StockImpl stock=new StockImpl();
    
 ResultSet rs=stock.validateProduct(pName);   
 %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>product Details</title>
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
        <li><a class="active" href="stockItemsusers.jsp">Stock Item</a></li>
        <li><a class="active" href="usercart.jsp"> My Cart</a></li>
     
         <li><a class="active" href="userview.jsp">My Profile</a></li>
        
      
         <li style="float: right;"><a class="active" href="index.jsp">Logout</a></li>
        <li style="float: right;"><a class="active" href="walletrecharge.jsp">Wallet</a></li>
        <li><a  class="active" href = "userpurchaselist.jsp">My order List</a></li>
           <li> <a  class="active"href = "userinvoice.jsp">  Invoice </a></li>
             <li><a class="active" href="#help">Help</a></li>
        <br><br>
      </ul>  
<form action="cart" method="post">
<table style="width: 80%; margin-left: 100px;">
		<tr>

			<th scope="col">ProductId</th>
			<th scope="col">ProductName</th>
			<th scope="col">ProductQuantity</th>
			<th scope="col">Price</th>
			
		</tr>


	<c:forEach items ="${productdetails}" var="products">
            
          
         
        <tbody>
          <tr>
            
            <td>${products.productId} </td>
            <td>${products.productName}</td>
            <td>${products.quantity}</td>
            <td>${products.unitPrice}</td>
     
		 <c:set var="productid" value="${products.productId}" scope="session" />
         <c:set var="productname" value="${products.productName}" scope="session" />
         <c:set var="proqty" value="${products.quantity}" scope="session" />
         <c:set var="unitprice" value="${products.unitPrice}" scope="session" />
         
      
      
      </c:forEach>
      
       <br><br><br>
      <div class="one">
       
       <lable>How much do you want to buy :</lable><br>
       <input type="number" name="quantity" id="quantity" list ="quantity" autofocus required placeholder="enter quantity" min="1" ><br>
        <lable>Expected no of days :</lable><br>
       <input type="Date" name="date" id="datefield"  list ="date" autofocus required placeholder="expected no of days"  ><br><br>
             <button type="submit" >submit</button>
      </div>
      
      
        <% String qtyerror=(String)session.getAttribute("qtyerror"); 

if(qtyerror !=null){
	%>
	<h3><%= session.getAttribute("qtyerror") %></h3>
<% }
session.removeAttribute("qtyerror") ;
%>
      
      
      
      
      
      
      
      
      
      
       </form>
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
