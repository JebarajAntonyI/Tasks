<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Request</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/style/TableStyle.css">
<!-- <style type="text/css">
table
{
	width: 100%;
	margin-left: auto;
	margin-right: auto;
}
table, th, td
{
	border: 2px solid rgb(46, 52, 54);
	border-collapse: collapse;
	text-align: center;
	padding: 15px;
}
th
{
	font-size: 18px;
}
body
{
	background-color: #F5F5DC;
}
h1
{
	margin-top: 300px;
}
</style>
 --></head>
<body>

	<table>
		<tr>
			<th>Request Number</th>
			<th>Customer Id</th>
			<th>Account Number</th>
			<th>Request Message</th>
			<th>Request Status</th>
		</tr>
		
		<tr>
			<td>1</td>
			<td>4</td>
			<td>769878954789</td>
			<td>Activate My Account</td>
			<td>
				<button>Approve</button>
				<button>Reject</button>
			</td>
		</tr>
		
		<tr>
			<td>2</td>
			<td>5</td>
			<td>798521365489</td>
			<td>Activate Account Please</td>
			<td>
				<button>Approve</button>
				<button>Reject</button>
			</td>
		</tr>
	</table>
	<div>
		<button>Save</button>
		<a href="jsp/AdminHome.jsp"><button>Back</button></a>
	</div>

</body>
</html>
