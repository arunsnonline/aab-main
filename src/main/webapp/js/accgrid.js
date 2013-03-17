

$(document).ready(function() {	
	
    tableObj = $('#mainGrid').dataTable( {
    "bProcessing": true, 
    "bServerSide": true,
    "sAjaxSource": "acc/list.htm", 
	"bJQueryUI": true,
	"aaSorting": [[0,'asc']] , 
	"iDisplayLength": 10,	
	"aoColumns":[
                    {'mData': 'id','sname':'id', 'sType':'numeric', 'bVisible':true,"mRender": function ( data, type, full ) {
							return '<a href="acc/edit.htm?id='+data+'">'+data+'</a>';
							}
					},
                    {'mData': 'accountName','sName':'accountName', 'sType':'string','bVisible':true},
                    {'mData': 'phone','sName':'phone', 'sType':'string','bVisible':true},
                    {'mData': 'fax','sName':'fax', 'sType':'string','bVisible':true},
                    {'mData': 'email','sName':'email', 'sType':'string','bVisible':true},
                    {'mData': 'websiteUrl','sName':'websiteUrl', 'sType':'string','bVisible':true},
                    {'mData': 'address','sName':'address', 'sType':'string','bVisible':true},
                    {'mData': 'contactPerson','sName':'contactPerson', 'sType':'string','bVisible':true},
                    {'mData': 'contactPersonMobile','sName':'contactPersonMobile', 'sType':'string','bVisible':true}
                    ]	
    });
	
});

