$(function() {
	
    $( "#slider-range" ).slider({
      range: true,
      min: 0,
      max: 1000000,
      values: [ 0, 1000000 ],
      slide: function( event, ui ) {
        $( "#amount" ).val( "$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ] );
      }
    });
    $( "#amount" ).val( "$" + $( "#slider-range" ).slider( "values", 0 ) +
      " - $" + $( "#slider-range" ).slider( "values", 1 ) );
  });

	var container = $('.grid').isotope({
		itemSelector: '.col-xs-12',
		getSortData: {
			name: '.name',
			price: '.price parseInt'
		}
	});
	$('.alphSort').on('click', function(e){
		e.preventDefault();
		container.isotope({ sortBy: 'name'});
	});
	$('.prcBtnH').on('click', function(e){
		e.preventDefault();
		container.isotope({ sortBy: 'price', sortAscending: false});
	});
	$('.prcBtnL').on('click', function(e){
		e.preventDefault();
		container.isotope({ sortBy: 'price', sortAscending: true});
	});
	$('.prcBtnR').on('click',function(e){
		e.preventDefault();
		container.isotope({sortBy:'random'});
	});
	$('.prcBtnO').on('click',function(e){
		e.preventDefault();
		container.isotope({sortBy:'original-order'});
	});

$('#btnRM').click(function(){
    $('#readmore').animate({height:'322px'}, 500);
});
$('#btnRL').click(function(){
	$('#readmore').animate({height:'0px'}, 500);
});
$('#btnRM2').click(function(){
    $('#readmore2').animate({height:'322px'}, 500);
});
$('#btnRL2').click(function(){
	$('#readmore2').animate({height:'0px'}, 500);
});

$(function () {
  $("#mydd1 a").on('click',function (e) {
  	e.preventDefault();
    $("#dropdownMenu1").html($(this).html() + ' <span class="downicon"></span>');
  });
});

$(function () {
  $("#mydd2 a").on('click',function (e) {
  	e.preventDefault();
    $("#dropdownMenu2").html($(this).html() + ' <span class="downicon"></span>');
  });
});
$(function () {
  $("#mydd3 a").on('click',function (e) {
  	e.preventDefault();
    $("#dropdownMenu3").html($(this).html() + ' <span class="downicon"></span>');
  });
});
$(function () {
  $("#mydd4 a").on('click',function (e) {
  	e.preventDefault();
    $("#dropdownMenu4").html($(this).html() + ' <span class="downicon"></span>');
  });
});
$(function () {
  $("#mydd5 a").on('click',function (e) {
  	e.preventDefault();
    $("#dropdownMenu5").html($(this).html() + ' <span class="downicon"></span>');
  });
});
$(function(){
	$("#make").on('change',function(e){
		if($("#make option:selected").text()!="MAKE"){
			$("#model").show();
			$("#model input").val("");
		}else{
			$("#model").hide();
			$("#model input").val("");
		}
	});
	if($("#make option:selected").text()=="MAKE"){
		$("#model").hide();
		$("#model input").val("");
	}
});
$(function(){
	$(window).unload(function(){
		per=100;
  		$("#price").val("");
		$("#fuel").val("");
		$("#horse").val("");
		$("#torque").val("");
	});
});
$(function(){
	$("#sbut").keypress(function(e){
            if(e.keyCode==13){
                e.preventDefault();
            }
	});
	$("#price").keypress(function(e){
            if(e.keyCode==13){
                e.preventDefault();
            }
	});
	$("#fuel").keypress(function(e){
            if(e.keyCode==13){
                e.preventDefault();
            }
	});
	$("#horse").keypress(function(e){
            if(e.keyCode==13){
                e.preventDefault();
            }
	});
	$("#torque").keypress(function(e){
            if(e.keyCode==13){
                e.preventDefault();
            }
	});
});
$(function(){
	var per=100;
	var price=0;
	var fuel=0;
	var horse=0;
	var torque=0;
	var check= /^\-?\d+$/;
	$("#per").text("PERCENTAGE LEFT: "+per);
	if(per!=0){
		$("#sbut").hide();
	}
	$("#price").on('blur',function(){
		price=0;
		$(".check").html("&nbsp;");
		if($("#price").val()!=""){
			if(!check.test(($("#price").val()))){
				$(".check").html("Please enter integer. 1");
				$("#price").val("");
				price=0;
			}else{
				price=parseFloat($("#price").val());
			}
		}
		per=100-price-fuel-horse-torque;
		if(per<0){
			$(".check").html("Total Percentage over 100, please reenter. 1");
			/*alert("Total Percentage over 100, please reenter.");*/	
			$("#price").val("");
			price=0;
		}else if(price<0){
			$(".check").html("Please enter positive integer. 1");
			/*alert("Please enter positive number");*/	
			$("#price").val("");
			price=0;
		}
		per=100-price-fuel-horse-torque;
		$("#per").text("PERCENTAGE LEFT: "+per);
		if(per==0){
			$("#sbut").show();
		}else{
			$("#sbut").hide();
		}
	});
	$("#fuel").on('blur',function(){
		fuel=0;
		$(".check").html("&nbsp;");
		if($("#fuel").val()!=""){
			if(!check.test(($("#fuel").val()))){
				$(".check").html("Please enter integer. 2");
				$("#fuel").val("");
				fuel=0;
			}else{
				fuel=parseFloat($("#fuel").val());
			}
		}
		per=100-price-fuel-horse-torque;
		if(per<0){
			$(".check").html("Total Percentage over 100, please reenter. 1");
			/*alert("Total Percentage over 100, please reenter.");*/	
			$("#fuel").val("");
			fuel=0;
		}else if(fuel<0){
			$(".check").html("Please enter positive integer. 1");
			/*alert("Please enter positive number");*/	
			$("#fuel").val("");
			fuel=0;
		}
		per=100-price-fuel-horse-torque;
		$("#per").text("PERCENTAGE LEFT: "+per);
		if(per==0){
			$("#sbut").show();
		}else{
			$("#sbut").hide();
		}
	});
	$("#horse").on('blur',function(){
		horse=0;
		$(".check").html("&nbsp;");
		if($("#horse").val()!=""){
			if(!check.test(($("#horse").val()))){
				$(".check").html("Please enter integer. 3");
				$("#horse").val("");
				horse=0;
			}else{
				horse=parseFloat($("#horse").val());
			}
		}
		per=100-price-fuel-horse-torque;
		if(per<0){
			$(".check").html("Total Percentage over 100, please reenter. 1");
			/*alert("Total Percentage over 100, please reenter.");*/	
			$("#horse").val("");
			horse=0;
		}else if(horse<0){
			$(".check").html("Please enter positive integer. 1");
			/*alert("Please enter positive number");*/	
			$("#horse").val("");
			horse=0;
		}
		per=100-price-fuel-horse-torque;
		$("#per").text("PERCENTAGE LEFT: "+per);
		if(per==0){
			$("#sbut").show();
		}else{
			$("#sbut").hide();
		}
	});
	$("#torque").on('blur',function(){
		torque=0;
		$(".check").html("&nbsp;");
		if($("#torque").val()!=""){
			if(!check.test(($("#torque").val()))){
				$(".check").html("Please enter integer. 4");
				$("#torque").val("");
				torque=0;
			}else{
				torque=parseFloat($("#torque").val());
			}
		}
		per=100-price-fuel-horse-torque;
		if(per<0){
			$(".check").html("Total Percentage over 100, please reenter. 1");
			/*alert("Total Percentage over 100, please reenter.");*/	
			$("#torque").val("");
			torque=0;
		}else if(torque<0){
			$(".check").html("Please enter positive integer. 1");
			/*alert("Please enter positive number");*/	
			$("#torque").val("");
			torque=0;
		}
		per=100-price-fuel-horse-torque;
		$("#per").text("PERCENTAGE LEFT: "+per);
		if(per==0){
			$("#sbut").show();
		}else{
			$("#sbut").hide();
		}
	});
});