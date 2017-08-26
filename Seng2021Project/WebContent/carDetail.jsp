<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,dataBase.Makes,searchResult.SearchResult, dataBase.Model"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="source/bootstrap-3.3.6-dist/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="source/font-awesome-4.5.0/css/font-awesome.css">
	<link rel="stylesheet" type="text/css" href="style/carDetail.css">
    <style>
   #myDiv{ width:1366px; height:720px; border:0px; margin:30px auto;overflow:hidden;}
	#myDiv img{ width:1366px; height:720px;}
	
	#number_ul{ width:260px; height:30px; border:#000 0px solid;}
	#number_ul li{ width:30px; height:30px; border:0px; list-style:none; float:left; margin-left:10px; line-height:30px; text-align:center; border-radius:30px; cursor:pointer; background:#000; color:#191919;}
	</style>
    <script src="source/js/jquery-1.8.3.js"></script>
    <script>
	$(function(){
		var index=0; //下标
		var isStop=false; //标识是否继续执行定时函数
		$("#number_ul li").mouseover(function(){
			index=$(this).index();  //获取悬浮li的下标
			  $("#number_ul li").eq(index).css({background:'#191919',color:'#FFF'}).siblings().css({background:'#FFF',color:'#191919'});
			//图片的显示与隐藏
			$("#myDiv img").eq(index).fadeIn("slow").stop(true,true).siblings().fadeOut();
			isStop=true;
		   }).mouseout(function(){
			//$(this).css("background","white");
			  isStop=false;
		  });
		//定时函数 
		$("#number_ul li").eq(0).css({background:'#191919',color:'#FFF'}).siblings().css({background:'#FFF',color:'#191919'});
		$("#myDiv img").eq(0).fadeIn("slow").stop(true,true).siblings().fadeOut("slow");
		index=1; 
		setInterval(function(){
			  if(isStop)return; //停止
			  if(index==$("#number_ul li").size()){
				  index=0;  //重置为0
			  }
			  $("#number_ul li").eq(index).css({background:'#191919',color:'#FFF'}).siblings().css({background:'#FFF',color:'#191919'});
			  $("#myDiv img").eq(index).fadeIn("slow").stop(true,true).siblings().fadeOut("slow");
			  index++;
			},5000);
		});
</script>
</head>

<%
	String id = "";
	if(request.getParameter("id")!=null){
		id = request.getParameter("id");
		request.getSession().setAttribute("id", id);
	}
	Model model = Makes.getModel(Integer.parseInt((String)request.getSession().getAttribute("id")));
%>

<body>
<%request.getSession().setAttribute("prevpage", "carDetail.jsp"); %>
<div id="header">
    <iframe src="header.jsp" height="200px" width="1366px" frameborder="0"></iframe>
</div>
<div class="txt">
	<h1>Car Detail</h1>
</div>

<div id="myDiv">
      
        <img  src="image/car1.jpg"/>
    	<img  src="image/car2.jpg"/>
   	 	<img  src="image/car3.jpg"/>
    	<img  src="image/car4.jpg"/>
   	 	<img  src="image/car5.jpg"/>
</div>
<div class="num">
      <ul id="number_ul">
        <li>1</li>
        <li>2</li>
        <li>3</li>
        <li>4</li>
        <li>5</li>
      </ul>
</div>
<div class="tb">
		<table class="table-fill" cellspacing="0" align="center">
		<tr>
			<td class="grey">Mode name</td>
			<td class="info"><%=model.getModelName() == null ? "" : model.getModelName()%></td>
            <td class="grey">Make</td>
			<td class="info"><%=model.getMake()== null ? "" : model.getMake()%></td>
		</tr>
		<tr>
			<td class="grey">Body type</td>
			<td class="info"><%=model.getBodyType() == null ? "" : model.getBodyType()%></td>
            <td class="grey">Driven Wheels</td>
			<td class="info"><%=model.getDrivenWheels()== null ? "" : model.getDrivenWheels()%></td>
		</tr>
		<tr>
			
			<td class="grey">Number of doors</td>
			<td class="info"><%=model.getNumDoors() == 0 ? "" : model.getNumDoors()%></td>
            <td class="grey">Engine name</td>
			<td class="info"><%=model.geteName()== null ? "" : model.geteName()%></td>
		</tr>
		<tr>
			<td class="grey">Engine type</td>
			<td class="info"><%=model.geteType() == null ? "" : model.geteType()%></td>
            <td class="grey">Displacement</td>
			<td class="info"><%=model.getDisplacement() == 0 ? "" : model.getDisplacement()%></td>
		</tr>
		<tr>
			<td class="grey">Horse power</td>
			<td class="info"><%=model.gethPower() == 0 ? "" : model.gethPower()%></td>
            <td class="grey">Torque</td>
			<td class="info"><%=model.getTorque() == 0 ? "" : model.getTorque()%></td>
		</tr>
		<tr>
			<td class="grey">Base price</td>
			<td colspan="3" class="info"><%=model.getPrice() == 0 ? "" : model.getPrice()%></td>
		</tr>
	</table>
</div>
<div class="page">
	<form action="Control">
	<input type='hidden' name='pick' value="<%=model.getStyleId()%>" class="btn" style="margin-left:460px;">
	<input type='submit' name='Compare' value='Add To Compare' class="btn" style="margin-left:460px;">
	<button class="btn" name="booking" value="<%=model.getStyleId()+" "+model.getModelName()%>" style="margin-left:50px;">Booking a Test Drive</button>
	</form>
</div>
<div class="footer">
    <div class="design">Designed by Kingsford Red Team</div>
</div>
</body>
</html>