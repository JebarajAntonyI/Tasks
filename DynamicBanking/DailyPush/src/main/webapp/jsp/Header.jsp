<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
<style type="text/css">
button {
	background-color: red;
	color: white;
	padding: 10px 15px;
	margin: 8px 0;
	border: double;
	cursor: pointer;
	width: 100%;
}
</style>
</head>
<body>
	<div style="float: right">
		<form action="<%=request.getContextPath()%>/servlet"
			target="_parent">
			<button type="submit" value="Logout" name="action">Logout</button>
		</form>
	</div>
	<div>
		<h1 style="text-align: center;">
			<b>JOVIZ BANK</b>
		</h1>
	</div>

</body>
</html>