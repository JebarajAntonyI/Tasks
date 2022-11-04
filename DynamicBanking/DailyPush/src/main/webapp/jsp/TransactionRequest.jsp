<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
			</select></td>
		</tr>
</table>
<div>
	<button type = "submit" name="action" value="showTransactionRequest">Submit</button>
</div>
</form>
<form action="<%= request.getContextPath() %>/servlet" target="adminArea">
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
		<jsp:useBean id="reqDate" class="java.util.Date"/>
    	<c:set target="${reqDate}" property="time" value="${ pending.value.getRequestTime() }"/>
		<tr>
			<td><input value="${ pending.key }" name="reqNo" readonly></td>
			<td>${ pending.value.getCustomerId() }</td>
			<td>${ pending.value.getAccountNo() }</td>
			<td>${ pending.value.getRequestFor() }</td>
			<td><fmt:formatDate value="${reqDate}"  pattern="dd-MM-yyyy  HH:mm:ss"/></td>
			<td style="text-align: center">-</td>
			<%-- <td>${ pending.value.getRequestTime() }</td>
			<td>${ pending.value.getVerifiedTime() }</td> --%>
			<td>${ pending.value.getAmount() }</td>
			<td>${ pending.value.getStatus() }</td>
			<td>
				<button type="submit" value="ApprovedTransaction" name="action">Approve</button>
				<button type="submit" value="RejectedTransaction" name="action">Reject</button>
			</td>
		</tr>
		</c:forEach>
		<c:forEach var = "status" items = "${ statusMap }" >
		<jsp:useBean id="reqDate1" class="java.util.Date"/>
		<jsp:useBean id="verDate1" class="java.util.Date"/>
		<c:set target="${reqDate1}" property="time" value="${ status.value.getRequestTime() }"/>
 	    <c:set target="${verDate1}" property="time" value="${ status.value.getVerifiedTime() }"/>
		<tr>
			<td>${ status.key }</td>
			<td>${ status.value.getCustomerId() }</td>
			<td>${ status.value.getAccountNo() }</td>
			<td>${ status.value.getRequestFor() }</td>
			<td><fmt:formatDate value="${reqDate1}"  pattern="dd-MM-yyyy  HH:mm:ss"/></td>
			<td><fmt:formatDate value="${verDate1}"  pattern="dd-MM-yyyy  HH:mm:ss"/></td>
			<%-- <td>${ status.value.getRequestTime() }</td>
			<td>${ status.value.getVerifiedTime() }</td> --%>
			<td>${ status.value.getAmount() }</td>
			<td>${ status.value.getStatus() }</td>
		</tr>
		</c:forEach>
	</table>
</form>


</body>
</html>
