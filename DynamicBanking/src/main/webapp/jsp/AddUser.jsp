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
		<h2 style="text-align: left; margin-left: 1%; margin-top: 0.5%;">Add New User</h2>
	</div>
	</header>
	<form action="<%=request.getContextPath()%>/servlet" target="adminArea">
		<div class="card">

			<div>
				<label class="labelClass2"> <input class="inputClass2"
					type="text" placeholder=" " name="name" required> <span
					class="spanClass2">Name<span style="color: red;"> *</span></span></label>
			</div>

			<div>
				<label class="labelClass2"> <input class="inputClass2"
					type="tel" placeholder="  " name="mobile" maxlength=10
					pattern="^[6-9][0-9]{9}" required> <span class="spanClass2">Mobile<span
						style="color: red;"> *</span></span></label>
			</div>

			<div>
				<label class="labelClass2"> <input class="inputClass2"
					type="email" placeholder=" " name="email"
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
				<label class="userAccountSel"><select style="text-align: left; font-size: 14px;" 
					class="inputStyle w-77" id="User" name="userType" required>
						<option value="">User Type *</option>
						<option value="Customer">Customer</option>
						<option value="ADMIN">ADMIN</option>
				</select></label>
			</div>

			<div>
				<label class="labelClass2"> <input class="inputClass2"
					type="password" placeholder=" " name="pass" required> <span
					class="spanClass2">Password<span style="color: red;"> *</span></span></label>
			</div>

			<div style="text-align: center; margin-top: 13px">
				<button class="accept-button button" type="submit" name="action"
					value="newUser">Add</button>
			</div>

		</div>

	</form>

	<h4 style="text-align: center; color: lime;">${ message }</h4>
</body>
</html>
