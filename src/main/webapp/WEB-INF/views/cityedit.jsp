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
	<a href='<c:url value="/admin/city/new"/>'>New</a>
	<br>
	<form:form commandName="modelObject" method="post"
		action="saveOrUpdate">

		<table>
				<form:hidden path="id" />
			<tr>
				<td><form:label path="cityName">City Name</form:label></td>
				<td><form:input path="cityName" /></td>
			</tr>
			<tr>
				<td><form:label path="state.id">State</form:label></td>
				<td><form:select path="state.id" items="${stateList}" itemValue="id" itemLabel="stateName"/></td>
			</tr>
			<tr>
				<td>
				<c:choose>
						<c:when test="${empty modelObject.id}">
							<input type="submit" value="Add City" />
						</c:when>
						<c:otherwise>
							<input type="submit" value="Update City" />
						</c:otherwise>
				</c:choose></td>
			</tr>
		</table>
	</form:form>
</body>
</html>