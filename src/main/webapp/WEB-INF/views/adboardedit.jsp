<%@ include file="/WEB-INF/include.jsp"%>
<html>
<head>
<title>Ads & Boards</title>
<link href='<spring:url value="/css/home.css" htmlEscape="true"/>' rel="stylesheet" type="text/css">
<link href='<spring:url value="/css/adboardedit.css" htmlEscape="true"/>' rel="stylesheet" type="text/css">
<link href='<spring:url value="/css/ui-lightness/jquery-ui-1.10.0.custom.min.css" htmlEscape="true"/>' rel="stylesheet" type="text/css">
<script src='<spring:url value="/js/jquery-1.9.0.min.js" htmlEscape="true"/>'></script>
<script src='<spring:url value="/js/jquery-migrate-1.1.0.min.js" htmlEscape="true"/>'></script>
<script src='<spring:url value="/js/jquery-ui-1.10.0.custom.min.js" htmlEscape="true"/>'></script>
<script src='<spring:url value="/js/editmap.js" htmlEscape="true"/>'></script>
<script type="text/javascript">
 var contextRoot='<spring:url javaScriptEscape="true" value="/" htmlEscape="true"/>';
 $(function() {
	    $( "#tabs" ).tabs();
 });
</script>
<script src='<spring:url value="/js/country_state_city_search.js" htmlEscape="true"/>'></script>
<script type="text/javascript"
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDkPkRfwMoMCW8D8Mmk6OEaL3fGC_4T10Y&sensor=true">
</script>
</head>
<body>
	
	<div id="header">ADS & BOARDS</div>
	<br>
	<a href='<spring:url value="/admin" htmlEscape="true"/>'>Admin Home</a>
	<a href='<spring:url value="/admin/acc/new" htmlEscape="true"/>'>New</a>
	<br>
	<form:form commandName="modelObject" method="post"
		action="saveOrUpdate">

		<table>
				<form:hidden path="id" />
				<form:hidden path="boardUUID" />
				<form:hidden id="lathidden" path="locationLatitude" />
				<form:hidden id="lnghidden" path="locationLongitude" />
				<form:hidden id="cityHiddenId" path="city.id" />
				<form:hidden id="stateHiddenId" path="city.state.id" />
				<form:hidden id="countryHiddenId" path="city.state.country.id" />
			<c:choose>
				<c:when test="${empty modelObject.city}">
        			<c:set var="countryName" value=""/>
        			<c:set var="stateName" value=""/>
        			<c:set var="cityName" value=""/>
    			</c:when>
				<c:otherwise>
        			<c:set var="countryName" value="${modelObject.city.state.country.countryName}"/>
        			<c:set var="stateName" value="${modelObject.city.state.stateName}"/>
        			<c:set var="cityName" value="${modelObject.city.cityName}"/>
    			</c:otherwise>
			</c:choose>
			<tr>
				<td>Country</td>
				<td><input id="countrysearch" type="text" value="${countryName}"/></td>
				<td>State</td>
				<td><input id="statesearch" type="text" value="${stateName}"/></td>
				<td>City</td>
				<td><input id="citysearch" type="text" value="${cityName}"/></td>
			</tr>
			<tr>
				<td><form:label path="street">Street</form:label></td>
				<td><form:input id="street" path="street" /></td>
			</tr>
			<tr>
				<td><form:label path="detailedLocation">Detailed Location</form:label></td>
				<td><form:textarea id="detailedLocation" path="detailedLocation" /></td>
				<td><input id="geocode" type="button" value="Geo code" /></td>
			</tr>
			<tr>
				<td><form:label path="locationLatitude">Latitude</form:label></td>
				<td id="lat">${modelObject.locationLatitude}</td>
			</tr>
			<tr>
				<td><form:label path="locationLongitude">Longitude</form:label></td>
				<td id="lng">${modelObject.locationLongitude}</td>
			</tr>
			<tr>
				<td><form:label path="contractDays">Contract Days</form:label></td>
				<td><form:input path="contractDays" /></td>
			</tr>
			<tr>
				<td><form:label path="contractStartDate">Contract Start Date</form:label></td>
				<td><form:input path="contractStartDate" placeholder="DD/MM/YYYY"/></td>
			</tr>
			<tr>
				<td><form:label path="length">Length</form:label></td>
				<td><form:input path="length" /></td>
			</tr>
			<tr>
				<td><form:label path="breadth">Breadth</form:label></td>
				<td><form:input path="breadth" /></td>
			</tr>
			<tr>
				<td><form:label path="uom">Uom</form:label></td>
				<td><form:input path="uom" /></td>
			</tr>
			<tr>
				<td><form:label path="boardType.id">Board Type</form:label></td>
				<td><form:select path="boardType.id" items="${boardTypeList}" itemValue="id" itemLabel="name"/></td>
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
<div id="tabs">
  <ul>
    <li><a href="#mapView">Map View</a></li>
    <li><a href="#uploadPhotos">Upload Photos</a></li>
  </ul>
  <div id="mapView">
    <div id="map-canvas"/>
  </div>
  <div id="uploadPhotos">
    <p>UPLOAD PHOTOS HERE!</p>
  </div>
</div>
	</form:form>
</body>
</html>