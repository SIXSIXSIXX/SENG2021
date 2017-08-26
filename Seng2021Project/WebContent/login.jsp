<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="source/bootstrap-3.3.6-dist/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="source/font-awesome-4.5.0/css/font-awesome.css">
    <link rel="stylesheet" type="text/css" href="style/login.css">
    <script src="http://s.codepen.io/assets/libs/modernizr.js" type="text/javascript"></script>
    <link rel="stylesheet" href="style/reset.css">
    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css'>
    <link rel="stylesheet" href="style/login.css">
</head>
<body>
<div id="header">
<iframe src="header.jsp" height="200px" width="1366px" frameborder="0" scrolling="no">
</iframe></div>

<div class="log">
   <img src="image/oldcar.jpg" width=1366px>
    <div class="box">
        <form action ='Control' method ="get">
            <div class="input1">
                <input type="text" name ="username" placeholder="Username">
            </div>
            <div class="input1">
                <input type="password"  name="password" placeholder="Password">
            </div>
            <button class="submit" name="login" type="submit">Login</button>
        </form>
    </div>
</div>

<div class="footer">
    <div class="design">Designed by Kingsford Red Team</div>
</div>
<script src="source/js/index1.js"></script>
</body>
</html>