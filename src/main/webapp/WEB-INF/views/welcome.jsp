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
	input {  display: block; margin: 10; }
</style>
</head>
<body>
		
			<div class="page">
					<div class="header">
						<div class="header-top">
							<h1>
								Ads & <span>Boards</span>
							</h1>
						</div>

					</div>
					
					<div>
						<ul>
						<form:form commandName="adboard" method="post" action="search/adboards">
							<form:hidden id="cityHiddenId" path="city.id" />
							<li>Country <input id="countrysearch" type="text"/></li>
							<li>State <input id="statesearch" type="text"/></li>
							<li>City <input id="citysearch" type="text"/></li>
							<li>Street(Optional) <form:input id="streetId" path="street" /></li>
							<li><input type="submit" value="Search"/></li>
						</form:form>
						</ul>
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
