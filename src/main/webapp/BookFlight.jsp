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
<br>
<a href=HomePage.jsp style="color:black;text-decoration:none ;font-size:35px;font-weight:bold;">FlyAway</a>
<br><br>

<%
	@SuppressWarnings("unchecked")
	HashMap<String,String> user=(HashMap<String,String>)session.getAttribute("username");
	/*  if(user==null){
		response.sendRedirect("UserPage.jsp");
	}  */
%>

<br><br>
<center>
<div style="border:5px solid black;width:25%;border-radius:20px;padding:20px" align="center">
<form action="<%=request.getContextPath()%>/bookFlights" method=post>
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
	<label for=departure>Departure :-</label> <input type=date name=departure id=departure/><br><br>
  	<label for=travellers>Travellers :-</label> <input type=number name=travellers id=travellers/><br><br>
	<input type=submit value=Book /> <input type=reset />
</form>
</div>
</center>

<p align="center"  style="color:green;font-size:40px;font-weight:bold">Flight Booked Successfully</p>
</body>
</html>
