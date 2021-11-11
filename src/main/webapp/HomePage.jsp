<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FlyAway</title>
</head>
<body >
<h1><center>FLYAWAY</center></h1>

</style>
<div align="right">
<a href="AdminPage.jsp">Admin Login</a>
</div>

<%
	@SuppressWarnings("unchecked")
	HashMap<String,String> user=(HashMap<String,String>)session.getAttribute("user");
	if(user!=null){
%>
<p>Welcome <%=user.get("name") %></p>
<a href="Logout">Logout</a>
<%
	}else{
%>
<!-- UPDATE YOGESH -->
<a href=login.jsp>User Login</a>
<%
	}
%>
<br><br>
<center>
<div style="border:5px solid black;width:25%;border-radius:20px;padding:20px" align="center">
<form action="<%=request.getContextPath()%>/searchFlights" method=post>
	<label for=fSrc>From :-</label> <select name="fSrc" id="source">
    <option value="New Delhi">New Delhi</option>
    <option value="New York">New York</option>
    <option value="Berlin">Berlin</option>
    <option value="Hyderabd">Hyderabad</option>
  </select><br><br>
	<label for=fDest>To :-</label>  <select name="fDest" id="destination">
    <option value="New Delhi">New Delhi</option>
    <option value="New York">New York</option>
    <option value="Berlin">Berlin</option>
    <option value="Hyderabd">Hyderabad</option>
  </select><br><br>
 <label for="fDate">Date:</label>
  <input type="date" id="fDate" name="fDate"><br><br>
  	<label for=travellers>Travellers :-</label> <input type=number name=travellers id=travellers/><br><br>
	<input type=submit value=Search /> <input type=reset />
</form>
</div>
</center>
</body>
</html>