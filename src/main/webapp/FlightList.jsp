<%@page import="com.yogesh.flyaway.model.FlightDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.util.*" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight List</title>
</head>
<body >
<br>
<a href=HomePage.jsp style="color:black;text-decoration:none;font-size:35px;font-weight:bold;">FlyAway</a>
<br><br>
<%
	@SuppressWarnings("unchecked")
List<FlightDetails> flights=(List<FlightDetails>)session.getAttribute("flights");
	if(flights!=null){
%>

<h1>Available Flights</h1>

<center>
<table border="1">
<tr>
	<th>From</th>
	<th>To</th>
	<th>Date</th>
</tr>



<%
	for(FlightDetails flight:flights){
%>

<tr>
<td><%=flight.getfSrc()%></td>
<td><%=flight.getfDest()%></td>
<td><%=flight.getfDate()%></td>
</tr>
</table>
</center>
<center><a href=BookFlight.jsp>Book Now</a> </center>
<%
	}
%>


<%
	}
	else{
%>
<h1>There are no available flights</h1>
<%
	}
%>
</body>
</html>