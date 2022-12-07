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
			<h2 style="text-align: left; margin-left: 1%; margin-top: 0.5%;">Block/Un-Block Customer</h2>
		</div>
	</header>
	<form action="<%=request.getContextPath()%>/servlet">
		<div style="margin-top: 15%;" class="card">

			<div>
				<label class="labelClass2"><input class="inputClass2"
					type="tel" placeholder=" " name="cid" min=1 required><span
					class="spanClass2">Customer ID<span style="color: red;"> *</span></span></label>
			</div>
			
			<div>
				<label class="labelClass2"><select class="inputStyle w-77"
					id="Acc No" name="status" required>
						<option value="">Select Status</option>
							<option value="ACTIVE">ACTIVATE</option>
							<option value="INACTIVE">DE-ACTIVATE</option>
				</select></label>
			</div>

			<div style="text-align: center">
				<button class="accept-button button" type="submit"
					value="modifyCustomerStatus" name="action">Submit</button>
			</div>

		</div>
		<h3 style="text-align: center; color: green;">${ greenMessage }</h3>
		<h3 style="text-align: center; color: red;">${ redMessage }</h3>
	</form>
</body>
</html>
