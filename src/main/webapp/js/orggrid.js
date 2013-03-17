

$(document).ready(function() {	
	
    tableObj = $('#mainGrid').dataTable( {
    "bProcessing": true, 
    "bServerSide": true,
    "sAjaxSource": "org/list.htm", 
	"bJQueryUI": true,
	"aaSorting": [[0,'asc']] , 
	"iDisplayLength": 10,	
	"aoColumns":[
                    {'mData': 'id','sname':'id', 'sType':'numeric', 'bVisible':true,"mRender": function ( data, type, full ) {
							return '<a href="org/edit.htm?id='+data+'">'+data+'</a>';
							}
					},
                    {'mData': 'organizationName','sName':'organizationName', 'sType':'string','bVisible':true}
                    ]	
    });
	
});

