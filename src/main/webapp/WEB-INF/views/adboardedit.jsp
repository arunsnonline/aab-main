<%@ include file="/WEB-INF/include.jsp"%>
<html>
<head>
<title>Ads & Boards</title>
<link href='<spring:url value="/css/home.css" htmlEscape="true"/>' rel="stylesheet" type="text/css">
<style type="text/css">     
      #map-canvas { height: 40% }
</style>
<script src='<spring:url value="/js/jquery-1.9.0.min.js" htmlEscape="true"/>'></script>
<script src='<spring:url value="/js/jquery-migrate-1.1.0.min.js" htmlEscape="true"/>'></script>
<script type="text/javascript"
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDkPkRfwMoMCW8D8Mmk6OEaL3fGC_4T10Y&sensor=true">
    </script>
    <script type="text/javascript">
$(document).ready(function() {
	   initialize();	
	    var geocoder;
		var map;
      function initialize() {
		geocoder = new google.maps.Geocoder();
        var mapOptions = {
          center: new google.maps.LatLng(-34.397, 150.644),
          zoom: 8,
          mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        map = new google.maps.Map(document.getElementById("map-canvas"),
            mapOptions);
      }
      
	  
	  $("#geocode").click(function(){
		codeAddress();
	  });
      
      function codeAddress() {
    	    var address = $("#detailedLocation").val();
			alert(address);
    	    geocoder.geocode( { 'address': address}, function(results, status) {
    	      if (status == google.maps.GeocoderStatus.OK) {
    	        map.setCenter(results[0].geometry.location);
    	        var marker = new google.maps.Marker({
    	            map: map,
    	            position: results[0].geometry.location
    	        });
    	      } else {
    	        alert("Geocode was not successful for the following reason: " + status);
    	      }
    	    });
		}
});
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
			<tr>
				<td><form:label path="street">Street</form:label></td>
				<td><form:input path="street" /></td>
			</tr>
			<tr>
				<td><form:label path="detailedLocation">Detailed Location</form:label></td>
				<td><form:input id="detailedLocation" path="detailedLocation" /></td>
				<td><input id="geocode" type="button" value="Geo code" /></td>
			</tr>
			<tr>
				<td><form:label path="contractDays">Contract Days</form:label></td>
				<td><form:input path="contractDays" /></td>
			</tr>
			<tr>
				<td><form:label path="contractStartDate">Contract Start Date</form:label></td>
				<td><form:input path="contractStartDate" /></td>
			</tr>
			<tr>
				<td><form:label path="length">Length</form:label></td>
				<td><form:input path="length" /></td>
			</tr>
			<tr>
				<td><form:label path="breadth">Breadth</form:label></td>
				<td><form:textarea path="breadth" /></td>
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
		<div id="map-canvas"/>
	</form:form>
</body>
</html>