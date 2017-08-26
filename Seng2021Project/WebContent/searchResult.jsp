<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,dataBase.Makes,searchResult.SearchResult, dataBase.Model, api.PhotoApi,org.json.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="source/bootstrap-3.3.6-dist/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="source/font-awesome-4.5.0/css/font-awesome.css">
	<link rel="stylesheet" type="text/css" href="style/result.css">
</head>
<body>
<%request.getSession().setAttribute("prevpage", "searchResult.jsp"); %>
<div id="header">
    <iframe src="header.jsp" height="200px" width="1366px" frameborder="0"></iframe>
</div>

<div class="txt">
	<h1>Search Result for: //add content here</h1>
</div>
<form action=Control method="get">
<div class="result">
		<ul>
        	<li style="font-size:27px">&nbsp;&nbsp;&nbsp;</li>
			<li style="font-size:27px">Photo</li>
			<li style="font-size:27px">Model</li>
			<li style="font-size:27px">Transmission</li>
			<li style="font-size:27px">Body Type</li>
            <li style="font-size:27px">Price</li>
			<li style="font-size:27px">Booking a Test Drive</li>
		</ul>
        
        <%
		for (Model model : SearchResult.getData()) {
			String photo = PhotoApi.getPhotoFromFile(String.valueOf(model.getStyleId()));
		%>
		
        <ul>
        	<li><input type="checkbox" name="pick" value="<%=model.getStyleId()%>" style="width:25px;height:25px;"></li>
        	<%if(!photo.equals("")){%>
			<li><a href="carDetail.jsp?id=<%=model.getStyleId()%>" style="color:#fff"><img SRC="<%=photo%>" width="215" height="147"></a></li>
			<%}%>
			<%if(photo.equals("")){ %>
			<li><a href="carDetail.jsp?id=<%=model.getStyleId()%>" style="color:#fff">Photo</a></li>
			<%}%>
			<li><%=model.getModelName()%></li>
			<li><%=model.getTransmissionType()%></li>
			<li><%=model.getBodyType()%></li>
            <li><%=model.getPrice()%></li>
			<li id="book"><button class="mybtn" name="booking" value="<%=model.getStyleId()+" "+model.getModelName()%>">Booking</button></li>
			
		</ul>
  <%
  	}
	%>
    </div>
    <%
int hiddenFlag = -1;
if(request.getAttribute("hiddenFlag")!=null)
	hiddenFlag = (Integer) request.getAttribute("hiddenFlag");
String pFlag = "visible";
String nFlag = "visible";
 if(hiddenFlag==1){
	 pFlag = "hidden";
 	
 }

 if(hiddenFlag==2){

 nFlag = "hidden";
 
	
 }
 

 
 if(hiddenFlag==3){
 
	 pFlag = "hidden";
	 nFlag = "hidden";
 	
 }%>
 
<div class="page">
    
        <button class="btn" name="addToCompare" type="submit" style="visibility:visible;margin-right:1040px">Add to<br>Compare</button>
        <button class="btn" name="prev" type="submit" style="visibility:${pFlag}">Prev</button>
        <button class="btn" name="next" type="submit" style="visibility:${nFlag}">Next </button>	
</div>
</form>
<div class="footer">
    <div class="design">Designed by Kingsford Red Team</div>
</div>

</body>
</html>