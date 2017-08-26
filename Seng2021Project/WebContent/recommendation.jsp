<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,dataBase.Makes,searchResult.SearchResult, dataBase.Model"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>Scarica gratis GARAGE Template html/css - Web Domus Italia - Web Agency </title>
	<meta name="description" content="Scarica gratis il nostro Template HTML/CSS GARAGE. Se avete bisogno di un design per il vostro sito web GARAGE pu� fare per voi. Web Domus Italia">
	<meta name="author" content="Web Domus Italia">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="source/bootstrap-3.3.6-dist/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="source/font-awesome-4.5.0/css/font-awesome.css">
	<link rel="stylesheet" type="text/css" href="style/slider.css">
	<link rel="stylesheet" type="text/css" href="style/recommendation.css">
</head>
<body>
<%request.getSession().setAttribute("prevpage", "/recommendation.jsp"); %>
<div id="header">
    <iframe src="header.jsp" height="200px" width="1366px" frameborder="0"></iframe>
</div>

<!--_______________________________________ Carousel__________________________________ -->
<form action ='Control' method ="post">
<div class="allcontain" style="padding-top:0px;">
	<div id="carousel-up" class="carousel slide" data-ride="carousel" style="margin-top:365px;">
		<nav class="navbar navbar-default midle-nav">
			<div class="collapse navbar-collapse" id="navbarmidle" style="padding-left:70px;padding-top:10px;padding-bottom:0px;">
				<div class="searchtxt">
					<h1 style="font-size:35px;">RECOMMENDATION</h1>
                    <h1>RECOMMEND CARS BASED ON YOUR PREFERENCES</h1><br>
                    <h1 style="font-size:25px;">STEP ONE: FILTER (OPTIONAL)</h1><br>
				</div>
                <div>
                <ul id="select" style="padding-left:0px;">
                <li>
                    <select class="form-control" name="transmission" id="publicationtype">
					<option class="firstwhite" value="">TRANSMISSION</option>
                    <option value="AUTOMATIC">AUTO</option>
					<option value="MANUAL">MANUAL</option>
					<option value="AUTOMATED_MANUAL">MANUAL</option>
					</select>
				</li>



              <li>
					<select class="form-control" name="body" id="Bodytype">

					<option value="">BODY TYPE</option>
			<%
				 Makes.getMakeNameList();
				for (String body : Makes.getBodyType()) {
			%>
			
				<option value="<%=body%>"><%=body%></option>

			<%
				}
			%>
					</select>
				</li>




                <li> 
                    <select class="form-control" name="make" id="publicationtype">
					<option  class="firstwhite" value="">MAKE</option>
					<%
						for (String make : Makes.getMakeNameList()) {
					%>	
						<option value="<%=make%>"><%=make%></option>
					<%
						}
					%>		
					</select>
				</li>
				</ul>
                </div>
					<div class="searchtxt" style="margin-top:65px;">
                    <h1 style="font-size:25px;display:inline">STEP TWO: ASSIGN IMPORTANCE IN %</h1>
                    <h1 id="per" style="font-size:25px;margin-left:70px;display:inline">PERCENTAGE LEFT: </h1>
				</div>
          		<ul class="select2" style="padding-left:0px;list-style-type:none">
                <li>
						<input type="text" id="price" class="form-control searchform" name ="price" placeholder="PRICE">
        		</li>
                <li>
						<input type="text" id="fuel" class="form-control searchform" name="fuelEfficient" placeholder="FUEL-EFFICIENT">
				</li>
                <li>
						<input type="text" id="horse" class="form-control searchform" name="horsepower" placeholder="HORSE POWER">
				</li>
                <li>
						<input type="text" id="torque" name="torque" class="form-control searchform" placeholder="TORQUE">
				</li>
					<li class="li-search"> <button  class="searchbutton" name="recommendation"><span id="sbut" class="glyphicon glyphicon-search "></span></button></li>
 				</ul>
			</div>
			<div class="check">&nbsp;
			</div>
		</nav>
	</div>
</div>
</form>

<!-- ________________________LATEST CARS SECTION _______________________-->
<div class="latestcars">
	<h1 class="text-center">&bullet; LATEST   CARS &bullet;</h1>
	<ul class="nav nav-tabs navbar-left latest-navleft">
		<li role="presentation" class="li-sortby"><span class="sortby">SORT BY: </span></li>
		<li data-filter=".RECENT" role="presentation"><a href="#mostrecent" class="prcBtnR">MOST RECENT </a></li>
		<li data-filter=".POPULAR" role="presentation"><a href="#mostpopular" class="prcBtnR">MOST POPULAR </a></li>
		<li  role="presentation"><a href="#" class="alphSort">ALPHABETICAL </a></li>
		<li data-filter=".HPRICE" role="presentation"><a href="#" class="prcBtnH">HIGHEST PRICE </a></li>
		<li data-filter=".LPRICE" role="presentation"><a href="#" class="prcBtnL">LOWEST  PRICE </a></li>
		<li id="hideonmobile">
	</ul>
</div>
<br>
<br>
<!-- ________________________Latest Cars Image Thumbnail________________-->
	<div class="grid">
		<div class="row">
			<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
				<div class="txthover">
					<img src="image/car1.jpg" alt="car1">
						<div class="txtcontent">
							<div class="stars">
								<div class="glyphicon glyphicon-star"></div>
								<div class="glyphicon glyphicon-star"></div>
								<div class="glyphicon glyphicon-star"></div>
							</div>
							<div class="simpletxt">
								<h3 class="name">Rolls Royce</h3>
								<p>"Lorem ipsum dolor sit amet, consectetur,<br>
	 							sed do eiusmod tempor incididunt" </p>
	 							<h4 class="price"> 1000&euro;</h4>
	 							<button>READ MORE</button><br>
	 							<div class="wishtxt">
		 							<p class="paragraph1"> Add to Wishlist <span class="glyphicon glyphicon-heart"></span> </p>
		 							<p class="paragraph2">Compare <span class="icon"><img src="image/compicon.png" alt="compicon"></span></p>
		 						</div>
							</div>
							<div class="stars2">
								<div class="glyphicon glyphicon-star"></div>
								<div class="glyphicon glyphicon-star"></div>
								<div class="glyphicon glyphicon-star"></div>
							</div>
						</div>
				</div>	 
			</div>
			<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3 ">
				<div class="txthover">
					<img src="image/car2.jpg" alt="car2">
						<div class="txtcontent">
							<div class="stars">
								<div class="glyphicon glyphicon-star"></div>
								<div class="glyphicon glyphicon-star"></div>
								<div class="glyphicon glyphicon-star"></div>
							</div>
							<div class="simpletxt">
								<h3 class="name">Renault</h3>
								<p>"Lorem ipsum dolor sit amet, consectetur,<br>
	 							sed do eiusmod tempor incididunt" </p>
	 							<h4 class="price">900 &euro;</h4>
	 							<button>READ MORE</button><br>
	 							<div class="wishtxt">
		 							<p class="paragraph1"> Add to Wishlist <span class="glyphicon glyphicon-heart"></span> </p>
		 							<p class="paragraph2">Compare <span class="icon"><img src="image/compicon.png" alt="compicon"></span></p>
		 						</div>
							</div>
							<div class="stars2">
								<div class="glyphicon glyphicon-star"></div>
								<div class="glyphicon glyphicon-star"></div>
								<div class="glyphicon glyphicon-star"></div>
							</div>
						</div>
				</div>	 
			</div>
			<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
				<div class="txthover">
					<img src="image/car3.jpg" alt="car3">
						<div class="txtcontent">
							<div class="stars">
								<div class="glyphicon glyphicon-star"></div>
								<div class="glyphicon glyphicon-star"></div>
								<div class="glyphicon glyphicon-star"></div>
							</div>
							<div class="simpletxt">
								<h3 class="name">Ford Mustang</h3>
								<p>"Lorem ipsum dolor sit amet, consectetur,<br>
	 							sed do eiusmod tempor incididunt" </p>
	 							<h4 class="price">3000 &euro;</h4>
	 							<button>READ MORE</button><br>
	 							<div class="wishtxt">
		 							<p class="paragraph1"> Add to Wishlist <span class="glyphicon glyphicon-heart"></span> </p>
		 							<p class="paragraph2">Compare <span class="icon"><img src="image/compicon.png" alt="compicon"></span></p>
		 						</div>
							</div>
							<div class="stars2">
								<div class="glyphicon glyphicon-star"></div>
								<div class="glyphicon glyphicon-star"></div>
								<div class="glyphicon glyphicon-star"></div>
							</div>
						</div>
				</div>	 
			</div>
			<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
				<div class="txthover">
					<img src="image/car4.jpg" alt="car4">
						<div class="txtcontent">
							<div class="stars">
								<div class="glyphicon glyphicon-star"></div>
								<div class="glyphicon glyphicon-star"></div>
								<div class="glyphicon glyphicon-star"></div>
							</div>
							<div class="simpletxt">
								<h3 class="name">Rover</h3>
								<p>"Lorem ipsum dolor sit amet, consectetur,<br>
	 							sed do eiusmod tempor incididunt" </p>
	 							<h4 class="price">1000 &euro;</h4>
	 							<button>READ MORE</button><br>
	 							<div class="wishtxt">
		 							<p class="paragraph1"> Add to Wishlist <span class="glyphicon glyphicon-heart"></span> </p>
		 							<p class="paragraph2">Compare <span class="icon"><img src="image/compicon.png" alt="compicon"></span></p>
		 						</div>
							</div>
							<div class="stars2">
								<div class="glyphicon glyphicon-star"></div>
								<div class="glyphicon glyphicon-star"></div>
								<div class="glyphicon glyphicon-star"></div>
							</div>
						</div>
				</div>	 
			</div>
			<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
				<div class="txthover">
					<img src="image/car5.jpg" alt="car5">
						<div class="txtcontent">
							<div class="stars">
								<div class="glyphicon glyphicon-star"></div>
								<div class="glyphicon glyphicon-star"></div>
								<div class="glyphicon glyphicon-star"></div>
							</div>
							<div class="simpletxt">
								<h3 class="name">Porche</h3>
								<p>"Lorem ipsum dolor sit amet, consectetur,<br>
	 							sed do eiusmod tempor incididunt" </p>
	 							<h4 class="price">1200 &euro;</h4>
	 							<button>READ MORE</button><br>
	 							<div class="wishtxt">
		 							<p class="paragraph1"> Add to Wishlist <span class="glyphicon glyphicon-heart"></span> </p>
		 							<p class="paragraph2">Compare <span class="icon"><img src="image/compicon.png" alt="compicon"></span></p>
		 						</div>
							</div>
							<div class="stars2">
								<div class="glyphicon glyphicon-star"></div>
								<div class="glyphicon glyphicon-star"></div>
								<div class="glyphicon glyphicon-star"></div>
							</div>
						</div>
				</div>	 
			</div>
			<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
				<div class="txthover">
					<img src="image/car6.jpg" alt="car6">
						<div class="txtcontent">
							<div class="stars">
								<div class="glyphicon glyphicon-star"></div>
								<div class="glyphicon glyphicon-star"></div>
								<div class="glyphicon glyphicon-star"></div>
							</div>
							<div class="simpletxt">
								<h3 class="name">Porche 911</h3>
								<p>"Lorem ipsum dolor sit amet, consectetur,<br>
	 							sed do eiusmod tempor incididunt" </p>
	 							<h4 class="price">4000 &euro;</h4>
	 							<button>READ MORE</button><br>
	 							<div class="wishtxt">
		 							<p class="paragraph1"> Add to Wishlist <span class="glyphicon glyphicon-heart"></span> </p>
		 							<p class="paragraph2">Compare <span class="icon"><img src="image/compicon.png" alt="compicon"></span></p>
		 						</div>
							</div>
							<div class="stars2">
								<div class="glyphicon glyphicon-star"></div>
								<div class="glyphicon glyphicon-star"></div>
								<div class="glyphicon glyphicon-star"></div>
							</div>
						</div>
				</div>	 
			</div>
			<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
				<div class="txthover">
					<img src="image/car7.jpg" alt="car7">
						<div class="txtcontent">
							<div class="stars">
								<div class="glyphicon glyphicon-star"></div>
								<div class="glyphicon glyphicon-star"></div>
								<div class="glyphicon glyphicon-star"></div>
							</div>
							<div class="simpletxt">
								<h3 class="name">Chevrolet SS</h3>
								<p>"Lorem ipsum dolor sit amet, consectetur,<br>
	 							sed do eiusmod tempor incididunt" </p>
	 							<h4 class="price">3000 &euro;</h4>
	 							<button>READ MORE</button><br>
	 							<div class="wishtxt">
		 							<p class="paragraph1"> Add to Wishlist <span class="glyphicon glyphicon-heart"></span> </p>
		 							<p class="paragraph2">Compare <span class="icon"><img src="image/compicon.png" alt="compicon"></span></p>
		 						</div>
							</div>
							<div class="stars2">
								<div class="glyphicon glyphicon-star"></div>
								<div class="glyphicon glyphicon-star"></div>
								<div class="glyphicon glyphicon-star"></div>
							</div>
						</div>
				</div>	 
			</div>
			<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
				<div class="txthover">
					<img src="image/car8.jpg" alt="car8">
						<div class="txtcontent">
							<div class="stars">
								<div class="glyphicon glyphicon-star"></div>
								<div class="glyphicon glyphicon-star"></div>
								<div class="glyphicon glyphicon-star"></div>
							</div>
							<div class="simpletxt">
								<h3 class="name">Meclaren</h3>
								<p>"Lorem ipsum dolor sit amet, consectetur,<br>
	 							sed do eiusmod tempor incididunt" </p>
	 							<h4 class="price">2500 &euro;</h4>
	 							<button>READ MORE</button><br>
	 							<div class="wishtxt">
		 							<p class="paragraph1"> Add to Wishlist <span class="glyphicon glyphicon-heart"></span> </p>
		 							<p class="paragraph2">Compare <span class="icon"><img src="image/compicon.png" alt="compicon"></span></p>
		 						</div>
							</div>
							<div class="stars2">
								<div class="glyphicon glyphicon-star"></div>
								<div class="glyphicon glyphicon-star"></div>
								<div class="glyphicon glyphicon-star"></div>
							</div>
						</div>
				</div>	 
			</div>	
		</div>
	</div>
<!-- _______________________________News Letter ____________________-->
	<div class="newslettercontent">
		<div class="leftside">
			<img src="image/border.png" alt="border">
			<h1>NEWSLETTER</h1>
			<p>Subscribe to the COLLECTIONCARS mailing list to <br>
				receive updates on new arrivals, special offers <br>
				and other discount information.</p>
		</div>
		<div class="rightside">
			<img class="newsimage" src="image/newsletter.jpg" alt="newsletter">
			<input type="text" class="form-control" id="subemail" placeholder="EMAIL">
			<button>SUBSCRIBE</button>
		</div>
	</div>
	
	<!-- ______________________________________________________Bottom Menu ______________________________-->
	
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