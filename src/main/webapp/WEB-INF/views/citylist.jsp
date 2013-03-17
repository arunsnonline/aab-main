<%@ include file="/WEB-INF/include.jsp"%>
<HTML>
<HEAD>
<TITLE> AdBoard </TITLE>

<script src='<spring:url value="/js/jquery-1.9.0.min.js" htmlEscape="true"/>'></script>
<script src='<spring:url value="/js/jquery-migrate-1.1.0.min.js" htmlEscape="true"/>'></script>
<script src='<spring:url value="/js/DataTables-1.9.4/media/js/jquery.dataTables.min.js" htmlEscape="true"/>'></script>


<link rel="stylesheet" href='<spring:url value="/js/DataTables-1.9.4/media/css/jquery.dataTables.css" htmlEscape="true"/>'/>
<link rel="stylesheet" href='<spring:url value="/js/DataTables-1.9.4/media/css/demo_table_jui.css" htmlEscape="true"/>'/>
<link rel="stylesheet" href='<spring:url value="/js/DataTables-1.9.4/media/css/jquery.dataTables_themeroller.css" htmlEscape="true"/>'/>
<link rel="stylesheet" href='<spring:url value="/css/ui-base/jquery-ui-1.8.11.custom.css" htmlEscape="true"/>'/>

<link rel="stylesheet" href='<spring:url value="/css/grid.css" htmlEscape="true"/>'/>
<script src='<spring:url value="/js/citygrid.js" htmlEscape="true"/>'></script>

<style>
	td{
		position:relative;
	}
</style>
</HEAD>

<BODY style= "background-color: #DEDEDE;margin: 0;">
	
		<div class="mainContainer">
			<div  style="background-color: #a0d5dd; width: 100%; height: 315px;padding-top: 40px;">
			<div class="mainHeader">City</div>
			<a href='<c:url value="/admin"/>'>Admin Home</a>
			<a href='<c:url value="/admin/city/new"/>'>New</a>
			<div>
				<div class="gridContainer">
					<h1 id="gridHeader"></h1>
					<table id="mainGrid" border="1">
						<thead>
							<tr class="headerRow">
								<th align="left" width="200"> Id</th>
								<th align="left" width="200">City</th>
							</tr>
					</thead>
					<tbody></tbody>
					</table>				
			</div>
			<div class="tableFooter"><div style="margin-left: 200px;margin-top: 10px;">&copy; Copyright 2013</div></div>				
			</div>
			</div>
		</div>
		<!-- 	<div id="busyicon">
				<img src="images/loading.gif"/>
			</div>
		 -->

</BODY>
</HTML>