<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/style/HomeStyle.css">
</head>
<body>

<c:if test="${ accountMap != null }">

		<div style="margin-top: 3%;" class="tables">
			<table>
				<tr style="background-color: #283655; color: white;">
					<th>Account No</th>
					<th>Type</th>
					<th>Branch</th>
					<th>IFSC</th>
					<th>Balance</th>
					<th>Status</th>
					<th>Action</th>
				</tr>

				<c:forEach var="account" items="${ accountMap }">
					<tr>
						<td>${ account.key }</td>
						<td>${ account.value.getAccountType() }</td>
						<td>${ account.value.getAccountBranch() }</td>
						<td>${ account.value.getIfsc() }</td>
						<td>${ account.value.getBalance() }</td>
						<td>${ account.value.getAccountStatus() }</td>
						<td>
							<form action="<%=request.getContextPath()%>/servlet">
								<input type="hidden" value="${ account.key }" name="accountNo" readonly>
								<input type="hidden" value="${ id }" name="id" readonly>
								<c:if
									test="${account.value.getAccountStatus().equals(\"ACTIVE\")}">
									<button style="font-size: small;" class="button red-button" type="submit"
										value="AccountAction" name="action">DE-ACTIVATE
									</button>
								</c:if>
								<c:if
									test="${account.value.getAccountStatus().equals(\"INACTIVE\")}">
									<button style="font-size: small;" class="button green-button" type="submit"
										value="AccountActivate" name="action">ACTIVATE
									</button>
								</c:if>
							</form>
						</td>
					</tr>
				</c:forEach>

			</table>
		</div>
	</c:if>
	
	<h4 style="text-align: left; color: red; margin-top: 2%;">${ message }</h4>

</body>
</html>