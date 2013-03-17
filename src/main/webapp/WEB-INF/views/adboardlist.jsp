<%@ include file="/WEB-INF/include.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE> AdBoard </TITLE>

<script src="js/DataTables-1.9.4/media/js/jquery.js"></script>
<script src="js/DataTables-1.9.4/media/js/jquery-ui.js"></script>
<script src="js/DataTables-1.9.4/media/js/jquery.dataTables.min.js"></script>
<script src="js/DataTables-1.9.4/media/js/dataTables.scroller.js"></script>

<link rel="stylesheet" href="js/DataTables-1.9.4/media/css/jquery.dataTables.css"/>
<link rel="stylesheet" href="js/DataTables-1.9.4/media/css/demo_table_jui.css"/>
<link rel="stylesheet" href="js/DataTables-1.9.4/media/css/jquery.dataTables_themeroller.css"/>
<link rel="stylesheet" href="css/ui-base/jquery-ui-1.8.11.custom.css"/>

<link rel="stylesheet" href="css/grid.css"/>
<script src="js/orggrid.js"></script>
<style>
	td{
		position:relative;
	}
</style>
</HEAD>

<BODY style= "background-color: #DEDEDE;margin: 0;">
	
		<div class="mainContainer">
			<div  style="background-color: #a0d5dd; width: 100%; height: 315px;padding-top: 40px;">
			<div class="mainHeader">Organization</div>
			<div>
				<div class="gridContainer">
					<h1 id="pgridHeader">List</h1>
					<table id="predictiveGrid" border="1">
						<thead>
							<tr class="headerRow">
								<th align="left" width="200"> ID</th>
								<th align="left" width="200">Name</th>
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
<!--		<div class="ratingPanel"><div class="progressWrapper"><div class="progressBar"><span class="progressValue">49</span><span class="avgValue"></span><span class="startLine"></span></div></div></div>-->

</BODY>
</HTML>