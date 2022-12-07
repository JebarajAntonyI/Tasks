function home(){
	$("#adminArea").load("AdminHome.html");
}

function searchUser(){
	$("#adminArea").load("SearchUser.html");
}

function searchAccount(){
	$("#adminArea").load("SearchAccount.html");
}

function allUsers(){
	$("#userArea").load("AllUser.html");
}

/*function profile(){
	$("#adminArea").load("UserDetails.html");
}*/

function profile(){
	
	$("#adminArea").load("UserDetails.html");
	var obj = {
		button :"userProfile"
	};
	
	var myJson = JSON.stringify(obj);
	$.ajax({
		type :"POST",
		url :"../servlet",
		data :myJson,
		success:function(response) 
		{
			var user = JSON.parse(response);
			if(user.redMessage == undefined)
			{
				$("#redMessage").hide();
				$("#cid").val(user.userId);
				$("#name").val(user.name);	
				$("#dob").val(user.dob);
				$("#mobile").val(user.mobile);
				$("#mail").val(user.email);
			}
			else
			{
				$("#redMessage").show();
				$("#fail").html(user.redMessage);
			}
		}
	});
}

function password(){
	$("#adminArea").load("ChangePassword.html");
}

function logout(){
	location.href = "LoginPage.html";
}

function userDetails(){
	
	var id = $("#id").val();
	if(id)
	{
		$("#userArea").load("UserDetails.html");
		var obj = {
			button :"userDetails", id:$("#id").val()
		};
		
		var myJson = JSON.stringify(obj);
		$.ajax({
			type :"POST",
			url :"../servlet",
			data :myJson,
			success:function(response) 
			{
				var user = JSON.parse(response);
				if(user.redMessage == undefined)
				{
					$("#redMessage").hide();
					$("#cid").val(user.userId);
					$("#name").val(user.name);	
					$("#dob").val(user.dob);
					$("#mobile").val(user.mobile);
					$("#mail").val(user.email);
				}
				else
				{
					$("#redMessage").show();
					$("#fail").html(user.redMessage);
				}
			}
		});
	}
	else
	{
		$("#redMessage").html("Enter User Id");
	}
}

function modifyUserDetails()
{
	var obj = {button:"modifyUserDetails", id:$("#cid").val(), name:$("#name").val(), dob:$("#dob").val(), mail:$("#mail").val(), mobile:$("#mobile").val()};
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
				$("#fail").hide();
				$("#success").show().html(message);
			}
			if(redMsg)
			{
				$("#success").hide();
				$("#fail").show().html(redMsg);
			}
		}
	});
}

function accountDetails()
{
	var id = $("#id").val();
	if(id)
	{
		$("#userArea").load("AccountDetails.html");
	}
	else
	{
		$("#redMessage").html("Enter User Id");
	}
}

function customerDetails()
{
	var id = $("#id").val();
	if(id)
	{
		$("#userArea").load("CustomerDocuments.html");
		var obj = {
			button :"customerDetails", id:$("#id").val()
		};
		
		var myJson = JSON.stringify(obj);
		$.ajax({
			type :"POST",
			url :"../servlet",
			data :myJson,
			success:function(response) 
			{
				var customer = JSON.parse(response);
				if(customer.redMessage == undefined)
				{
					$("#redMessage").hide();
					$("#cid").val(customer.customerId);
					$("#name").val(customer.name);	
					$("#dob").val(customer.dob);
					$("#aadhar").val(customer.aadhar);
					$("#pan").val(customer.pan);
				}
				else
				{
					$("#redMessage").show();
					$("#fail").html(customer.redMessage);
				}
			}
		});
	}
	else
	{
		$("#redMessage").html("Enter User Id");
	}
}

function modifyCustomerDetails()
{
	var obj = {button: "modifyCustomerDetails", id:$("#cid").val(), 
	name:$("#name").val(), dob:$("#dob").val(), aadhaar:$("#aadhar").val(), pan:$("#pan").val()}
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
				$("#fail").hide();
				$("#success").show().html(message);
			}
			if(redMsg)
			{
				$("#success").hide();
				$("#fail").show().html(redMsg);
			}
		}
	})
}

function transaction()
{
	var id = $("#id").val();
	if(id)
	{
		$("#userArea").load("AdminTransactionDetails.html");
	}
	else
	{
		$("#redMessage").html("Enter User Id");
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

function allAccount()
{
	$("#userArea").load("AllAccount.html");
}

function accountSearch()
{
	var acNo = $("#acNo").val();
	if(acNo)
	{
		$("#userArea").load("AdminAccountDetails.html");
	}
	else
	{
		$("#redMessage").html("Enter User Id");
	}
}

function addUser(){
	$("#adminArea").load("AddUser.html");
}

function createUser(){
	var obj = {button:"newUser", name:$("#name").val(), mobile:$("#mobile").val(), email:$("#email").val(), pass:$("#pass").val(), dob:$("#dob").val(), userType:$("#userType").val()};
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
				$("#message").html(message);
			}
			else
			{
				$("#message").hide();
				$("#redMessage").html(redMsg);
			}
		}
	});
}

function addCustomer(){
	$("#adminArea").load("AddCustomer.html");
}

function createCustomer(){
	var obj = {button:"newCustomer", name:$("#name").val(), mobile:$("#mobile").val(), email:$("#email").val(), pass:$("#pass").val(), dob:$("#dob").val(), userType:"Customer", aadhar:$("#aadhar").val(), pan:$("#pan").val(), address:$("#address")};
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
				$("#message").html(message);
			}
			else
			{
				$("#message").hide();
				$("#redMessage").html(redMsg);
			}
		}
	});
}

function addDetails(){
	$("#adminArea").load("AddCustomerDetailsOnly.html");
}

function fillCustomerDetails(){
	var obj = {button:"newCustomerDetails", id:$("#cid").val(), aadhar:$("#aadhar").val(), pan:$("#pan").val(), address:$("#address")};
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
				$("#message").html(message);
			}
			else
			{
				$("#message").hide();
				$("#redMessage").html(redMsg);
			}
		}
	});
}

function addAccount(){
	$("#adminArea").load("AddAccount.html");
}

function createAccount(){
	var obj = {button:"newAccount", id:$("#cid").val(), balance:$("#balance").val(), accountType:$("#accountType").val(), accountBranch:$("#accountBranch")};
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
				$("#message").html(message);
			}
			else
			{
				$("#message").hide();
				$("#redMessage").html(redMsg);
			}
		}
	});
}

function transactionReq(){
	$("#adminArea").load("TransactionRequest.html");
}

function showTransactionRequest()
{
	var obj = {button: "showTransactionRequest", reqType:$("#reqType").val()};
		var myJson = JSON.stringify(obj);
		
		$.ajax({
			type :"POST",
			url :"../servlet",
			data :myJson,
			success:function(response) 
			{
				var map = JSON.parse(response);
				console.log(map);
				$(".tr").remove();
				for(i in map)
				{
					var val = map[i];
					var status = val.status;
					
					if(status == "Pending")
					{
						$("#transReq").append(
							"<tr class='tr'>"
							+"<td>"+val.requestNumber+"</td>"
							+"<td>"+val.customerId+"</td>"
							+"<td>"+val.accountNo+"</td>"
							+"<td>"+val.requestFor+"</td>"
							+"<td>"+val.requestTime+"</td>"
							+"<td>"+val.verifiedTime+"</td>"
							+"<td>"+val.amount+"</td>"
							+"<td>"+val.status+"</td>"
							+"<td><button title='Approve' style='width: 40%;' class='button green-button'"
							+"type='submit' value='ApprovedTransaction' name='action'>"
							+"<span style='font-size: 100%;'>&#10004;</span>"
							+"</button>"
							+"<button title='Reject' style='width: 40%;' class='button red-button'"
							+"type='submit' value='ejectedTransaction' name='action'>"
							+"<span style='font-size: 100%;'>&#10006;</span>"
							+"</button></td>"
							+"</tr>"
						);
					}
					else
					{
						$("#transReq").append(
							"<tr class='tr'>"
							+"<td>"+val.requestNumber+"</td>"
							+"<td>"+val.customerId+"</td>"
							+"<td>"+val.accountNo+"</td>"
							+"<td>"+val.requestFor+"</td>"
							+"<td>"+val.requestTime+"</td>"
							+"<td>"+val.verifiedTime+"</td>"
							+"<td>"+val.amount+"</td>"
							+"<td>"+val.status+"</td>"
							+"<td>-</td>"
							+"</tr>"
						);
					}
				}
			}
		})
}

function viewCustomerRequest(){
	$("#adminArea").load("ViewCustomerRequest.html");
}

function showCustomerRequest()
{
	var obj = {button: "showCustomerRequest", reqType:$("#reqType").val()};
	var myJson = JSON.stringify(obj);
	
	$.ajax({
		type :"POST",
		url :"../servlet",
		data :myJson,
		success:function(response) 
		{
			var map = JSON.parse(response);
			console.log(map);
			$(".tr").remove();
			for(i in map)
			{
				var val = map[i];
				var message = val.requestMessage;
				var status = val.requestStatus;
				
				if(message == "Requst for Activation" && status=="Pending")
				{
					$("#custReq").append(
						"<tr class='tr'>"
						+"<td>"+val.requestNo+"</td>"
						+"<td>"+val.customerId+"</td>"
						+"<td>"+val.accountNo+"</td>"
						+"<td>"+val.requestMessage+"</td>"
						+"<td>"+val.requestStatus+"</td>"
						+"<td><button title='Activate' style='width: 40%;' class='button green-button'"
						+"type='submit' value='ActivateAccount' name='action'>"
						+"<span style='font-size: 100%;'>&#10004;</span>"
						+"</button>"
					 	+"<button title='Reject' style='width: 40%;' class='button red-button'"
						+"type='submit' value='cancelCustomerRequest' name='action'>"
						+"<span style='font-size: 100%;'>&#10006;</span>"
						+"</button></td>"
						+"</tr>"
					);
				}
				else if(message == "Requst for Deactivation" && status=="Pending")
				{
					$("#custReq").append(
						"<tr class='tr'>"
						+"<td>"+val.requestNo+"</td>"
						+"<td>"+val.customerId+"</td>"
						+"<td>"+val.accountNo+"</td>"
						+"<td>"+val.requestMessage+"</td>"
						+"<td>"+val.requestStatus+"</td>"
						+"<td><button title='De-Activate' style='width: 40%;' class='button deactivate-button'"
						+"type='submit' value='DeactivateAccount' name='action'>"
						+"<span style='font-size: 100%;'>&#9940;</span>"
						+"</button>"
						+"<button title='Reject' style='width: 40%;' class='button red-button'"
						+"type='submit' value='cancelCustomerRequest' name='action'>"
						+"<span style='font-size: 100%;'>&#10006;</span>"
						+"</button></td>"
						+"</tr>"
					);
				}
				else
				{
					$("#custReq").append(
						"<tr class='tr'>"
						+"<td>"+val.requestNo+"</td>"
						+"<td>"+val.customerId+"</td>"
						+"<td>"+val.accountNo+"</td>"
						+"<td>"+val.requestMessage+"</td>"
						+"<td>"+val.requestStatus+"</td>"
						+"<td>-</td>"
						+"</tr>"
					);
				}
			}
		}
	})
}

function customerStatus(){
	$("#adminArea").load("CustomerStatus.html");
}

function modifyCustomerStatus(){
	var obj = {button: "modifyCustomerStatus", cid:$("#cid").val(), status:$("#state").val()};
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
				$("#message").html(message);
			}
			else
			{
				$("#message").hide();
				$("#redMessage").html(redMsg);
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



















