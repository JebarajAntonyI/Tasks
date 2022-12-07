<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Accounts</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/style/HomeStyle.css">
<style type="text/css">
.hide {
	visibility: hidden;
	display: none;
}

.tables th {
	font-size: 18px;
	position: sticky;
	top: 4%;
	background-color: #283655;
	color: white;
}
</style>
</head>
<body>
	<header class="header">
		<h2 style="text-align: left; margin-top: 2%;">All Accounts</h2>
	</header>

	<div class="${ show }">
		<div class="tables">
			<table>
				<tr style="background-color: #283655; color: white;">
					<th>Customer Id</th>
					<th>Account Number</th>
					<th>Type</th>
					<th>Branch</th>
					<th>IFSC</th>
					<th>Balance</th>
					<th>Status</th>
				</tr>

				<c:forEach var="account" items="${ accountList }">
					<tr>
						<td>
							<form action="<%=request.getContextPath()%>/servlet"
								target="adminArea">
								<input class="userId" type="submit"
									value="${ account.getCustomerId() }" name="id" readonly>
								<input type="hidden" value="accountDetails" name="action">
							</form>
						</td>

						<td>
							<form action="<%=request.getContextPath()%>/servlet"
								target="adminArea">
								<input class="userId" type="submit"
									value="${ account.getAccountNo() }" name="accountNo" readonly>
								<input type="hidden" value="7" name="days">
								<input type="hidden" value="showTransaction" name="action">
							</form>
						</td>

						<td>${ account.getAccountType() }</td>
						<td>${ account.getAccountBranch() }</td>
						<td>${ account.getIfsc() }</td>
						<td>${ account.getBalance() }</td>
						<td>${ account.getAccountStatus() }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>



	<%-- <c:if test="${ accountMap != null }">
		<div class="tables">
			<table>
				<tr style="background-color: #4C7197; color: white;">
					<th>Account No</th>
					<th>Type</th>
					<th>Branch</th>
					<th>IFSC</th>
					<th>Balance</th>
					<th>Status</th>
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
		</div>
	</c:if> --%>

</body>
</html>















