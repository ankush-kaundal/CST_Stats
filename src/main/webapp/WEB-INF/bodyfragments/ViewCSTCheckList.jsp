<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style type="text/css"> 
    <%@include file="../css/table.css" %>
</style>

<div style="margin-top: 60px;">
	<form action="#" method="get">
		<h1 style="font-size: 20px">
			<b><strong>CST Check List by Project</strong></b>
		</h1>

		<div style="margin-top: 10px;">
			<select id="projectNameCodeId" onchange="projectNameCodeAction()">
				<option>None</option>
				<c:forEach items="${projectNameCodeList}" var="listValue">
					<option value="${listValue.projectCode}">${listValue.projectCode} :
						(${listValue.projectName})</option>
				</c:forEach>
			</select> <input type="hidden" id="userId" name="userId" />
			<button>Submit</button>
			<br>
		</div>

		<br>
		<div style="width: 1000px; overflow: auto">
			<table class="sample" style="width: 980px;">
				<tr>
					<th colspan='3' align="center" style="background-color: LIGHTCORAL;">Project Info</th>
				</tr>	
				<tr>
					<th>Description</th>
					<th>Notes/Comments</th>
				</tr>
				<tr>
					<th colspan='2' align="center" style="background-color: AQUA;">Project Management</th>
				</tr>
				<tr>
					<td>Project Name</td>
					<td>
						<input type="text" id="textIdProjectName" size="90"/>
					</td>
				</tr>
				<tr>
					<td>Project Code</td>
					<td>
						<input type="text" id="textIdProjectCode" size="90"/>
					</td>
				</tr>
				<tr>
					<td>Project Plan</td>
					<td>
						<input type="text" id="textId11" size="90"/>
					</td>
				</tr>
				<tr>
					<td>Billing Information</td>
					<td>
						<input type="text" id="textId12" size="90"/>
					</td>
				</tr>
				<tr>
					<td>RMT</td>
					<td>
						<input type="text" id="textId13" size="90"/>
					</td>
				</tr>	
				<tr>
					<td>SalesForce-Usage </td>
					<td>
						<select id="cmboxId11">
							<option>No</option>
							<option>Yes</option>							
						</select>
					</td>
				</tr>	
				<tr>
					<th colspan='2' align="center" style="background-color: AQUA;">GEO  Engagement</th>
				</tr>		
				<tr>
					<td>Onsite team details</td>
					<td>
						<input type="text" id="textId14" size="90"/>
					</td>
				</tr>
				<tr>
					<td>Customer team details</td>
					<td>
						<input type="text" id="textId15" size="90"/>
					</td>
				</tr>	
				<tr>
					<th colspan='2' align="center" style="background-color: AQUA;">Environment Details</th>
				</tr>		
				<tr>
					<td>Environment Info</td>
					<td>
						<input type="text" id="textId16" size="90"/>
					</td>
				</tr>
				<tr>
					<td>Windows Project VM- Build/Debug</td>
					<td>
						<input type="text" id="textId17" size="90"/>
					</td>
				</tr>
				<tr>
					<td>Development VM image path</td>
					<td>
						<input type="text" id="textId18" size="90"/>
					</td>
				</tr>	
						
				<tr>
					<th colspan='2' align="center" style="background-color: AQUA;">Code Management</th>
				</tr>		
				<tr>
					<td>WM/MDA are separate Repos</td>
					<td>
						<select id="cmboxId12">
							<option>No</option>
							<option>Yes</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>WM Repo</td>
					<td>
						<input type="text" id="textId19" size="90"/>
					</td>
				</tr>
				<tr>
					<td>MDA Repo</td>
					<td>
						<input type="text" id="textId20" size="90"/>
					</td>
				</tr>	
				<tr>
					<td>GIT Info</td>
					<td>
						<input type="text" id="textId21" size="90"/>
					</td>
				</tr>	
				<tr>
					<td>Mod Specs</td>
					<td>
						<input type="text" id="textId22" size="90"/>
					</td>
				</tr>	
				<tr>
					<td>Technical Document</td>
					<td>
						<input type="text" id="textId23" size="90"/>
					</td>
				</tr>	
				<tr>
					<td>Delivery Note</td>
					<td>
						<input type="text" id="textId24" size="90"/>
					</td>
				</tr>	
			</table>
		</div>

		<br> <br>
		<div style="width: 1000px; overflow: auto">
			<table class="sample" style="width: 980px;">
				<tr>
					<th colspan='3' align="center" style="background-color: LIGHTCORAL;">Entry Criteria</th>
				</tr>	
				<tr>
					<th>Description</th>
					<th>Availability ?</th>
					<th>Comments</th>
				</tr>
				<tr>
					<td>Any mods in progress?</td>
					<td align="center">
						<select id="cmboxId1">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td align="center">
						<input type="text" id="textId1" size="80"/>
					</td>
				</tr>
				<tr>
					<td>Is the project Status Red?</td>
					<td align="center">
						<select id="cmboxId2">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td align="center">
						<input type="text" id="textId2" size="80"/>
					</td>
				</tr>
				<tr>
					<td>Any planned group of mods?</td>
					<td align="center">
						<select id="cmboxId3">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td align="center">
						<input type="text" id="textId3" size="80"/>
					</td>
				</tr>
				<tr>
					<td>Is Go-live date more than 2 months?</td>
					<td align="center">
						<select id="cmboxId4">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td align="center">
						<input type="text" id="textId4" size="80"/>
					</td>
				</tr>
				<tr>
					<td>All extensions tested and installed at Customer environment?</td>
					<td align="center">
						<select id="cmboxId5">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td align="center">
						<input type="text" id="textId5" size="80"/>
					</td>
				</tr>
				<tr>
					<td>Number of open custom P1, P2, P3 count with India Team < 20 ?</td>
					<td align="center">
						<select id="cmboxId6">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td align="center">
						<input type="text" id="textId6" size="80"/>
					</td>
				</tr>
				<tr>
					<td>Is resource hand-over planned or just KT for existing resources in CST?</td>
					<td align="center">
						<select id="cmboxId7">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td align="center">
						<input type="text" id="textId7" size="80"/>
					</td>
				</tr>
				<tr>
					<td>Number of Project Hours (Bill/Non-Bill) logged for last month < 500 hrs (3 FTE)?</td>
					<td align="center">
						<select id="cmboxId8">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td align="center">
						<input type="text" id="textId8" size="80"/>
					</td>
				</tr>				
			</table>
		</div>

		
		<br><br>
		<div style="width: 1000px; overflow: auto">
			<table class="sample" style="width: 980px;">
				<tr>
					<th colspan='3' align="center" style="background-color: LIGHTCORAL;">Check List</th>
				</tr>
				<tr>
					<th width="20">Description</th>
					<th>Availability ?</th>
					<th>Comments</th>
				</tr>
				<tr>
					<td>Is the VPT planned?</td>
					<td>
						<select id="cmboxId31">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td>
						<input type="text" id="textId31" size="80"/>
					</td>
				</tr>
				<tr>
					<td>Warehouse flow Document</td>
					<td>
						<select id="cmboxId32">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td>
						<input type="text" id="textId32" size="80"/>
					</td>
				</tr>
				<tr>
					<td>Version/Rollup information</td>
					<td>
						<select id="cmboxId33">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td>
						<input type="text" id="textId33" size="80"/>
					</td>
				</tr>
				<tr>
					<td>Mod vs Environment Mapping</td>
					<td>
						<select id="cmboxId34">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td>
						<input type="text" id="textId34" size="80"/>
					</td>
				</tr>
				<tr>
					<td>Java/CPP build and runtime should be in Sync</td>
					<td>
						<select id="cmboxId35">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td>
						<input type="text" id="textId35" size="80"/>
					</td>
				</tr>
				<tr>
					<td>List of SF cases for all the Extension/Issue</td>
					<td>
						<select id="cmboxId36">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td>
						<input type="text" id="textId36" size="80"/>
					</td>
				</tr>
				<tr>
					<td>Configuration Document for all the Extension's</td>
					<td>
						<select id="cmboxId37">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td>
						<input type="text" id="textId37" size="80"/>
					</td>
				</tr>
				<tr>
					<td>Build Box(Java/CPP) should be in sync with GIT</td>
					<td>
						<select id="cmboxId38">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td>
						<input type="text" id="textId38" size="80"/>
					</td>
				</tr>	
				
				<tr>
					<td>Add CST manager to netsteps as development manager</td>
					<td  colspan='2'>
						<select id="cmboxId38">
							<option>No</option>
							<option>Yes</option>
						</select>
					</td>
				</tr>	
						
				<tr>
					<td>SDN Creation/Delivery process should be documented</td>
					<td>
						<select id="cmboxId39">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td>
						<input type="text" id="textId40" size="80"/>
					</td>
				</tr>		
				<tr>
					<td>Knowledge Transfer for all Complex MOD(s)/Extension's</td>
					<td>
						<select id="cmboxId41">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td>
						<input type="text" id="textId41" size="80"/>
					</td>
				</tr>		
				<tr>
					<td>Fixpack creation Process? FullFix Pac/Incremental Pack</td>
					<td>
						<select id="cmboxId42">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td>
						<input type="text" id="textId42" size="80"/>
					</td>
				</tr>	
				<tr>
					<td>Test Scripts checked-in in MA-MATTERS for all the Extension's</td>
					<td>
						<select id="cmboxId44">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td>
						<input type="text" id="textId44" size="80"/>
					</td>
				</tr>	
				<tr>
					<td>Resource handover during CST transition - Does this resource know most of the mods</td>
					<td>
						<select id="cmboxId45">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td>
						<input type="text" id="textId45" size="80"/>
					</td>
				</tr>	
				<tr>
					<td>JIRA Ticket's used to check-in the file should be mentioned in corresponding SF Case</td>
					<td>
						<select id="cmboxId46">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td>
						<input type="text" id="textId46" size="80"/>
					</td>
				</tr>				
			</table>
		</div>
		
		<br><br><br><br><br>

	</form>
</div>

<script>function projectNameCodeAction(){
	var userId = document.getElementById("userNameList").value;
	document.getElementById('userId').value  = userId;
	
}</script>