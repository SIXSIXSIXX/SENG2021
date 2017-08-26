<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="userInfo" scope="session"  class="Bean.UserBean"></jsp:useBean>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="source/bootstrap-3.3.6-dist/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="source/font-awesome-4.5.0/css/font-awesome.css">
	<link rel="stylesheet" type="text/css" href="style/bookingManagement.css">
</head>
</head>
<body>
<div id="header">
	    <iframe src="header.jsp" height="200px" width="1366px" frameborder="0"></iframe>
</div>
<div class="plz">
	<%
	if(!userInfo.getType().equals("Public")&&!userInfo.getType().equals("Dealer")){
	%><h1>Please Log in to see the list</h1>
	<%
	}
	if(userInfo!=null&&userInfo.getType().equals("Public")){
	%>
	<%@include file="clientBookingList.jsp"%>
	<%}%>
	<%	
	if(userInfo!=null&&userInfo.getType().equals("Dealer")){
	%>
	<%@include file="dealerBookingList.jsp"%>
	<%}%>
</div>
<div class="footer">
    <div class="design">Designed by Kingsford Red Team</div>
</div>
</body>
</html>