<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>jQuery UI Datepicker - Select a Date Range</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<style type="text/css"> 
    table.sample {
	border-spacing: 1px;
	border-style: outset;
	border-color: gray;
	border-collapse: separate;
	background-color: white;
}
table.sample th {
	padding: 5px;
	border-style: inset;
	border-color: gray;
	background-color: white;
	-moz-border-radius: ;
}
table.sample td {
	border-width: 1px;
	padding: 2px;
	border-style: inset;
	border-color: gray;
	background-color: white;
	-moz-border-radius: ;
}
</style>

<script>
	$(function() {
		var dateFormat = "mm/dd/yy", from = $("#from").datepicker({
			minDate: 0, 
			changeMonth : true,
			numberOfMonths : 3
		}).on("change", function() {
			to.datepicker("option", "minDate", getDate(this));
		}), to = $("#to").datepicker({
			minDate: 0, 
			changeMonth : true,
			numberOfMonths : 3
		}).on("change", function() {
			from.datepicker("option", "maxDate", getDate(this));
		});

		function getDate(element) {
			var date;
			try {
				date = $.datepicker.parseDate(dateFormat, element.value);
			} catch (error) {
				date = null;
			}

			return date;
		}
	});
</script>

<form action="submitLeave" method="get">
	<div class="w3-main" style="margin-top: 60px;">
		<table class="sample" style="width: 400px;">
			<tr>
				<th align="left" style="font-size: 20">From Date :</th>	
				<th style="font-size: 20"><input id="from" type="text" name="fromDate" style="font-family: Arial;"  required ></th>				
			</tr>
			<tr>
				<th align="left" style="font-size: 20">To Date : </th>				
				<th style="font-size: 20"><input id="to" type="text" name="toDate" style="font-family: Arial;"  required ></th>
			</tr>
			<tr>
				<th colspan='2' style="font-size: 20"><button style="cursor: pointer; box-shadow:  0px 2px 11px 0px rgba(0, 0, 0, 0.3); border: 1px solid #A8F1FF; 
					border-radius: 5px; background-color:#444; color: #fff;  float: none; padding: 5px;">Submit</button></th>				
			</tr>
			<tr>
				<th colspan='2' style="font-size: 20"><p id="submitResponse">${submitResponse}</p></th>				
			</tr>
		</table>
	</div>
</form>
