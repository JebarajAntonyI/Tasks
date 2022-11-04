<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account Details</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/style/TableStyle.css">
<!-- <style type="text/css">
	button
	{
		text-align: center;
	}
	body
	{
		background-color: #F5F5DC;
	}
</style> -->
</head>
<body>

	<table style = "width:20%">
		<tr>
			<th>Account No</th>
			<th>Account Type</th>
			<th>Account Branch</th>
			<th>IFSC</th>
			<th>Account Balance</th>
			<th>Account Status</th>
		</tr>
		<c:forEach var="account" items="${ accountMap }">
		<tr>
			<td>${ account.key }</td>
			<td>${ account.value.getAccountType() }</td>
			<td>${ account.value.getAccountBranch() }</td>
			<td>${ account.value.getIfsc() }</td>
			<td>${ account.value.getBalance() }</td>
			<td>${ account.value.getAccountStatus() }</td>
		</tr>
		</c:forEach>
		
		<c:forEach var="account" items="${ account }">
		<tr>
			<td>${ account.getAccountNo() }</td>
			<td>${ account.getAccountType() }</td>
			<td>${ account.getAccountBranch() }</td>
			<td>${ account.getIfsc() }</td>
			<td>${ account.getBalance() }</td>
			<td>${ account.getAccountStatus() }</td>
		</tr>
		</c:forEach>
		<!-- 
		<tr>
			<td><b>Account No: </b></td>
			<td>712365478965</td>
		</tr>
		
		<tr>
			<td><b>Account Type: </b></td>
			<td>Savings</td>
		</tr>
		
		<tr>
			<td><b>Account Branch: </b></td>
			<td>MaduraiMain</td>
		</tr>
		
		<tr>
			<td><b>IFSC: </b></td>
			<td>ZIUB000008</td>
		</tr>
		
		<tr>
			<td><b>Account Balance: </b></td>
			<td>98500</td>
		</tr> -->
	</table>
	
</body>
</html>