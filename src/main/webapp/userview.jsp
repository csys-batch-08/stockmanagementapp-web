   
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
            <%
      int userid = (int) session.getAttribute("user id");
  	UserImpl ui = new UserImpl();
  	ResultSet rs = ui.userview(userid);

      
         %>
    <br>
     <table border=1; style="width:90%;margin-left:100px; border-collapse:collapse ">
           <tr>
            
            <th scope="col">UserId</th>
            <th scope="col">UserName</th>
            <th scope="col">Email</th>
             <th scope="col">Address</th>
            <th scope="col">Password</th>
            <th scope="col">PhoneNumber</th>
            
            <th scope="col">UserType</th>
            <th scope="col">WalletAmount</th>
            
          </tr>
       
       
       
         <% while(rs.next())
        { 
       
        %>
          <tr>
            
            <td><%=rs.getInt(1)%></td>
            <a><td><%=rs.getString(2)%></td>
            <td><%=rs.getString(3)%></td>
             <td><%=rs.getString(4) %></td>
              <td><%=rs.getString(5)%></td>
            <td><%=rs.getLong(6)%></td>
                <td><%=rs.getString(7)%></td>
             <td><%=rs.getDouble(8)%></td>
            
            
              
              
              
           		
      
          </tr>
           <%} %>
     
      </table>
</body>
</html>