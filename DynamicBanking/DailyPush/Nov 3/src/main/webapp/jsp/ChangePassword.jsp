<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Password</title>
<style type="text/css">
	.pass
	{
		text-align: center;
	}
	body
	{
		background-color: #F5F5DC;
	}
	button
	{
		text-align: center;
	}
</style>
</head>
<body>
	<h3 style="text-align: center; color: purple;">${ message }</h3>
	<form action="<%= request.getContextPath() %>/servlet" method="post">
	<div class = "pass">
		<table>
			<tr>
				<td><label for="oldPassword"><b>Old Password</b></label></td>
				<td><input type="password" placeholder="Enter Old Password" name="oldPassword"></td>
			</tr>
			<tr>
				<td><label for="newPassword"><b>New Password</b></label></td>
				<td><input type="password" placeholder="Enter New Password" name="newPassword"></td>
			</tr>
			<tr>
				<td><label for="confirmPassword"><b>Confirm Password</b></label></td>
				<td><input type="password" placeholder="Re Enter Password" name="confirmPassword"></td>
			</tr>
		</table>
	</div>
	
	<div>
		<button type="submit" value="passChange" name="action">Submit</button>
	</div>
	</form>
</body>
</html>