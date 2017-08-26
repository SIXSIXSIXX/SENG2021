<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.SimpleDateFormat, java.text.DateFormat"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="source/bootstrap-3.3.6-dist/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="source/font-awesome-4.5.0/css/font-awesome.css">
	<link href="style/myStyle.css" rel="stylesheet" />
	<link rel="stylesheet" href="style/bookingDetail.css">
</head>
<body>
<% 
DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
Date date = new Date();
String startTime = dateFormat.format(date).replace(" ", "T");
%>
<div id="header">
    <iframe src="header.jsp" height="200px" width="1366px" frameborder="0"></iframe>
</div>
<div class="txt">
	<h1>Booking test drive for: <%=request.getSession(false).getAttribute("modelName")%></h1>
</div>
<div class="book">
	<form action ='Control' method ="get">
		<dl class="dl">
            <dd>Name: </dd>
            <dd>1</dd>
            <dd><div class="input1">
                <input type="text" name ="Name" placeholder="Name">
            </div></dd>
        </dl>
        <dl class="dl">
            <dd>Booking Date: </dd>
            <dd>1</dd>
            <dd><div class="input1">
                <input name="dt" type="datetime-local" min="<%=startTime%>" max="2020-01-01T01:01"/>
            </div></dd>
        </dl>
        <dl class="dl"><button class="btn" name="confirmBooking" type="submit">Confirm</button></dl>
    </form>
</div>
<div class="footer">
    <div class="design">Designed by Kingsford Red Team</div>
</div>
</body>
</html>