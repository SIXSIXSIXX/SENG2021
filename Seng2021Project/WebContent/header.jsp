<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
	<meta name="description" content="Scarica gratis il nostro Template HTML/CSS GARAGE. Se avete bisogno di un design per il vostro sito web GARAGE può fare per voi. Web Domus Italia">
	<meta name="author" content="Web Domus Italia">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="source/bootstrap-3.3.6-dist/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="source/font-awesome-4.5.0/css/font-awesome.css">
	<link rel="stylesheet" type="text/css" href="style/hf.css">
</head>
<body>
<!-- Header -->
<div class="allcontain">

	<div class="header">
	<% 
	String username ="";
    if(request.getSession(false) != null){
    	username = (String)request.getSession(false).getAttribute("username");
    }
    				
	if(username == null){
		request.getSession().setAttribute("username", "");
		username="";
	}
	//System.out.println("username: "+username);
	if(username.equals("")){ %>
			<ul class="logreg">
				<li><a href="login.jsp" target="_parent">Login </a></li>
				<li><a href="register.jsp" target="_parent"><span class="register">Register</span></a></li>
			</ul>
	<%}
	else{%>	
			<ul class="logreg">
				<li><a><%=username%></a></li>
				<li><a href="Control?logout=1" ><span class="register">log out</span></a></li>
			</ul>
			<%} %>
	</div>

	<!-- Navbar Up -->
	<nav class="topnavbar navbar-default topnav">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed toggle-costume" data-toggle="collapse" data-target="#upmenu" aria-expanded="false">
					<span class="sr-only"> Toggle navigaion</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
			</div>	 
		</div>
        <a class="navbar-brand logo" href="#"><img src="image/logo1.png" alt="logo"></a>
		<div class="collapse navbar-collapse" id="upmenu">
			<ul class="nav navbar-nav" id="navbarontop">
				<li><a href="search.jsp" target="_parent">HOME</a></li>
				<li><a href="searchResult.jsp" target="_parent">SEARCH RESULT</a></li>
				<li><a href="recommendation.jsp" target="_parent">RECOMMENDATION</a></li>
				<li><a href="recommendationResult.jsp" target="_parent">RECOMMENDATION RESULT</a></li>
				<li><a href="comparisonList.jsp"  target="_parent">COMPARISON LIST</a></li>
				<li><a href="bookingManagement.jsp"  target="_parent">BOOKING LIST</a></li>
			</ul>
		</div>
	</nav>
</div>

<script type="text/javascript" src="source/bootstrap-3.3.6-dist/js/jquery.js"></script>
<script type="text/javascript" src="source/js/isotope.js"></script>
<script type="text/javascript" src="source/js/myscript.js"></script> 
<script type="text/javascript" src="source/bootstrap-3.3.6-dist/js/jquery.1.11.js"></script>
<script type="text/javascript" src="source/bootstrap-3.3.6-dist/js/bootstrap.js"></script>
</body>
</html>