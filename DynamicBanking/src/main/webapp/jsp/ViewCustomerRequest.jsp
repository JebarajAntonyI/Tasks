<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Request</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/style/HomeStyle.css">
</head>
<body>
	<header class="header">
		<div class="sameGrid positionf t-l-0">
			<h2
				style="text-align: left; margin-left: 5%; margin-top: 3.5%; margin-top: 1%;">Customer
				Request</h2>

			<form action="<%=request.getContextPath()%>/servlet">

				<select style="margin-left: 60%; width: 20%" class="inputStyle"
					id="Acc No" name="reqType">
					<option value="Pending">Pending</option>
					<option value="Processed">Processed</option>
					<option value="Rejected">Rejected</option>
				</select>
				<button style="margin-left: 30px;" class="button accept-button"
					type="submit" name="action" value="showCustomerRequest">
					Search</button>

			</form>
		</div>
	</header>

	<c:choose>
		<c:when
			test="${ requestMap.isEmpty() == false || statusMap.isEmpty() == false }">
			<%-- <h3 style="text-align: center; color: blue;">${ request }Details</h3> --%>
			<div class="tables">
				<table style="width: 90%;">
					<tr style="background-color: #283655; color: white;">
						<th>Request Number</th>
						<th>Customer Id</th>
						<th>Account Number</th>
						<th>Request Message</th>
						<th>Request Status</th>
						<th>Action</th>
					</tr>

					<c:forEach var="pending" items="${ requestMap }">
						<tr>
							<td>${ pending.key }</td>
							<td>${ pending.value.getCustomerId() }</td>
							<td>${ pending.value.getAccountNo() }</td>
							<td>${ pending.value.getRequestMessage() }</td>
							<td>${ pending.value.getRequestStatus() }</td>
							<td><form action="<%=request.getContextPath()%>/servlet"
									target="adminArea">
									<input type="hidden" value="${ pending.key }" name="reqNo"
										readonly> <input type="hidden"
										value="${ pending.value.getAccountNo() }" name="acNo" readonly>
									<c:if
										test="${pending.value.getRequestMessage().equals(\"Requst for Activation\")}">
										<button title="Activate" style="width: 40%;" class="button green-button"
											type="submit" value="ActivateAccount" name="action">
											<span style='font-size: 100%;'>&#10004;</span>
										</button>
										<button title="Reject" style="width: 40%;" class="button red-button"
											type="submit" value="cancelCustomerRequest" name="action">
											<span style='font-size: 100%;'>&#10006;</span>
										</button>
									</c:if>
									<c:if
										test="${pending.value.getRequestMessage().equals(\"Requst for Deactivation\")}">
										<button title="De-Activate" style="width: 40%;" class="button deactivate-button"
											type="submit" value="DeactivateAccount" name="action">
											<span style='font-size: 100%;'>&#9940;</span>
										</button>
										<button title="Reject" style="width: 40%;" class="button red-button"
											type="submit" value="cancelCustomerRequest" name="action">
											<span style='font-size: 100%;'>&#10006;</span>
										</button>
									</c:if>
								</form></td>

						</tr>
					</c:forEach>
					<c:forEach var="status" items="${ statusMap }">
						<tr>
							<td style="background: none;"><input type="hidden"
								value="${ status.key }" name="reqNo" readonly>${ status.key }</td>
							<td>${ status.value.getCustomerId() }</td>
							<td>${ status.value.getAccountNo() }</td>
							<td>${ status.value.getRequestMessage() }</td>
							<td>${ status.value.getRequestStatus() }</td>
							<td>-</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</c:when>
		<c:otherwise>
			<h3 style="text-align: center; color: red;">No Pending Request
				Available</h3>
		</c:otherwise>
	</c:choose>
</body>
</html>
