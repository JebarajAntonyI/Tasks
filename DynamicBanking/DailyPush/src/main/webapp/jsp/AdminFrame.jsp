<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Frame</title>
<style type="text/css">
	.header
	{
		background-color: fuchsia;
	}
</style>
</head>
<body>
<p> ${name }</p>
	<div class="header">
		<iframe src="jsp/Header.jsp" width=99% height=88></iframe>
	</div>
	<iframe src="jsp/AdminMenu.jsp" width=20% height=875></iframe>
	<iframe src="jsp/AdminHome.jsp" width=78% height=875 name="adminArea"></iframe>
	
</body>
</html>
