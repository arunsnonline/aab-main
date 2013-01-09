<%@ include file="/WEB-INF/include.jsp"%>
<html>
<head>
<title>Ads & Boards</title>
<link href='<c:url value="/css/home.css"/>' rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
        $(document).ready(function(){
        	
        });
        </script>
</head>
<body>
	<div id="header">ADS & BOARDS</div>
	<br>
	<a href='<c:url value="/admin"/>'>Admin Home</a>
	<a href='<c:url value="/admin/city/new"/>'>New</a>
	<br>
	<div id="content">
	<form:form method="post">
		<display:table name="cityList" defaultsort="1"
			defaultorder="ascending" pagesize="10" requestURI="">
			<display:column title="<input type='checkbox' name='selectall' onClick='selectAll()' />">
          			<input type="checkbox" />
            </display:column>
			<display:column property="id" title="ID" />
			<display:column property="cityName" title="NAME" />
			<display:column href="city/edit.htm" paramId="id" paramProperty="id">Edit</display:column>
		</display:table>
	</form:form>
	</div>
</body>
</html>