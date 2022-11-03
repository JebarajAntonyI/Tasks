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
			<td><label for="name"><b>Customer Name</b></label> &nbsp;</td>
			<td><input type="text" placeholder="Enter Name" name="name" required></td>
		</tr>
		<tr>
			<td><label for="mobile"><b>Mobile Number</b></label> &nbsp;</td>
			<td><input type="tel" placeholder="Enter Mobile " name="mobile" maxlength=10 required></td>
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
			<td><label for="userType"><b>User Type</b></label> &nbsp;</td>
			<!-- <td><input type="text" placeholder="Enter Type" name="userType" required></td> -->
			<td><select id = "User" name = "userType" required>
				<option value="Customer">Customer</option>
				<option value="ADMIN">ADMIN</option>
			</select></td>
		</tr>
		<tr>
			<td><label for="pass"><b>Password</b></label> &nbsp;</td>
			<td><input type="password" placeholder="Enter initial password" name="pass" required></td>
		</tr>
	</table>
	</div>
	<div>
		<button type="submit" name="action" value="newUser">Submit</button>
		<a href="jsp/AdminHome.jsp"><button>Back</button></a>
	</div>
	</form>
	
	<h4 style="text-align: center; color: lime;">${ message }</h4>
</body>
</html>