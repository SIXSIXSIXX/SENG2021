<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,dataBase.Makes,searchResult.SearchResult, dataBase.Model, booking.Request"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="description" content="Scarica gratis il nostro Template HTML/CSS GARAGE. Se avete bisogno di un design per il vostro sito web GARAGE può fare per voi. Web Domus Italia">
	<meta name="author" content="Web Domus Italia">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="source/bootstrap-3.3.6-dist/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="source/font-awesome-4.5.0/css/font-awesome.css">
    <link rel="stylesheet" type="text/css" href="style/addAvailableCar.css">
    <script src="source/js/jquery-1.8.3.js"></script>
<script>

	$(function(){
		var i = 1;
		$("#addTr").click(function(){
			$("table").append("<tr><td><select class='form-control' name='makeList"+i+"' id='makeList"+i+"' onchange='callAJAX("+i+")' style='height:40px;font-size:23px;'><option value='' selected='selected'>MAKE</option><% for (String make : Makes.getMakeNameList()) { %><option value='<%=make%>'><%=make%></option><% }%></select></td><td><select class='form-control' name='select-two"+i+"' id='select-two"+i+"'  style='height:40px;font-size:23px;'></select></td><td><input type='button' class='btn1' value='Delete'/></td></tr>");
			i++;
	   });
		$("input[value='Delete']").live("click",function(){
			$(this).parent().parent().remove();
		});
		});
		
		function callAJAX(i){
			var e=i;
			$.ajax({
				url: "GetModelList",//servlet URL that gets first option as parameter and returns JSON of to-be-populated options
				type: "GET",//request type, can be GET
				cache: false,//do not cache returned data
				
				data: {make:$('#makeList'+e+' option:selected').val()},//data to be sent to the server
				success: function(response){ 
					
					var myNode = document.getElementById("select-two"+e);
					while (myNode.firstChild) {
						myNode.removeChild(myNode.firstChild);
					}
					var array = response.split(',');
					var select = document.getElementById("select-two"+e); 
					for (var i in array) {
						var opt = array[i];
						var el = document.createElement("option");
						el.textContent = opt;
						el.value = opt;
						select.appendChild(el);
					}
				},
				error: function(e){  
					//handle error
				} 
			});
		}
</script>
</head>
<body>


<div id="header">
    <iframe src="header.jsp" height="200px" width="1366px" frameborder="0"></iframe>
</div>
<div class="txt">
	<h1>Add Available Car</h1>
</div>
<div class="book">
	<form action ='Control' method ="get">
    <table width="1000" cellpadding="0" cellspacing="0">
    			<tr>
				<td><select class="form-control" name="makeList" id="makeList0" onchange="callAJAX('0')" style="height:40px;font-size:23px;">
				<option value="" selected="selected">MAKE</option>
			<%
				for (String make : Makes.getMakeNameList()) {
			%>	
				<option value="<%=make%>"><%=make%></option>

			<%
				}
			%>		
				</select>	</td>	
				<td><select class="form-control" name="select-two" id="select-two0"  style="height:40px;font-size:23px;"></select></td>
                <td></td>
                </tr>
                </table>
            <input type="button" class="btn" id="addTr" value="Add More"/>
          	<button class="btn" name="addCar" type="submit">Confirm</button>
    </form>
    
</div>
<div class="footer">
    <div class="design">Designed by Kingsford Red Team</div>
</div>
	   

</body>
</html>