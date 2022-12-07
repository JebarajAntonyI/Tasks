<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page
	import="java.util.ArrayList, java.util.List, java.util.Map, java.util.HashMap, com.banking.pojo.Account, 
com.banking.pojo.Transaction, com.banking.methods.CustomerMethods"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transaction Page</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/style/HomeStyle.css">
</head>
<body>

	<header class="header">
		<div class="sameGrid3 positionf t-l-0">
			<div>
				<h2 style="text-align: left; margin-top: 3%; margin-left: 5%;">Account
					Details</h2>
			</div>
			<div>
				<form action="<%=request.getContextPath()%>/servlet"
					target="userArea">
					<button style="width: 15%" class="button accept-button"
						type="submit" value="View All Account" name="action">All
						Account</button>
				</form>
			</div>
		</div>
	</header>

	<div class="positionf t-l-10">
		<form style="margin-left: 0.5%;"
			action="<%=request.getContextPath()%>/servlet" target="userArea">
			<div>
				<input style="width: 14%;" class="userIdInput" type="number"
					value="${ id }" name="id" min="1" max="1300000000000"
					placeholder="Customer Id or Account Number" required>
				<button style="margin-left: 0.9%; width: 13%;"
					class="button accept-button" type="submit" name="action"
					value="AdminaccountDetails">Search</button>


			</div>
		</form>
	</div>

	<iframe
		style="background-color: #DFE8FB; border: none; margin-top: 3%;"
		width="100%" height="710" name="userArea"></iframe>

</body>
</html>
