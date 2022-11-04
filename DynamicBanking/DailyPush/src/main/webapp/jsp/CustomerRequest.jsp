<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deposit</title>
<style type="text/css">
.deposit
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
	<div>
	<table>
		<tr>
			<th><label for = "Account No"> Choose Account: </label></th>
			<td><select id = "Acc No" name = "accountNo">
					<c:forEach var = "account" items = "${ accountList }" >
						<option value = "${ account }">${ account }</option>
					</c:forEach>
			</select></td>
		</tr>
	</table>
	</div>
	
	<div>
		<button type = "submit" value="requestDeactivation" name="action">Request Deactivation</button>
	</div>
	</form>
	
	<form action="<%= request.getContextPath() %>/servlet">
	<div>
	<table>
		<tr>
			<th><label for = "Account No"> Choose Account: </label></th>
			<td><select id = "Acc No" name = "accountNo">
					<c:forEach var = "account" items = "${ inactiveAccounts }" >
						<option value = "${ account }">${ account }</option>
					</c:forEach>
			</select></td>
		</tr>
	</table>
	</div>
	
	<div>
		<button type = "submit" value="requestActivation" name="action">Request Activation</button>
	</div>
	<h3 style = "text-align: center; color: green;">${ message }</h3>
	</form>
	
</body>
</html>
