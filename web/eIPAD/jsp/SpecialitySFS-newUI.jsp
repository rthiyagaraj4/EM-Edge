<%@page
	import="java.util.*,java.sql.*,java.io.*,eIPAD.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*"
	contentType="text/html;charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String locale = "en";
	String fSpecialityId = "";
	String fSpecialityName = "";
	String fNursingUnitId = "";
	String fNursingUnitName = "";
	String fPractitionerId = "";
	String fPractitionerName = "";
	String fSfsContext = "";
	String searchHeading = "";
	
	
	if(request.getParameter("hdnSpecialityId") != null && request.getParameter("hdnSpecialityId").trim() != "")
	{
	 
		fSpecialityId = ((String)request.getParameter("hdnSpecialityId"));
	}
	if(request.getParameter("hdnSpecialityName") != null && request.getParameter("hdnSpecialityName").trim() != "")
	{
	 
		fSpecialityName = ((String)request.getParameter("hdnSpecialityName"));
	}
	if(request.getParameter("hdnNursingUnitId") != null && request.getParameter("hdnNursingUnitId").trim() != "")
	{
	 
		fNursingUnitId = ((String)request.getParameter("hdnNursingUnitId"));
	}
	if(request.getParameter("hdnNursingUnitName") != null && request.getParameter("hdnNursingUnitName").trim() != "")
	{
	 
		fNursingUnitName = ((String)request.getParameter("hdnNursingUnitName"));
	}
	if(request.getParameter("hdnPractitionerId") != null && request.getParameter("hdnPractitionerId").trim() != "")
	{
	 
		fPractitionerId = ((String)request.getParameter("hdnPractitionerId"));
	}
	if(request.getParameter("hdnPractitionerName") != null && request.getParameter("hdnPractitionerName").trim() != "")
	{
	 
		fPractitionerName = ((String)request.getParameter("hdnPractitionerName"));
	}
	if(request.getParameter("hdnSfsContext") != null && request.getParameter("hdnSfsContext").trim() != "")
	{
	 
		fSfsContext = ((String)request.getParameter("hdnSfsContext"));
	}
	
	if(fSfsContext.equals("SP"))
		searchHeading = "Speciality";
	else if(fSfsContext.equals("NU"))
		searchHeading = "Nursing Unit";
	else if(fSfsContext.equals("PR"))
		searchHeading = "Practitioner";
	
	
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
<link rel="stylesheet" href="../css/iPADThemeA.css" /> 
<script src="../jquery-1.5.2.min.js"></script>

<!-- <Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>  -->
<script type="application/javascript" src="../js/iscroll.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
function searchFormSubmit()
{
	 //$.trim($("#hdnPatientId").val($.trim($("#txtPatientId").val())));
	 //alert(document.getElementById("txtPatientId").value.length);
	 //var trimmedPatId= document.getElementById("txtPatientId").value.trim();
	 //alert(trimmedPatId.length);
	 //document.getElementById("hdnPatientId").value = document.getElementById("txtPatientId").value;
	 document.getElementById("IpSearchForm").submit();
}
function ipSearch(){
	parent.document.getElementById('hdnSpeciality').value = document.getElementById('hdnSpecialityId').value;
	parent.document.getElementById('hdnNursingUnit').value = document.getElementById('hdnNursingUnitId').value;
	parent.document.getElementById('hdnClinicianId').value = document.getElementById('hdnPractitionerId').value;
	parent.document.getElementById('hdnPatientId').value = '';
	parent.document.getElementById('IpForm').submit();
}

function back(){
	var searchForm = document.getElementById("IpSearchForm");
	searchForm.action = 'IPSearch-newUI.jsp';
	searchForm.submit();
}

</script>
<link rel="stylesheet" href="../css/iPADNew.css" />
</head>
<body style="width: 100%; height: 100%;">
	<form name='IpSearchForm' id='IpSearchForm' method='post' id="IpSearchForm" action="SpecialityList-newUI.jsp">
		<div class="ipSearchHeader ipSearchHeaderTheme">
			<table>
				<tr>
					<td style="width:100px;"><div class="ipSearchHeaderButtonTheme" onclick="back()">Back</div></td>
					<td style="width:200px;"><div class="ipSearchHeaderText ipSearchHeaderTextTheme"><%=searchHeading %></div></td>
					<td style="width:100px;"><div class="ipSearchHeaderButtonTheme" onclick="ipSearch()">Search</div></td>
				</tr>
			</table>
		</div>

		<div class="ipSearchContainer ipSearchContainerTheme">
			<div>
				<table  cellpadding = "0" cellspacing = "0" border = "0" style="width:100%;height:100%;">
					<tr>
						<td style="width:50%;"><div class="ipSearchTabSelected ipSearchTabSelectedTheme"><div class="ipSearchTabText">Search</div></div></td>
						<td style="width:50%;"><div class="ipSearchTabNotSelected ipSearchTabNotSelectedTheme"><div class="ipSearchTabText">Recent Search</div></div></td>
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
								<div style="display:table-cell;vertical-align:middle"><input type="text" name="specialitySearchText" id="specialitySearchText" id="specialitySearchText" class="ipSearchSfsItemTextBoxTheme" style="width:200px"></div>
								<div style="display:table-cell;width:5px"> </div>
								<div style="display:table-cell;vertical-align:middle"><div class="WidgetButtonTheme" onclick="searchFormSubmit()"><img src = "../images/Search.png"/></div></div>
							</div>
						</div>	
				</div>

		</div>
		
		<input type = "hidden" name ="hdnSpecialityId" id ="hdnSpecialityId" value ="<%=fSpecialityId %>"/>
		<input type = "hidden" name ="hdnSpecialityName" id ="hdnSpecialityName" value ="<%=fSpecialityName %>"/>
		<input type = "hidden" name ="hdnNursingUnitId" id ="hdnNursingUnitId" value ="<%=fNursingUnitId %>"/>
		<input type = "hidden" name ="hdnNursingUnitName" id ="hdnNursingUnitName" value ="<%=fNursingUnitName %>"/>
		<input type = "hidden" name ="hdnPractitionerId" id ="hdnPractitionerId" value ="<%=fPractitionerId %>"/>
		<input type = "hidden" name ="hdnPractitionerName" id ="hdnPractitionerName" value ="<%=fPractitionerName %>"/>
		<input type = "hidden" name ="hdnSfsContext" id ="hdnSfsContext" value ="<%=fSfsContext %>"/>

	</form>
</body>
</html>

