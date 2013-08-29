$(document).ready(function() {	
var countryId,stateId,cityId;

function searchBoxAutoComplete(inputId,ajaxUrl,inputModel){
	$("#"+inputId).autocomplete({		
		source: function (request, response) {
			 	$.ajax({
					url: contextRoot+ajaxUrl,
					dataType: "json",
					data: (function(){
								if(inputModel=="country"){
									return { 
										cname_startsWith: request.term
									} 
								}else
								if(inputModel=="state"){
									return { 
										stateNameStartsWith: request.term,
										countryId: countryId
									} 
								}else
								if(inputModel=="city"){
									return { 
										cityNameStartsWith: request.term,
										stateId:stateId
									} 
								}else{
									return { 
										cityId:cityId,
										street: request.term
									} 
								}	
							})()
					,
					success: function (data) {

						response($.map( data, function( item ) {
						var labelValue,itemValue;
						if(inputModel=="country"){
							labelValue =  item.countryName;
							itemValue =  item.id;
						}else
						if(inputModel=="state"){
							labelValue = item.stateName;
							itemValue= item.id;
						}else
						if(inputModel=="city"){
							labelValue = item.cityName;
							itemValue= item.id;
						}else{
							labelValue = item;
							itemValue = item;
						}
					return {
							label: labelValue ,
							value: itemValue
					}
				}));

					}
		  	});
		},
		select: function( event, ui ) {
			event.preventDefault();
			if(inputModel=="country"){
							countryId=ui.item.value;
			}else
			if(inputModel=="state"){
							stateId=ui.item.value;
			}else
			if(inputModel=="city"){
							cityId=ui.item.value;
							$("#cityHiddenId").val(ui.item.value);
			}
			$(this).val(ui.item.label);
		},
		open: function () {
				$(this).removeClass("ui-corner-all").addClass("ui-corner-top");
		},
		close: function () {
				$(this).removeClass("ui-corner-top").addClass("ui-corner-all");
		}
	});
}



searchBoxAutoComplete("countrysearch","search/country/list.htm","country");
searchBoxAutoComplete("statesearch","search/state/list.htm","state");
searchBoxAutoComplete("citysearch","search/city/list.htm","city");
searchBoxAutoComplete("streetId","search/street/list.htm","street");
searchBoxAutoComplete("countrysearchpop","search/country/list.htm","country");
searchBoxAutoComplete("statesearchpop","search/state/list.htm","state");
searchBoxAutoComplete("citysearchpop","search/city/list.htm","city");
searchBoxAutoComplete("streetIdpop","search/street/list.htm","street");

$( "#adv_search" ).click(function(){
	if ($("#adv_pop").dialog( "isOpen" )==false) {
		$( "#adv_pop" ).dialog( "open" );
	} 
});


 $( "#adv_pop" ).dialog({
      height: 400,
	  width: 300,
	  autoOpen: false,
      modal: true
    });
/*if$("#available").click(function(){
    alert("clicked");
     ($(this).attr("checked") == "checked"){
    	var d = new Date();
    	d.setDate(d.getDate()-1);
    	var month = d.getMonth()+1;
    	var day = d.getDate();
    	var output = (day<10 ? '0' : '') + day + '/' +
    	    		 (month<10 ? '0' : '') + month + '/' + 
    	    		 d.getFullYear();
    	$("#contractStartDate").val(output);
        $("#contractDays").val(10);
    } else {
    	$("#contractStartDate").val(null);
        $("#contractDays").val(null);
    }
  });*/
});
