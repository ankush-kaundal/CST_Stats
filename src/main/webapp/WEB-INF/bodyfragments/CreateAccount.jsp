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

			<form name='createUserAccount' action="validateAndCreateUserAccount" method="post">
				<p id="errorMessage">${response}</p>
				<input class="text" type="text" name="userName"
					placeholder="UserName" required> <input class="text"
					type="text" name="userEmailId" placeholder="Manh E-Mail Id"
					required> <input class="text" type="password"
					name="password" placeholder="Password" required> <input
					type="submit" value="Submit" name="submit">
			</form>
		</div>
	</div>

	<div class="copyright">
		<p>
			© 2016 CD. All rights reserved | Design by <a href="http://manh.com/"
				target="_blank"><font color="#999999"><b>CST</b></font></a>
		</p>
	</div>
</body>
</html>