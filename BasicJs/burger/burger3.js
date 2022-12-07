
var crustName;
var crustAmount;

var fillingName;
var fillingAmount;

var toppingName = [];
var toppingAmount = [];
var totalToppingAmount;
var topLength;
var discount = 0;

var totalAmount;


$(document).ready(function(){
		$("#burgerType").hide();
		$("#crustDiv").hide();
		$("#fillingDiv").hide();
		$("#toppingsDiv").hide();
		$("#invoiceDiv").hide();
		$("#confirmOrder").hide();
		$(".cancel").hide();
		$("#welcomeDiv").hide();
		
	$("#enter").click(function(){
		$("#enter").hide();
		$("#welcomeDiv").show();
	});
	
	$("#orderBurger").click(function()
	{
		$("#welcomeDiv").hide();
		$("#burgerType").show();
	});
	
	$("#exit").click(function(){
		$("#welcomeDiv").hide();
		$("#enter").show();
	});
	
	$("#veg").click(function()
	{
		/*$("#burgerType").hide();*/
		$(".chicken").hide();
		$(".turkey").hide();
		$(".meatStrip").hide();
		
		$("#crustDiv").show();
		$("#fillingDiv").show();
		$("#toppingsDiv").show();
	});
	
	$("#nonVeg").click(function()
	{
		/*$("#burgerType").hide();*/
		$(".chicken").show();
		$(".turkey").show();
		$(".meatStrip").show();
		
		$("#crustDiv").show();
		$("#fillingDiv").show();
		$("#toppingsDiv").show();
	});
	
	/*$("#selectCrust").click(function()
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
	});*/
	
	$("#submit").click(function(){
		
		$(".cancel").show();
		
		//crust
		crustName = $("input:radio[name='crust']:checked").attr('id');
		crustAmount = $("input:radio[name='crust']:checked").val();
		if(crustAmount != undefined)
		{
			totalAmount = crustAmount;
		}
		else
		{
			alert("Select Crust");
		}
		
		//filling
		fillingName = $("input:radio[name='filling']:checked").attr('id');
		fillingAmount = $("input:radio[name='filling']:checked").val();
		if(fillingAmount != undefined)
		{
			totalAmount = Number(totalAmount) + Number(fillingAmount);
		}
		else
		{
			alert("Select Filling");
		}
		
		//topping
		$(':checkbox:checked').each(function(i){
			toppingAmount[i] = $(this).val();
			toppingName[i] = $(this).attr('id');
		});
		
		topLength = toppingAmount.length;
		if(topLength <= 3 && topLength > 0)
		{
			for(let i=0; i<topLength; i++)
			{
				totalAmount = Number(totalAmount) + Number(toppingAmount[i]);
			}
			if (topLength == 3)
			{
				discount = Math.min.apply(Math, toppingAmount);
				totalAmount = Number(totalAmount) - Number(discount);
			}
			$("#submit").hide();
			$("#burgerType").hide();
			$("#confirmOrder").show();
		}
		else
		{
			if (topLength == 0)
			{
				alert("Select Topping");
			}
			else
			{
				alert("Select less than 3 Toppings");
			}
		}
	})
	
	$("#confirmOrder").click(function(){
		$("#burgerType").hide();
		$("#crustDiv").hide();
		$("#fillingDiv").hide();
		$("#toppingsDiv").hide();
		$("#invoiceDiv").hide();
		$("#confirmOrder").hide();
		$("#cancelBurger").hide();
		$("#invoiceDiv").show();
		
		$("<table />", {id: "invoiceTable"}).appendTo("#invoice");
		$("<tr />", {id: "trHead"}).appendTo("#invoiceTable");
		$("<th />", { text: "Details"}).appendTo("#trHead");
		$("<th />", { text: "Amount"}).appendTo("#trHead");

		$("<tr />", {id: "trCrust"}).appendTo("#invoiceTable");
		$("<td />", { text: "Crust: " + crustName}).appendTo("#trCrust");
		$("<td />", { text: crustAmount}).appendTo("#trCrust");
		
		$("<tr />", {id: "trFilling"}).appendTo("#invoiceTable");
		$("<td />", { text: "Filling: " + fillingName}).appendTo("#trFilling");
		$("<td />", { text: fillingAmount}).appendTo("#trFilling");

		
		for(let i=0; i<topLength; i++)
		{
			$("<tr />", {id: "trTopping" + i}).appendTo("#invoiceTable");
			$("<td />", { text: "Topping: " + toppingName[i]}).appendTo("#trTopping" + i);
			$("<td />", { text: toppingAmount[i]}).appendTo("#trTopping" + i);
		}
		$("<tr />", {id: "trDiscount"}).appendTo("#invoiceTable");
		$("<td />", { text: "Discound"}).appendTo("#trDiscount");
		$("<td />", { text: discount}).appendTo("#trDiscount");
		
		$("<p />", { text: "Total: " + totalAmount}).appendTo("#invoiceTable");
	});
	
	$("#randomBurger").click(function(){
		
		$("#welcomeDiv").hide();
		$("#invoiceDiv").show();
		
		var crusts = ["Hard", "Thin", "Soft"];
		/*var crustPrice = ["10", "10", "12"]*/
		var fillings = ["Chicken Tikka", "Paneer Tikka", "Turkey Meat"];
		/*var fillingPrice = ["120", "100", "130"]*/
		var topp = ["Cucumber", "Tomato", "Meat strip", "Cabbage"];
		/*var topPrice = ["25", "20", "45", "20"];*/
		
		var ranCrust = crusts[Math.floor(Math.random()*crusts.length)];
		var ranFilling = fillings[Math.floor(Math.random()*fillings.length)];
		var ranTopp = topp[Math.floor(Math.random()*topp.length)];
		
		switch(ranCrust)
		{
			case "Hard":
				crustPri = 10;
				totalAmount = 10;
				break;
				
			case "Thin":
				crustPri = 10;
				totalAmount = 10;
				break;
				
			case "Soft":
				crustPri = 12;
				totalAmount = 12;
				break;
		}
		
		switch(ranFilling)
		{
			case "Chicken Tikka":
				fillingPri = 120;
				totalAmount = Number(totalAmount) + 120;
				break;
				
			case "Paneer Tikka":
				fillingPri = 100;
				totalAmount = Number(totalAmount) + 100;
				break;
				
			case "Turkey Meat":
				fillingPri = 130;
				totalAmount = Number(totalAmount) + 130;
				break;
		}
		
		switch(ranTopp)
		{
			case "Cucumber":
				toppPri = 25;
				totalAmount = Number(totalAmount) + 25;
				break;
				
			case "Tomato":
				toppPri = 20;
				totalAmount = Number(totalAmount) + 20;
				break;
				
			case "Meat strip":
				toppPri = 45;
				totalAmount = Number(totalAmount) + 45;
				break;
				
			case "Cabbage":
				toppPri = 20;
				totalAmount = Number(totalAmount) + 20;
				break;
		}
		
		$("<table />", {id: "invoiceTable"}).appendTo("#invoice");
		$("<tr />", {id: "trHead"}).appendTo("#invoiceTable");
		$("<th />", { text: "Details"}).appendTo("#trHead");
		$("<th />", { text: "Amount"}).appendTo("#trHead");

		$("<tr />", {id: "trCrust"}).appendTo("#invoiceTable");
		$("<td />", { text: "Crust: " + ranCrust}).appendTo("#trCrust");
		$("<td />", { text: crustPri}).appendTo("#trCrust");
		
		$("<tr />", {id: "trFilling"}).appendTo("#invoiceTable");
		$("<td />", { text: "Filling: " + ranFilling}).appendTo("#trFilling");
		$("<td />", { text: fillingPri}).appendTo("#trFilling");

		$("<tr />", {id: "trTopping"}).appendTo("#invoiceTable");
		$("<td />", { text: "Topping: " + ranTopp}).appendTo("#trTopping");
		$("<td />", { text: toppPri}).appendTo("#trTopping");
			
		$("<p />", { text: "Total: " + totalAmount}).appendTo("#invoiceTable");
		
		$("<button />", { text: "Place Order", id: "placeOrder", onclick: "placeOrder()"}).appendTo("#invoiceTable");
		
	});
	
	$("#cancelBurger").click(function()
	{
		$("#welcomeDiv").hide();
		$("#confirmOrder").hide();
		$("#cancelBurger").hide();
		$("#burgerType").show();
		$("#submit").show();
	});
	
	/*$("#placeOrder").click(function(){
		$("#placeOrder").hide();
		$("<p />", { text: "Order Placed", style: "color: green" }).appendTo("#invoiceTable");
	});*/
	
	
	});
	
	function placeOrder()
	{
		$("#placeOrder").hide();
		$("<p />", { text: "Order Placed", style: "color: green" }).appendTo("#invoiceTable");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	