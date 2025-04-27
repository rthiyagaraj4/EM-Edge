<%@page import="java.util.*,java.sql.*,eIPAD.*,eIPAD.HealthObjects.*,java.io.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%
request.setCharacterEncoding("UTF-8");
PatientContext oPatientContext = new PatientContext();
oPatientContext.request = request;
String strRowCount = "";
if(session.getValue("facility_id") != null )
{
	oPatientContext.sFacilityId = (String)session.getValue("facility_id");
}
if(session.getValue("ca_practitioner_id") != null)
{
	oPatientContext.sClinicianId  = (String)session.getValue("ca_practitioner_id");
}
if(session.getValue("practitioner_type") != null )
{
	oPatientContext.sPracType = (String)session.getValue("practitioner_type");
}
if(session.getValue("PatientID") != null)
{
	oPatientContext.sPatientId = (String)session.getValue("PatientID");
}
if(session.getValue("EpisodeId") != null )
{
	oPatientContext.sEncounterId = (String)session.getValue("EpisodeId");
}

%>
<!DOCTYPE html> 
<html> 
<head> 
<title>jQuery Mobile Application</title> 
<link rel="stylesheet" href="../jquery.mobile-1.0a4.1.min.css" />  
<script src="../jquery-1.5.2.min.js"></script>  
<script src="../jquery.mobile-1.0a4.1.min.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  
<link rel="stylesheet" href="../css/iPadwidget.css" />

<script>

function ShowCount()
{
	window.parent.showProcedureCount(document.getElementById("hdnRowCount").value) ;
}
function expandprocdetails()
{
	if(window.parent != null)
	{
		window.parent.expandprocdetails();
	}
}
$(document).ready(function() {
	
	
	$("#tbPage2").bind("swiperight", function() {
		if(window.parent != null)
			window.parent.rightSwipe();
	});


});
</script>
<style>
.tbWidgetContent
{
	height : 100%;
	width : 100%;
	border : 0px;
	
}

</style>
</head> 
<body onload = "ShowCount()" > 
<section id="pageWidgetContent" data-role="page" style ="background-color:#ffffff"> 
<form>
<table class = "tbWidgetContent" cellpadding = "0" cellspacing = "0" onclick = "expandprocdetails()" id = "tbPage2">
<% 
			       		
eIPAD.ProcedureDetails bean = new eIPAD.ProcedureDetails();
List<ProcedureDet> objProcedureDet = new ArrayList<ProcedureDet>(); 
int nRowCount = 1;	//To hold the rowcount and to limit the row size to 6.		       			    
int nCssCount = 1;  // To display alternate Row Color.
int nDummyRowcount = 1;
int nListSize = 0;

int nLoopCount = 0;
ProcedureDet oProcedureDet = null;


try {
objProcedureDet = bean.getProcedureDet(oPatientContext);
nListSize =  objProcedureDet.size();
if(nListSize > 0)
{
	  for(nLoopCount = 0 ; nLoopCount < nListSize;nLoopCount ++)
	  {
		  oProcedureDet= objProcedureDet.get(nLoopCount);
		  if(oProcedureDet != null && nRowCount < 7)
		  {
			  if( nRowCount == 1)
				{
					strRowCount = oProcedureDet.getsProcedureCount();
				}
			  if(nRowCount == 7)
			  {
				  break;
			  } 
 
  %>
			       <tr class="trWidgetRows<%=nCssCount %>">
			          <td style = "width:7%" align="center" valign = "center"><img src="../images/Bullet Arrow.png"></img></td>
			          <td style ="width:93%"  align ="left" style="word-break:break-all"> <div class = "spanWidRows" ><%=oProcedureDet.getsProcNarration()%>-<%=oProcedureDet.getsProcDate()%>-<%=oProcedureDet.getsPracName()%></div></td>
			      </tr>	      
			      
		 <%
		  }
		  nRowCount = nRowCount + 1;
		  if(nCssCount==1)
		  {
			   nCssCount = nCssCount +1;
		  }
		  else
		  {
			  nCssCount = nCssCount -1;
		  }	 
	  }
  }		 

else
{
	  %>
	     <%= IPADConstants.NORECORDS_FOR_WIDGETS%>
	  <% 
}
 
  %>

     
			      
			      
			      
			      
			    
			      
			    </table>
			<input type = "hidden" name = "hdnRowCount" id = "hdnRowCount"	value = "<%=strRowCount %>" />   
	</form>		    
 </section>
  <%
}catch ( Exception e ){
	out.println("Exception " + e);
	//out.println(sqlStr.toString());
	e.printStackTrace();
}
finally{

}
%>
</body>
</html>

