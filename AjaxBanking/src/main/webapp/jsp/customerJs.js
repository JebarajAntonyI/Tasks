
function home(){
	$("#customerArea").load("CustomerHome.html");
}

function accountDetails(){
	$("#customerArea").load("AccountDetails.html");
}

function deposit()
{
	$("#customerArea").load("Deposit.html");
}

function withdraw()
{
	$("#customerArea").load("Withdraw.html");
}

function transfer()
{
	$("#customerArea").load("Transfer.html");
}

function transactionDetails()
{
	$("#customerArea").load("TransactionDetails.html");
}

function request()
{
	$("#customerArea").load("CustomerRequest.html");
}

function profile(){
	$("#customerArea").load("CustomerDetails.html");
}

function password(){
	$("#customerArea").load("ChangePassword.html");
}

function logout(){
	location.href = "LoginPage.html";
}

function depositAmount()
{
	var obj = {button:"depositAmount", accountNo:$("#accNo").val(), amount:$("#amount").val()};
	var myJson = JSON.stringify(obj);
	
	$.ajax({
		type:"POST",
		url:"../servlet",
		data:myJson,
		success:function(response)
		{
			var json = JSON.parse(response);
			var message = json.message;
			var redMsg = json.redMessage;
			$("#message").html(message);
			$("#redMessage").html(redMsg);
		}
	});
}

function withdrawAmount()
{
	var obj = {button:"withdrawRequest", accountNo:$("#accNo").val(), amount:$("#amount").val()};
	var myJson = JSON.stringify(obj);
	
	$.ajax({
		type:"POST",
		url:"../servlet",
		data:myJson,
		success:function(response)
		{
			var json = JSON.parse(response);
			var message = json.message;
			var redMsg = json.redMessage;
			$("#message").html(message);
			$("#redMessage").html(redMsg);
		}
	});
}

function transferAmount()
{
	var obj = {button:"transferAmount", accountNo:$("#accNo").val(), toAccount:$("#toAcc").val(), amount:$("#amount").val()};
	var myJson = JSON.stringify(obj);
	
	$.ajax({
		type:"POST",
		url:"../servlet",
		data:myJson,
		success:function(response)
		{
			var json = JSON.parse(response);
			var message = json.message;
			var redMsg = json.redMessage;
			if(message)
			{
				$("#redMessage").hide();
				$("#message").show().html(message);
			}
			if(redMsg)
			{
				$("#message").hide();
				$("#redMessage").show().html(redMsg);
			}
		}
	});
}

function showTransaction()
{
	var obj = {button:"showTransaction", accountNo:$("#accNo").val(), days:$("#days").val()};
	var myJson = JSON.stringify(obj);
	
	$.ajax({
		type:"POST",
		url:"../servlet",
		data:myJson,
		success:function(response)
		{
			var map = JSON.parse(response);
			$(".trans").remove();
			for(i in map)
				{
					$("#transactionTable").append(
						"<tr class='trans'><td>"+map[i].transactionId+"</td>"
						+ "<td>"+map[i].primaryAccount+"</td>"
						+ "<td>"+map[i].secondaryAccount+"</td>"
						+ "<td>"+map[i].transactionTime+"</td>"
						+ "<td>"+map[i].modeOfTransaction+"</td>"
						+ "<td>"+map[i].transactionType+"</td>"
						+ "<td>"+map[i].amount+"</td>"
						+ "<td>"+map[i].closingBalance+"</td>"
						+ "<td>"+map[i].transactionStatus+"</td></tr>"
					);
				}
		}
	});
}

function deactivate()
{
	var obj = {button:"requestDeactivation", accountNo:$("#actAcc").val()};
	var myJson = JSON.stringify(obj);
	
	$.ajax({
		type:"POST",
		url:"../servlet",
		data:myJson,
		success:function(response)
		{
			var json = JSON.parse(response);
			var message = json.message;
			var redMsg = json.redMessage;
			if(message)
			{
				$("#redMessage").hide();
				$("#message").show().html(message);
			}
			if(redMsg)
			{
				$("#message").hide();
				$("#redMessage").show().html(redMsg);
			}
		}
	});
}

function activate()
{
	var obj = {button:"requestActivation", accountNo:$("#inactAcc").val()};
	var myJson = JSON.stringify(obj);
	
	$.ajax({
		type:"POST",
		url:"../servlet",
		data:myJson,
		success:function(response)
		{
			var json = JSON.parse(response);
			var message = json.message;
			var redMsg = json.redMessage;
			if(message)
			{
				$("#redMessage").hide();
				$("#message").show().html(message);
			}
			if(redMsg)
			{
				$("#message").hide();
				$("#redMessage").show().html(redMsg);
			}
		}
	});
}

function modifyDetails()
{
	var obj = {button:"modifyUserDetails", id:$("#cid").val(), mail:$("#mail").val(), mobile:$("#mobile").val()};
	var myJson = JSON.stringify(obj);
	
	$.ajax({
			type :"POST",
			url :"../servlet",
			data :myJson,
			success:function(response) 
			{
				var json = JSON.parse(response);
				var message = json.message;
				var redMsg = json.redMessage;
				if(message)
				{
					$("#redMessage").hide();
					$("#message").show().html(message);
				}
				if(redMsg)
				{
					$("#message").hide();
					$("#redMessage").show().html(redMsg);
				}
			}
		});
}

function changePassword()
{
	var obj = {button:"passChange", old:$("#old").val(), new:$("#new").val(), re:$("#re").val()};
	var myJson = JSON.stringify(obj);
	
	$.ajax({
			type :"POST",
			url :"../servlet",
			data :myJson,
			success:function(response) 
			{
				var json = JSON.parse(response);
				
				var message = json.message;
				var redMsg = json.redMessage;
				$("old").val("");
				$("new").val("");
				$("re").val("");
				if(message)
				{
					$("#redMessage").hide();
					$("#message").show().html(message);
				}
				if(redMsg)
				{
					$("#message").hide();
					$("#redMessage").show().html(redMsg);
				}
			}
		});
}
























