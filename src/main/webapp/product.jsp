<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.sql.ResultSet"
 import ="com.stock.impl.*" import = "javax.servlet.http.HttpSession" %>   
 
    <%
    String pName=request.getParameter("pname");
    StockImpl stock=new StockImpl();
    
 ResultSet rs=stock.validateProduct(pName);   
 %>
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
	<%if(rs.next()) { %>
            
            <label>Product Id :</label> <b><%=rs.getInt(1)%></b> <br>
            <label>Product Name :</label><%=rs.getString(2)%><br>
			<lable>Product Quantity :</lable><%=rs.getInt(3)%><br>
			<lable>Product Price :</lable><%=rs.getDouble(4)%><br>
			
			
			<% session.setAttribute("product id",rs.getInt(1) );
			session.setAttribute("price",rs.getDouble(4));
			session.setAttribute("productName", rs.getString(2));
			
			session.setAttribute("currentqty", rs.getInt(3));
			%>
      <%} %>  
      
      
      
      
       <br><br><br>
      <div class="one">
       
       <lable>How much do you want to buy :</lable><br>
       <input type="number" name="quantity" id="quantity" list ="quantity" autofocus required placeholder="enter quantity" min="1" ><br>
        <lable>Expected no of days :</lable><br>
       <input type="number" name="date" id="date"  list ="date" autofocus required placeholder="expected no of days" min="1" ><br><br>
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
</html>
