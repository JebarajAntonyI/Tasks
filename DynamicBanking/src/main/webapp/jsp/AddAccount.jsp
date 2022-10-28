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
	
	<div class="newAccount">
	<table>
		<tr>
			<td><label for="accountNo">Account Number</label> &nbsp;</td>
			<td><input type="number" placeholder="Enter number" name="accountNo" required></td>
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
		<button type="submit">Submit</button>
		<a href="AdminHome.jsp"><button>Back</button></a>
	</div>

</body>
</html>
