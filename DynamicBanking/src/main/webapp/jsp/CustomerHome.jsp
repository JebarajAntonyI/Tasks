<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Home Page</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/style/HomeStyle.css">
</head>

<style type="text/css">
body {
	background-image:
		url("<%=request.getContextPath()%>/images/customerHome.jpg");
	background-size: cover;
	background-repeat: no-repeat;
}
</style>

<body>
	<c:if test="${ accountMap != null }">
		<div class="tables"
			style="margin-left: auto; margin-right: auto; margin-top: 17%;">
			<table>
				<tr style="background-color: #283655; color: white;">
					<th>Account No</th>
					<th>Type</th>
					<th>Status</th>
				</tr>
				<c:forEach var="account" items="${ accountMap }">
					<tr>
						<td>${ account.key }</td>
						<td>${ account.value.getAccountType() }</td>
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
