<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<title>CST Diary</title>

<style type="text/css">
    <%@include file="../style.css" %>
</style>

</head>
<body>	
	<!-- main -->
	<div class="main" style="margin-top: 40px;">
		<div class="headercst">
			 <p>Welcome to CST Diary...</p> 
		</div>
			
		<div class="main-row">
			<div class="agileits-top">
				<form name='createAccount' action="createAccount" method="get">
						<input class="text" type="text" name="userName" placeholder="UserName" required >
						<input class="text" type="text" name="userEmailId" placeholder="Manh E-Mail Id" required >
						<input class="text" type="password" name="password" placeholder="Password" required>
						<input type="submit" value="Submit" name="submit">		
				</form>
			</div>	 
		</div>	
		
		<!-- copyright -->
		<div class="copyright">
			<p> © 2016 CD. All rights reserved | Design by <a href="http://manh.com/" target="_blank"><font color="#999999"><b>CST</b></font></a></p>
		</div>
		<!-- //copyright -->
	</div>	
	<!-- //main --> 
</body>
</html>