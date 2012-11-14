<%@ include file="/WEB-INF/include.jsp"%>
<html>
<head>
<title>Home</title>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">

        $(document).ready(function(){
        	var getHost = function() {
        		 var port = "8080";
        		// var port = (window.location.port == "8080") ? ":8443" : "";
        	    //return ((secure) ? 'https://' : 'http://') + window.location.hostname + port;
        		 return 'http://' + window.location.hostname + port;
        	};
        	
        	$("#login").click(function(){
        		alert("begin");
        		var in1 = $("#username").val();
        		var in2 = $("#password").val()
        		$.ajax({
        			  type: "POST",	
        			  url: getHost()+"/login.htm",
        			  data: "username=" + in1 + "&password=" + in2,
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
	<input type="text" id="username" value="Username"/>
	<input type="text" id="password" value="Password"/>
	<input type="button" id="login" value="Sign In" />
	<div id="display" />
</body>
</html>
