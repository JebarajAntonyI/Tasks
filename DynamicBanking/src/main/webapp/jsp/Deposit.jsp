<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deposit</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/style/HomeStyle.css">
</head>
<body>
	<header class="header">
		<div class="positionf t-l-0">
			<h2 style="text-align: left; margin-left: 1%; margin-top: 1%;">Deposit</h2>
		</div>
	</header>
	<form action="<%=request.getContextPath()%>/servlet">
		<div style="margin-top: 15%;" class="card">

			<div>
				<label class="labelClass2"><select class="inputStyle w-77"
					id="Acc No" name="accountNo" required>
						<option value="">Select Account</option>
						<c:forEach var="account" items="${ accountList }">
							<option value="${ account }">${ account }</option>
						</c:forEach>
				</select></label>
			</div>


			<div>
				<label class="labelClass2"><input class="inputClass2"
					type="number" placeholder=" " name="amount" min=1 required><span
					class="spanClass2">Amount<span style="color: red;"> *</span></span></label>
			</div>

			<div style="text-align: center">
				<button class="accept-button button" type="submit"
					value="depositAmount" name="action">Submit</button>
			</div>

		</div>
		<h3 style="text-align: center; color: green;">${ message }</h3>
	</form>
</body>
</html>
