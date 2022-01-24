<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.sql.ResultSet"
 import ="com.stock.impl.*" import = "javax.servlet.http.HttpSession" %>   
 
    <%
    String pName=request.getParameter("pname");

    %>
    <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>product Details</title>

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
.mov{
	margin-top:40px
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
<form action="purchase" method="post">
<div class="#">
	<%int user_id=Integer.parseInt(session.getAttribute("user id").toString());
    String productName=session.getAttribute("productName").toString();
	CartImpl cimpl=new CartImpl();
    ResultSet rs=  cimpl.allcart(user_id);
	if(rs.next()) { %>
            <center class="mov">
          
            <label>Product Id :</label> <input type="text" name="prodid" value="<%=rs.getInt(3)%>" ><br>
            
            <label>user Id :</label> <b><%=rs.getInt(2)%></b> <br>
            <label>Product Name :</label><%=productName%><br>
			<lable>Product Quantity :</lable><%=rs.getInt(4)%><br>
			<lable>total Price :</lable><%=rs.getDouble(5)%><br>
			<% session.setAttribute("product id",rs.getInt(3) );
			session.setAttribute("price",rs.getDouble(5));
			session.setAttribute("productname",productName );
			session.setAttribute("quantity", rs.getInt(4));
			
			
			
			
			%>
			
       <%} %> 
       
      
       

       
    <button type="submit" class="btn btn-primary">confirm</button>
       
      <a href="cart.jsp" ><button type="button" class="btn btn-dark">Cancel</button></a>
       
       
       </center>
       
       
       
       
       
        <% String lowbal=(String)session.getAttribute("low bal"); 

if(lowbal !=null){
	%>
	<h3><%= session.getAttribute("low bal") %></h3>
<% }
session.removeAttribute("low bal") ;
%>
       
       </div>
       </form>


</body>
</html>