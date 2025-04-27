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

<!-- <script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>-->
<script type="application/javascript" src="../js/iscroll.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
function openSpecialitySearch(){
	var searchForm = document.getElementById("IpMainSearchForm");
	document.getElementById('hdnSfsContext').value='SP';
	searchForm.action = 'SpecialitySFS-newUI.jsp';
	searchForm.submit();
}
function openNursingUnitSearch(){
	var searchForm = document.getElementById("IpMainSearchForm");
	document.getElementById('hdnSfsContext').value='NU';
	searchForm.action = 'SpecialitySFS-newUI.jsp';
	searchForm.submit();
}
function openPractitionerSearch(){
	var searchForm = document.getElementById("IpMainSearchForm");
	document.getElementById('hdnSfsContext').value='PR';
	searchForm.action = 'SpecialitySFS-newUI.jsp';
	searchForm.submit();
}
function ipSearch(){
	parent.document.getElementById('hdnSpeciality').value = document.getElementById('hdnSpecialityId').value;
	parent.document.getElementById('hdnNursingUnit').value = document.getElementById('hdnNursingUnitId').value;
	parent.document.getElementById('hdnClinicianId').value = document.getElementById('hdnPractitionerId').value;
	parent.document.getElementById('hdnPatientId').value = '';
	parent.document.getElementById('IpForm').submit();
}
</script>
<link rel="stylesheet" href="../css/iPADNew.css" />
</head>
<body style="width: 100%; height: 100%;">
	<form name='IpSearchForm' id='IpSearchForm' method='post' id="IpMainSearchForm">
		<div class="ipSearchHeader ipSearchHeaderTheme">
			<table>
				<tr>
					<td style="width:100px"><div class="ipSearchHeaderButtonTheme" onclick="parent.showsfs()">Cancel</div></td>
					<td style="width:200px"><div class="ipSearchHeaderTextTheme">In Patient</div></td>
					<td style="width:100px"><div class="ipSearchHeaderButtonTheme" onclick="ipSearch()">Search</div></td>
				</tr>
			</table>
		</div>
		<div class="ipSearchContainer ipSearchContainerTheme">

				<div class="ipSearchItem ipSearchItemTheme" id="ipSearchItemSpeciality" onclick="openSpecialitySearch()">
					<div class="ipSearchItemHeading ipSearchItemHeadingTheme">Speciality</div>
					<div>
						<input type="text" class="ipSearchItemTextbox ipSearchItemTextboxTheme" name="specialityName" id="specialityName" placeholder="Speciality" value ="<%=fSpecialityName %>" readonly />
					</div>		
				</div>
				<div class="ipSearchItem ipSearchItemTheme" id="ipSearchItemNursingUnit" onclick="openNursingUnitSearch()">
					<div class="ipSearchItemHeading ipSearchItemHeadingTheme">Nursing Unit</div>
					<div>
						<input type="text" class="ipSearchItemTextbox ipSearchItemTextboxTheme" name="nursingUnitName" id="nursingUnitName" placeholder="Nursing Unit" value="<%=fNursingUnitName %>" readonly />
					</div>		
				</div>
				<div class="ipSearchItem ipSearchItemTheme" id="ipSearchItemPractitioner" onclick="openPractitionerSearch()">
					<div class="ipSearchItemHeading ipSearchItemHeadingTheme">Practitioner</div>
					<div>
						<input type="text" class="ipSearchItemTextbox ipSearchItemTextboxTheme" name="practitionerName" id="practitionerName" placeholder="Practitioner" value="<%=fPractitionerName%>"readonly />
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

