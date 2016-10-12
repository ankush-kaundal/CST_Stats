<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
$( function() {
  $( "#accordion" ).accordion();
} );
</script>

<body>
 
<div id="accordion" style="margin-top:60px;">


		<c:forEach items="${projectDetails}" var="listValue">
			<h3>${listValue.projectCode} : ${listValue.projectName}</h3>
			<div>
				<p>Mauris mauris ante, blandit et, ultrices a, suscipit eget,
					quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida
					in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros.
					Nam mi. Proin viverra leo ut odio. Curabitur malesuada. Vestibulum
					a velit eu ante scelerisque vulputate.</p>
			</div>
		</c:forEach>
	</div> 
 
</body>
