<!-- Register Page -->
<%@page pageEncoding="UTF-8"%>
<%@page import="org.nlavee.skidmore.webapps.web.VarNames"%>
<%@page import="org.json.JSONObject"%>
<%@page import="java.util.Date" %>
<%@page import="java.text.*" %>
<%@page import="org.nlavee.skidmore.webapps.database.beans.Message" %>

<%
	String remoteAdd = (String) request.getSession().getAttribute(
			VarNames.REMOTE_ADDRESS);
	String userID = request.getSession()
			.getAttribute(VarNames.USER_PARAM_FIELD_NAME).toString();
	String weatherDesc = (request.getAttribute("weather_description")
			.toString().toUpperCase());
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd     HH:mm:ss");
	Date date = new Date();
	String temp = request.getAttribute("temp").toString();
	String humidity = request.getAttribute("humidity").toString();
	String wind = request.getAttribute("wind").toString();
	String place = request.getAttribute("place").toString();
	Message m = (Message) request.getAttribute("message");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
	crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="staticFiles/css/main.css">
<meta http-equiv="refresh" content="5" />
<title>MagMirr Client</title>
</head>

<body>

	<div class="row">
		<div class="col-md-6">
			<p style="color: white">
				Mirror for
				<%=userID%></p>
		</div>
		<div class="col-md-6">
			<p>Magic Mirror 2016 &#169;</p>
		</div>
	</div>
	<div class="row">
		<h1><%=dateFormat.format(date)%></h1>
	</div>
	<div class="row">
		<div class="col-md-4">
			<h3>
				Weather @ <%=place%>:
			</h3>
		</div>
		<div class="col-md-8">
			<h3>Current Top News for Selected Topics:</h3>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4">
				<%=weatherDesc%>&nbsp;
				<%
				if (weatherDesc.equals("clear sky")) {
				%>
				<img src="staticFiles/icons/summer-inverted.png" />
				<%
					} else {
				%>
				<img src="staticFiles/icons/summer-inverted.png" />
				<%
					}
				%>
				<h4><%=temp%>&deg;</h4>
				<h4><%=humidity%>&#37; (Humidity <img src="staticFiles/icons/humidity.png"/>)</h4>
				<h4><%=wind%> (Wind <img src="staticFiles/icons/wind.png"/>)</h4>
		</div>
		<div class="col-md-8">
			
		</div>
	</div>
	<div class="row">
		<%
		if(m != null)
		{
			%>
			<h2>Your Message:</h2>
			<h3>&ldquo;<%=m.getBody()%>&rdquo;</h3>
			<%
		}
		%>
	</div>
	<h3></h3>

	<p style="color: white">Weather icons designed by Freepik</p>
</body>
</html>