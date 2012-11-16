<%@ include file="/WEB-INF/include.jsp"%>
<html>
<head>
<title>Home</title>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">

        $(document).ready(function(){
        	
        	$("#login").click(function(){
        		alert("begin");
        		var in1 = $("#username").val();
        		var in2 = $("#password").val()
        		$.ajax({
        			  type: "POST",	
        			  url: "login.htm",
        			  data: "username=" + in1 + "&password=" + in2,
        			  success: function(data) {
        				  alert(data);
        			   $("#display").html("data:"+data);
        			  }
        			});
        	});
        });
        </script>
</head>
<body>
	<h1>Hello world!</h1>
	<input type="text" id="username" name="Username"/>
	<input type="password" id="password" name="Password"/>
	<input type="button" id="login" value="Sign In" />
	<div id="display"></div>
</body>
</html>
