<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Frame</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
.header {
	background-color: #204e7d;
	position: fixed;
	width: 100%;
	height: 92px;
}

body {
	margin: 0px;
	padding: 0px;
	border: none;
}

.adminMenuBody {
	/* background-color: #ebf5f4; */
	
}

.adminMenuBody iframe {
	margin-top: 92px;
}

.sidebar {
	position: fixed;
}

.mainContent {
	background-color: #ebf5f4;
	margin-left: 14%;
}

.dropbtn {
	/* background-color: #c52323;
	font-weight: 400;
	font-size: 18px;
	color: white;
	margin: 5px 0;
	border: none;
	cursor: pointer;
	width: 100px;
	height: 45px;
	border-radius:5px; */
	position: static;
	overflow: scroll;
}

.dropdown {
	position: inherit;
	display: inline;
	right: 2%;
	top: 20px;
}

.dropdown-content {
	display: none;
	position: inherit;
	background-color: white;
	right: 0px;
}

.dropdown-content button {
	border: none;
	background-color: #204e7d;
	color: white;
	padding: 12px 16px;
	text-decoration: none;
	display: absolute;
	width: 160px;
}

.dropdown-content button:hover {
	background-color: blue;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropbtn {
	background: transparent;
	border: none;
	width: 60px;
	height: 60px;
}

.logo {
	float: left;
	margin-left: 17.5px;
	margin-top: 15px;
	width: 75px;
	height: 75px;
}

.logo img {
	width: 65px;
	height: 65px;
	border-radius: 5px;
}
</style>
</head>
<body>
	<header class="header" style="border: none;">

		<div class="dropdown">
			<button style="margin-top: 5%;" type="button"
				class="btn btn-default btn-lg">
				<span style="color: #204e7d;" class="glyphicon glyphicon-user"></span><span
					style="font-size: 15px; color: #204e7d;"> User</span>
			</button>
			<div class="dropdown-content">
				<form action="<%=request.getContextPath()%>/servlet"
					target="adminArea">
					<input class="userId" type="hidden"
						value="${ userPojo.getUserId() }" name="id" readonly>
					<button type="submit" value="userProfile" name="action">Profile</button>
				</form>

				<form action="<%=request.getContextPath()%>/servlet"
					target="adminArea">
					<button type="submit" value="Change Password" name="action">
						<i class="fa fa-solid fa-key "></i> Change Password
					</button>
				</form>

				<form action="<%=request.getContextPath()%>/servlet"
					target="_parent">
					<button class="profileBth" type="submit" value="Logout"
						name="action">Logout</button>
				</form>
			</div>
		</div>

		<div style="float: left; width: 100%;">
			<div class="logo">
				<img src="images/Joviz_bank_logoF.jpg">
			</div>
			<h1
				style="text-align: left; color: white; margin-left: 120px; margin-top: 25px;">
				<b>JOVIZ BANK</b>
			</h1>
		</div>

	</header>
	
	<div class="adminMenuBody">
		<iframe class="sidebar" style="border: none;" src="jsp/AdminMenu.jsp"
			width=14% height=100%></iframe>
		<iframe style="background-color: #DFE8FB; border: none;"
			class="mainContent" src="jsp/AdminHome.jsp" width=86% height=867vh
			name="adminArea"></iframe>
	</div>
</body>
</html>
