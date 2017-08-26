<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,dataBase.Makes,searchResult.SearchResult, dataBase.Model"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>Scarica gratis GARAGE Template html/css - Web Domus Italia - Web Agency </title>
	<meta name="description" content="Scarica gratis il nostro Template HTML/CSS GARAGE. Se avete bisogno di un design per il vostro sito web GARAGE puÃ² fare per voi. Web Domus Italia">
	<meta name="author" content="Web Domus Italia">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="source/bootstrap-3.3.6-dist/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="source/font-awesome-4.5.0/css/font-awesome.css">
	<link rel="stylesheet" type="text/css" href="style/slider.css">
	<link rel="stylesheet" type="text/css" href="style/comparisonList.css">
</head>
<%
	ArrayList<Model> carsCompare = (ArrayList<Model>)session
	        .getAttribute("carsCompare");
%>
<body>
<%request.getSession().setAttribute("prevpage", "comparisonList.jsp"); %>
<div id="header">
    <iframe src="header.jsp" height="200px" width="1366px" frameborder="0"></iframe>
</div>


<!-- ______________________________________________________List ______________________________-->

<form action="Control" method="get">
<div class="pricing_table_wdg">
		<ul>
			<li>Photo</li>
			<li>Make</li>
			<li>Model</li>
			<li>Transmission</li>
			<li>Body Type</li>
			<li>Driven Wheels</li>
			<li>Displacement</li>
            <li>Horse Power</li>
            <li>Torque</li>
             <li>Price</li>
			<li></li>
		</ul>
	<%
	if(carsCompare!=null){
	for(Model model:carsCompare){
	%>		
		<input type='hidden' name='modelName' value="<%=model.getModelName()%>"/>
        <ul>
			<li>Photo</li>
			<li><%=model.getMake() == null ? "&nbsp;" :model.getMake() %></li>
			<li><%=model.getModelName() == null ? "&nbsp;" : model.getModelName()%></li>
			<li><%=model.getTransmissionType() == null ? "&nbsp;" : model.getTransmissionType() %></li>
			<li><%=model.getBodyType() == null ? "&nbsp;" : model.getBodyType() %></li>
			<li><%=model.getDrivenWheels() == null ? "&nbsp;" : model.getDrivenWheels() %></li>
			<li><%=model.getDisplacement() == 0 ? "&nbsp;" : model.getDisplacement() %></li>
            <li><%=model.gethPower() == 0 ? "&nbsp;" :model.gethPower()%></li>
            <li><%=model.getTorque() == 0 ? "&nbsp;" : model.getTorque()%></li>
            <li><%=model.getPrice() == 0 ? "&nbsp;" : model.getPrice()%></li>
			<li></li>
			<li id="book"><button name="booking"value="<%=model.getStyleId()+" "+model.getModelName()%>">Book a Test Drive</button></li>
            <li class="button" ><button name="removeFromCompare" value="<%=model.getStyleId()%>">Remove from List</button></li>
		</ul>
	<%
	}}
	%>

</div>
</form>
<div class="footer">
    <div class="design">Designed by Kingsford Red Team</div>
</div>

<script type="text/javascript" src="source/bootstrap-3.3.6-dist/js/jquery.js"></script>
<script type="text/javascript" src="source/js/isotope.js"></script>
<script type="text/javascript" src="source/js/myscript.js"></script> 
<script type="text/javascript" src="source/bootstrap-3.3.6-dist/js/jquery.1.11.js"></script>
<script type="text/javascript" src="source/bootstrap-3.3.6-dist/js/bootstrap.js"></script>
</body>
</html>