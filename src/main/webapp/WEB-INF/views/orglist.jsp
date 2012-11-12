<%@ include file="/WEB-INF/include.jsp"%>
<html>
<head>
	<title>Ads & Boards</title>
	<link href='<c:url value="/css/home.css"/>' rel="stylesheet" type="text/css">
</head>
<body>
	<div id="header">ADS & BOARDS</div><br>
	<a href='<c:url value="/admin"/>'>Admin Home</a>
	<a href='<c:url value="/admin/org/new"/>'>New</a>
	<br>
	<div id="content">
		<display:table name="organizationList" defaultsort="1"
			defaultorder="ascending" pagesize="10" requestURI="">
			<display:column property="id" title="ID" />
			<display:column property="organizationName" title="NAME" />
			<display:column href="org/edit.htm" paramId="id" paramProperty="id">Edit</display:column>
		</display:table>
	</div>
</body>
</html>