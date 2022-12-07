<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
button {
	background-color: #c52323;
	font-weight: 400;
	font-size: 18px;
	color: white;
	margin: 5px 0;
	border: none;
	cursor: pointer;
	width: 100px;
	height: 45px;
	border-radius: 5px;
}
</style>
</head>
<body>
	<div style="float: right">
		<form action="<%=request.getContextPath()%>/servlet" target="_parent">
			<button class="profileBth" type="submit" value="Logout" name="action">Logout</button>
		</form>
	</div>
	<div>
		<h1 style="text-align: center; color: white;">
			<b>JOVIZ BANK</b>
		</h1>
	</div>

</body>
</html>