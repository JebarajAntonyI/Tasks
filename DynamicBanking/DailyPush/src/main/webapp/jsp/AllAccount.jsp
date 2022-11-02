<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Accounts</title>
<style type="text/css">
	table
	{
		width: 100%;
		margin-left: auto;
		margin-right: auto;
	}
	table, th, td
	{
		border: 2px solid rgb(46, 52, 54);
		border-collapse: collapse;
		text-align: center;
		padding: 15px;
	}
	th
	{
		font-size: 18px;
	}
	body
	{
		background-color: #F5F5DC;
	}
</style>
</head>
<body>

	<table>
		<tr>
			<th>Customer Id</th>
			<th>Account Number</th>
			<th>Account Type</th>
			<th>Account Branch</th>
			<th>IFSC</th>
			<th>Balance</th>
			<th>Account Status</th>
		</tr>
		
		<c:forEach var="account" items="${ accountList }">
		<tr>
			<td>${ account.getCustomerId() }</td>
			<%-- <td>
				<form action="<%= request.getContextPath() %>/servlet" target="adminArea">
				<input value="${ account.getCustomerId() }" name="id" readonly>
				<button type="submit" value="accountDetails" name="action"></button>
				</form>
			</td> --%>
			<td>${ account.getAccountNo() }</td>
			<td>${ account.getAccountType() }</td>
			<td>${ account.getAccountBranch() }</td>
			<td>${ account.getIfsc() }</td>
			<td>${ account.getBalance() }</td>
			<td>${ account.getAccountStatus() }</td>
		</tr>
		</c:forEach>
		
		<!-- <tr>
			<td>2</td>
			<td>769878954516</td>
			<td>Savings</td>
			<td>Karaikudi</td>
			<td>ZIUB000045</td>
			<td>200000</td>
			<td>ACTIVE</td>
		</tr>
		
		<tr>
			<td>3</td>
			<td>712563987456</td>
			<td>Savings</td>
			<td>Chennai South</td>
			<td>ZIUB000097</td>
			<td>300000</td>
			<td>ACTIVE</td>
		</tr>
 -->	</table>
	<div>
		<a href="jsp/AdminHome.jsp"><button>Back</button></a>
	</div>

</body>
</html>















