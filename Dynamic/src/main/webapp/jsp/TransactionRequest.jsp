<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transaction Request</title>
<link rel="stylesheet" type="text/css" href="style/TableStyle.css">
</head>
<body>

	<table style="width:100%">
		<tr>
			<th>Customer ID</th>
			<th>Account Number</th>
			<th>Request Type</th>
			<th>Request Time</th>
			<th>Verified Time</th>
			<th>Amount</th>
			<th>Status</th>
		</tr>
		
		<tr>
			<td>2</td>
			<td>769878954516</td>
			<td>Withdraw</td>
			<td>27-10-2022 7:40PM</td>
			<td>-</td>
			<td>1000</td>
			<td>
				<select>
					<option>Pending</option>
					<option>Approve</option>
					<option>Reject</option>
				</select>
			</td>
		</tr>
		
		<tr>
			<td>3</td>
			<td>712563987456</td>
			<td>Withdraw</td>
			<td>27-10-2022 7:42PM</td>
			<td>-</td>
			<td>2000</td>
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
