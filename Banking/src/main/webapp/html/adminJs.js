

function home(){
	undoMenuButtonColor();
	document.getElementById("home").setAttribute("style", "background-color: #204e7d; color: white;");
	$("#adminArea").load("AdminHome.html");
}

function searchUser(){
	undoMenuButtonColor();
	document.getElementById("searchId").setAttribute("style", "background-color: #204e7d; color: white;");
	$("#adminArea").load("SearchUser.html");
}

function searchAccount(){
	undoMenuButtonColor();
	document.getElementById("searchAcc").setAttribute("style", "background-color: #204e7d; color: white;");
	$("#adminArea").load("SearchAccount.html");
}

function allUsers(){
	$("#userArea").empty();
	$("#redMessage").hide();
	$("#message").hide();
	undoUserButtonColor();
	document.getElementById("allUse").setAttribute("style", "background-color: #204e7d; color: white;");
	$("#userArea").load("AllUser.html");
}

function profile(){
	undoMenuButtonColor();
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
				$("#fail").show().html(user.redMessage);
			}
		}
	});
}

function password(){
	undoMenuButtonColor();
	$("#adminArea").load("AdminPassword.html");
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

function userDetails(){
	undoUserButtonColor();
	$("#userArea").empty();
	document.getElementById("uDetail").setAttribute("style", "background-color: #204e7d; color: white;");
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
					$("#message").hide();
					$("#cid").val(user.userId);
					$("#name").val(user.name);	
					$("#dob").val(user.dob);
					$("#mobile").val(user.mobile);
					$("#mail").val(user.email);
				}
				else
				{
					$("#message").hide();
					$(".views").hide();
					$("#redMessage").show().html(user.redMessage);
				}
			}
		});
	}
	else
	{
		$("#redMessage").show().html("Enter User Id");
	}
}

function modifyUserDetails()
{
	var mail = $("#mail").val();
	var mobile = $("#mobile").val();
	var name = $("#name").val();
	var id = $("#cid").val();
	var dob = $("#dob").val();
	var obj = {button:"modifyUserDetails", id:id, name:name, dob:dob, mail:mail, mobile:mobile};
	var myJson = JSON.stringify(obj);
	
	if(mail && mobile && name && id && dob)
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
	else
	{
		$("#success").hide();
		$("#fail").show().html("No Fields should be Empty");
	}
}

function accountDetails()
{
	undoUserButtonColor();
	$("#userArea").empty();
	document.getElementById("accDetail").setAttribute("style", "background-color: #204e7d; color: white;");
	var id = $("#id").val();
	if(id)
	{
		$("#view").hide();
		$("#message").hide();
		$("#redMessage").hide();
		$("#userArea").load("AccountDetails.html");
	}
	else
	{
		$("#redMessage").show().html("Enter User Id");
	}
}

function customerDetails()
{
	undoUserButtonColor();
	$("#userArea").empty();
	document.getElementById("documents").setAttribute("style", "background-color: #204e7d; color: white;");
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
				if(customer.redMessage == undefined && customer.aadhar)
				{
					$("#redMessage").hide();
					$("#message").hide();
					$("#cid").val(customer.customerId);
					$("#name").val(customer.name);	
					$("#dob").val(customer.dob);
					$("#aadhar").val(customer.aadhar);
					$("#pan").val(customer.pan);
				}
				else
				{
					$("#message").hide();
					$(".views").hide();
					$("#redMessage").show().html(customer.redMessage);
				}
			}
		});
	}
	else
	{
		$("#redMessage").show().html("Enter User Id");
	}
}

function modifyCustomerDetails()
{
	var name = $("#name").val();
	var dob = $("#dob").val();
	var id = $("#cid").val();
	var aadhaar = $("#aadhar").val();
	var pan = $("#pan").val();
	var obj = {button: "modifyCustomerDetails", id:id, 
	name:name, dob:dob, aadhaar:aadhaar, pan:pan}
	var myJson = JSON.stringify(obj);
	
	if(name && dob && id && aadhaar && pan)
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
	else
	{
		$("#success").hide();
		$("#fail").show().html("No Fields should be Empty");
	}
}

function transaction()
{
	undoUserButtonColor();
	$("#userArea").empty();
	document.getElementById("transDetail").setAttribute("style", "background-color: #204e7d; color: white;");
	var id = $("#id").val();
	if(id)
	{
		$("#message").hide();
		$("#redMessage").hide();
		$("#userArea").load("AdminTransactionDetails.html");
	}
	else
	{
		$("#message").hide();
		$("#redMessage").show().html("Enter User Id");
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
			$("#views").show();
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

function allAccount()
{
	undoAccountButtonColor();
	$("#userArea").empty();
	$("#redMessage").hide();
	$("#message").hide();
	document.getElementById("allAcc").setAttribute("style", "background-color: #204e7d; color: white; width: 35%;");
	$("#userArea").load("AllAccount.html");
}

function accountSearch()
{
	undoAccountButtonColor();
	$("#userArea").empty();
	$("#redMessage").hide();
	$("#message").hide();
	document.getElementById("accSearch").setAttribute("style", "background-color: #204e7d; color: white; margin-left: 0.9%; width: 35%;");
	var acNo = $("#acNo").val();
	if(acNo)
	{
		$("#userArea").load("AdminAccountDetails.html");
	}
	else
	{
		$("#redMessage").show().html("Enter User Id or Account Number");
	}
}

function add()
{
	undoMenuButtonColor();
	$("#adminArea").load("Add.html");
	document.getElementById("add").setAttribute("style", "background-color: #204e7d; color: white;");
}

function addUser(){
	$("#userArea").load("AddUser.html");
	undoCreateButtonColor();
	document.getElementById("Usr").setAttribute("style", "background-color: #204e7d; color: white; margin-left: 2%;");
}

function createUser(){
	var name = $("#name").val();
	var mobile = $("#mobile").val();
	var email = $("#email").val();
	var pass = $("#pass").val();
	var dob = $("#dob").val();
	var userType = $("#userType").val();
	var obj = {button:"newUser", name:name, mobile:mobile, email:email, pass:pass, dob:dob, userType:userType};
	var myJson = JSON.stringify(obj);
	
	if(name && mobile && email && pass && dob && userType)
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
				else
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
		$("#redMessage").show().html("No Fields should be Empty");
	}
}

function addCustomer(){
	$("#userArea").load("AddCustomer.html");
	undoCreateButtonColor();
	document.getElementById("Custom").setAttribute("style", "background-color: #204e7d; color: white;");
}

function createCustomer(){
	var name = $("#name").val();
	var mobile = $("#mobile").val();
	var email = $("#email").val();
	var pass = $("#pass").val();
	var dob = $("#dob").val();
	var aadhar = $("#aadhar").val();
	var pan = $("#pan").val();
	var address = $("#address").val();
	var obj = {button:"newCustomer", name:name, mobile:mobile, email:email, pass:pass, dob:dob, userType:"Customer", aadhar:aadhar, pan:pan, address:address};
	var myJson = JSON.stringify(obj);
	
	if(name && mobile && email && pass && dob && aadhar && pan && address)
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
				else
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
		$("#redMessage").show().html("No Fields should be Empty");
	}
}

function addDetails(){
	$("#userArea").load("AddCustomerDetailsOnly.html");
	undoCreateButtonColor();
	document.getElementById("CustomDetails").setAttribute("style", "background-color: #204e7d; color: white;");
}

function fillCustomerDetails(){
	var id = $("#cid").val();
	var aadhar = $("#aadhar").val();
	var pan = $("#pan").val();
	var address = $("#address").val();
	var obj = {button:"newCustomerDetails", id:id, aadhar:aadhar, pan:pan, address:address};
	var myJson = JSON.stringify(obj);
	
	if(id && aadhar && pan && address)
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
				else
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
		$("#redMessage").show().html("No Fields should be Empty");
	}
}

function addAccount(){
	$("#userArea").load("AddAccount.html");
	undoCreateButtonColor();
	document.getElementById("Acc").setAttribute("style", "background-color: #204e7d; color: white;");
}

function createAccount(){
	var id = $("#cid").val();
	var balance = $("#balance").val();
	var accountType = $("#accountType").val();
	var accountBranch = $("#accountBranch").val();
	var obj = {button:"newAccount", id:id, balance:balance, accountType:accountType, accountBranch:accountBranch};
	var myJson = JSON.stringify(obj);
	
	if(id && balance && accountType && accountBranch)
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
				else
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
		$("#redMessage").show().html("No Fields should be Empty");
	}
}

function transactionReq(){
	undoMenuButtonColor();
	document.getElementById("transRequest").setAttribute("style", "background-color: #204e7d; color: white;");
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
						let reqTime = new Date(val.requestTime);
						$("#transReq").append(
							"<tr class='tr'>"
							+"<td>"+val.requestNumber+"</td>"
							+"<td>"+val.customerId+"</td>"
							+"<td>"+val.accountNo+"</td>"
							+"<td>"+val.requestFor+"</td>"
							+"<td>"+reqTime.toLocaleString()+"</td>"
							+"<td>-</td>"
							+"<td>"+val.amount+"</td>"
							+"<td>"+val.status+"</td>"
							+"<td><button onclick='approveTransaction(" + val.requestNumber +")' title='Approve' style='width: 40%;' class='button green-button'"
							+"type='submit' value='ApproveTransaction' name='action'>"
							+"<span style='font-size: 100%;'>&#10004;</span>"
							+"</button>"
							+"<button onclick='rejectTransaction(" + val.requestNumber +")' title='Reject' style='width: 40%;' class='button red-button'"
							+"type='submit' value='RejectTransaction' name='action'>"
							+"<span style='font-size: 100%;'>&#10006;</span>"
							+"</button></td>"
							+"</tr>"
						);
					}
					else
					{
						let reqTime = new Date(val.requestTime);
						let verTime = new Date(val.verifiedTime);
						$("#transReq").append(
							"<tr class='tr'>"
							+"<td>"+val.requestNumber+"</td>"
							+"<td>"+val.customerId+"</td>"
							+"<td>"+val.accountNo+"</td>"
							+"<td>"+val.requestFor+"</td>"
							+"<td>"+reqTime.toLocaleString()+"</td>"
							+"<td>"+verTime.toLocaleString()+"</td>"
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
	undoMenuButtonColor();
	document.getElementById("customRequest").setAttribute("style", "background-color: #204e7d; color: white;");
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
							+"<td><button onclick='activateAccount(" + val.requestNo + ", " + val.accountNo +")' title='Activate' style='width: 40%;' class='button green-button'"
							+"type='submit' value='ActivateAccount' name='action'>"
							+"<span style='font-size: 100%;'>&#10004;</span>"
							+"</button>"
						 	+"<button onclick='cancelCustomerRequest(" + val.requestNo + ")' title='Reject' style='width: 40%;' class='button red-button'"
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
							+"<td><button onclick='deactivateAccount(" + val.requestNo + ", " + val.accountNo +")' title='De-Activate' style='width: 40%;' class='button deactivate-button'"
							+"type='submit' value='DeactivateAccount' name='action'>"
							+"<span style='font-size: 100%;'>&#9940;</span>"
							+"</button>"
							+"<button onclick='cancelCustomerRequest(" + val.requestNo + ")' title='Reject' style='width: 40%;' class='button red-button'"
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
	undoMenuButtonColor();
	document.getElementById("blockUser").setAttribute("style", "background-color: #204e7d; color: white;");
	$("#adminArea").load("CustomerStatus.html");
}

function modifyCustomerStatus(){
	var cid = $("#cid").val();
	var status = $("#state").val();
	var obj = {button: "modifyCustomerStatus", cid:cid, status:status};
	var myJson = JSON.stringify(obj);
	
	if(cid && status)
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
				else
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
		$("#redMessage").show().html("No Fields should be Empty");
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
		$("#redMessage").show().html("No Fields should be Empty");
	}
}

function accountActivate(accNo)
{
	var obj = {button:"AccountActivate", accountNo:accNo};
	var myJson = JSON.stringify(obj);
	
	$.ajax({
		type :"POST",
		url :"../servlet",
		data :myJson,
		success:function() 
		{
			$("#userArea").load("AdminAccountDetails.html");
		}
	});
}

function accountDeactivate(accNo)
{
	var obj = {button:"AccountAction", accountNo:accNo};
	var myJson = JSON.stringify(obj);
	
	$.ajax({
		type :"POST",
		url :"../servlet",
		data :myJson,
		success:function() 
		{
			$("#userArea").load("AdminAccountDetails.html");
		}
	});
}

function approveTransaction(requestNo)
{
	var obj = {button:"ApproveTransaction", reqNo:requestNo};
	var myJson = JSON.stringify(obj);
	
	$.ajax({
		type :"POST",
		url :"../servlet",
		data :myJson,
		success:function() 
		{
			$("#adminArea").load("TransactionRequest.html");
		}
	});
}

function rejectTransaction(requestNo)
{
	var obj = {button:"RejectTransaction", reqNo:requestNo};
	var myJson = JSON.stringify(obj);
	
	$.ajax({
		type :"POST",
		url :"../servlet",
		data :myJson,
		success:function() 
		{
			$("#adminArea").load("TransactionRequest.html");
		}
	});
}

function activateAccount(requestNo, accountNo)
{
	var obj = {button:"ActivateAccount", reqNo:requestNo, acNo:accountNo};
	var myJson = JSON.stringify(obj);
	
	$.ajax({
		type :"POST",
		url :"../servlet",
		data :myJson,
		success:function() 
		{
			$("#adminArea").load("ViewCustomerRequest.html");
		}
	});
}

function deactivateAccount(requestNo, accountNo)
{
	var obj = {button:"DeactivateAccount", reqNo:requestNo, acNo:accountNo};
	var myJson = JSON.stringify(obj);
	
	$.ajax({
		type :"POST",
		url :"../servlet",
		data :myJson,
		success:function() 
		{
			$("#adminArea").load("ViewCustomerRequest.html");
		}
	});
}

function cancelCustomerRequest(requestNo)
{
	var obj = {button:"cancelCustomerRequest", reqNo:requestNo};
	var myJson = JSON.stringify(obj);
	
	$.ajax({
		type :"POST",
		url :"../servlet",
		data :myJson,
		success:function() 
		{
			$("#adminArea").load("ViewCustomerRequest.html");
		}
	});
}

function undoMenuButtonColor()
{
	document.getElementById("home").setAttribute("style", "background-color: #D0E1F9; color: black");
	document.getElementById("searchId").setAttribute("style", "background-color: #D0E1F9; color: black");
	document.getElementById("searchAcc").setAttribute("style", "background-color: #D0E1F9; color: black");
	document.getElementById("add").setAttribute("style", "background-color: #D0E1F9; color: black");
	document.getElementById("transRequest").setAttribute("style", "background-color: #D0E1F9; color: black");
	document.getElementById("customRequest").setAttribute("style", "background-color: #D0E1F9; color: black");
	document.getElementById("blockUser").setAttribute("style", "background-color: #D0E1F9; color: black");
}

function undoUserButtonColor()
{
	document.getElementById("uDetail").setAttribute("style", "background-color: transparent; color: black; margin-top: 1%;");
	document.getElementById("accDetail").setAttribute("style", "background-color: transparent; color: black; margin-top: 1%;");
	document.getElementById("documents").setAttribute("style", "background-color: transparent; color: black; margin-top: 1%;");
	document.getElementById("transDetail").setAttribute("style", "background-color: transparent; color: black; margin-top: 1%;");
	document.getElementById("allUse").setAttribute("style", "background-color: transparent; color: black; margin-top: 1%;");
}

function undoAccountButtonColor()
{
	document.getElementById("accSearch").setAttribute("style", "background-color: transparent; color: black; margin-left: 0.9%; width: 35%;");
	document.getElementById("allAcc").setAttribute("style", "background-color: transparent; color: black; width: 35%");
}
	
	
function undoCreateButtonColor()
{
	document.getElementById("Usr").setAttribute("style", "background-color: transparent; color: black; margin-top: 1%; margin-left: 2%;");
	document.getElementById("Custom").setAttribute("style", "background-color: transparent; color: black; margin-top: 1%;");
	document.getElementById("CustomDetails").setAttribute("style", "background-color: transparent; color: black; margin-top: 1%;");
	document.getElementById("Acc").setAttribute("style", "background-color: transparent; color: black; margin-top: 1%;");
}
	

















