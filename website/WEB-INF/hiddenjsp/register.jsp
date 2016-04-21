<!-- Register Page -->
<%@page pageEncoding="UTF-8" %>
<%@page import="org.nlavee.skidmore.webapps.web.VarNames"%>

<%
	String remoteAdd = (String) request.getSession().getAttribute(VarNames.REMOTE_ADDRESS);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet" type="text/css" href="staticFiles/css/base.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://code.getmdl.io/1.1.3/material.indigo-pink.min.css">
<script defer src="https://code.getmdl.io/1.1.3/material.min.js"></script>
<meta http-equiv="refresh" content="2"/>
<link href='https://fonts.googleapis.com/css?family=VT323' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="staticFiles/css/main.css">
<title>MagMirr Client</title>
</head>

<body>
<h1>It seems like we are unable to associate this mirror with an existing account.</h1>
<h4>Please go to <a href="/MagMirror">localhost:8080/MagMirror</a> and login with your username and password to add the following IP address to the account's associated mirror.</h4>
<h4>IP Address: <%=remoteAdd%></h4>
<!-- MDL Spinner Component -->
<br>
<div class="mdl-spinner mdl-js-spinner is-active"></div>
<p>WAITING FOR REGISTRATION</p>
</body>
</html>