<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
<p><input type="number" name="uid" placeholder="Enter User Id">${ uid }</p>
	<button type = "submit" name="action" value="getAccountList">Submit</button>
	<%-- <h4>Choose one Account: </h4>
	<select id = "Acc No" name = "accountNo">
			<c:forEach var = "account" items = "${ customerAccounts }" >
				<option value = "${ account }">${ account }</option>
			</c:forEach>
	</select> --%>
<table>
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
	<button type = "submit" name="action" value="showAdminTransaction">Submit</button>
</div>
</form>

<h3 style="text-align: center; color: blue">Selected Account: ${ accountNo }</h3>
<table style = "width:100%">
	<tr>
		<th> Transaction ID </th>
		<th> Primary Account </th>
		<th> Secondary Account </th>
		<th> Transaction Time </th>
		<th> Mode of Transaction </th>
		<th> Transaction Type </th>
		<th> Amount </th>
		<th> Closing Balance </th>
		<th> Transaction Status </th>
	</tr>
	<c:forEach var = "Transaction" items = "${ transactionList }" >
	<jsp:useBean id="myDate" class="java.util.Date"/>
    <c:set target="${myDate}" property="time" value="${ Transaction.getTransactionTime() }"/>
	<tr>
		<td>${ Transaction.getTransactionId() }</td>
		<td>${ Transaction.getPrimaryAccount() }</td>
		<td>${ Transaction.getSecondaryAccount() }</td>
		<%-- <td>${ Transaction.getTransactionTime() }</td> --%>
		<td><fmt:formatDate value="${myDate}"  pattern="dd-MM-yyyy  HH:mm:ss"/></td>
		<td>${ Transaction.getModeOfTransaction() }</td>
		<td>${ Transaction.getTransactionType() }</td>
		<td>${ Transaction.getAmount() }</td>
		<td>${ Transaction.getClosingBalance() }</td>
		<td>${ Transaction.getTransactionStatus() }</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>
