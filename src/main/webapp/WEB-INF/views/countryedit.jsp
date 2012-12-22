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
	<a href='<c:url value="/admin/country/new"/>'>New</a>
	<br>
	<form:form commandName="modelObject" method="post"
		action="saveOrUpdate">

		<table>
			<tr>
				<form:hidden path="id" />
				<td><form:label path="countryName">Country</form:label></td>
				<td><form:input path="countryName" /></td>
			</tr>
			<tr>
				<td>
				<c:choose>
						<c:when test="${empty modelObject.id}">
							<input type="submit" value="Add Country" />
						</c:when>
						<c:otherwise>
							<input type="submit" value="Update Country" />
						</c:otherwise>
				</c:choose></td>
			</tr>
		</table>
	</form:form>
</body>
</html>