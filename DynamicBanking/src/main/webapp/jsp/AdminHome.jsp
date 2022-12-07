<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/style/HomeStyle.css">
<body>

	<div>
		<!-- <h3 style="text-align: center; padding-top: 40px;">Profile</h3> -->
	</div>
	<div class="tables bgNone">
		<table style="margin-top: 15%; width: 30%" class="formTable">
			<tr>
				<th style="text-align: left;">Customer Id</th>
				<td><input class="inputStyle bgNone"
					value="${ userPojo.getUserId() }" name="id" readonly></td>
			</tr>

			<tr>
				<th style="text-align: left;">Name</th>
				<td><input class="inputStyle bgNone"
					value="${ userPojo.getName() }" name="name" readonly></td>
			</tr>

			<tr>
				<th style="text-align: left;">DOB</th>
				<td><input class="inputStyle bgNone" type="date"
					value="${ userPojo.getDob() }" name="dob" readonly></td>
			</tr>

			<tr>
				<th style="text-align: left;">Mobile</th>
				<td><input class="inputStyle bgNone" type="tel"
					value="${ userPojo.getMobile() }" maxlength="10" name="mobile"
					readonly></td>
			</tr>

			<tr>
				<th style="text-align: left;">Email</th>
				<td><input class="inputStyle bgNone" type="email"
					value="${ userPojo.getEmail() }" name="mail" readonly></td>
			</tr>
		</table>
	</div>

</body>
</html>
