
function home(){
	undoMenuButtonColor();
	document.getElementById("home").setAttribute("style", "background-color: #204e7d; color: white;");
	$("#customerArea").load("CustomerHome.html");
}

function accountDetails(){
	undoMenuButtonColor();
	document.getElementById("acc").setAttribute("style", "background-color: #204e7d; color: white;");
	$("#customerArea").load("AccountDetails.html");
}

function deposit()
{
	undoMenuButtonColor();
	document.getElementById("dep").setAttribute("style", "background-color: #204e7d; color: white;");
	$("#customerArea").load("Deposit.html");
}

function withdraw()
{
	undoMenuButtonColor();
	document.getElementById("draw").setAttribute("style", "background-color: #204e7d; color: white;");
	$("#customerArea").load("Withdraw.html");
}

function transfer()
{
	undoMenuButtonColor();
	document.getElementById("transfer").setAttribute("style", "background-color: #204e7d; color: white;");
	$("#customerArea").load("Transfer.html");
}

function transactionDetails()
{
	undoMenuButtonColor();
	document.getElementById("trans").setAttribute("style", "background-color: #204e7d; color: white;");
	$("#customerArea").load("TransactionDetails.html");
}

function request()
{
	undoMenuButtonColor();
	document.getElementById("req").setAttribute("style", "background-color: #204e7d; color: white;");
	$("#customerArea").load("CustomerRequest.html");
}

function profile(){
	undoMenuButtonColor();
	$("#customerArea").load("CustomerDetails.html");
}

function password(){
	undoMenuButtonColor();
	$("#customerArea").load("CustomerPassword.html");
}

function logout(){
	var obj = {
		button :"Logout"
	};
	
	var myJson = JSON.stringify(obj);
	$.ajax({
		type :"POST",
		url :"../servlet",
		data :myJson,
		success:function() 
		{
			location.href = "LoginPage.html";
		}
	});
}

function depositAmount()
{
	var acNo = $("#accNo").val();
	var amount = $("#amount").val();
	var obj = {button:"depositAmount", accountNo:acNo, amount:amount};
	var myJson = JSON.stringify(obj);
	
	if(acNo && amount)
	{
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
	else
	{
		$("#message").hide();
		$("#redMessage").show().html("Fill all Fields");
	}
}

function withdrawAmount()
{
	var acNo = $("#accNo").val();
	var amount = $("#amount").val();
	var obj = {button:"withdrawRequest", accountNo:acNo, amount:amount};
	var myJson = JSON.stringify(obj);
	
	if(acNo && amount)
	{
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
	else
	{
		$("#message").hide();
		$("#redMessage").show().html("Fill all Fields");
	}
}

function transferAmount()
{
	var acNo = $("#accNo").val();
	var toAc = $("#toAcc").val();
	var amount = $("#amount").val();
	var obj = {button:"transferAmount", accountNo:acNo, toAccount:toAc, amount:amount};
	var myJson = JSON.stringify(obj);
	
	if(acNo && toAc && amount)
	{
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
	else
	{
		$("#message").hide();
		$("#redMessage").show().html("Fill all Fields");
	}
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
					let time = new Date(map[i].transactionTime);
					let secondaryAccount = map[i].secondaryAccount;
					if(secondaryAccount == 0)
					{
						secondaryAccount = "-";
					}
					$("#transactionTable").append(
						"<tr class='trans'><td>"+map[i].transactionId+"</td>"
						+ "<td>"+map[i].primaryAccount+"</td>"
						+ "<td>"+secondaryAccount+"</td>"
						+ "<td>"+time.toLocaleString()+"</td>"
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
	var id = $("#cid").val();
	var name = $("#name").val();
	var dob = $("#dob").val();
	var mail = $("#mail").val();
	var mobile = $("#mobile").val();
	var obj = {button:"modifyUserDetails", id:id, mail:mail, mobile:mobile, name:name, dob:dob};
	var myJson = JSON.stringify(obj);
	
	if(id && mail && mobile)
	{
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
	else
	{
		$("#message").hide();
		$("#redMessage").show().html("Fill all Fields");
	}
}

function changePassword()
{
	var old = $("#old").val();
	var ne = $("#new").val();
	var re = $("#re").val();
	var obj = {button:"passChange", old:old, new:ne, re:re};
	var myJson = JSON.stringify(obj);
	
	if(old && ne && re)
	{
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
	else
	{
		$("#message").hide();
		$("#redMessage").show().html("Fill all Fields");
	}
}

function undoMenuButtonColor()
{
	document.getElementById("home").setAttribute("style", "background-color: #D0E1F9; color: black");
	document.getElementById("acc").setAttribute("style", "background-color: #D0E1F9; color: black");
	document.getElementById("dep").setAttribute("style", "background-color: #D0E1F9; color: black");
	document.getElementById("draw").setAttribute("style", "background-color: #D0E1F9; color: black");
	document.getElementById("transfer").setAttribute("style", "background-color: #D0E1F9; color: black");
	document.getElementById("trans").setAttribute("style", "background-color: #D0E1F9; color: black");
	document.getElementById("req").setAttribute("style", "background-color: #D0E1F9; color: black");
}
























