<%@ include file="/WEB-INF/include.jsp"%>
<html>
<head>
<title>Ads & Boards</title>
<link href='<spring:url value="/css/home.css" htmlEscape="true"/>' rel="stylesheet" type="text/css">
</head>
<body>
	
	<div id="header">ADS & BOARDS</div>
	<br>
	<a href='<c:url value="/admin"/>'>Admin Home</a>
	<a href='<c:url value="/admin/state/new"/>'>New</a>
	<br>
	<form:form commandName="modelObject" method="post"
		action="saveOrUpdate">

		<table>
				<form:hidden path="id" />
			<tr>
				<td><form:label path="stateName">State Name</form:label></td>
				<td><form:input path="stateName" /></td>
			</tr>
			<tr>
				<td><form:label path="country.id">Country</form:label></td>
				<td><form:select path="country.id" items="${countryList}" itemValue="id" itemLabel="countryName"/></td>
			</tr>
			<tr>
				<td>
				<c:choose>
						<c:when test="${empty modelObject.id}">
							<input type="submit" value="Add State" />
						</c:when>
						<c:otherwise>
							<input type="submit" value="Update State" />
						</c:otherwise>
				</c:choose></td>
			</tr>
		</table>
	</form:form>
</body>
</html>