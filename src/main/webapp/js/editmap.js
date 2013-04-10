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