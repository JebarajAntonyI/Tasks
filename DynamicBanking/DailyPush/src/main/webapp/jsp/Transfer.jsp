<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transfer Page</title>
<style type="text/css">
	.transfer
	{
		text-align: left;
	}
	
	.button
	{
		text-align: left;
	}
	body
	{
		background-color: #F5F5DC;
	}
</style>
</head>
<body>
	<form action="<%= request.getContextPath() %>/servlet">
	<div class = "transfer">
	<table>
		<tr>
			<td><label for = "Account No"> <b> Choose Your Account: </b> </label></td>
			<td><select id = "Acc No" name = "accountNo">
					<c:forEach var = "account" items = "${ accountList }" >
							<option value = "${ account }">${ account }</option>
						</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td><label for = "toAccount"> <b> Receiver Account No: </b> </label></td>
			<td><input type = "number" placeholder = "Enter Receiver Account" name = "toAccount" required></td>
		</tr>
		<tr>
			<td><label for = "amount"> <b> Amount: </b> </label></td>
			<td><input type = "number" placeholder = "Enter Amount" name = "amount" required></td>
		</tr>
	</table>
	</div>
	
	<div class = "button">
		<button type = "submit" value="transferAmount" name="action">Submit</button>
	</div>
	<h3 style = "text-align: center; color: green;">${ message }</h3>
	</form>
	<div>
			<a href = "jsp/CustomerHome.jsp"><button type = "submit">Back</button></a>
	</div>
</body>
</html>
