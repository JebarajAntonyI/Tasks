<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transaction Request</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/style/HomeStyle.css">
<body>
	<header class="header">
		<div class="sameGrid positionf t-l-0">
			<h2
				style="text-align: left; margin-left: 5%; margin-top: 3.5%; margin-top: 1%;">Transaction
				Request</h2>

			<form action="<%=request.getContextPath()%>/servlet">

				<select style="margin-left: 60%; width: 20%" class="inputStyle"
					id="Acc No" name="reqType">
					<option value="Pending">Pending</option>
					<option value="Approved">Approved</option>
					<option value="Rejected">Rejected</option>
				</select>
				<button style="margin-left: 30px;" class="button accept-button"
					type="submit" name="action" value="showTransactionRequest">
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
						<th>Request No</th>
						<th>Customer ID</th>
						<th>Account Number</th>
						<th>Request Type</th>
						<th>Request Time</th>
						<th>Verified Time</th>
						<th>Amount</th>
						<th>Status</th>
						<th>Action</th>
					</tr>

					<c:forEach var="pending" items="${ requestMap }">
						<jsp:useBean id="reqDate" class="java.util.Date" />
						<c:set target="${reqDate}" property="time"
							value="${ pending.value.getRequestTime() }" />
						<tr>
							<td style="background: none;">${ pending.key }</td>
							<td>${ pending.value.getCustomerId() }</td>
							<td>${ pending.value.getAccountNo() }</td>
							<td>${ pending.value.getRequestFor() }</td>
							<td><fmt:formatDate value="${reqDate}"
									pattern="dd-MM-yyyy  HH:mm:ss" /></td>
							<td style="text-align: center">-</td>
							<td>${ pending.value.getAmount() }</td>
							<td>${ pending.value.getStatus() }</td>
							<td style="width: 13%"><form
									action="<%=request.getContextPath()%>/servlet"
									target="adminArea">
									<input type="hidden" value="${ pending.key }" name="reqNo"
										readonly>
									<button title="Approve" style="width: 40%;" class="button green-button"
										type="submit" value="ApprovedTransaction" name="action">
										<span style='font-size: 100%;'>&#10004;</span>
									</button>
									<button title="Reject" style="width: 40%;" class="button red-button"
										type="submit" value="RejectedTransaction" name="action">
										<span style='font-size: 100%;'>&#10006;</span>
									</button>
								</form></td>
						</tr>
					</c:forEach>
					<c:forEach var="status" items="${ statusMap }">
						<jsp:useBean id="reqDate1" class="java.util.Date" />
						<jsp:useBean id="verDate1" class="java.util.Date" />
						<c:set target="${reqDate1}" property="time"
							value="${ status.value.getRequestTime() }" />
						<c:set target="${verDate1}" property="time"
							value="${ status.value.getVerifiedTime() }" />
						<tr>
							<td>${ status.key }</td>
							<td>${ status.value.getCustomerId() }</td>
							<td>${ status.value.getAccountNo() }</td>
							<td>${ status.value.getRequestFor() }</td>
							<td><fmt:formatDate value="${reqDate1}"
									pattern="dd-MM-yyyy  HH:mm:ss" /></td>
							<td><fmt:formatDate value="${verDate1}"
									pattern="dd-MM-yyyy  HH:mm:ss" /></td>
							<td>${ status.value.getAmount() }</td>
							<td>${ status.value.getStatus() }</td>
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
