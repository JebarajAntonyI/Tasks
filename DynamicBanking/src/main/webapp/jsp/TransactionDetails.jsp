<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page
	import="java.util.ArrayList, java.util.List, 
com.banking.pojo.Transaction, com.banking.methods.CustomerMethods"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transaction Page</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/style/HomeStyle.css">
</head>
<body>
	<header class="header">
		<div class="sameGrid positionf t-l-0">
			<h2 style="text-align: left; margin-left: 5%; margin-top: 3.5%;">Transaction
				Details</h2>
			<form action="<%=request.getContextPath()%>/servlet">

				<select style="margin-left: 50px; width: 20%; margin-top: 1%;"
					class="inputStyle" id="Acc No" name="accountNo" required>
					<option value="">Select Account</option>
					<c:forEach var="account" items="${ accountList }">
						<option value="${ account }">${ account }</option>
					</c:forEach>
				</select> <select style="margin-left: 50px; width: 20%; margin-top: 1%;"
					class="inputStyle" id="Day" name="days" required>
					<option value="">Select Days</option>
					<option value="7">7</option>
					<option value="15">15</option>
					<option value="30">30</option>
				</select>
				<button style="margin-left: 30px;" class="button accept-button"
					type="submit" name="action" value="showTransaction">Submit</button>
			</form>
		</div>
	</header>
	<%
	long accountNo = 0;
	try {
		accountNo = (Long) request.getAttribute("accountNo");
	} catch (Exception e) {

	}
	if (accountNo != 0) {
	%>
	<h3 style="text-align: center; color: blue">${ days }Days
		Transaction Details for Account ${ accountNo }</h3>
	<div class="tables">


		<table>
			<tr style="background-color: #283655; color: white;">
				<th>ID</th>
				<th>Primary Account</th>
				<th>Secondary Account</th>
				<th>Time</th>
				<th>Mode</th>
				<th>Type</th>
				<th>Amount</th>
				<th>Closing Balance</th>
				<th>Status</th>
			</tr>
			<c:forEach var="Transaction" items="${ transactionList }">
				<jsp:useBean id="myDate" class="java.util.Date" />
				<c:set target="${myDate}" property="time"
					value="${ Transaction.getTransactionTime() }" />
				<tr>
					<td>${ Transaction.getTransactionId() }</td>
					<td>${ Transaction.getPrimaryAccount() }</td>
					<td>${ Transaction.getSecondaryAccount() }</td>
					<%-- <td>${ Transaction.getTransactionTime() }</td> --%>
					<td><fmt:formatDate value="${myDate}"
							pattern="dd-MM-yyyy  HH:mm:ss" /></td>
					<td>${ Transaction.getModeOfTransaction() }</td>
					<td>${ Transaction.getTransactionType() }</td>
					<td>${ Transaction.getAmount() }</td>
					<td>${ Transaction.getClosingBalance() }</td>
					<td>${ Transaction.getTransactionStatus() }</td>
				</tr>
			</c:forEach>
		</table>
		<%} %>
	</div>
</body>
</html>


























