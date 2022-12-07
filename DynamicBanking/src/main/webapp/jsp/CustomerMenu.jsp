<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Menu</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/style/Menu.css">
</head>
<body>

	<h2 style="text-align: left; margin-left: 15px; margin-top: 9%;"> Welcome ${ name } </h2><hr style="width: 100%; color: gray;">
	<form action="<%= request.getContextPath() %>/servlet" target="customerArea">
		<div class="menuButton"><button type="submit" value="Customer Home" name="action">Home</button></div>
	</form>
	
	<div class="menuButton">
	<form action="<%= request.getContextPath() %>/servlet" target="customerArea">
		<!-- <div><button type="submit" value="customerDetails" name="action">Profile</button></div> -->
		<div><button type="submit" value="accountDetails" name="action">Account Details</button></div>
		
		<!-- <div class="menuButton dropdown">
		  <button type="button" class="dropbtn">Transaction</button>
		  <div class="dropdown-content">
		    <button type="submit" value="Deposit" name="action">Deposit</button>
			<button type="submit" value="Withdraw" name="action">Withdraw</button>
			<button type="submit" value="Transfer" name="action">Transfer</button>
		  </div>
		</div> -->
		
		<div><button type="submit" value="Deposit" name="action">Deposit</button></div>
		<div><button type="submit" value="Withdraw" name="action">Withdraw</button></div>
		<div><button type="submit" value="Transfer" name="action">Transfer</button></div>
			
		<div><button type="submit" value="Transaction Details" name="action">Transaction Details</button></div>
		<!-- <div><button type="submit" value="Change Password" name="action">Change Password</button></div> -->
		
		<div><button type="submit" value="selectCustomerRequest" name="action">Account Request</button></div>
	</form>
	
	</div>

</body>
</html>
