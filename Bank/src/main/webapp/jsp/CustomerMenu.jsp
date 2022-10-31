<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Menu</title>
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

<h1 style="text-align:center;"> Welcome </h1>
	<form action="../servlet" target="customerArea">
		<div class="menuButton"><button type="submit" value="Customer Home" name="action">Customer Home</button></div>
	</form>
	<!-- <h3 style="text-align: center;"><a href="AdminHome.jsp" target="adminArea">Home</a></h3> -->
	
	<div class="menuButton">
	<form action="../servlet" target="customerArea">
		<div><button type="submit" value="Deposit" name="action">Deposit</button></div>
		<div><button type="submit" value="Withdraw" name="action">Withdraw</button></div>
		<div><button type="submit" value="Transfer" name="action">Transfer</button></div>
		<div><button type="submit" value="Transaction Details" name="action">Transaction Details</button></div>
		<div><button type="submit" value="Profile" name="action">Profile</button></div>
		<div><button type="submit" value="Change Password" name="action">Change Password</button></div>
	</form>
	
	<!-- <form action="../servlet" target="_parent">
		<div><button type="submit" value="Logout" name="action">Logout</button></div>
	</form> -->
	</div>

	<!-- <h2 style = text-align:center> Menu </h2>
	<form action="../servlet">
		<h4 style = text-align:center><a href = "CustomerHome.jsp" target = "customerArea">Home</a></h4>
	</form>
	<div>
		<div><a href = "Deposit.jsp" target = "customerArea">Deposit</a></div>
		<div><a href = "Deposit.jsp" target = "customerArea">Withdraw</a></div>
		<div><a href = "Transfer.jsp" target = "customerArea">Transfer</a></div>
		<div><a href = "TransactionDetails.jsp" target = "customerArea">Transaction Details</a></div>
		<div><a href = "CustomerDetails.jsp" target = "customerArea">Customer Details</a></div>
		<div><a href = "ChangePassword.jsp" target = "customerArea">Change Password</a></div>
		<div><a href = "LoginPage.jsp" target = "_parent">Logout</a></div>
	</div> -->

</body>
</html>
