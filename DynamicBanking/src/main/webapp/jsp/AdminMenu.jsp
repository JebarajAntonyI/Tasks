<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Menu</title>
<style type="text/css">
	body
	{
		background-color: #FFA07A;
	}
</style>
</head>
<body>

	<h1 style="text-align:center;"> Hi Admin </h1>
	<h3 style="text-align: center;"><a href="AdminHome.jsp" target="adminArea">Home</a></h3>

	<div>
		<div><a href="AllUser.jsp" target="adminArea">View All User</a></div>
		<div><a href="AllAccount.jsp" target="adminArea">View All Account</a></div>
		<div><a href="AddCustomer.jsp" target="adminArea">Add New Customer</a></div>
		<div><a href="AddAccount.jsp" target="adminArea">Add New Account</a></div>
		<div><a href = "TransactionRequest.jsp" target = "adminArea">View Transaction Request</a></div>
		<div><a href = "CustomerRequest.jsp" target = "adminArea">View Customer Request</a></div>
		<div><a href = "ChangePassword.jsp" target = "adminArea">Change Password</a></div>
		<div><a href="LoginPage.jsp" target="_parent">Logout</a></div>
	</div>

</body>
</html>
