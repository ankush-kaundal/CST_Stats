<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<link href="<c:url value="/resources/css/styles.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/css/jquery-ui.css"/>" rel="stylesheet">
	<script src="<c:url value="/resources/js/jquery-1.10.2.min.js"/>"></script	>
	<script src="<c:url value="/resources/js/jquery.tablesorter.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery-ui.js"/>"></script> 
	<style>
	.toggler {
		width: 500px;
		height: 200px;
	}
	
	#button {
		padding: .5em 1em;
		text-decoration: none;
	}
	
	#effect {
		position: relative;
		width: 240px;
		height: 170px;
		padding: 0.4em;
	}
	
	#effect h3 {
		margin: 0;
		padding: 0.4em;
		text-align: center;
	}
	</style>
</head>
<body>
	<div style="margin-top: 60px;">
		<h1 style="font-size: 18px">Resource Utilization</h1>
		
		<form action="submitUtilization" method="get">
			From<input type="text" id="fromDatePicker" name="fromDate" value="${fromDate}"/>
			To<input type="text" id="toDatePicker" name="toDate" value="${toDate}"/> 
			
			<!-- <input type="button" value="Fetch data"	id="fetchButton"> -->
			<input type = "hidden" name = "clientHours" value = "111111" />
			<button onclick="progress(80, $('#progressBar'));" id="fetchButton">Fetch data</button>
		</form>	
		<br/>
			 <label>Quick Search: <input id="search" type="text" ></label>
		<div style="width: 900px; height: 700px; overflow: auto" id="effect">
			<table class="sample" style="width: 880px; display: table"
				id="keywords1">
				<thead>
					<tr>
						<th>Name</th>
						<th>Total Hours</th>
						<th>Client Hours</th>
						<th>HOL-OFF</th>
						<th>CDEV</th>
						<th>Resource Util %</th>
						<th>Billability</th>
						<th>Billable %</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${resourceDataMap}" var="data">
						<tr>
							<td align="center">${data.value.name}</td>

							<c:choose>
								<c:when test="${data.value.totalHours < 40}">
									<td align="center" style='color: red;'>${data.value.totalHours}</td>
								</c:when>
								<c:otherwise>
									<td align="center">${data.value.totalHours}</td>
								</c:otherwise>
							</c:choose>

							<td align="center">${data.value.clientHours}</td>
							<td align="center">${data.value.holidayOff}</td>
							<td align="center">${data.value.cdev}</td>

							<c:choose>
								<c:when test="${data.value.resourceUtilization < 40}">
									<td align="center" style='background-color: #de4343;'>${data.value.resourceUtilization}%</td>
								</c:when>
								<c:when test="${data.value.resourceUtilization > 85}">
									<td align="center" style='background-color: #1c7d08;'>${data.value.resourceUtilization}%</td>
								</c:when>
								<c:otherwise>
									<td align="center">${data.value.resourceUtilization}%</td>
								</c:otherwise>
							</c:choose>
							<td align="center">${data.value.billability}</td>
							<td align="center">${data.value.billablePercent}%</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<script>
		var $cells = $("td");
		$("#search").keyup(function() {
			var val = $.trim(this.value).toUpperCase();
			if (val === "")
				$cells.parent().show();
			else {
				$cells.parent().hide();
				$cells.filter(function() {
					return -1 != $(this).text().toUpperCase().indexOf(val);
				}).parent().show();
			}
		});

		function toggleTable() {
			alert("Fetching data, please wait");
			document.getElementById("fetchButton").disabled = "true";
			if (document.getElementById("keywords").style.display == "table") {
				document.getElementById("keywords").style.display = "none";
			} else {
				document.getElementById("keywords").style.display = "table";
			}
		}
		
		$(function(){
			  $('#keywords1').tablesorter(); 
		});
		
		$(function() {
			$("#fromDatePicker").datepicker();
		});

		$(function() {
			$("#toDatePicker").datepicker();
		});
		
		
		var availableTags = new Array();
		$(document).ready(function() {
			$("#keywords1 tr td:nth-child(1)").each(function(i) {
				availableTags.push($(this).text());
			});
		});

		$(function() {
			$("#search").autocomplete({
				source : availableTags
			});
		});
		
		
		$(function() {
			$(document).tooltip();
		});

		$(function() {
			// run the currently selected effect
			function runEffect() {
				// get effect type from
				var selectedEffect = 'fade';

				// Most effect types need no options passed by default
				var options = {};

				// Run the effect
				$("#effect").toggle(selectedEffect, options, 500);
			}
			;

			// Set effect from select menu value
			$("#fetchButton").on("click", function() {
				runEffect();
			});
		});
	</script>
</body>
</html>