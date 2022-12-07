<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Account</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/style/HomeStyle.css">
</head>
<body>
	<header class="header">
	<div class="positionf t-l-0">
		<h2 style="text-align: left; margin-left: 1%; margin-top: 0.5%;">Add New Account</h2>
	</div>
	</header>
	<form action="<%=request.getContextPath()%>/servlet" target="adminArea">
		<div class="card">

			<div>
				<label class="labelClass2"> <input class="inputClass2"
					type="tel" placeholder=" " name="id" maxlength=10 required>
					<span class="spanClass2">Customer ID<span style="color: red;">
							*</span></span></label>
			</div>

			<div style="margin-top: 13px">
				<label class="labelClass2"><select style="text-align: left; font-size: 14px;" 
					class="inputStyle w-77" id="AccType" name="accountType" required>
						<option value="">Account Type *</option>
						<option value="Savings">Savings</option>
						<option value="Salary">Salary</option>
						<option value="Current">Current</option>
						<option value="Loan">Loan</option>
						<option value="NRI account">NRI account</option>
				</select></label>
			</div>

			<div style="margin-top: 7px">
				<label class="labelClass2"><select style="text-align: left; font-size: 14px;" 
					class="inputStyle w-77" id="AccBranch" name="accountBranch" required>
						<option value="">Account Branch *</option>
						<option value="MADURAI">MADURAI</option>
						<option value="KARAIKUDI">KARAIKUDI</option>
						<option value="CHENNAI">CHENNAI</option>
						<option value="TRICHY">TRICHY</option>
				</select></label>
			</div>

			<div>
				<label class="labelClass2"> <input class="inputClass2"
					type="tel" placeholder=" " name="balance" required> <span
					class="spanClass2">Balance<span style="color: red;"> *</span></span></label>
			</div>

			<div style="text-align: center;  margin-top: 13px">
				<button class="accept-button button" type="submit" name="action"
					value="newAccount">Add</button>
			</div>

		</div>
	</form>

	<h4 style="text-align: center; color: lime;">${ message }</h4>

</body>
</html>
