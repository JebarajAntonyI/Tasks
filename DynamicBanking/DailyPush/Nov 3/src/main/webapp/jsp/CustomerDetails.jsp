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

<%
	Customer customerPojo = (Customer) request.getAttribute("customer");
%>

<h2>Customer Details</h2>

<form action="<%= request.getContextPath() %>/servlet">
	<table style = "width: 25%">
		<tr>
			<th>Customer Id</th>
			<td><input value="${ customer.getCustomerId() }" name="id" readonly></td>
		</tr>
		
		<tr>
			<th>Name</th>
			<td><input value="${ customer.getName() }" name="name" readonly></td>
		</tr>
		
		<tr>
			<th>DOB</th>
			<td><input value="${ customer.getDob() }" name="dob" readonly></td>
		</tr>
		
		<tr>
			<th>Mobile</th>
			<td><input type="tel" value="${ customer.getMobile() }" maxlength="10" name="mobile"><%-- ${ customerInfo.getMobile() } --%></td>
		</tr>
		
		<tr>
			<th>Email</th>
			<td><input type="email" value="${ customer.getEmail() }" name="mail"><%-- ${ customerInfo.getEmail() } --%></td>
		</tr>
		
		<tr>
			<th>Aadhar Number</th>
			<td><input value="${ customer.getAadhar() }" readonly></td>
		</tr>
		
		<tr>
			<th>PAN</th>
			<td><input value="${ customer.getPan() }" readonly></td>
		</tr>
	</table>
	
	<div>
		<button type = "submit" name="action" value="modifyUserDetails">Save</button>
	</div>
</form>

</body>
</html>