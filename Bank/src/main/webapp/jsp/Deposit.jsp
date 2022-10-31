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
	<div class = "deposit">
	<table>
		<tr>
			<th><label for = "Account No"> Choose one Account: </label></th>
			<td><select id = "Acc No" name = "Acc No">
				<option>---Select---</option>
				<option value = "712365478965">712365478965</option>
				<option value = "798654896321">798654896321</option>
			</select></td>
		</tr>
		
		<tr>
			<td><label for = "amount"> <b> Amount: </b> </label></td>
			<td><input type = "number" placeholder = "Enter Amount" name = "amount" required></td>
		</tr>
	</table>
	</div>
	
	<div class = "button">
		<button type = "submit">Submit</button>
		<a href = "jsp/CustomerHome.jsp"><button type = "submit">Back</button></a>
	</div>
</body>
</html>
