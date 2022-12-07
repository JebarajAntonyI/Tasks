<%@ page import="com.banking.pojo.Customer"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Details</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/style/HomeStyle.css">
</head>
<body>

	<h4 style="text-align: center; color: green;">${ message }</h4>

	<header class="header"><h2 style="text-align: left">User Details</h2></header>

	<form action="<%=request.getContextPath()%>/servlet"
		target="userArea">
		<div class="sameLine">
			<input class="userIdInput w-15" type="tel" name="accountNo"
				placeholder="Account Number" required>
		<button class="button accept-button  w-15" type="submit" name="action"
			value="userDetails">User Details</button>
		<button class="button accept-button  w-15" type="submit" name="action"
			value="accountDetails">Account Details</button>
		<button class="button accept-button w-15" type="submit" name="action"
			value="Transaction Details">Transaction Details</button>
		<button class="button accept-button w-15" type="submit"
			value="customerDetails" name="action">Customer Documents</button>
		<button class="button accept-button w-15" type="submit"
			value="View All User" name="action">All User</button>
		</div>
	</form>

	<iframe style="border: none;" width="100%" height="710" name="userArea"></iframe>
</body>
</html>