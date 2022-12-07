<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login Page</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/style/LoginStyle.css">
<style type="text/css">
.labelClass {
	margin: 20px 0;
	position: relative;
	display: inline-block;
}

.spanClass {
	padding: 10px;
	pointer-events: none;
	position: absolute;
	left: 0;
	top: 0;
	transition: 0.2s;
	transition-timing-function: ease;
	transition-timing-function: cubic-bezier(0.25, 0.1, 0.25, 1);
	opacity: 0.5;
}

.inputClass {
	padding: 10px;
}

.inputClass:focus+.spanClass, .inputClass:not(:placeholder-shown)+.spanClass
	{
	opacity: 1;
	transform: scale(0.9) translateY(-100%) translateX(-10px);
}

.inputClass:focus+.spanClass, .inputClass:not(:-ms-input-placeholder)+.spanClass
	{
	opacity: 1;
	transform: scale(0.9) translateY(-100%) translateX(-10px);
}

input::-webkit-inner-spin-button, 
input::-webkit-outer-spin-button { 
  -webkit-appearance: none; 
  margin: 0; 
}

input[type=number] {
  -moz-appearance: textfield;
}
</style>
</head>

<body class="loginBody">
	<div>
		<div>
			<h1 class="bankName" style="text-align: center;">JOVIZ BANK</h1>
		</div>


		<div class="signin">
			<div>
				<h2 style="text-align: center; margin-bottom: 50px">User Login</h2>
			</div>
			<form action="<%=request.getContextPath()%>/servlet" method="post">
				<div style="margin-left: 12px">
					<label class="labelClass"> <input
						class="inputClass loginInput" type="number" placeholder="  " min="1" max="100000"
						name="uid" required><span class="spanClass">UserId</span></label>
				</div>
				<div style="margin-left: 12px">
					<label class="labelClass"> <!-- <input class="passInput" type="password" placeholder=" " name="pass"
						required><span>Password</span></label> --> <input
						class="inputClass loginInput" type="password" placeholder=" "
						name="pass" required><span class="spanClass">Password</span></label>
				</div>
				<div>
					<h3 style="text-align: center; color: red">${ message }</h3>
				</div>
				<div class="loginButton">
					<button type="submit" value="Login" name="action">LOGIN</button>
				</div>
			</form>
		</div>
	</div>
</body>

</html>
