

$(document).ready(function() {	
	
    tableObj = $('#mainGrid').dataTable( {
    "bProcessing": true, 
    "bServerSide": true,
    "sAjaxSource": "city/list.htm", 
	"bJQueryUI": true,
	"aaSorting": [[0,'asc']] , 
	"iDisplayLength": 10,	
	"aoColumns":[
                    {'mData': 'id','sname':'id', 'sType':'numeric', 'bVisible':true,"mRender": function ( data, type, full ) {
							return '<a href="city/edit.htm?id='+data+'">'+data+'</a>';
							}
					},
                    {'mData': 'cityName','sName':'cityName', 'sType':'string','bVisible':true}
                    ]	
    });
	
});

