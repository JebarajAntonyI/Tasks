<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All User Table</title>
<style type="text/css">
	table
	{
		width: 70%;
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
</style>
</head>
<body>

	<table>
		<tr>
			<th>User ID</th>
			<th>Name</th>
			<th>DOB</th>
			<th>Mobile</th>
			<th>Email</th>
			<th>User Type</th>
		</tr>
		
		<c:forEach var="user" items="${ userList }">
		<tr>
			<td>${ user.getUserId() }</td>
			
			<%-- <td>
				<form action="<%= request.getContextPath() %>/servlet" target="adminArea">
				<input type="submit" value="${ user.getUserId() }" name="id" readonly>
				<input type="hidden" value="userDetails" name="action">
				</form>
			</td> --%>
			
			<%-- <td>
				<form action="<%= request.getContextPath() %>/servlet" target="adminArea">
				<input value="${ user.getUserId() }" name="id" readonly>
				<button type="submit" value="userDetails" name="action"></button>
				</form>
			</td> --%>
			<td>${ user.getName() }</td>
			<td>${ user.getDob() }</td>
			<td>${ user.getMobile() }</td>
			<td>${ user.getEmail() }</td>
			<td>${ user.getUserType() }</td>
		</tr>
		</c:forEach>
	</table>

	<div>
		<a href="jsp/AdminHome.jsp"><button>Back</button></a>
	</div>
</body>
</html>



























