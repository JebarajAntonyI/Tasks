<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> User Login Page </title>
<link rel="stylesheet" type="text/css" href="../style/LoginStyle.css">
</head>

<body>
<div class="loginBody">
	<div>
		<h1 style="text-align:center;"> JOVIZ BANK </h1>
	</div>
	<div>
		<h2 style="text-align:center;"> User Login </h2>
	</div>
	
	<div class = "signin">
		<form action="../servlet" method="post">
		<table>
			<tr>
				<td><label for = "uid"> <b> User ID </b> </label></td>
				<td><input type = "number" placeholder = "Enter User ID" name = "uid" required></td>
			</tr>
			<tr>
				<td><label for = "psw"> <b> Password </b> </label></td>
				<td><input type = "password" placeholder = "Enter Password" name = "psw" required></td>
			</tr>
		</table>
		<div class="loginButton">
			<button type="submit" value="Login" name="action">Login</button>
		</div>
		</form>
		
		<!-- <div>
			<a href = "CustomerFrame.jsp"><button type = "submit">Customer Login</button></a>
			<a href = "AdminFrame.jsp"><button type = "submit">Admin Login</button></a>
		</div> -->
	</div>
</div>
</body>

</html>
