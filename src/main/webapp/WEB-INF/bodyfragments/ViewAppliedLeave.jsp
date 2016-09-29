<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style type="text/css"> 
    <%@include file="../css/table.css" %>
    
</style>

<script src="http://code.jquery.com/jquery-1.4.2.min.js"></script>
<script src="../css/sorttable.js"></script>

<div style="margin-top: 60px;">
	<form action="viewAppliedLeaveByUser" method="get">
		<h1 style="font-size: 20px">
			<b><strong>Planned Leave By User : </strong></b>
		</h1>

		<div style="margin-top: 10px;">
			<label>Quick Search: <input id="search" type="text"></label>
		</div>

		<br>
		<div style="width: 900px; height: 700px; overflow: auto">
			<table class="sample" style="width: 880px;" class="sortable">
				<thead>
					<tr>
						<th>Name</th>
						<th>From Date</th>
						<th>To Date</th>
						<th>Email-Id</th>
					</tr>
				</thead>
				<c:forEach items="${userAppliedLeaveList}" var="listValue">
					<tbody>
						<tr>
							<td align="center">${listValue.userName}</td>
							<td align="center">${listValue.fromDate}</td>
							<td align="center">${listValue.toDate}</td>
							<td align="center">${listValue.userId}</td>
						</tr>
					</tbody>
				</c:forEach>
			</table>
		</div>

	</form>	
</div>

<script>
function userNameAction(){
	var userId = document.getElementById("userNameList").value;
	document.getElementById('userId').value  = userId;
	
}

var $cells = $("td");
$("#search").keyup(function() {
    var val = $.trim(this.value).toUpperCase();
    if (val === "")
        $cells.parent().show();
    else {
        $cells.parent().hide();
        $cells.filter(function() {
            return -1 != $(this).text().toUpperCase().indexOf(val); }).parent().show();
    }
});
</script>