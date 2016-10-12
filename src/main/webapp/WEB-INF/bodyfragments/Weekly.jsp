<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css"> 
    <%@include file="../css/table.css" %>
</style>

<div style="margin-top:60px;">

	<h1 style="font-size:70;">
		Project Name : 
	</h1>

	<div style="margin-top:10px;">
		<select name="projectlist" id="projectlist"
			onchange="activateFields()">
			<option>None</option>
			<c:if test="${not empty projectDetails}">
				<ul>
					<c:forEach items="${projectDetails}" var="listValue">
						<option	value="${listValue.projectCode} : ${listValue.projectName}">
							${listValue.projectCode} : ${listValue.projectName}</option>
					</c:forEach>
					</select>
				</ul>
			</c:if>
		</select>
		
		<form action="submitWeekly">
			<div style="margin-top: 20px; display: none" id="WeeklyTableForm">
				<table class="sample">
					<tr>
						<th scope="col"></th>
						<th scope="col"># Delivered</th>
						<th scope="col"># In-Progress</th>
						<th scope="col"># Open</th>
					</tr>
					<tr>
						<th scope="row">Base Issue</th>
						<td><input type="text" id="baseDelivered"
							name="baseDeliveredIssue" value="0" size="25" maxlength="3"
							onkeypress='validate(event)' required /></td>
						<td><input type="text" id="baseInProgress"
							name="baseInprogressIssue" value="0" size="25" maxlength="3"
							onkeypress='validate(event)' required /></td>
						<td><input type="text" id="baseOpen"
							name="baseOpenIssue" value="0" size="25" maxlength="3"
							onkeypress='validate(event)' required /></td>
					</tr>
					<tr>
						<th scope="row">Custom Issue</th>
						<td><input type="text" id="customDelivered"
							name="customDeliveredIssue" value="0" size="25" maxlength="3"
							onkeypress='validate(event)' required /></td>
						<td><input type="text" id="customInProgress"
							name="customInprogressIssue" value="0" size="25" maxlength="3"
							onkeypress='validate(event)' required /></td>
						<td><input type="text" id="customOpen"
							name="customOpenIssue" value="0" size="25" maxlength="3"
							onkeypress='validate(event)' required /></td>
					</tr>
					<tr>
						<th scope="row">Mod Extensions</th>
						<td><input type="text" id="modDelivered"
							name="modDeliveredIssue" value="0" size="25" maxlength="3"
							onkeypress='validate(event)' required /></td>
						<td><input type="text" id="modInProgress"
							name="modInprogressIssue" value="0" size="25" maxlength="3"
							onkeypress='validate(event)' required /></td>
						<td><input type="text" id="modOpen"
							name="modOpenIssue" value="0" size="25" maxlength="3"
							onkeypress='validate(event)' required /></td>
					</tr>
					<tr>
						<th scope="row">Comments</th>
						<td colspan="4"><textarea id="comments" name="comments"
								style="width: 725px; height: 300px; border: 0"></textarea></td>
					</tr>
					<tr>
						<td colspan="5" align="center"><button
								style="cursor: pointer; border: 1px solid #A8F1FF; border-radius: 5px; background-color: #444; color: #fff; padding: 5px;">Submit</button></td>
					</tr>
				</table>
				
				<input type="hidden" id="projectCodeId" name="projectCode" />
				<input type="hidden" id="projectCodeName" name="projectName" />
				
			</div>
		</form>
		
	</div>

	<!-- End page content -->
</div>

<script>
function activateFields(){
	var projectlistValue = document.getElementById("projectlist").value;
	
	var fields = projectlistValue.split(" : ");
    document.getElementById('projectCodeId').value = fields[0];
	document.getElementById('projectCodeName').value = fields[1];
	
	var element = document.getElementById("WeeklyTableForm");
    if(projectlistValue != 'None'){
        element.style.display = 'block';
    }else{
        element.style.display = 'none';
    }
}

function validate(evt) {
	var theEvent = evt || window.event;
	var key = theEvent.keyCode || theEvent.which;
	key = String.fromCharCode(key);
	var regex = /[0-9]|\./;
	if (!regex.test(key)) {
		theEvent.returnValue = false;
		if (theEvent.preventDefault)
			theEvent.preventDefault();
	}
}
</script>