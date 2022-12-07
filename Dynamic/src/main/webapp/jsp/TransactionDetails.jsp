<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transaction Page</title>
<style type="text/css">
	table
	{
		margin-left: auto;
		margin-right: auto;
		width:100%;
	}
	table, th, td
	{
		text-align: center;
		border: 2px solid rgb(46, 52, 54);
		border-collapse: collapse;
		border-style: groove;
		padding: 10px;
	}
	body
	{
		background-color: #F5F5DC;
	}
</style>
</head>
<body>

<h1 style="text-align:center;"> Transaction Details Page </h1>

<table style = "width:100%">
	<tr>
		<th> Transaction ID </th>
		<th> Primary Account </th>
		<th> Secondary Account </th>
		<th> Transaction Time </th>
		<th> Mode of Transaction </th>
		<th> Transaction Type </th>
		<th> Amount </th>
		<th> Closing Balance </th>
		<th> Transaction Status </th>
	</tr>
	<tr>
		<td>1</td>
		<td>712365478965</td>
		<td>798654896321</td>
		<td>27-10-2022</td>
		<td>Transfer</td>
		<td>Debit</td>
		<td>2000</td>
		<td>98000</td>
		<td>Success</td>
	</tr>
	<tr>
		<td>2</td>
		<td>712365478965</td>
		<td>-</td>
		<td>27-10-2022</td>
		<td>Withdraw</td>
		<td>Debit</td>
		<td>1000</td>
		<td>97000</td>
		<td>Success</td>
	</tr>
	<tr>
		<td>3</td>
		<td>712365478965</td>
		<td>-</td>
		<td>27-10-2022</td>
		<td>Deposit</td>
		<td>Credit</td>
		<td>1500</td>
		<td>98500</td>
		<td>Success</td>
	</tr>
	<tr>
		<td>4</td>
		<td>712365478965</td>
		<td>-</td>
		<td>27-10-2022</td>
		<td>Withdraw</td>
		<td>Debit</td>
		<td>1000</td>
		<td>98500</td>
		<td>Failed</td>
	</tr>
</table>
<div>
	<a href = "CustomerHome.jsp"><button>Customer Home</button></a>
	<a href = "AdminHome.jsp"><button>Admin Home</button></a>
</div>

</body>
</html>


























