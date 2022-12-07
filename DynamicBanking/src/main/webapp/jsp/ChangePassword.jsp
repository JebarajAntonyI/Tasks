<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Password</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/style/HomeStyle.css">
</head>
<body>
	<h3 style="text-align: center; color: purple;">${ message }</h3>
	<form action="<%=request.getContextPath()%>/servlet" method="post">
		<div class="card w-40">

			<div>
				<label class="labelClass2"><input class="inputClass2"
					type="text" placeholder=" " name="oldPassword" required><span
					class="spanClass2">Old Password<span style="color: red;">
							*</span></span></label>
			</div>


			<div>
				<label class="labelClass2"><input class="inputClass2"
					type="text" placeholder=" " name="newPassword" required><span
					class="spanClass2">New Password<span style="color: red;">
							*</span></span></label>
			</div>


			<div>
				<label class="labelClass2"><input class="inputClass2"
					type="password" placeholder=" " name="confirmPassword" required><span
					class="spanClass2">Re-Enter Password<span
						style="color: red;"> *</span></span></label>
			</div>

			<div style="text-align: center">
				<button class="accept-button button" type="submit"
					value="passChange" name="action">Submit</button>
			</div>

		</div>
	</form>
</body>
</html>