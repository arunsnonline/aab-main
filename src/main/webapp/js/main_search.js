$(document).ready(function() {	
var countryId,stateId,cityId;

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
			countryId=ui.item.value;
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
						countryId: countryId
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
			stateId=ui.item.value;
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
					stateId:stateId
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
$("#detailedLocation").autocomplete({
	source: function (request, response) {
		 	$.ajax({
				url: contextRoot+"search/street/list.htm",
				dataType: "json",
				data: { 
					cityId:$("#cityHiddenId").val(),
					street: request.term
		  		},
				success: function (data) {
					response($.map( data, function( item ) {
				return {
					label: item ,
					value: item
				}
			}));

				}
	  	});
	},
	open: function () {
			$(this).removeClass("ui-corner-all").addClass("ui-corner-top");
	},
	close: function () {
			$(this).removeClass("ui-corner-top").addClass("ui-corner-all");
	}
});
});
