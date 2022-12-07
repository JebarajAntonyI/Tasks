<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account Details</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/style/HomeStyle.css">
</head>
<body>
	<h4 style="color: red;">${ message }</h4>
	<c:if test="${ message == null }">
	<header class="header">
	<div class="positionf t-l-0">
	<h2 style="text-align: left; margin-left: 1%; margin-top: 1%;">Account Details</h2>
	</div>
	</header>
	
	<div class="tables">
		<table>
			<tr style="background-color: #283655; color: white;">
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

			<c:forEach var="account" items="${ account }">
				<tr>
					<td>${ account.value.getAccountNo() }</td>
					<td>${ account.value.getAccountType() }</td>
					<td>${ account.value.getAccountBranch() }</td>
					<td>${ account.value.getIfsc() }</td>
					<td>${ account.value.getBalance() }</td>
					<td>${ account.value.getAccountStatus() }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	</c:if>
</body>
</html>