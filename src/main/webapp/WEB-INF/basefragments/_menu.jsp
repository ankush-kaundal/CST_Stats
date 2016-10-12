<style type="text/css">
    <%@include file="../css/w3.css" %>
    <%@include file="../css/font-awesome.min.css" %> 
    <%@include file="../css/style_button.css" %>
</style>

<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">


<div class="w3-sidenav w3-black w3-large" style="border: 1px solid white;width:15%;">
	<div class="w3-container w3-row">
		<div class="w3-col s4">
			<img src="/WEB-INF/bg.jpg" class="w3-circle w3-margin-right" alt="aaa"
				style="width: 46px">
		</div>
		<div class="w3-col s8">
			<span>Welcome, <strong>${welcomeUserName}</strong></span><br>
			<a href="#"
				class="w3-hover-none w3-hover-text-red w3-show-inline-block"><i
				class="fa fa-envelope"></i></a> <a href="#"
				class="w3-hover-none w3-hover-text-green w3-show-inline-block"><i
				class="fa fa-user"></i></a> <a href="#"
				class="w3-hover-none w3-hover-text-blue w3-show-inline-block"><i
				class="fa fa-cog"></i></a>
		</div>
	</div>
	<hr>
	<ul>
		<%-- <li><a href="${pageContext.request.contextPath}/">Home</a></li><br>
		<li><a href="${pageContext.request.contextPath}/contactus">Contact Us</a></li><br> --%>
		<li><a href="${pageContext.request.contextPath}/default">Overview</a></li><br>
		<li><a href="${pageContext.request.contextPath}/cstChecklist">CST Checklist</a></li><br>
		<li><a href="${pageContext.request.contextPath}/default">Resource Utilization</a></li><br>
		
		<li><a href="${pageContext.request.contextPath}/weekly">Weekly</a></li>
		<ul>			
			<li><a href="${pageContext.request.contextPath}/viewAllWeekly"> &nbsp;&nbsp;&nbsp;&nbsp; View
					Weekly</a></li>
		</ul><br>
		<li ><a href="${pageContext.request.contextPath}/leavePlanner">Leave Planner</a></li>
		<ul>			
			<li><a href="${pageContext.request.contextPath}/viewAllAppliedLeave"> &nbsp;&nbsp;&nbsp;&nbsp; View
					Leave</a></li>
				
		</ul><br><li><a href="${pageContext.request.contextPath}/projectDetails">Project Details</a></li><br>
		<li><a href="${pageContext.request.contextPath}/minutesOfMeeting">Minutes of Meeting</a></li><br>
		<li><a href="${pageContext.request.contextPath}/seatAllocationLink">Seat Allocation Link</a></li><br>
		<li><a href="${pageContext.request.contextPath}/upcomingEvents">Upcoming Events</a></li><br>

	</ul>
</div>