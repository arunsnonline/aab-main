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
	<a href='<c:url value="/admin/org/new"/>'>New</a>
	<br>
	<form:form commandName="modelObject" method="post"
		action="saveOrUpdate">

		<table>
			<tr>
				<form:hidden path="id" />
				<td><form:label path="organizationName">Organization</form:label></td>
				<td><form:input path="organizationName" /></td>
			</tr>
			<tr>
				<td>
				<c:choose>
						<c:when test="${empty modelObject.id}">
							<input type="submit" value="Add Organization" />
						</c:when>
						<c:otherwise>
							<input type="submit" value="Update Organization" />
						</c:otherwise>
				</c:choose></td>
			</tr>
		</table>
	</form:form>
</body>
</html>