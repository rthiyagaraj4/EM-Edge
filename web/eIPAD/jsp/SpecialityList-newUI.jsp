<%@page import="java.util.*,java.sql.*,java.io.*,eIPAD.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*,eIPAD.HealthObjects.*,eIPAD.sfs.*," contentType="text/html;charset=UTF-8" %>
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

Boolean bRadioCode = true;
Boolean bRadioDesc = false;
String sfacility_id = "";
String sclinicianId = "";
String sPracId = "";
String sPractionerId = "";
String sSearchBy = "" ;
String sSearchCriteria = "" ;
String sSearchText = "";
String SearchBy = "" ;
String SearchCriteria = "" ;
String SearchText = "";

SFSContext oSFSContext = new SFSContext();
oSFSContext.setRequest(request);

if(session.getValue("facility_id") != null && session.getValue("facility_id") != "")
{
	sfacility_id = (String)session.getValue("facility_id");
	oSFSContext.setSfacility_id(sfacility_id);
}

if(session.getValue("ca_practitioner_id") != null && session.getValue("ca_practitioner_id") != "")
{
	sclinicianId = (String)session.getValue("ca_practitioner_id");
	oSFSContext.setSclinicianId(sclinicianId);
}
if(request.getParameter("hdnPractitionerId") != null && request.getParameter("hdnPractitionerId") != "")
{
	sPractionerId = (String)request.getParameter("hdnPractitionerId");
	oSFSContext.setsPractionerId(sPractionerId);
}

if(fSfsContext.equals("NU"))
{
	//sclinicianId = sPractionerId;
	oSFSContext.setsPractionerId(sclinicianId); //for Nursing Unit search alone always the practitioner ID is the login practitioner
}
//oSFSContext.setSclinicianId(sclinicianId);

if(request.getParameter("specialitySearch") != null && request.getParameter("specialitySearch") != "" )
{
	
	sSearchBy = (String)request.getParameter("specialitySearch");
	oSFSContext.setsSearchBy(sSearchBy);
	
	if(sSearchBy != null && sSearchBy.equals("desc")){
		bRadioDesc = true;
		bRadioCode = false;
	}
	
	
}
if(request.getParameter("specialitySearchCriteria") != null && request.getParameter("specialitySearchCriteria") != "" )
{
	sSearchCriteria = (String)request.getParameter("specialitySearchCriteria");
	oSFSContext.setsSearchCriteria(sSearchCriteria);
}	
if(request.getParameter("specialitySearchText") != null && request.getParameter("specialitySearchText") != "" )
{
	sSearchText = (String)request.getParameter("specialitySearchText");
	oSFSContext.setsSearchText(sSearchText);
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
<script src="../jquery-1.5.2.min.js"></script>

<!-- <Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>  -->
<script type="application/javascript" src="../js/iscroll.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
var scrollContent1,
scrollNav;
document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
function loaded1() {
//scrollContent1 = new iScroll('contentWrapper1');
scrollNav = new iScroll('contentWrapper');
}

document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);

document.addEventListener('DOMContentLoaded', loaded1, false);

function selectSpeciality(code,description){
	
	var sfsContext = document.getElementById("hdnSfsContext").value
	
	if(sfsContext == 'SP'){		
		document.getElementById("hdnSpecialityId").value = code;
		document.getElementById("hdnSpecialityName").value = description;
	}
	else if(sfsContext == 'NU'){
		document.getElementById("hdnNursingUnitId").value = code;
		document.getElementById("hdnNursingUnitName").value = description;		
	}
	else if(sfsContext == 'PR'){
		document.getElementById("hdnPractitionerId").value = code;
		document.getElementById("hdnPractitionerName").value = description;		
	}
	document.getElementById("IpSpecialityListForm").submit();
}

function ipSearch(){
	parent.document.getElementById('hdnSpeciality').value = document.getElementById('hdnSpecialityId').value;
	parent.document.getElementById('hdnNursingUnit').value = document.getElementById('hdnNursingUnitId').value;
	parent.document.getElementById('hdnClinicianId').value = document.getElementById('hdnPractitionerId').value;
	parent.document.getElementById('hdnPatientId').value = '';
	parent.document.getElementById('IpForm').submit();
}
function back(){
	var searchForm = document.getElementById("IpSpecialityListForm");
	searchForm.action = 'SpecialitySFS-newUI.jsp';
	searchForm.submit();
}
</script>
<link rel="stylesheet" href="../css/iPADNew.css" />
</head>
<body style="width: 100%; height: 100%;">
	<form name='IpSpecialityListForm' id='IpSpecialityListForm' method='post' id="IpSpecialityListForm" style= "width:100%; height:100%;" action="IPSearch-newUI.jsp">
		<div class="ipSearchHeader ipSearchHeaderTheme">
			<table>
				<tr>
					<td style="width:100px;"><div class="ipSearchHeaderButtonTheme" onclick="back()">Back</div></td>
					<td style="width:200px;"><div class="ipSearchHeaderText ipSearchHeaderTextTheme"><%=searchHeading %></div></td>
					<td style="width:100px;"><div class="ipSearchHeaderButtonTheme" onclick="ipSearch()">Search</div></td>
				</tr>
			</table>
		</div>
		<div class="ipSearchContainer ipSearchContainerTheme" style="width: 392px; height: 254px;">
			<div>
				<table  cellpadding = "0" cellspacing = "0" border = "0" style="width:100%;height:100%;">
					<tr>
						<td style="width:50%;"><div class="ipSearchTabSelected ipSearchTabSelectedTheme"><div class="ipSearchTabText">Search</div></div></td>
						<td style="width:50%;"><div class="ipSearchTabNotSelected ipSearchTabNotSelectedTheme"><div class="ipSearchTabText">Recent Search</div></div></td>
					</tr>
				</table>
			</div>
	<div  data-role = "none" id = "contentWrapper" class="ipSearchResWrapperTheme ipSearchResWrapper">
       <div data-role = "none" style = "width:100%;height:auto;overflow:auto">
		<div>
			<table cellpadding="0" cellspacing = "0" style="width: 100%; height: 100%;" class="ipSearchResultsTableTheme">
				<tr class="ipSearchResultsHeading ipSearchResultsHeadingTheme">
					<th style="width:20%"><span class="ipSearchResultsHeadingText">Code</span></th>
					<th style="width:80%"><span class="ipSearchResultsHeadingText">Description</span></th>
				</tr>
				<%-- 
				<%
				int cnt = 0;
				if(rs != null) 
				 {

				  while (  rs.next() ){ 
						String sCode=rs.getString("code");
						String sDesc=rs.getString("description");
				%> --%>
				
				   <%
					   int nRowCount = 1;		       			    
					   int nLoopCount = 0;
					   int nListSize = 0;
					   SFSDetails bean = new SFSDetails();
					   List<SFSUnit> objSfsDetails = new ArrayList<SFSUnit>(); 
					  
					   try {
						  if(fSfsContext.equals("SP"))
							   oSFSContext.setType(SFSContext.SPECIALITY);
						  else if(fSfsContext.equals("NU"))
							  oSFSContext.setType(SFSContext.NURSINGUNIT);
						  else if(fSfsContext.equals("PR"))
							  oSFSContext.setType(SFSContext.PRACTITIONER);
						  
							  
							  
						  objSfsDetails = bean.getSFSUnit(oSFSContext); 
						   
					  
					   nListSize =  objSfsDetails.size();
					   //out.println(nListSize);
					   SFSUnit sfsUnit = null;
					   if(nListSize > 0)
					   {
					 	  for(nLoopCount = 0 ; nLoopCount < nListSize;nLoopCount++)
					 	  {
					 		 sfsUnit = objSfsDetails.get(nLoopCount);
					 		  if(sfsUnit != null )
							  {
		  
	 
	 				 %>
				 <tr class="ipSearchResultsBody ipSearchResultsBodyTheme" onclick="selectSpeciality('<%=sfsUnit.getsCode()%>','<%=sfsUnit.getsDescription()%>')">
					<td><span class="ipSearchResultsBodyText"><%=sfsUnit.getsCode()%></span></td>
					<td><span class="ipSearchResultsBodyText"><%=sfsUnit.getsDescription()%></span></td>
				</tr> 
			  
			  <%
			 		 
					  }
					  nRowCount = nRowCount + 1;
					} %>
					
					</table>
					<%
			   }
			   else
			   {
				   
				  %></table>
				      <div class="sfsSearchResultsEmptyTheme">No Records Found</div>
				  <%
				   
			   }
	  		%>

		</div>
		</div></div>
 		
		<input type = "hidden" name ="hdnSpecialityId" id ="hdnSpecialityId" value ="<%=fSpecialityId %>"/>
		<input type = "hidden" name ="hdnSpecialityName" id ="hdnSpecialityName" value ="<%=fSpecialityName %>"/>
		<input type = "hidden" name ="hdnNursingUnitId" id ="hdnNursingUnitId" value ="<%=fNursingUnitId %>"/>
		<input type = "hidden" name ="hdnNursingUnitName" id ="hdnNursingUnitName" value ="<%=fNursingUnitName %>"/>
		<input type = "hidden" name ="hdnPractitionerId" id ="hdnPractitionerId" value ="<%=fPractitionerId %>"/>
		<input type = "hidden" name ="hdnPractitionerName" id ="hdnPractitionerName" value ="<%=fPractitionerName %>"/>
		<input type = "hidden" name ="hdnSfsContext" id ="hdnSfsContext" value ="<%=fSfsContext %>"/>
		</div>
	</form>
	   <%
				 }catch ( Exception e ){
						//out.println(sqlStr.toString() + e);
						e.printStackTrace();
					}
					finally{

					}
					   

		
%> 
</body>
</html>

