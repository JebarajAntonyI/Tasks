<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transaction Request</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/style/TableStyle.css">
<!-- <style type="text/css">
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
h1
{
	margin-top: 300px;
}
</style>
 --></head>
<body>



<form action="<%= request.getContextPath() %>/servlet">
<table>
		<tr>
			<th><label for = "Account No"> Choose Type of Request: </label></th>
			<td><select id = "Acc No" name = "reqType">
					<option value = "Pending">Pending</option>
					<option value = "Approved">Approved</option>
					<option value = "Rejected">Rejected</option>
					<%-- <c:forEach var = "account" items = "${ accountList }" >
						<option value = "${ account }">${ account }</option>
					</c:forEach> --%>
			</select></td>
		</tr>
</table>
<div>
	<button type = "submit" name="action" value="showTransactionRequest">Submit</button>
</div>
</form>

	<table style="width:100%">
		<tr>
			<th>Request No</th>
			<th>Customer ID</th>
			<th>Account Number</th>
			<th>Request Type</th>
			<th>Request Time</th>
			<th>Verified Time</th>
			<th>Amount</th>
			<th>Status</th>
		</tr>
		
		<c:forEach var = "pending" items = "${ requestMap }" >
		<tr>
			<form action="<%= request.getContextPath() %>/servlet" target="adminArea">
			<td><input value="${ pending.value.getRequestNumber() }" name="reqNo"></td>
			<td>${ pending.value.getCustomerId() }</td>
			<td>${ pending.key }</td>
			<td>${ pending.value.getRequestFor() }</td>
			<td>${ pending.value.getRequestTime() }</td>
			<td>${ pending.value.getVerifiedTime() }</td>
			<td>${ pending.value.getAmount() }</td>
			<td>${ pending.value.getStatus() }</td>
			<td>
				<button type="submit" value="ApprovedTransaction" name="action">Approve</button>
				<button type="submit" value="RejectedTransaction" name="action">Reject</button>
			</td>
			</form>
		</tr>
		</c:forEach>
		<c:forEach var = "status" items = "${ statusMap }" >
		<tr>
			<td>${ status.value.getRequestNumber() }</td>
			<td>${ status.value.getCustomerId() }</td>
			<td>${ status.key }</td>
			<td>${ status.value.getRequestFor() }</td>
			<td>${ status.value.getRequestTime() }</td>
			<td>${ status.value.getVerifiedTime() }</td>
			<td>${ status.value.getAmount() }</td>
			<td>${ status.value.getStatus() }</td>
		</tr>
		</c:forEach>
	</table>


</body>
</html>
