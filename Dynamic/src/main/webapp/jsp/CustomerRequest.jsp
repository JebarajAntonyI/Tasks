<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Request</title>
<link rel="stylesheet" type="text/css" href="style/TableStyle.css">
</head>
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
				<select>
					<option>Pending</option>
					<option>Approve</option>
					<option>Reject</option>
				</select>
			</td>
		</tr>
		
		<tr>
			<td>2</td>
			<td>5</td>
			<td>798521365489</td>
			<td>Activate Account Please</td>
			<td>
				<select>
					<option>Pending</option>
					<option>Approve</option>
					<option>Reject</option>
				</select>
			</td>
		</tr>
	</table>
	<div>
		<button>Save</button>
		<a href="AdminHome.jsp"><button>Back</button></a>
	</div>

</body>
</html>
