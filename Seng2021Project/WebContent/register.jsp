<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="source/bootstrap-3.3.6-dist/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="source/font-awesome-4.5.0/css/font-awesome.css">
	<link rel="stylesheet" href="style/register.css">
</head>
<body>
<div id="header">
<iframe src="header.jsp" height="200px" width="1366px" frameborder="0" scrolling="no"></iframe>
</div>
    
<div class="log">
<img src="image/oldcar.jpg" width=1366px>
    <div class="box">
        <form action ='Control' method ="get">
        	<dl class="dl">
            <dd>Username: </dd>
            <dd>1</dd>
            <dd><div class="input1">
                <input type="text" name ="username" placeholder="Username">
            </div></dd>
            </dl>
            <dl class="dl">
            <dd>Password:  </dd>
            <dd>1</dd>
            <dd><div class="input1">
                <input type="password"  name="password" placeholder="Password">
            </div></dd>
            </dl>
            <dl class="dl">
            <dd>Confirm Password:  </dd>
            <dd>1</dd>
            <dd><div class="input1">
                <input type="password"  name="password" placeholder="Confirm Password">
            </div></dd>
            </dl>
            <dl class="dl">
            <dd>Address:  </dd>
            <dd>1</dd>
            <dd><div class="input1">
                <input type="text" name ="address" placeholder="Address">
            </div></dd>
            </dl>
            <dl class="dl">
            <dd>Phone No: </dd> 
            <dd>1</dd>
            <dd><div class="input1">
                <input type="text" name ="phone" placeholder="Phone No">
            </div></dd>
            </dl>
            <dl class="dl"><button class="btn" name="confirm" type="submit">Register</button></dl>
        </form>
    </div>
</div>

<div class="footer">
    <div class="design">Designed by Kingsford Red Team</div>
</div>
<script src="source/js/index1.js"></script>
</body>
</html>