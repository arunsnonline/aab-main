$(document).ready(function() {	
var countryId,stateId;

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
			$("#countryHiddenId").val(ui.item.value);
			$(this).val(ui.item.label);
		},
		open: function () {
				$(this).removeClass("ui-corner-all").addClass("ui-corner-top");
		},
		close: function () {
				$(this).removeClass("ui-corner-top").addClass("ui-corner-all");
		}
	});

$("#statesearch").autocomplete({
		source: function (request, response) {
			 	$.ajax({
					url: contextRoot+"search/state/list.htm",
					dataType: "json",
					data: { 
						stateNameStartsWith: request.term,
						countryId: $("#countryHiddenId").val()
			  		},
					success: function (data) {

						response($.map( data, function( item ) {
					return {
						label: item.stateName ,
						value: item.id
					}
				}));

					}
		  	});
		},
		select: function( event, ui ) {
			event.preventDefault();
			$("#stateHiddenId").val(ui.item.value);
			$(this).val(ui.item.label);
		},
		open: function () {
				$(this).removeClass("ui-corner-all").addClass("ui-corner-top");
		},
		close: function () {
				$(this).removeClass("ui-corner-top").addClass("ui-corner-all");
		}
	});
$("#citysearch").autocomplete({
	source: function (request, response) {
		 	$.ajax({
				url: contextRoot+"search/city/list.htm",
				dataType: "json",
				data: { 
					cityNameStartsWith: request.term,
					stateId:$("#stateHiddenId").val()
		  		},
				success: function (data) {
					response($.map( data, function( item ) {
				return {
					label: item.cityName ,
					value: item.id
				}
			}));

				}
	  	});
	},
	select: function( event, ui ) {
		event.preventDefault();
		$("#cityHiddenId").val(ui.item.value);
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