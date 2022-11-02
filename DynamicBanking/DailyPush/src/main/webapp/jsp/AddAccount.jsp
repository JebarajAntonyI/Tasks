<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Account</title>
<style type="text/css">
	body
	{
		background-color: #F5F5DC;
	}
</style>
</head>
<body>
	<form action="<%= request.getContextPath() %>/servlet" target="adminArea">
	<div class="newAccount">
	<table>
		<tr>
			<td><label for="id">Customer ID</label> &nbsp;</td>
			<td><input type="number" placeholder="Enter number" name="id" required></td>
		</tr>
		<tr>
			<td><label for="accountType">Account Type</label> &nbsp;</td>
			<td><input type="text" placeholder="Enter type" name="accountType" required></td>
		</tr>
		<tr>
			<td><label for="accountBranch">Account Branch</label> &nbsp;</td>
			<td><input type="text" placeholder="Enter branch" name="accountBranch" required></td>
		</tr>
		<tr>
			<td><label for="ifsc">Account IFSC</label> &nbsp;</td>
			<td><input type="text" placeholder="Enter IFSC" name="ifsc" required></td>
		</tr>
		<tr>
			<td><label for="balance">Account Balance</label> &nbsp;</td>
			<td><input type="number" placeholder="Enter balance" name="balance" required></td>
		</tr>
	</table>
	</div>
	<div>
		<button type="submit" name="action" value="newAccount">Submit</button>
		<a href="jsp/AdminHome.jsp"><button>Back</button></a>
	</div>
	</form>
	
	<h4 style="text-align: center; color: lime;">${ message }</h4>

</body>
</html>
