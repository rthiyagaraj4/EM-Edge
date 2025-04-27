<%@page import="java.util.*,java.sql.*,java.io.*,eIPAD.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*,eIPAD.HealthObjects.*,eIPAD.sfs.*," contentType="text/html;charset=UTF-8" %>
<%
request.setCharacterEncoding("UTF-8");

String locale = "en";

String fPractitionerId = "";
String fPractitionerName = "";
String fSfsContext = "";
String searchHeading = "Practitioner";



if(request.getParameter("hdnPractitionerId") != null && request.getParameter("hdnPractitionerId").trim() != "")
{
 
	fPractitionerId = ((String)request.getParameter("hdnPractitionerId"));
}
if(request.getParameter("hdnPractitionerName") != null && request.getParameter("hdnPractitionerName").trim() != "")
{
 
	fPractitionerName = ((String)request.getParameter("hdnPractitionerName"));
}


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
	//oSFSContext.setSclinicianId(sclinicianId);
}
/* if(request.getParameter("hdnPractitionerId") != null && request.getParameter("hdnPractitionerId") != "")
{
	sPractionerId = (String)request.getParameter("hdnPractitionerId");
	oSFSContext.setsPractionerId(sPractionerId);
} */

/* if( sPractionerId!= null && !sPractionerId.equals("")  && fSfsContext.equals("NU"))
{
	sclinicianId = sPractionerId;
}
oSFSContext.setSclinicianId(sclinicianId); */

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


<!-- <link rel="stylesheet" href="../css/iPadNew_IP.css" /> -->
<link rel="stylesheet" href="../css/iPADNew.css" />  
<link rel="stylesheet" href="../css/iPADThemeA.css" /> 
<script src="../jquery-1.5.2.min.js"></script>

<!--<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>  -->
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
	document.getElementById("hdnPractitionerId").value = code;
	document.getElementById("hdnPractitionerName").value = description;		
	$(".prPracSearchResultsTableTheme").find(".prPracSearchResultsBodySelectedTheme")
	.removeClass("prPracSearchResultsBodySelectedTheme").addClass("prPracSearchResultsBodyTheme");
	$("#prPractionerSelect" + code).removeClass("prPracSearchResultsBodyTheme").addClass("prPracSearchResultsBodySelectedTheme");

}

function done(){
	var code = document.getElementById("hdnPractitionerId").value;
	var description = document.getElementById("hdnPractitionerName").value;
	
	if(code == ""){
		alert("Please choose a Practioner");
	}
	else{
		parent.Practitioner(code,description);
		//parent.showPracSfs();
	}
}
function back(){
	document.getElementById("hdnPractitionerId").value = "";
	document.getElementById("hdnPractitionerName").value = "";	
	var searchForm = document.getElementById("PrPractitionerListForm");
	searchForm.action = 'PendingResultsPractitionerSFS-newUI.jsp';
	searchForm.submit();
}
</script>
<link rel="stylesheet" href="../css/iPADNew.css" />
</head>
<body style="width: 100%; height: 100%;">
	<form name='PrPractitionerListForm' id='PrPractitionerListForm' method='post' id="PrPractitionerListForm" style= "width:100%; height:100%;" action="IPSearch-newUI.jsp">
		<div class="prPractSearchHeader prPractSearchHeaderTheme">
			<table>
				<tr>
					<td style="width:100px;"><div class="prPracSearchHeaderButtonTheme" onclick="back()">Back</div></td>
					<td style="width:200px;"><div class="prPracSearchHeaderText prPracSearchHeaderTextTheme"><%=searchHeading %></div></td>
					<td style="width:100px;"><div class="prPracSearchHeaderButtonTheme" onclick="done()">Done</div></td>
				</tr>
			</table>
		</div>
		<div class="prPracSearchContainer prPracSearchContainerTheme" style="width: 392px; height: 254px;">
			<div>
				<table  cellpadding = "0" cellspacing = "0" border = "0" style="width:100%;height:100%;">
					<tr>
						<td style="width:50%;"><div class="prPracSearchTabSelected prPracSearchTabSelectedTheme"><div class="prPracSearchTabText">Search</div></div></td>
						<td style="width:50%;"><div class="prPracSearchTabNotSelected prPracSearchTabNotSelectedTheme"><div class="prPracSearchTabText">Recent Search</div></div></td>
					</tr>
				</table>
			</div>
	<div  data-role = "none" id = "contentWrapper" class="prPracSearchResultsContentWrapperTheme" style = "position:relative;width:100%;height:215px;overflow:auto;z-index:1000;" >
       <div data-role = "none" style = "width:100%;height:auto;overflow:auto">
		<div>
			<table cellpadding="0" cellspacing = "0" style="width: 100%; height: 100%;" class="prPracSearchResultsTableTheme">
				<tr class="prPracSearchResultsHeading prPracSearchResultsHeadingTheme">
					<th style="width:20%"><span class="prPracSearchResultsHeadingText">Code</span></th>
					<th style="width:80%"><span class="prPracSearchResultsHeadingText">Description</span></th>
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
				 <tr class="prPracSearchResultsBody prPracSearchResultsBodyTheme" id="prPractionerSelect<%=sfsUnit.getsCode()%>" onclick="selectSpeciality('<%=sfsUnit.getsCode()%>','<%=sfsUnit.getsDescription()%>')">
					<td><span class="prPracSearchResultsBodyText"><%=sfsUnit.getsCode()%></span></td>
					<td><span class="prPracSearchResultsBodyText"><%=sfsUnit.getsDescription()%></span></td>
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
				   
				  %>
				  </table>
				      <div class=prSfsSearchResultsEmptyTheme">No Records Found</div>
				  <%
				   
			   }
	  		%>

		</div>
		</div></div>
 		

		<input type = "hidden" name ="hdnPractitionerId" id ="hdnPractitionerId" value ="<%=fPractitionerId %>"/>
		<input type = "hidden" name ="hdnPractitionerName" id ="hdnPractitionerName" value ="<%=fPractitionerName %>"/>
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

