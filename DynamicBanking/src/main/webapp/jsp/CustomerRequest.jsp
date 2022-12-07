
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page
	import="java.util.List, java.util.ArrayList, com.banking.pojo.Account"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Request</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/style/HomeStyle.css">
<style type="text/css">
.column {
	float: left;
	width: 45%;
	padding: 0 10px;
}

/* Remove extra left and right margins, due to padding */
.row {
	margin: 0 -1px;
	margin-left: 5%;
	margin-top: 10%;
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}

/* Responsive columns */
@media screen and (max-width: 600px) {
	.column {
		width: 100%;
		display: block;
		margin-bottom: 20px;
	}
}

/* Style the counter cards */
.card2 {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	margin-bottom: 10vh;
	height: 200px;
	padding: 16px;
	padding-top: 50px;
	padding-bottom: 50px;
	text-align: center;
	background-color: #D0E1F9;
	border-radius: 10px;
}
</style>
</head>
<body>
	<header class="header">
		<div class="positionf t-l-0">
			<h2 style="text-align: left; margin-left: 1%; margin-top: 1%;">Account
				Request</h2>
		</div>
	</header>

	<div class="row">
		<div class="column">
			<div style="" class="card2">
				<h4 style="text-align: center;">De-Activation Request</h4>
				<form action="<%=request.getContextPath()%>/servlet">

					<div>
						<label class="labelClass2"><select class="inputStyle w-75"
							id="Acc No" name="accountNo" required>
								<option value="">Active Accounts</option>
								<c:forEach var="account" items="${ accountList }">
									<option value="${ account }">${ account }</option>
								</c:forEach>
						</select></label>
					</div>

					<div style="text-align: center; padding-top: 5%;">
						<button class="button accept-button" type="submit"
							value="requestDeactivation" name="action">Request
							Deactivation</button>
					</div>

				</form>
			</div>
		</div>

		<c:if test="${ inactiveAccounts.isEmpty() == false }">
			<div class="column">
				<div class="card2">
					<h4 style="text-align: center;">Activation Account Request</h4>
					<form action="<%=request.getContextPath()%>/servlet">

						<div>
							<label class="labelClass2"><select
								class="inputStyle w-75" id="Acc No" name="accountNo" required>
									<option value="">Inactive Accounts</option>
									<c:forEach var="account" items="${ inactiveAccounts }">
										<option value="${ account }">${ account }</option>
									</c:forEach>
							</select></label>
						</div>

						<div style="text-align: center; padding-top: 5%;">
							<button class="button accept-button" type="submit"
								value="requestActivation" name="action">Request
								Activation</button>
						</div>

					</form>
				</div>
			</div>
		</c:if>
	</div>
	<h3 style="text-align: center; color: green;">${ message }</h3>
</body>
</html>
