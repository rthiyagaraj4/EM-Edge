<%@page import="java.util.*,java.sql.*,java.io.*,eIPAD.*,eIPAD.HealthObjects.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%
request.setCharacterEncoding("UTF-8");

String descCellInd = "";
String resultNum = "";
String color_cell_indicator = "";
String normalLow = "";
String normalHigh = "";
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
	window.parent.showPCFCount(document.getElementById("hdnRowCount").value) ;
}
function expandpatientcareflowsheet()
{
	 if(window.parent != null)
	 {
		 window.parent.expandpatientcareflowsheet();
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
.tbWidgetContent
{
	height : 100%;
	width : 100%;
	border : 0px;
	
}
.trWidgetSummary
{
	height : 38px;
	 background : #48cbcb;
	
}
</style>
</head> 
<body onload = "ShowCount()"> 
<section id="pageWidgetContent" data-role="page" style ="background-color:white"> 
<form>
<table class = "tbWidgetContent" cellpadding = "0" cellspacing = "0" onclick = "expandpatientcareflowsheet()" id = "tbPage1">
	
<%

eIPAD.PatientCFSDetails bean = new eIPAD.PatientCFSDetails();
List<PatientCFS> objPatientCFSDetails = new ArrayList<PatientCFS>(); 
int nRowCount = 1;	//To hold the rowcount and to limit the row size to 6.		       			    
int nCssCount = 1;  // To display alternate Row Color.
int nDummyRowcount = 1;
int nListSize = 0;

int nLoopCount = 0;
PatientCFS oPatientCFS = null;
try {
objPatientCFSDetails = bean.getPatientCFS(oPatientContext);
nListSize =  objPatientCFSDetails.size();

if(nListSize > 0)
{

	 for(nLoopCount = 0 ; nLoopCount < nListSize;nLoopCount ++)
	 {
		 oPatientCFS = objPatientCFSDetails.get(nLoopCount);
		  if(oPatientCFS != null && nRowCount < 7)
		  {
			  if( nRowCount == 1)
			  {
					strRowCount = oPatientCFS.getsCount();
			  }
			  if(nRowCount == 7)
			  {
				  break;
			  } 
	   
	     color_cell_indicator = oPatientCFS.getsNormalRangeSymbol();
	     descCellInd = oPatientCFS.getsDescCellIndicator();
	  
	   
	    normalLow = oPatientCFS.getsNormalLow();//rs.getString("NORMAL_LOW") == null ? "" : rs.getString("NORMAL_LOW");
		normalHigh = oPatientCFS.getsNormalHigh();//rs.getString("NORMAL_HIGH") == null ? "" : rs.getString("NORMAL_HIGH");
		resultNum = oPatientCFS.getsResultNum();//rs.getString("RESULT_NUM") == null ? "0" : rs.getString("RESULT_NUM");
 
  %>
			       <tr class="trWidgetRows<%=nCssCount %>">
			          <td style = "width:7%" align="center" valign = "center"><img src="../images/Bullet Arrow.png" ></img></td>
			       <td style ="width:93%"  align ="left" valign = "middle"> <span class = "spanWidRows" ><%=oPatientCFS.getsDesc()%> - <%=oPatientCFS.getsCareFlowDetail()%> </span>
			         <%
			         if(!color_cell_indicator.equals("") && color_cell_indicator != null && !color_cell_indicator.equals("NONE"))
			         {
			         %>
			            &nbsp;<img src = "../images/<%=color_cell_indicator%>"> </img>
			         <%
			         }
			         else
			         {//1
			        	 if(!normalLow.equals("") && !normalHigh.equals(""))
			        	 {//2
			        		 if(Float.parseFloat(resultNum)>0)
			        		 {//3
			        			 if((Float.parseFloat(resultNum) >= Float.parseFloat(normalLow)) && (Float.parseFloat(resultNum) <= Float.parseFloat(normalHigh)))
			        			 {//4
			         %> 
			               &nbsp;&nbsp;<img src = "../images/NI_Normal.png"  style = "margin-top : 7px"> </img>
			          
			         <%
			        			 }//e4
			        		 }//e3
			        	 }//e2
			        	 if(!normalLow.equals("") && normalHigh.equals(""))
			        	 {//22
			        		 
			        		 if(Float.parseFloat(resultNum)>0)
			        		 {//33
			        			 if(Float.parseFloat(resultNum) >= Float.parseFloat(normalLow)) 
			        			 {//44
			        	 %>
			        	        &nbsp;&nbsp;<img src = "../images/NI_Normal.png"  style = "margin-top : 7px"> </img>
			        	        
			           <% 
			        			 }//e44
			        		 }//e33
			        	 }//e22
			        	 
			        	 if(normalLow.equals("") && !normalHigh.equals(""))
			        	 { //222
			        		 if(Float.parseFloat(resultNum)>0)
			        		 {//333
			        			 if(Float.parseFloat(resultNum) <= Float.parseFloat(normalHigh))
			        			 {//444
			        	  %>
			        	  &nbsp;&nbsp;<img src = "../images/NI_Normal.png" style = "margin-top : 7px"> </img>
			        	  
			      <% 
			        			 }//e444
			        		 }//e333
			        	 }//e222
			       }//end 1
			         %>
			         
			            <% 
			         if(!descCellInd.equals(""))
				{
			        	 
				
			        	 %> 
			        	 &nbsp;&nbsp;<span class = "spanWidRowsBold" ><%=oPatientCFS.getsDescCellIndicator()%></span>	
							<%
			         }
			         %>	
			       </td>
			      </tr>
			      
			      
			      
			      
		 <%
		  }//if oPatientCFS != null
		  nRowCount = nRowCount + 1;
		  if(nCssCount==1)
		  {
			   nCssCount = nCssCount +1;
		  }
		  else
		  {
			  nCssCount = nCssCount -1;
		  }	 
		 
  }//for
}//if nlistsize
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

