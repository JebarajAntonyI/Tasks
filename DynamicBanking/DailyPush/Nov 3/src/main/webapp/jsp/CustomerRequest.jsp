<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Request</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/style/TableStyle.css">
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
 -->
</head>
<body>

	<form action="<%=request.getContextPath()%>/servlet">
		<table>
			<tr>
				<th><label for="Account No"> Choose Type of Request: </label></th>
				<td><select id="Acc No" name="reqType">
						<option value="Pending">Pending</option>
						<option value="Processed">Processed</option>
						<option value="Rejected">Rejected</option>
				</select></td>
			</tr>
		</table>
		<div>
			<button type="submit" name="action" value="showCustomerRequest">Submit</button>
		</div>
	</form>
	<form action="<%=request.getContextPath()%>/servlet"
		target="adminArea">
		<table>
			<tr>
				<th>Request Number</th>
				<th>Customer Id</th>
				<th>Account Number</th>
				<th>Request Message</th>
				<th>Request Status</th>
			</tr>

			<c:forEach var="pending" items="${ requestMap }">
				<tr>
					<td><input value="${ pending.key }" name="reqNo" readonly></td>
					<td>${ pending.value.getCustomerId() }</td>
					<td><input value="${ pending.value.getAccountNo() }"
						name="acNo" readonly></td>
					<td>${ pending.value.getRequestMessage() }</td>
					<td>${ pending.value.getRequestStatus() }</td>
					<td>
						<button type="submit" value="ActivateAccount" name="action">Activate</button>
						<button type="submit" value="DeactivateAccount" name="action">De
							Activate</button>
						<button type="submit" value="cancelCustomerRequest" name="action">Reject
							Request</button>
					</td>

				</tr>
			</c:forEach>
			<c:forEach var="status" items="${ statusMap }">
				<tr>
					<td><input value="${ status.key }" name="reqNo"></td>
					<td>${ status.value.getCustomerId() }</td>
					<td>${ status.value.getAccountNo() }</td>
					<td>${ status.value.getRequestMessage() }</td>
					<td>${ status.value.getRequestStatus() }</td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<!-- <div>
		<button>Save</button>
		<a href="jsp/AdminHome.jsp"><button>Back</button></a>
	</div> -->

</body>
</html>
