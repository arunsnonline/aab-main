

$(document).ready(function() {	
	
    tableObj = $('#mainGrid').dataTable( {
    "bProcessing": true, 
    "bServerSide": true,
    "sAjaxSource": "adboard/list.htm", 
	"bJQueryUI": true,
	"aaSorting": [[0,'asc']] , 
	"iDisplayLength": 10,	
	"aoColumns":[
                    {'mData': 'id','sname':'id', 'sType':'numeric', 'bVisible':true,"mRender": function ( data, type, full ) {
								return '<a href="adboard/edit.htm?id='+data+'">'+data+'</a>';
							}
					},
                    {'mData': 'street','sName':'street', 'sType':'string','bVisible':true},
                    {'mData': 'detailedLocation','sName':'detailedLocation', 'sType':'string','bVisible':true},
                    {'mData': 'boardType.name','sName':'boardType', 'sType':'string','bVisible':true},
					{'mData': 'length','sName':'length', 'sType':'string','bVisible':true,"mRender": function ( data, type, full ) {
								return full.length+'*'+full.breadth+' '+full.uom;
							}
					}
                    ]	
    });
	
});

