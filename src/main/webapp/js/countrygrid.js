

$(document).ready(function() {	
	
    tableObj = $('#mainGrid').dataTable( {
    "bProcessing": true, 
    "bServerSide": true,
    "sAjaxSource": "country/list.htm", 
	"bJQueryUI": true,
	"aaSorting": [[0,'asc']] , 
	"iDisplayLength": 10,	
	"aoColumns":[
                    {'mData': 'id','sname':'id', 'sType':'numeric', 'bVisible':true,"mRender": function ( data, type, full ) {
							return '<a href="country/edit.htm?id='+data+'">'+data+'</a>';
							}
					},
                    {'mData': 'countryName','sName':'countryName', 'sType':'string','bVisible':true}
                    ]	
    });
	
});

