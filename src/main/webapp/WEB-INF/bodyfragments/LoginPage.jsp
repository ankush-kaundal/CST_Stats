<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<title>CST Diary</title>

<style type="text/css">
    <%@include file="../css/style.css" %>
</style>
</head>
<body>
	<div class="main " style="margin-top: 80px; margin-left: 10%">
		<div class="main-row agileits-top">
			<p>Welcome to CST Diary...</p><br><br>
			<p id="errorMessage">${response}</p>
			<form name="loginForm" action="loginForm" method="post">
				<input class="text" type="text" name="userEmailId"
					placeholder="E-MailId" required> <input class="text"
					type="password" name="password" placeholder="Password" required>
				<input type="submit" value="LOGIN" name="submit">
			</form>
			<p>
				<a href="#">Forgot password?</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
					href="createUserPage">Create Account?</a>
			</p>
		</div>

		<div class="copyright">
			<p>
				© 2016 CD. All rights reserved | Design by <a
					href="http://manh.com/" target="_blank"><font color="#999999"><b>CST</b></font></a>
			</p>
		</div>
	</div>
</body>
</html>