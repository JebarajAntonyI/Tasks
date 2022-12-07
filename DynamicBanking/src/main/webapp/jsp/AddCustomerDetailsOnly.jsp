<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Customer</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/style/HomeStyle.css">
</head>
<body>
	<header class="header">
	<div class="positionf t-l-0">
	<h2 style="text-align: left; margin-left: 1%; margin-top: 0.5%;">Add Customer Details</h2>
	</div>
	</header>
	<form action="<%=request.getContextPath()%>/servlet" target="adminArea">
		<div class="card">

			<div>
				<label class="labelClass2"> <input class="inputClass2"
					type="tel" placeholder=" " name="id" required> <span
					class="spanClass2">Customer Id<span style="color: red;">
							*</span></span></label>
			</div>

			<div>
				<label class="labelClass2"> <input class="inputClass2"
					type="tel" placeholder=" " name="aadhar" maxlength=12
					pattern="^[0-9]{12}" required> <span class="spanClass2">Aadhar<span
						style="color: red;"> *</span></span></label>
			</div>

			<div>
				<label class="labelClass2"> <input class="inputClass2"
					type="text" placeholder=" " name="pan"
					pattern="[A-Z]{5}[0-9]{4}[A-Z]{1}" required> <span
					class="spanClass2">Pan<span style="color: red;"> *</span></span></label>
			</div>

			<div>
				<label class="labelClass2"> <input class="inputClass2"
					type="text" placeholder=" " name="address" required> <span
					class="spanClass2">Address<span style="color: red;"> *</span></span></label>
			</div>

			<div style="margin-top: 13px">
				<button class="accept-button button" type="submit" name="action"
					value="newCustomerDetails">Add</button>
			</div>


		</div>
	</form>

	<h4 style="text-align: center; color: lime;">${ message }</h4>
</body>
</html>
