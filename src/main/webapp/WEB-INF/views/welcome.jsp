<%@ include file="/WEB-INF/include.jsp"%>
<html>
<head>
<title>Ads & Boards</title>
<link href="css/home.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/ui-lightness/jquery-ui-1.10.0.custom.min.css" />
<script src="js/jquery-1.9.0.min.js"></script>
<script src="js/jquery-ui-1.10.0.custom.min.js"></script>
<script src="js/jquery-migrate-1.1.0.min.js"></script>
<script src="js/unslider.min.js"></script>
<script type="text/javascript">
 var contextRoot='<spring:url javaScriptEscape="true" value="/" htmlEscape="true"/>';
 $('.intro').unslider({
		keys: true,               //  Enable keyboard (left, right) arrow shortcuts
		dots: true               //  Display dot navigation
	});
</script>
<script src='<spring:url value="/js/main_search.js" htmlEscape="true"/>'></script>
<style>
	input {  display: block; margin: 10; }
</style>
</head>
<body>
		
			<div class="header">
				<img class="board-image" src="images/outdoor-billboard.png" />
			</div>
		
			<div class="page">	
					<div class="searchbox">
						<ul>
						<form:form commandName="adboard" method="post" action="search/adboards">
							<form:hidden id="cityHiddenId" path="city.id" />
							<li><input id="countrysearch" type="text" placeholder="Enter Country"/></li>
							<li><input id="statesearch" type="text" placeholder="Enter State"/></li>
							<li><input id="citysearch" type="text" placeholder="Enter City"/></li>
							<li><form:input id="streetId" path="street" placeholder="Enter Street(Optional)"/></li>
							<li><input type="submit" value="Search"/><a id="adv_search" href="#">More Search Options</a></li>
						</form:form>
						</ul>
					</div>
					
<!--	 <div class="intro"> 
						  <ul>
        					<li style="background-color: #780000">This is a slide.</li>
        					<li style="background-color: #0099CC">This is another slide.</li>
        					<li style="background-color: #FFFF66">This is a final slide.</li>
    					</ul>
					</div> -->
					
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
		
		<div id="adv_pop">
		<form:form commandName="adboard" method="post" action="search/adboards">
			<ul>
							<form:hidden id="cityHiddenId" path="city.id" />
							<form:hidden id="contractDays" path="contractDays" />
							<form:hidden id="contractStartDate" path="contractStartDate" />
							<li><input id="countrysearchpop" type="text" placeholder="Enter Country"/></li>
							<li><input id="statesearchpop" type="text" placeholder="Enter State"/></li>
							<li><input id="citysearchpop" type="text" placeholder="Enter City"/></li>
							<li><form:input id="streetIdpop" path="street" placeholder="Enter Street(Optional)"/></li>
							
			</ul>
			<ul>
							<li><input id="available" type="checkbox">Show only available<br></li>
							<li><form:input path="length" placeholder="Length in Ft"/></li>
							<li><form:input path="breadth" placeholder="Breadth in Ft"/></li>
							<li><form:input path="detailedLocation" placeholder="Landmark"/></li>
							<li><form:select path="boardType.id" items="${boardTypeList}" itemValue="id" itemLabel="name"/></li>
							
			</ul>
						<input type="submit" value="Search"/>
		</form:form>
		</div>
	
</body>
</html>
