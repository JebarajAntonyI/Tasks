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

	<div class = "transfer">
	<table>
		<tr>
			<td><label for = "Account No"> <b> Choose Your Account: </b> </label></td>
			<td><select id = "Acc No" name = "Acc No">
				<option>---Select---</option>
				<option value = "">712365478965</option>
				<option value = "">798654896321</option>
			</select></td>
		</tr>
		<tr>
			<td><label for = "to"> <b> Receiver Account No: </b> </label></td>
			<td><input type = "number" placeholder = "Enter Receiver Account" name = "to" required></td>
		</tr>
		<tr>
			<td><label for = "amount"> <b> Amount: </b> </label></td>
			<td><input type = "number" placeholder = "Enter Amount" name = "amount" required></td>
		</tr>
	</table>
	</div>
	
	<div class = "button">
		<button type = "submit">Submit</button>
		<a href = "CustomerHome.jsp"><button type = "submit">Back</button></a>
	</div>

</body>
</html>
