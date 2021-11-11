<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
</head>
<body >
<br>
<a href=HomePage.jsp style="color:black;text-decoration:none ;font-size:35px;font-weight:bold;">FlyAway</a>
<br><br>
<center>
<h1>Insert New Flight Details</h1>

<div style="border:3px solid black;width:25%;border-radius:20px;padding:20px" align="center">
<form action="<%=request.getContextPath()%>/adminHome"  method=post>
	<label for=fName>Name :-</label> <input type="text" name=fName id=name /><br><br>
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
	<label for=fPrice>Price :-</label> <input type="text" name=fPrice id=price /><br><br>
	<input type=submit value=submit /> <input type=reset />
</form>
</div>
</center>
<%
	String message=(String)session.getAttribute("message");
	if(message!=null){
%>
<p style="color:silver;"><%=message %></p>
<%
		session.setAttribute("message", null);
	}
%>
</body>
</html>