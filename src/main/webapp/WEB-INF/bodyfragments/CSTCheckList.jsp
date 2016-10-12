<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style type="text/css"> 
    <%@include file="../css/table.css" %>
</style>

<body onload="pageOnLoad()"> 
<div style="margin-top: 60px;">

	<form method="post" >
		<table class="sample" style="width: 400px;">
			<tr >
				<th style="border-width: 1px;background-color: white;border-color: gray;">
					<input type="radio" id="createRadio"  name="radios" value="radio1" onclick="createCSTCheckListEvent()"> New Check List 
				</th>
				<th style="border-width: 1px;background-color: white;border-color: gray;">
					<input type="radio" id="viewRadio" name="radios" value="radio2" onclick="viewCSTCheckListEvent()"> View/Update Check List
				</th>
			</tr>
		</table>
	</form>

	
	<form action="viewCSTListByProject" method="post" style="margin-top:10px; display: none;" id="projectDetailForm">
		<select id="projectNameCodeId" onchange="projectNameCodeAction()">
				<option>None</option>
				<c:forEach items="${projectNameCodeList}" var="listValue">
					<option value="${listValue.projectCode}">${listValue.projectCode} :
						(${listValue.projectName})</option>
				</c:forEach>
			</select> <input type="hidden" id="projectCodeId" name="projectCode" />
		
		<button style="cursor: pointer; box-shadow:  0px 2px 11px 0px rgba(0, 0, 0, 0.3); border: 1px solid #A8F1FF; 
					border-radius: 5px; background-color:#444; color: #fff;  float: none; padding: 5px;">Submit</button>
	</form>
	
	<br>
	<form action="submitCSTCheckList" method="post" >
		<div id="cstChecklistTable" style="margin-top:10px; display: block; width: 1000px; overflow: auto" id="cstCheckListTableId">
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
						<input type="text" id="textIdProjectName" size="90" name="projectName" value="${cstListByProjectCode.projectName}"  required />
					</td>
				</tr>
				<tr>
					<td>Project Code</td>
					<td>
						<input type="text" id="textIdProjectCode" size="90" name="projectCode" value="${cstListByProjectCode.projectCode}" onkeydown="convertToUpperCase(this)" required />
					</td>
				</tr>
				<tr>
					<td>Project Plan</td>
					<td>
						<input type="text" id="textId11" size="90" name="projectPlan" value="${cstListByProjectCode.projectPlan}"/>
					</td>
				</tr>
				<tr>
					<td>Billing Information</td>
					<td>
						<input type="text" id="textId12" size="90" name="billingInformation" value="${cstListByProjectCode.billingInformation}"/>
					</td>
				</tr>
				<tr>
					<td>RMT</td>
					<td>
						<input type="text" id="textId13" size="90" name="rmt" value="${cstListByProjectCode.rmt}"/>
					</td>
				</tr>	
				<tr>
					<td>SalesForce-Usage </td>
					<td>
						<select id="cmboxId11" name="salesforceUsage" value="${cstListByProjectCode.salesforceUsage}">
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
						<input type="text" id="textId14" size="90" name="onsiteTeamDetails" value="${cstListByProjectCode.onsiteTeamDetails}"/>
					</td>
				</tr>
				<tr>
					<td>Customer team details</td>
					<td>
						<input type="text" id="textId15" size="90" name="customerTeamDetails" value="${cstListByProjectCode.customerTeamDetails}"/>
					</td>
				</tr>	
				<tr>
					<th colspan='2' align="center" style="background-color: AQUA;">Environment Details</th>
				</tr>		
				<tr>
					<td>Environment Info</td>
					<td>
						<input type="text" id="textId16" size="90" name="environmentInfo" value="${cstListByProjectCode.environmentInfo}"/>
					</td>
				</tr>
				<tr>
					<td>Windows Project VM- Build/Debug</td>
					<td>
						<input type="text" id="textId17" size="90" name="windowsVmBox" value="${cstListByProjectCode.windowsVmBox}"/>
					</td>
				</tr>
				<tr>
					<td>Development VM image path</td>
					<td>
						<input type="text" id="textId18" size="90" name="vmImagePath" value="${cstListByProjectCode.vmImagePath}"/>
					</td>
				</tr>	
						
				<tr>
					<th colspan='2' align="center" style="background-color: AQUA;">Code Management</th>
				</tr>		
				<tr>
					<td>WM/MDA are separate Repos</td>
					<td>
						<select id="cmboxId12" name="isWmMdaRepoSeperated" value="${cstListByProjectCode.isWmMdaRepoSeperated}">
							<option>No</option>
							<option>Yes</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>WM Repo</td>
					<td>
						<input type="text" id="textId19" size="90" name="wmRepo" value="${cstListByProjectCode.wmRepo}"/>
					</td>
				</tr>
				<tr>
					<td>MDA Repo</td>
					<td>
						<input type="text" id="textId20" size="90" name="mdaRepo" value="${cstListByProjectCode.mdaRepo}"/>
					</td>
				</tr>	
				<tr>
					<td>GIT Info</td>
					<td>
						<input type="text" id="textId21" size="90" name="gitInfo" value="${cstListByProjectCode.gitInfo}"/>
					</td>
				</tr>	
				<tr>
					<td>Mod Specs</td>
					<td>
						<input type="text" id="textId22" size="90" name="modSpecs" value="${cstListByProjectCode.modSpecs}"/>
					</td>
				</tr>	
				<tr>
					<td>Technical Document</td>
					<td>
						<input type="text" id="textId23" size="90" name="techDoc" value="${cstListByProjectCode.techDoc}"/>
					</td>
				</tr>	
				<tr>
					<td>Delivery Note</td>
					<td>
						<input type="text" id="textId24" size="90" name="deliveryNote" value="${cstListByProjectCode.deliveryNote}"/>
					</td>
				</tr>	
			</table>
			<br>
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
						<select id="cmboxId1" name="anyModsInProgress" value="${cstListByProjectCode.anyModsInProgress}">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td align="center">
						<input type="text" id="textId1" size="80" name="anyModsInProgressCmnt" value="${cstListByProjectCode.anyModsInProgressCmnt}"/>
					</td>
				</tr>
				<tr>
					<td>Is the project Status Red?</td>
					<td align="center">
						<select id="cmboxId2" name="isTheProjectStatusRed" value="${cstListByProjectCode.isTheProjectStatusRed}">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td align="center">
						<input type="text" id="textId2" size="80" name="isTheProjectStatusRedCmnt" value="${cstListByProjectCode.isTheProjectStatusRedCmnt}"/>
					</td>
				</tr>
				<tr>
					<td>Any planned group of mods?</td>
					<td align="center">
						<select id="cmboxId3" name="plannedGroupOfMods" value="${cstListByProjectCode.plannedGroupOfMods}">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td align="center">
						<input type="text" id="textId3" size="80" name="plannedGroupOfModsCmnt" value="${cstListByProjectCode.plannedGroupOfModsCmnt}"/>
					</td>
				</tr>
				<tr>
					<td>Is Go-live date more than 2 months?</td>
					<td align="center">
						<select id="cmboxId4" name="goLiveDate" value="${cstListByProjectCode.goLiveDate}">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td align="center">
						<input type="text" id="textId4" size="80" name="goLiveDateCmnt" value="${cstListByProjectCode.goLiveDateCmnt}"/>
					</td>
				</tr>
				<tr>
					<td>All extensions tested and installed at Customer environment?</td>
					<td align="center">
						<select id="cmboxId5" name="modTestedOnClient" value="${cstListByProjectCode.modTestedOnClient}">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td align="center">
						<input type="text" id="textId5" size="80" name="modTestedOnClientCmnt" value="${cstListByProjectCode.modTestedOnClientCmnt}"/>
					</td>
				</tr>
				<tr>
					<td>Number of open custom P1, P2, P3 count with India Team < 20 ?</td>
					<td align="center">
						<select id="cmboxId6" name="numberOfOpenIssue" value="${cstListByProjectCode.numberOfOpenIssue}">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td align="center">
						<input type="text" id="textId6" size="80" name="numberOfOpenIssueCmnt" value="${cstListByProjectCode.numberOfOpenIssueCmnt}"/>
					</td>
				</tr>
				<tr>
					<td>Is resource hand-over planned or just KT for existing resources in CST?</td>
					<td align="center">
						<select id="cmboxId7" name="resourcHandoverPlanned" value="${cstListByProjectCode.resourcHandoverPlanned}">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td align="center">
						<input type="text" id="textId7" size="80" name="resourceHandoverPlannedCmnt" value="${cstListByProjectCode.resourceHandoverPlannedCmnt}"/>
					</td>
				</tr>
				<tr>
					<td>Number of Project Hours (Bill/Non-Bill) logged for last month < 500 hrs (3 FTE)?</td>
					<td align="center">
						<select id="cmboxId8" name="loggedHours" value="${cstListByProjectCode.loggedHours}">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td align="center">
						<input type="text" id="textId8" size="80" name="loggedHoursCmnt" value="${cstListByProjectCode.loggedHoursCmnt}"/>
					</td>
				</tr>				
			</table>
			<br>
			<table class="sample" style="width: 980px;">
				<tr>
					<th colspan='3' align="center" style="background-color: LIGHTCORAL;">Check List</th>
				</tr>
				<tr>
					<th>Description</th>
					<th>Availability ?</th>
					<th>Comments</th>
				</tr>
				<tr>
					<td>Is the VPT planned?</td>
					<td>
						<select id="cmboxId31" name="vptPlanned" value="${cstListByProjectCode.vptPlanned}">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td>
						<input type="text" id="textId31" size="80" name="vptPlannedCmnt" value="${cstListByProjectCode.vptPlannedCmnt}"/>
					</td>
				</tr>
				<tr>
					<td>Warehouse flow Document</td>
					<td>
						<select id="cmboxId32" name="warehouseFlowDocument" value="${cstListByProjectCode.warehouseFlowDocument}">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td>
						<input type="text" id="textId32" size="80" name="warehouseFlowDocumentCmnt" value="${cstListByProjectCode.warehouseFlowDocumentCmnt}"/>
					</td>
				</tr>
				<tr>
					<td>Version/Rollup information</td>
					<td>
						<select id="cmboxId33" name="versionRollupInfo" value="${cstListByProjectCode.versionRollupInfo}">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td>
						<input type="text" id="textId33" size="80" name="versionRollupInfoCmnt" value="${cstListByProjectCode.versionRollupInfoCmnt}"/>
					</td>
				</tr>
				<tr>
					<td>Mod vs Environment Mapping</td>
					<td>
						<select id="cmboxId34" name="modVsEnvMapping" value="${cstListByProjectCode.modVsEnvMapping}">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td>
						<input type="text" id="textId34" size="80" name="modVsEnvMappingCmnt" value="${cstListByProjectCode.modVsEnvMappingCmnt}"/>
					</td>
				</tr>
				<tr>
					<td>Java/CPP build and runtime should be in Sync</td>
					<td>
						<select id="cmboxId35" name="buildInSync" value="${cstListByProjectCode.buildInSync}">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td>
						<input type="text" id="textId35" size="80" name="buildInSyncCmnt" value="${cstListByProjectCode.buildInSyncCmnt}"/>
					</td>
				</tr>
				<tr>
					<td>List of SF cases for all the Extension/Issue</td>
					<td>
						<select id="cmboxId36" name="listOfSfCase" value="${cstListByProjectCode.listOfSfCase}">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td>
						<input type="text" id="textId36" size="80" name="listOfSfCaseCmnt" value="${cstListByProjectCode.listOfSfCaseCmnt}"/>
					</td>
				</tr>
				<tr>
					<td>Configuration Document for all the Extension's</td>
					<td>
						<select id="cmboxId37" name="configDocForMod" value="${cstListByProjectCode.configDocForMod}">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td>
						<input type="text" id="textId37" size="80" name="configDocForModCmnt" value="${cstListByProjectCode.configDocForModCmnt}"/>
					</td>
				</tr>
				<tr>
					<td>Build Box(Java/CPP) should be in sync with GIT</td>
					<td>
						<select id="cmboxId38" name="buildBoxInSync" value="${cstListByProjectCode.buildBoxInSync}">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td>
						<input type="text" id="textId38" size="80" name="buildBoxInSyncCmnt" value="${cstListByProjectCode.buildBoxInSyncCmnt}"/>
					</td>
				</tr>	
				
				<tr>
					<td>Add CST manager to netsteps as development manager</td>
					<td  colspan='2'>
						<select id="cmboxId38" name="addCstManagerNetsteps" value="${cstListByProjectCode.addCstManagerNetsteps}">
							<option>No</option>
							<option>Yes</option>
						</select>
					</td>
				</tr>	
						
				<tr>
					<td>SDN Creation/Delivery process should be documented</td>
					<td>
						<select id="cmboxId39" name="sdnProcessDocumented" value="${cstListByProjectCode.sdnProcessDocumented}">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td>
						<input type="text" id="textId40" size="80" name="sdnProcessDocumentedCmnt" value="${cstListByProjectCode.sdnProcessDocumentedCmnt}"/>
					</td>
				</tr>		
				<tr>
					<td>Knowledge Transfer for all Complex MOD(s)/Extension's</td>
					<td>
						<select id="cmboxId41" name="ktForMod" value="${cstListByProjectCode.ktForMod}">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td>
						<input type="text" id="textId41" size="80" name="ktForModCmnt" value="${cstListByProjectCode.ktForModCmnt}"/>
					</td>
				</tr>		
				<tr>
					<td>Fixpack creation Process? FullFix Pac/Incremental Pack</td>
					<td>
						<select id="cmboxId42" name="fixPackCreationProcess" value="${cstListByProjectCode.fixPackCreationProcess}">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td>
						<input type="text" id="textId42" size="80" name="fixPackCreationProcessCmnt" value="${cstListByProjectCode.fixPackCreationProcessCmnt}"/>
					</td>
				</tr>	
				<tr>
					<td>Test Scripts checked-in in MA-MATTERS for all the Extension's</td>
					<td>
						<select id="cmboxId44" name="testScriptsInMamatters" value="${cstListByProjectCode.testScriptsInMamatters}">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td>
						<input type="text" id="textId44" size="80" name="testScriptsInMamattersCmnt" value="${cstListByProjectCode.testScriptsInMamattersCmnt}"/>
					</td>
				</tr>	
				<tr>
					<td>Resource handover during CST transition - Does this resource know most of the mods</td>
					<td>
						<select id="cmboxId45" name="resourceHandover" value="${cstListByProjectCode.resourceHandover}">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td>
						<input type="text" id="textId45" size="80" name="resourceHandoverCmnt" value="${cstListByProjectCode.resourceHandoverCmnt}"/>
					</td>
				</tr>	
				<tr>
					<td>JIRA Ticket's used to check-in the file should be mentioned in corresponding SF Case</td>
					<td>
						<select id="cmboxId46" name="jiraMentionedInSf" value="${cstListByProjectCode.jiraMentionedInSf}">
							<option>No</option>
							<option>Yes</option>
							<option>May Be</option>
						</select>
					</td>
					<td>
						<input type="text" id="textId46" size="80" name="jiraMentionedInSfCmnt" value="${cstListByProjectCode.jiraMentionedInSfCmnt}"/>
					</td>
				</tr>				
			</table>
			<br>
			<button style="height: 40px;width: 150px" >Submit</button>
		</div>
		
	</form>
	<br><br><br><br>
</div>
</body>

<script>
	function projectNameCodeAction() {
		var value = document.getElementById("projectNameCodeId").value;
		document.getElementById('projectCodeId').value = value;

	}

	function createCSTCheckListEvent() {
		document.getElementById("cstChecklistTable").style.display = 'block';
		document.getElementById("projectDetailForm").style.display = 'none';
	}

	function viewCSTCheckListEvent() {
		document.getElementById("cstChecklistTable").style.display = 'none';
		document.getElementById("projectDetailForm").style.display = 'block';
	}

	function pageOnLoad() {
		if (document.getElementById("textIdProjectCode").value != '') {
			document.getElementById("projectDetailForm").style.display = 'block';
			document.getElementById("viewRadio").checked = true;
		} else {
			document.getElementById("projectDetailForm").style.display = 'none';
			document.getElementById("createRadio").checked = true;
		}
	}
	
	function convertToUpperCase(a){
	    setTimeout(function(){
	        a.value = a.value.toUpperCase();
	    }, 1);
	}
</script>