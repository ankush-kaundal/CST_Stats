<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="margin-top:60px;">

	<h1 style="font-size:20;">
		Project Name : 
	</h1>

	<div style="margin-top:10px;">
		<select name="projectlist" id="projectlist"
			onchange="activateFields()">
			<option>None</option>
			<c:if test="${not empty projectDetails}">
				<ul>
					<c:forEach items="${projectDetails}" var="listValue">
						<option
							value="${listValue.modSpecsLink} * ${listValue.techDocLink} * ${listValue.deliverNoteLink} * ${listValue.mamattersLink}">
							${listValue.projectCode} : ${listValue.projectName}</option>
					</c:forEach>
				</ul>
			</c:if>
		</select>

		<div style="margin-top:10px; display: none" id="ProjectsLinkId">
			<p>
				<a id="mamattersLinkId" target="_blank">Click here to go to - <b
					class="w3-text-red">Ma-Matters</b></a></br> <a id="modSpecsLinkId"
					target="_blank">Click here to go to - <b class="w3-text-red">Mod
						specs link</b></a></br> <a id="techDocLinkId" target="_blank">Click here to
					go to - <b class="w3-text-red">Tech doc link</b>
				</a></br> <a id="deliveryNoteLinkId" target="_blank">Click here to go to
					- <b class="w3-text-red">Delivery notes link</b>
				</a>
			</p>
		</div>
	</div>

	<!-- End page content -->
</div>

<script>function activateFields(){
	var projectlistValue = document.getElementById("projectlist").value;
	
	var element = document.getElementById("ProjectsLinkId");
    if(projectlistValue != 'None'){
        element.style.display = 'block';
    }else{
        element.style.display = 'none';
    }
    
    var fields = projectlistValue.split(" * ");
    var modSpecsLink = fields[0];
    var techDocLink = fields[1];
    var deliverNoteLink = fields[2];
    var mamattersLink = fields[3];
    
    //document.getElementById("mamattersLinkId").innerHTML = mamattersLink; 
    document.getElementById("mamattersLinkId").setAttribute("href", mamattersLink); 
    document.getElementById("modSpecsLinkId").setAttribute("href", modSpecsLink); 
    document.getElementById("techDocLinkId").setAttribute("href", techDocLink); 
    document.getElementById("deliveryNoteLinkId").setAttribute("href", deliverNoteLink); 
    
}</script>