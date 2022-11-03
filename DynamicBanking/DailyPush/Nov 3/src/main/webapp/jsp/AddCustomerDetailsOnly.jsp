<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Customer</title>
<style type="text/css">
	body
	{
		background-color: #F5F5DC;
	}
</style>
</head>
<body>
	<form action="<%= request.getContextPath() %>/servlet" target="adminArea">
	<div class="add">
	<table>
		<tr>
			<td><label for="id"><b>Customer Id</b></label> &nbsp;</td>
			<td><input type="number" placeholder="Enter Id" name="id" required></td>
		</tr>
		<tr>
			<td><label for="aadhar"><b>Aadhar Number</b></label> &nbsp;</td>
			<td><input type="number" placeholder="Enter Aadhar" name="aadhar" required></td>
		</tr>
		<tr>
			<td><label for="pan"><b>PAN Number</b></label> &nbsp;</td>
			<td><input type="text" placeholder="Enter pan" name="pan" required></td>
		</tr>
		<tr>
			<td><label for="address"><b>Address</b></label> &nbsp;</td>
			<td><input type="text" placeholder="Enter Address" name="address" required></td>
		</tr>
	</table>
	</div>
	<div>
		<button type="submit" name="action" value="newCustomerDetails">Submit</button>
		<a href="jsp/AdminHome.jsp"><button>Back</button></a>
	</div>
	</form>
	
	<h4 style="text-align: center; color: lime;">${ message }</h4>
</body>
</html>
