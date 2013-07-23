$(document).ready(function() {	
	    var geocoder;
		var map;
		var marker;
		var initialLocation;
		var india = new google.maps.LatLng(22.00, 77.00);
		var browserSupportFlag =  new Boolean();
		
	  initialize();
      function initialize() {
		geocoder = new google.maps.Geocoder();
        var mapOptions = {
          zoomControl: true,
		  zoomControlOptions: {
			style: google.maps.ZoomControlStyle.LARGE
		  },
          zoom: 8,
          mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        map = new google.maps.Map(document.getElementById("map-canvas"),
            mapOptions);
        
     // Try W3C Geolocation (Preferred)
        if(navigator.geolocation) {
          browserSupportFlag = true;
          navigator.geolocation.getCurrentPosition(function(position) {
            initialLocation = new google.maps.LatLng(position.coords.latitude,position.coords.longitude);
            map.setCenter(initialLocation);
          }, function() {
            handleNoGeolocation(browserSupportFlag);
          });
        }
        // Browser doesn't support Geolocation
        else {
          browserSupportFlag = false;
          handleNoGeolocation(browserSupportFlag);
        }

      }
      
	  
	  $("#geocode").click(function(){
		codeAddress();
	  });
	  
	  function handleNoGeolocation(errorFlag) {
		    if (errorFlag == true) {
		      alert("Geolocation service failed.");
		      initialLocation = india;
		    } else {
		      alert("Your browser doesn't support geolocation. We've placed you in India.");
		      initialLocation = india;
		    }
		    map.setCenter(initialLocation);
		}
		
		
      
      function codeAddress() {
	   if(marker!=null){
    		  marker.setMap(null);
    	  }
    	    var landmark = $("#detailedLocation").val();
    	    var street = $("#street").val();
    	    var city = $("#citySearch").val();
    	    var state = $("#stateSearch").val();
    	    var country = $("#countrySearch").val();
    	    var address=landmark+","+street+","+city+","+state+","+country;
			//alert(address);
    	    geocoder.geocode( { 'address': address}, function(results, status) {
    	      if (status == google.maps.GeocoderStatus.OK) {
    	        map.setCenter(results[0].geometry.location);
    	        	marker = new google.maps.Marker({
    	            map: map,
    	            draggable:true,
    	            position: results[0].geometry.location
    	        });
    	        google.maps.event.addListener(marker, 'dragend', dragEnd);

    	      } else {
    	        alert("Geocode was not successful for the following reason: " + status);
    	      }
    	    });
		}
      
      function dragEnd() {

    	  var latLng = marker.getPosition();
    	  var lat = latLng.lat();
    	  var lng = latLng.lng();
    	  $("#lat").html(lat);
    	  $("#lng").html(lng);
    	  $("#lathidden").val(lat);
    	  $("#lnghidden").val(lng);
    	}
});