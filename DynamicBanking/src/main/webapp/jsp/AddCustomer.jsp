<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Customer</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/style/HomeStyle.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
<link rel="stylesheet"
	href="node_modules/mdbootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="node_modules/mdbootstrap/css/mdb.min.css">
<link rel="stylesheet" href="node_modules/mdbootstrap/css/style.css">
</head>
<body>
	<header class="header">
	<div class="positionf t-l-0">
		<h2 style="text-align: left; margin-left: 1%; margin-top: 0.5%;">Add New Customer</h2>
	</div>
	</header>
	<form action="<%=request.getContextPath()%>/servlet" target="adminArea">
		<div style="margin-top: 1%;" class="card">

			<div>
				<label class="labelClass2"> <input class="inputClass2"
					type="text" placeholder=" " name="name" required> <span
					class="spanClass2">Name<span style="color: red;"> *</span></span></label>
			</div>

			<div>
				<label class="labelClass2"> <input class="inputClass2"
					type="tel" placeholder=" " name="mobile" maxlength=10
					pattern="^[6-9][0-9]{9}" required> <span class="spanClass2">Mobile<span
						style="color: red;"> *</span></span></label>
			</div>

			<div>
				<label class="labelClass2"> <input class="inputClass2"
					type="text" placeholder=" " name="email"
					pattern="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9-]+.[a-zA-Z]+$" required>
					<span class="spanClass2">Email<span style="color: red;">
							*</span></span></label>
			</div>

			<div>
				<label class="labelClass2"> <input
					class="inputClass2 textbox-n" type="text"
					onfocus="(this.type='date')" placeholder="DOB *" name="dob"
					id="date" required></label>
			</div>

			<div>
				<label class="labelClass2"> <input class="inputClass2"
					type="tel" placeholder=" " name="aadhar" maxlength=12
					pattern="^[1-9][0-9]{11}" required> <span class="spanClass2">Aadhaar<span
						style="color: red;"> *</span></span></label>
			</div>

			<div>
				<label class="labelClass2"> <input class="inputClass2"
					type="text" placeholder=" " name="pan"
					pattern="[A-Z]{5}[0-9]{4}[A-Z]{1}" required> <span
					class="spanClass2">Pan<span style="color: red;"> *</span></span></label>
			</div>

			<div>
				<input type="hidden" value="Customer" name="userType" readonly>
			</div>

			<div>
				<label class="labelClass2"> <input class="inputClass2"
					type="text" placeholder=" " name="address" required> <span
					class="spanClass2">Address<span style="color: red;">
							*</span></span></label>
			</div>

			<div>
				<label class="labelClass2"> <input class="inputClass2"
					type="password" placeholder=" " name="pass" required> <span
					class="spanClass2">Initial Password<span style="color: red;">
							*</span></span></label>
			</div>

			<div style="text-align: center; margin-top: 13px">
				<button class="accept-button button" type="submit" name="action"
					value="newCustomer">Add</button>
			</div>

		</div>

	</form>

	<h4 style="text-align: center; color: lime;">${ message }</h4>
</body>
</html>
