<%@ page import="com.banking.pojo.Customer" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Details</title>
<style type="text/css">
	body
	{
		background-color: #F5F5DC;
	}
</style>
</head>
<body>

	<h4 style="text-align: center; color: green;">${ message }</h4>

<h2>User Details</h2>

<form action="<%= request.getContextPath() %>/servlet">
<p><input type="number" name="id" placeholder="Enter User Id" required></p>
	<button type = "submit" name="action" value="userDetails">Submit</button>
</form>

<form action="<%= request.getContextPath() %>/servlet">
	<table style = "width: 25%">
		<tr>
			<th>Customer Id</th>
			<td><input value="${ userPojo.getUserId() }" name="id"></td>
		</tr>
		
		<tr>
			<th>Name</th>
			<td><input value="${ userPojo.getName() }" name="name"></td>
		</tr>
		
		<tr>
			<th>DOB</th>
			<td><input value="${ userPojo.getDob() }" name="dob"></td>
		</tr>
		
		<tr>
			<th>Mobile</th>
			<td><input type="tel" value="${ userPojo.getMobile() }" maxlength="10" name="mobile"><%-- ${ customerInfo.getMobile() } --%></td>
		</tr>
		
		<tr>
			<th>Email</th>
			<td><input type="email" value="${ userPojo.getEmail() }" name="mail"><%-- ${ customerInfo.getEmail() } --%></td>
		</tr>
		
	</table>
	
	<div>
		<button type = "submit" name="action" value="modifyUserDetails">Save</button>
	</div>
</form>

</body>
</html>