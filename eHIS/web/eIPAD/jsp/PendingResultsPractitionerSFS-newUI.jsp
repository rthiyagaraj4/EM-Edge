<%@page
	import="java.util.*,java.sql.*,java.io.*,eIPAD.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*"
	contentType="text/html;charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String locale = "en";
	String fPractitionerId = "";
	String fPractitionerName = "";
	String searchHeading = "Practitioner";

	if(request.getParameter("hdnPractitionerId") != null && request.getParameter("hdnPractitionerId").trim() != "")
	{
	 
		fPractitionerId = ((String)request.getParameter("hdnPractitionerId"));
	}
	if(request.getParameter("hdnPractitionerName") != null && request.getParameter("hdnPractitionerName").trim() != "")
	{
	 
		fPractitionerName = ((String)request.getParameter("hdnPractitionerName"));
	}
	
	
%>
<!DOCTYPE html>
<html>
<head>
<title>IP View</title>
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=4.0, user-scalable=no" />
<!-- <link rel="stylesheet" href="../jquery.mobile-1.0a4.1.min.css" /> -->


<link rel="stylesheet" href="../css/iPadNew_IP.css" />
<link rel="stylesheet" href="../css/iPADNew.css" />  
<link rel="stylesheet" href="../css/iPADThemeA.css" /> 
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>

<!-- <script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script> -->
<script type="application/javascript" src="../js/iscroll.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function searchFormSubmit()
{
	 //$.trim($("#hdnPatientId").val($.trim($("#txtPatientId").val())));
	 //alert(document.getElementById("txtPatientId").value.length);
	 //var trimmedPatId= document.getElementById("txtPatientId").value.trim();
	 //alert(trimmedPatId.length);
	 //document.getElementById("hdnPatientId").value = document.getElementById("txtPatientId").value;
	 document.getElementById("PracSearchForm").submit();
}
/* function ipSearch(){
	parent.document.getElementById('hdnSpeciality').value = document.getElementById('hdnSpecialityId').value;
	parent.document.getElementById('hdnNursingUnit').value = document.getElementById('hdnNursingUnitId').value;
	parent.document.getElementById('hdnClinicianId').value = document.getElementById('hdnPractitionerId').value;
	parent.document.getElementById('hdnPatientId').value = '';
	parent.document.getElementById('IpForm').submit();
} */

/* function back(){
	var searchForm = document.getElementById("PracSearchForm");
	searchForm.action = 'IPSearch-newUI.jsp';
	searchForm.submit();
} */

</script>
<link rel="stylesheet" href="../css/iPADNew.css" />
</head>
<body style="width: 100%; height: 100%;">
	<form name='PracSearchForm' id='PracSearchForm' method='post' id="PracSearchForm" action="PendingResultsPractitionerList-newUI.jsp">
		<div class="ipSearchHeader ipSearchHeaderTheme">
			<table>
				<tr>
					<td style="width:100px;"><div class="prPracSearchHeaderButtonTheme" onclick="parent.showPracSfs()">Cancel</div></td>
					<td style="width:200px;"><div class="prPracSearchHeaderText prPracSearchHeaderTextTheme"><%=searchHeading %></div></td>
					<td style="width:100px;"><div class="prPracSearchHeaderButtonDisabledTheme">Done</div></td>
				</tr>
			</table>
		</div>

		<div class="prPracSearchContainer prPracSearchContainerTheme">
			<div>
				<table  cellpadding = "0" cellspacing = "0" border = "0" style="width:100%;height:100%;">
					<tr>
						<td style="width:50%;"><div class="prPracSearchTabSelected prPracSearchTabSelectedTheme"><div class="prPracSearchTabText">Search</div></div></td>
						<td style="width:50%;"><div class="prPracSearchTabNotSelected prPracSearchTabNotSelectedTheme"><div class="prPracSearchTabText">Recent Search</div></div></td>
					</tr>
				</table>
			</div>
		
				<div class="ipSearchSfsItem ipSearchSfsItemTheme" id="ipSearchItemSpeciality">
						<div class="ipSearchItemHeadingTheme"><%=searchHeading%></div>
						<div class="ipSearchItemRadioButtons">
							<span><input type="radio" id="rdCode" class="ipSearchRadioTheme" data-role="none" name="specialitySearch" id="specialitySearch" value="code" checked></span>
							<span class="ipSearchSfsItemTextTheme">Code</span>
							<span><input type="radio" id="rdDesc" class="ipSearchRadioTheme" data-role="none" name="specialitySearch" id="specialitySearch" value="desc"></span>
							<span class="ipSearchSfsItemTextTheme">Description</span>
						</div>	
				</div>
				<div class="ipSearchSfsItem ipSearchSfsItemTheme" id="ipSearchItemSpecialityCriteria">
						<div class="ipSearchItemHeadingTheme">Search Criteria</div>
						<div class="ipSearchItemRadioButtons">
							<span><input type="radio" id="rdStartWith" class="ipSearchRadioTheme" data-role="none" name="specialitySearchCriteria" id="specialitySearchCriteria" value="SW" checked></span>
							<span class="ipSearchSfsItemTextTheme">Starts With</span>
							<span><input type="radio" id="rdEndWith" class="ipSearchRadioTheme" data-role="none" name="specialitySearchCriteria" id="specialitySearchCriteria" value="EW"></span>
							<span class="ipSearchSfsItemTextTheme">Ends With</span>
							<span><input type="radio" id="rdContains" class="ipSearchRadioTheme" data-role="none" name="specialitySearchCriteria" id="specialitySearchCriteria" value="CN"></span>
							<span class="ipSearchSfsItemTextTheme">Contains</span>
						</div>	
				</div>
				<div class="ipSearchSfsItem ipSearchSfsItemTheme" id="ipSearchItemSpecialitySearchText">
						<div class="ipSearchItemHeadingTheme">Search Text</div>
	
						<div style="display:table"  class="ipSearchSfsItemTextSearch">
							<div style="display:table-row">
								<div style="display:table-cell;vertical-align:middle"><input type="text" name="specialitySearchText" id="specialitySearchText" id="specialitySearchText" class="ipSearchSfsItemTextBoxTheme"></div>
								<div style="display:table-cell;width:5px"> </div>
								<div style="display:table-cell;vertical-align:middle"><div class="WidgetButtonTheme" onclick="searchFormSubmit()"><img src = "../images/Search.png"/></div></div>
							</div>
						</div>	
				</div>

		</div>
		

		<input type = "hidden" name ="hdnPractitionerId" id ="hdnPractitionerId" value ="<%=fPractitionerId %>"/>
		<input type = "hidden" name ="hdnPractitionerName" id ="hdnPractitionerName" value ="<%=fPractitionerName %>"/>

	</form>
</body>
</html>

