<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="com.banking.pojo.Customer"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Documents</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/style/HomeStyle.css">
</head>
<body>
	<h4 style="color: red;">${ redMessage }</h4>
	<c:if test="${ redMessage == null }">
	<header class="header">
		<h2 style="text-align: left;">Customer Documents</h2>
	</header>
	<h4 style="text-align: center; color: green;">${ message }</h4>

	<form action="<%=request.getContextPath()%>/servlet">
		<div style="margin-top: 0px; padding-top: 15px; padding-bottom: 15px;"
			class="card w-40">
			<table class="formTable">
				<tr>
					<td class="w-40">Customer Id</td>
					<td><b><input class="inputStyle w-100"
							value="${ customer.getCustomerId() }" name="id" readonly></b></td>
				</tr>

				<tr>
					<td class="w-40">Name <span style='font-size: 12px;'>&#128395;</span></td>
					<td><b><input class="inputStyle w-100"
							value="${ customer.getName() }" name="name"></b></td>
				</tr>

				<tr>
					<td class="w-40">DOB <span style='font-size: 12px;'>&#128395;</span></td>
					<td><b><input class="inputStyle w-100" type="date"
							value="${ customer.getDob() }" name="dob"></b></td>
				</tr>

				<tr>
					<td class="w-40">Aadhaar Number <span style='font-size: 12px;'>&#128395;</span></td>
					<td><b><input class="inputStyle w-100" pattern="^[1-9][0-9]{11}" maxlength=12 type="tel" name="aadhaar"
							value="${ customer.getAadhar() }"></b></td>
				</tr>

				<tr>
					<td class="w-40">PAN <span style='font-size: 12px;'>&#128395;</span></td>
					<td><b><input class="inputStyle w-100" type="text" pattern="[A-Z]{5}[0-9]{4}[A-Z]{1}" name="pan"
							value="${ customer.getPan() }"></b></td>
				</tr>
			</table>
			<div style="text-align: center;">
				<button class="accept-button button" type="submit" name="action"
					value="modifyCustomerDetails">Save</button>
			</div>
		</div>

	</form>
	</c:if>
</body>
</html>