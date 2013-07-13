$(document).ready(function() {	
	$("#countrysearch").autocomplete({
		
		
		source: function (request, response) {
			 	$.ajax({
					url: contextRoot+"search/country/list.htm",
					dataType: "json",
					data: { 
						cname_startsWith: request.term
			  		},
					success: function (data) {

						response($.map( data, function( item ) {
					return {
						label: item.countryName ,
						value: item.id
					}
				}));

					}
		  	});
		},
		select: function( event, ui ) {
			event.preventDefault();
			$(this).val(ui.item.label);
		},
		open: function () {
				$(this).removeClass("ui-corner-all").addClass("ui-corner-top");
		},
		close: function () {
				$(this).removeClass("ui-corner-top").addClass("ui-corner-all");
		}
	});
});