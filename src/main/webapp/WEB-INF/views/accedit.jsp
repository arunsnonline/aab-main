<%@ include file="/WEB-INF/include.jsp"%>
<html>
<head>
<title>Ads & Boards</title>
<link href='<c:url value="/css/home.css"/>' rel="stylesheet" type="text/css">
</head>
<body>
	
	<div id="header">ADS & BOARDS</div>
	<br>
	<a href='<c:url value="/admin"/>'>Admin Home</a>
	<a href='<c:url value="/admin/acc/new"/>'>New</a>
	<br>
	<form:form commandName="modelObject" method="post"
		action="saveOrUpdate">

		<table>
				<form:hidden path="id" />
			<tr>
				<td><form:label path="accountName">Account Name</form:label></td>
				<td><form:input path="accountName" /></td>
			</tr>
			<tr>
				<td><form:label path="phone">Phone</form:label></td>
				<td><form:input path="phone" /></td>
			</tr>
			<tr>
				<td><form:label path="fax">Fax</form:label></td>
				<td><form:input path="fax" /></td>
			</tr>
			<tr>
				<td><form:label path="email">E-Mail</form:label></td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td><form:label path="websiteUrl">Website</form:label></td>
				<td><form:input path="websiteUrl" /></td>
			</tr>
			<tr>
				<td><form:label path="address">Address</form:label></td>
				<td><form:textarea path="address" /></td>
			</tr>
			<tr>
				<td><form:label path="contactPerson">Contact Person</form:label></td>
				<td><form:input path="contactPerson" /></td>
			</tr>
			<tr>
				<td><form:label path="contactPersonMobile">Contact Person Mobile</form:label></td>
				<td><form:input path="contactPersonMobile" /></td>
			</tr>
			<tr>
				<td><form:label path="organization.id">Organization</form:label></td>
				<td><form:select path="organization.id" items="${organizationList}" itemValue="id" itemLabel="organizationName"/></td>
			</tr>
			<tr>
				<td>
				<c:choose>
						<c:when test="${empty modelObject.id}">
							<input type="submit" value="Add Account" />
						</c:when>
						<c:otherwise>
							<input type="submit" value="Update Account" />
						</c:otherwise>
				</c:choose></td>
			</tr>
		</table>
	</form:form>
</body>
</html>