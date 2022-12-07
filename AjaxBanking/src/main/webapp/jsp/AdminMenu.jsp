<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Menu</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/style/Menu.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.css">
</head>
<body>

	<h2 style="text-align: left; margin-left: 15px; margin-top: 10px;">Welcome
		${ name }</h2>
	<hr style="width: 100%; color: gray;">

	<form action="<%=request.getContextPath()%>/servlet" target="adminArea">
		<div class="menuButton">
			<button type="submit" value="Admin Home" name="action">Home</button>
		</div>
	</form>
	<!-- <h3 style="text-align: center;"><a href="AdminHome.jsp" target="adminArea">Home</a></h3> -->

	<div class="menuButton">
		<form action="<%=request.getContextPath()%>/servlet"
			target="adminArea">

			<!-- <div class="menuButton dropdown">	
			<button type="button" class="dropbtn">User Details</button>
			<div class="dropdown-content">
				<div><button type="submit" value="View All User" name="action">All User</button></div>
				<div><button type="submit" value="View All Account" name="action">All Account</button></div>
				<div><button type="submit" value="adminStatement" name="action">Transaction Statement</button></div>
			</div>
		</div> -->


			<!-- <div>
				<button type="submit" value="View All User" name="action">All
					User</button> 																		//usefulll.........
			</div> -->
			<!-- <div>
				<button type="submit" value="View All Account" name="action">All
					Account</button>																	//usefulll.........
			</div> -->
			<!-- <div>
				<button type="submit" value="adminStatement" name="action">Transaction
					Statement</button>																	//usefulll.........
			</div> -->

			<div>
				<button type="submit" value="searchUser" name="action">Search
					User</button>
			</div>
			<div>
				<button type="submit" value="AdminaccountDetails" name="action">Search
					Account</button>
			</div>

			<!-- <div class="menuButton dropdown">
			<button type="button" class="dropbtn">Add</button>
			<div class="dropdown-content">
				<div><button type="submit" value="Add New User" name="action">Add New User</button></div>
				<div><button type="submit" value="Add New Customer" name="action">Add New Customer</button></div>
				<div><button type="submit" value="Fill Customer Details" name="action">Add Customer Details</button></div>
				<div><button type="submit" value="Add New Account" name="action">Add New Account</button></div>
			</div>
		</div> -->
			<div>
				<button type="submit" value="Add New User" name="action">Add
					User</button>
			</div>
			<div>
				<button type="submit" value="Add New Customer" name="action">Add
					Customer</button>
			</div>
			<div>
				<button type="submit" value="Fill Customer Details" name="action">Add
					Customer Details</button>
			</div>
			<div>
				<button type="submit" value="Add New Account" name="action">Add
					Account</button>
			</div>

			<!-- <div class="menuButton dropdown">
			<button type="button" class="dropbtn">View Request</button>
			<div class="dropdown-content">
				<div><button type="submit" value="View Transaction Request" name="action">View Transaction Request</button></div>
				<div><button type="submit" value="View Customer Request" name="action">View Customer Request</button></div>
			</div>
		</div> -->
			<div>
				<button type="submit" value="View Transaction Request" name="action">Transaction
					Request</button>
			</div>
			<div>
				<button type="submit" value="View Customer Request" name="action">Customer
					Request</button>
			</div>
			<div>
				<button type="submit" value="customerStatus" name="action">Block Customer</button>
			</div>
			<!-- <div><button type="submit" value="Change Password" name="action"><i class="fa fa-solid fa-key "></i>  Change Password</button></div> -->
		</form>
	</div>

</body>
</html>
