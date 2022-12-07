<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All User Table</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/style/HomeStyle.css">

<style type="text/css">
.tables th {
	font-size: 18px;
	position: sticky;
	top: 2%;
	background-color: #283655;
	color: white;
}
</style>

</head>
<body>
	<header>
		<h2 style="text-align: left">All Users</h2>
	</header>
	
	<div class="tables">
		<table>
			<tr style="background-color: #283655; color: white;">
				<th>User ID</th>
				<th>Name</th>
				<th>DOB</th>
				<th>Mobile</th>
				<th>Email</th>
				<th>User Type</th>
				<th>Online Status</th>
			</tr>

			<c:forEach var="user" items="${ userList }">
				<tr>
					<td>
						<form action="<%=request.getContextPath()%>/servlet"
							target="adminArea">
							<input class="userId" type="submit" value="${ user.getUserId() }"
								name="id" readonly> <input type="hidden"
								value="userDetails" name="action">
						</form>
					</td>
					<td>${ user.getName() }</td>
					<td>${ user.getDob() }</td>
					<td>${ user.getMobile() }</td>
					<td>${ user.getEmail() }</td>
					<td>${ user.getUserType() }</td>
					<td>${ user.getOnlineStatus() }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>



























