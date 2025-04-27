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
<title></title> 
<link rel="stylesheet" href="../jquery.mobile-1.0a4.1.min.css" />  
<script src="../jquery-1.5.2.min.js"></script>  
<script src="../jquery.mobile-1.0a4.1.min.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
<link rel="stylesheet" href="../css/iPadwidget.css" />

<script>
function ShowCount()
{
	window.parent.showProblemsCount(document.getElementById("hdnRowCount").value) ;
}
function expandactiveproblems()
{
	if(window.parent != null)
	{
		window.parent.expandactiveproblems();
	}
}

$(document).ready(function() {
	
	
	$("#tbPage1").bind("swipeleft", function() {
		if(window.parent != null)
			window.parent.widgetsummaryswipeps();
	});


});

</script>
<style>
.tbWidgetContent1
{
	height : 100%;
	width : 100%;
	border : 0px;
	background : #ffffff;
	
}
</style>
</head> 
<body onload = "ShowCount()" > 
<section id="pageWidgetContent" data-role="page" style ="background-color:white;padding:0px"> 
<form>

<table class = "tbWidgetContent1" border = "0" cellpadding = "0" cellspacing = "0" onclick = "expandactiveproblems()" id = "tbPage1">
		
			    
<%
eIPAD.ProblemDetails bean = new eIPAD.ProblemDetails();
List<Problem> objProblemDetails = new ArrayList<Problem>(); 
int nRowCount = 1;	//To hold the rowcount and to limit the row size to 6.		       			    
int nCssCount = 1;  // To display alternate Row Color.
int nDummyRowcount = 1;
int nListSize = 0;

int nLoopCount = 0;
Problem oProblem = null;


try {
objProblemDetails = bean.getProblemDetails(oPatientContext);
nListSize =  objProblemDetails.size();
if(nListSize > 0)
{
	  for(nLoopCount = 0 ; nLoopCount < nListSize;nLoopCount ++)
	  {
		  oProblem = objProblemDetails.get(nLoopCount);
		  if(oProblem != null && nRowCount < 7)
		  {
			  if( nRowCount == 1)
				{
					/*strRowCount = oProblem.getsCount();*/
				}
			  if(nRowCount == 7)
			  {
				  break;
			  }
 
  %>
			       <tr class="trWidgetRows<%=nCssCount %>">
			       <%if(oProblem.getScurrenstate().equals("problems")){%>
			          <td style = "width:7%" align="center" valign = "center"><img src="../images/Blue Bullet.png"></img></td>
			          <%}else{%>
			           <td style = "width:7%" align="center" valign = "center"><img src="../images/Yellow Bullet.png"></img></td>
			           <%}%>
			       <td style ="width:93%"  align ="left"> <span class = "spanWidRows" ><%=oProblem.getsProblemDesc()%>-<%=oProblem.getsProblemAccuracy()%>-<%=oProblem.getsProblemSevereity()%></span></td>
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
  }	//end if
  else
  {
	  %>
	     <%= IPADConstants.NORECORDS_FOR_WIDGETS%>
	  <% 
  }

 	  
 
%>
  


 
 	

         
		  
	   <input type = "hidden" name = "hdnRowCount" id = "hdnRowCount"	value = "<%=nListSize %>" />	 	   
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

