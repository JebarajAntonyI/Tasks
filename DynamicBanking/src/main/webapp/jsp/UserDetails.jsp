<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="com.banking.pojo.Customer"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Details</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/style/HomeStyle.css">
</head>
<body>
	<h4 style="color: red;">${ redMessage }</h4>
	<c:if test="${ redMessage == null }">
	<header class="header">
		<h2 style="text-align: left;">User Details</h2>
	</header>
	<h4 style="text-align: center; color: green;">${ message }</h4>

	<form action="<%=request.getContextPath()%>/servlet">
		<div style="margin-top: 0px; padding-top: 15px; padding-bottom: 15px;"
			class="card w-40">
			<table class="formTable">
				<tr>
					<td class="w-25">Customer Id</td>
					<td><b><input class="inputStyle w-100"
							value="${ userPojo.getUserId() }" name="id" readonly></b></td>
				</tr>

				<tr>
					<td class="w-25">Name <span style='font-size: 12px;'>&#128395;</span></td>
					<td><b><input class="inputStyle w-100"
							value="${ userPojo.getName() }" name="name"></b></td>
				</tr>

				<tr>
					<td class="w-25">DOB <span style='font-size: 12px;'>&#128395;</span></td>
					<td><b><input class="inputStyle w-100" type="date"
							value="${ userPojo.getDob() }" name="dob"></b></td>
				</tr>

				<tr>
					<td class="w-25">Mobile <span style='font-size: 12px;'>&#128395;</span></td>
					<td><b><input class="inputStyle w-100" type="tel" pattern="^[6-9][0-9]{9}"
							value="${ userPojo.getMobile() }" maxlength="10" name="mobile"></b></td>
				</tr>

				<tr>
					<td class="w-25">Email <span style='font-size: 12px;'>&#128395;</span></td>
					<td><b><input class="inputStyle w-100" type="email" pattern="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9-]+.[a-zA-Z]+$"
							value="${ userPojo.getEmail() }" name="mail"></b></td>
				</tr>

				<tr>
					<td><label></label></td>
					<td><button class="accept-button button" type="submit"
							name="action" value="modifyUserDetails">Save</button></td>
				</tr>

			</table>
		</div>
	</form>
	</c:if>

</body>
</html>