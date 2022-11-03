<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList, java.util.List, 
com.banking.pojo.Transaction, com.banking.methods.CustomerMethods" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transaction Page</title>
<style type="text/css">
	table
	{
		margin-left: auto;
		margin-right: auto;
		width:100%;
	}
	table, th, td
	{
		text-align: center;
		border: 2px solid rgb(46, 52, 54);
		border-collapse: collapse;
		border-style: groove;
		padding: 10px;
	}
	body
	{
		background-color: #F5F5DC;
	}
</style>
</head>
<body>
<h1 style="text-align:center;"> Transaction Details Page </h1>

<form action="<%= request.getContextPath() %>/servlet">
<p><input type="number" name="id" placeholder="Enter User Id"></p>
	<button type = "submit" name="action" value="accountDetails">Submit</button>
	<%-- <h4>Choose one Account: </h4>
	<select id = "Acc No" name = "accountNo">
			<c:forEach var = "account" items = "${ customerAccounts }" >
				<option value = "${ account }">${ account }</option>
			</c:forEach>
	</select> --%>
<%-- <table>
		<tr>
			<th><label for = "Account No"> Choose one Account: </label></th>
			<td><select id = "Acc No" name = "accountNo">
					<c:forEach var = "account" items = "${ customerAccounts }" >
						<option value = "${ account }">${ account }</option>
					</c:forEach>
			</select></td>
		</tr>
</table>
<div>
	<button type = "submit" name="action" value="accountDetails">Submit</button>
</div> --%>
</form>

<%-- <h3 style="text-align: center; color: blue">Selected Account: ${ accountNo }</h3> --%>
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
</table>

</body>
</html>
