<%@ include file="/WEB-INF/include.jsp"%>
<html>
<head>
<title>Ads & Boards</title>
<link href="css/home.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/ui-lightness/jquery-ui-1.10.0.custom.min.css" />
<script src="js/jquery-1.9.0.min.js"></script>
<script src="js/jquery-ui-1.10.0.custom.min.js"></script>
<script src="js/jquery-migrate-1.1.0.min.js"></script>
<script type="text/javascript">
 var contextRoot='<spring:url javaScriptEscape="true" value="/" htmlEscape="true"/>';
</script>
<script src='<spring:url value="/js/main_search.js" htmlEscape="true"/>'></script>

<style>
	.toggler { width: 500px; height: 200px; }
	#button { padding: .5em 1em; text-decoration: none; }
	#effect { width: 240px; height: 150px; padding: 0.4em; position: relative; background-color: #FAF0E6; }
	#effect h3 { margin: 0; padding: 0.4em; text-align: center; }
	input {  display: block; margin: 10; }
</style>
<script>
$(function() {
	 var contextRoot='<spring:url javaScriptEscape="true" value="/" htmlEscape="true"/>';
	// run the currently selected effect
	function runEffect() {
		// run the effect
		$( "#effect" ).toggle("blind");
	};
	// set effect 
	$( "#button" ).click(function() {
		runEffect();
		return false;
	});
	
$( "#login" ).click(function() {
	var in1 = $("#username").val();
	var in2 = $("#password").val()
	$.ajax({
		  type: "POST",	
		  url: "login.htm",
		  data: "username=" + in1 + "&password=" + in2,
		  success: function(data) {
			  if(data){
				  document.location.href=contextRoot+'admin';  
			  }else{
				  $("#errormsg").html("Invalid Username/Passord");
			  }		  
		  }
	});
});


	$("#effect").hide();
	$("#uname").$("#pass").corner("round");
});
</script>
</head>
<body>
		
			<div class="page">
					<div class="header">
						<div class="header-top">
							<h1>
								Ads & <span>Boards</span>
							</h1>
						</div>
						<a href="#" id="button" class="ui-state-default ui-corner-all">Admin Login</a>
					<div class="toggler">
						<div id="effect" class="ui-widget-content ui-corner-all">
							<h3 class="ui-widget-header ui-corner-all">Admin Login</h3>
							<div id="uname">
								<input id="username" type="text" name="username" value="username"/>
							</div>
							<div id="pass">
								<input id="password" type="password" name="password" value="password"/>
							</div>
							<a href="#" id="login" class="ui-state-default ui-corner-all">Sign In</a>
							<div id="errormsg"></div>
						</div>
					</div>
					</div>
					
					<div class="footer">
						<p>
							&copy; Copyright 2010. Designed by <a target="_blank"
								href="#">Arun</a><br>
						</p>
						<ul>
							<li style="border-left: medium none;"><a href="index.html"><span>Home</span></a></li>
							<li><a href="#"><span>About&nbsp;us</span></a></li>
							<li><a href="#"><span>What's&nbsp;new</span></a></li>
							<li><a href="#"><span>Services</span></a></li>
							<li><a href="#"><span>Contact</span></a></li>
							<li><a href="#"><span>Resources</span></a></li>
							<li style="padding-right: 0px;"><a href="#"><span>Links</span></a></li>
						</ul>
					</div>
				
			
		</div>
	
</body>
</html>
