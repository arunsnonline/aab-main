<%@ include file="/WEB-INF/include.jsp"%>
<html>
<head>
<title>Home</title>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
        $(document).ready(function(){
        	$("#add").click(function(){
        		alert("begin");
        		var in1 = $("#input1").val();
        		var in2 = $("#input2").val()
        		$.ajax({
        			  type: "POST",	
        			  url: "/spring-hiber/add.htm",
        			  data: "input1=" + in1 + "&input2=" + in2,
        			  success: function(data) {
        			   $("#display").html(data);
        			   
        			  }
        			});
        	});
        });
        </script>
</head>
<body>
	<h1>Hello world!</h1>
	<input type="text" id="input1" />
	<input type="text" id="input2" />
	<input type="button" id="add" value="Add" />
	<div id="display" />
</body>
</html>
