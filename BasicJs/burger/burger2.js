
var crustName;
var crustAmount;

var fillingName;
var fillingAmount;

var toppingName = [];
var toppingAmount = [];
var totalToppingAmount;

var totalAmount;





$(document).ready(function(){
		$("#burgerType").hide();
		$("#crustDiv").hide();
		$("#fillingDiv").hide();
		$("#toppingsDiv").hide();
		$("#invoiceDiv").hide();
		$("#confirmOrder").hide();
	
	$("#orderBurger").click(function()
	{
		$("#welcomeDiv").hide();
		$("#burgerType").show();
	});
	
	$("#veg").click(function()
	{
		$("#burgerType").hide();
		$(".chicken").hide();
		$(".turkey").hide();
		$(".meatStrip").hide();
		
		$("#crustDiv").show();
	});
	
	$("#nonVeg").click(function()
	{
		$("#burgerType").hide();
		$("#crustDiv").show();
	});
	
	$("#selectCrust").click(function()
	{
		crustName = $("input:radio[name='crust']:checked").attr('id');
		crustAmount = $("input:radio[name='crust']:checked").val();
		if(crustAmount != undefined)
		{
			totalAmount = crustAmount;
			$("#crustDiv").hide();
			$("#fillingDiv").show();
		}
		else
		{
			alert("Select Crust");
		}
	});
	
	$("#selectFilling").click(function()
	{
		fillingName = $("input:radio[name='filling']:checked").attr('id');
		fillingAmount = $("input:radio[name='filling']:checked").val();
		if(fillingAmount != undefined)
		{
			totalAmount = Number(totalAmount) + Number(fillingAmount);
			$("#fillingDiv").hide();
			$("#toppingsDiv").show();
		}
		else
		{
			alert("Select Filling");
		}
	});
	
	$("#selectToppings").click(function()
	{
		$(':checkbox:checked').each(function(i){
			toppingAmount[i] = $(this).val();
			toppingName[i] = $(this).attr('id');
		});
		
		let length = toppingAmount.length;
		if(length <= 3 && length > 0)
		{
			for(let i=0; i<length; i++)
			{
				totalAmount = Number(totalAmount) + Number(toppingAmount[i]);
			}
			if (length == 3)
			{
				let discount = Math.min.apply(Math, toppingAmount);
				totalAmount = Number(totalAmount) - Number(discount);
			}
			$("#toppingsDiv").hide();
			$("#confirmOrder").show();
		}
		else
		{
			if (length == 0)
			{
				alert("Select Topping");
			}
			else
			{
				alert("Select less than 3 Toppings");
			}
		}
	});
	
	$("#submit").click(function(){
		//crust
		crustName = $("input:radio[name='crust']:checked").attr('id');
		crustAmount = $("input:radio[name='crust']:checked").val();
		if(crustAmount != undefined)
		{
			totalAmount = crustAmount;
			$("#crustDiv").hide();
			$("#fillingDiv").show();
		}
		else
		{
			alert("Select Crust");
		}
	})
	
	$("#confirmOrder").click(function(){
		$("#confirmOrder").hide();
		$("#invoiceDiv").show();
		$("<p />", { text: "Crust: " + crustName}).appendTo("#invoice");
	});
	
	});
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	