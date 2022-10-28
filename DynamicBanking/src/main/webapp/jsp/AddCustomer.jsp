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
	
	<div class="add">
	<table>
		<tr>
			<td><label for="name"><b>Customer Name</b></label> &nbsp;</td>
			<td><input type="text" placeholder="Enter Name" name="name" required></td>
		</tr>
		<tr>
			<td><label for="mobile"><b>Mobile Number</b></label> &nbsp;</td>
			<td><input type="number" placeholder="Enter Mobile " name="mobile" required></td>
		</tr>
		<tr>
			<td><label for="email"><b>Email ID</b></label> &nbsp;</td>
			<td><input type="email" placeholder="Enter email" name="email" required></td>
		</tr>
		<tr>
			<td><label for="dob"><b>Date Of Birth</b></label> &nbsp;</td>
			<td><input type="date" placeholder="Enter dob" name="dob" required></td>
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
			<td><label for="user"><b>User Type</b></label> &nbsp;</td>
			<td><input type="text" placeholder="Enter Type" name="user" required></td>
		</tr>
		<tr>
			<td><label for="address"><b>Address</b></label> &nbsp;</td>
			<td><input type="text" placeholder="Enter Address" name="address" required></td>
		</tr>
		<tr>
			<td><label for="pass"><b>Password</b></label> &nbsp;</td>
			<td><input type="password" placeholder="Enter initial password" name="pass" required></td>
		</tr>
	</table>
	</div>
	<div>
		<button type="submit">Submit</button>
		<a href="AdminHome.jsp"><button>Back</button></a>
	</div>

</body>
</html>
