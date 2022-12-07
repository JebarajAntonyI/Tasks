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

	<header class="header">
		<div class="sameGrid3 positionf t-l-0">
			<div>
				<h2 style="text-align: left; margin-top: 3%; margin-left: 5%;">User
					Details</h2>
			</div>
			<div style="margin-left: 0.5%;">
				<form action="<%=request.getContextPath()%>/servlet"
					target="userArea">
					<button style="width: 17.5%" class="button accept-button"
						type="submit" value="View All User" name="action">All
						User</button>
				</form>
			</div>
		</div>
	</header>


	<div class="positionf t-l-10">
		<form style="margin-left: 1%;"
			action="<%=request.getContextPath()%>/servlet" target="userArea">
			<input class="userIdInput w-15" type="number" name="id" min="1" max="100000"
				placeholder="Enter User ID" required>
			<button class="button accept-button  w-15" type="submit"
				name="action" value="userDetails">User Details</button>
			<button class="button accept-button  w-15" type="submit"
				name="action" value="accountDetails">Account Details</button>
			<!-- <button class="button accept-button w-15" type="submit" name="action"
				value="Transaction Details">Transaction Details</button> -->
			<button class="button accept-button w-15" type="submit"
				value="customerDetails" name="action">Customer Documents</button>
			<button class="button accept-button w-15" type="submit" name="action"
				value="getAccountList">Transaction Details</button>
		</form>
	</div>

	<iframe style="border: none; margin-top: 3%;" width="100%" height="710"
		name="userArea"></iframe>
</body>
</html>