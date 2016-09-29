<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<title>CST Diary</title>
 
<style type="text/css">
    <%@include file="../css/style.css" %>
</style>

</head>
<body>	
	<!-- main -->
	<div class="main">
		<div class="headercst">
			<!-- <p>Welcome to CST Diary...</p> -->
		</div>
			
		<div class="main-row">
			<div class="agileits-top">
<p>
				<c:if test="${not empty error}">
					${error}
				</c:if>
				<c:if test="${not empty msg}">
					${msg}
				</c:if></p>

				<form commandName="loginForm" name='loginForm'	action="<c:url value='/j_spring_security_check' />" method='POST'>
						<input class="text" type="text" name="username" placeholder="Username" required >
						<input class="text" type="password" name="password" placeholder="Password" required>
						<input type="submit" value="LOGIN" name="submit">	
						
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
								
				</form>
				<p><a href="#">Forgot password?</a></p>
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
</html> --%>