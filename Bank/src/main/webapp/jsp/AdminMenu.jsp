<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Menu</title>
<link rel="stylesheet" type="text/css" href="../style/Menu.css">
<!-- <style type="text/css">
	body
	{
		background-color: #FFA07A;
	}
	button
	{
		background-color: olive;
		color: white;
		padding: 10px 15px;
		margin: 8px 0;
		border: double;
		cursor: pointer;
		width: 100%;
	}
</style> -->
</head>
<body>

	<h1 style="text-align:center;"> Hi Admin </h1>
	<form action="../servlet" target="adminArea">
		<div class="menuButton"><button type="submit" value="Admin Home" name="action">Admin Home</button></div>
	</form>
	<!-- <h3 style="text-align: center;"><a href="AdminHome.jsp" target="adminArea">Home</a></h3> -->
	
	<div class="menuButton">
	<form action="../servlet" target="adminArea">
		<div><button type="submit" value="View All User" name="action">View All User</button></div>
		<div><button type="submit" value="View All Account" name="action">View All Account</button></div>
		<div><button type="submit" value="Add New Customer" name="action">Add New Customer</button></div>
		<div><button type="submit" value="Add New Account" name="action">Add New Account</button></div>
		<div><button type="submit" value="View Transaction Request" name="action">View Transaction Request</button></div>
		<div><button type="submit" value="View Customer Request" name="action">View Customer Request</button></div>
		<div><button type="submit" value="Change Password" name="action">Change Password</button></div>
	</form>
	
		<!-- <div><a href="AllUser.jsp" target="adminArea">View All User</a></div>
		<div><a href="AllAccount.jsp" target="adminArea">View All Account</a></div>
		<div><a href="AddCustomer.jsp" target="adminArea">Add New Customer</a></div>
		<div><a href="AddAccount.jsp" target="adminArea">Add New Account</a></div>
		<div><a href = "TransactionRequest.jsp" target = "adminArea">View Transaction Request</a></div>
		<div><a href = "CustomerRequest.jsp" target = "adminArea">View Customer Request</a></div>
		<div><a href = "ChangePassword.jsp" target = "adminArea">Change Password</a></div>
		<div><a href="LoginPage.jsp" target="_parent">Logout</a></div> -->
	
	<!-- <form action="../servlet" target="_parent">
		<div><button type="submit" value="Logout" name="action">Logout</button></div>
	</form> -->
		
	</div>

</body>
</html>
