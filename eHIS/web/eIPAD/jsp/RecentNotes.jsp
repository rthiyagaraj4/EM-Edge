<%@page import="java.util.*,java.sql.*,java.io.*,eIPAD.*,eIPAD.HealthObjects.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%
request.setCharacterEncoding("UTF-8");
String locale = "en";
String facility_id= ""; //(String)session.getValue("facility_id");
String clinicianId = "" ;//(String)session.getValue("ca_practitioner_id");
String strPracType = "";
String strPostBack = "false";
String strInterval = "";
String strPatientId = "";
String strEncounterId = "";
String strChartType = "";
CreateNotesRequest oCreateNotesReq = new CreateNotesRequest();
oCreateNotesReq.setRequest(request);


String normalInd = "";
String strPatientClass = "";
String strFilterBy = "P";
String strNoteType = "";


if(session.getValue("facility_id") != null )
{
	oCreateNotesReq.setFacilityId((String)session.getValue("facility_id"));
}
if(session.getValue("ca_practitioner_id") != null)
{
	oCreateNotesReq.setClinicianId((String)session.getValue("ca_practitioner_id"));
}
if(session.getValue("practitioner_type") != null )
{
	oCreateNotesReq.setPracType((String)session.getValue("practitioner_type"));
}
if(session.getValue("PatientID") != null)
{
	oCreateNotesReq.setPatientId((String)session.getValue("PatientID"));
}
if(session.getValue("EpisodeId") != null )
{
	oCreateNotesReq.setEncounterId((String)session.getValue("EpisodeId"));
}

if(session.getValue("responsibility_id") != null)
{
	oCreateNotesReq.setRespId((String)session.getValue("responsibility_id"));
}
oCreateNotesReq.setApplTaskID("CLINICAL_NOTES");
if(request.getParameter("patclass") != null )
{
	strPatientClass = request.getParameter("patclass");
	
}
if(request.getParameter("hdnPostBack") != null)
{
	strPostBack = request.getParameter("hdnPostBack");
}
if(strPostBack != null && strPostBack.equals("true"))
{
	strPatientClass = request.getParameter("hdnPatientClass");
	strFilterBy = request.getParameter("hdnFilterBy");
	strNoteType = request.getParameter("hdnNoteType");
}
oCreateNotesReq.setFilterBy(strFilterBy);
oCreateNotesReq.setPatientClass(strPatientClass);
oCreateNotesReq.setNoteType(strNoteType);

%>


<!DOCTYPE html> 
<html> 
<head> 
<title>jQuery Mobile Application</title> 
<meta name="apple-mobile-web-app-capable" content="yes" />
<link rel="stylesheet" href="../jquery.mobile-1.0a4.1.min.css" />  
<script src="../jquery-1.5.2.min.js"></script>  
<script src="../jquery.mobile-1.0a4.1.min.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
<link rel="stylesheet" href="../css/iPadRecentNotes.css" />

<script>
function Loading()
{
	window.parent.hideLoading();
	 
}
function changeOrientation(orient)
{
		//alert(orient);
	if(orient == "landscape")
	   {
	
	    $("#dvNotesMenu").css('min-height','509px');
	    
	    //var dvheight = $("#dvNotesMenu").height() + "px";
	    
	   }
     else
	   {

    	$("#dvNotesMenu").css('min-height','765px');
	   }
 
}
function loadWidgets()
{
	window.parent.showCreateNotes();
}

function displayNotesContent(accessionNum,noteType)
{
	var newAccessionNum = escape(accessionNum);
	window.parent.dispNotesContent(newAccessionNum,noteType);
}
</script>
</head>

<body onload = "Loading()" style = "background-color : #ffffff">
<section data-role = "page" style = "padding:0px;background-color : #ffffff">
 <form id = "frmRecentNotes" >

 <div data-role = "none" class ='divmain' id = 'dvmain'  style="padding:0px" >
   <div data-role = "none" class = "dvViewNotes">
     <table style="width:100%;height:100%" border = "0" cellpadding = "0" cellspacing = "0">
       <tr style="width:100%;height:100%">
         <td style = "width : 95%" align = "left" valign = "center">
            <span class = "spanViewNotes">Recent Clinical Notes</span>
            
         </td> 
         <td style="width:5%" onclick = "loadWidgets()" align = "center" valign = "middle">
           <img src = "../images/Close.png"></img>
         </td>
       </tr>
     </table>
   </div>
   

   <div id = "dvNotesMenu" class = "dvNotesMenu" data-role = "none" >
   
       <%
       RecentClinicalNotesResponse oRecNoteResponse = null;
       List<RecentClinicalNotesHO> lstRecentClinicalNotes = null;
       RecentClinicalNotesHO oRecNotesHO = null;
       NotesDetail bean = new NotesDetail();
      
       int nLoopCount = 0;
       int nListSize = 0;
       int nCssCount = 1;  // To display alternate Row Color.
       try {
    	   oRecNoteResponse = bean.getRecentNotes(oCreateNotesReq);
           if(oRecNoteResponse != null && oRecNoteResponse.getLstRecentClinicalNotes() != null)
           {
        	   lstRecentClinicalNotes = oRecNoteResponse.getLstRecentClinicalNotes();
         	  if(lstRecentClinicalNotes != null)
         	  {
         		  nListSize = lstRecentClinicalNotes.size();
         	  }
         	  if(nListSize > 0)
         	  {
         		  for(nLoopCount = 0 ; nLoopCount < nListSize;nLoopCount ++)
         		  {
         			 oRecNotesHO = lstRecentClinicalNotes.get(nLoopCount);
         			  if(oRecNotesHO != null)
         			  {
         				  %>
         				  <table class = "tbRecentView" cellpadding = "0" cellspacing = "0"  border = "0" onclick = "displayNotesContent('<%=oRecNotesHO.getAccessionNum()%>','<%=oRecNotesHO.getNoteType()%>')">
					           <tr class = "trRecentView<%=nCssCount%>">
						            <td style="width:60%" align = "left" valign = "center">
						             <span class = "srchLabel"><%=oRecNotesHO.getNoteTypeDesc() %></span>
						           </td>
						           <td style="width:40%" align = "left" valign = "center">
						             <span class = "srchLabel"><%=oRecNotesHO.getEventDateTime() %></span>
						          </td>
					           </tr>
				          </table>
         				  <% 
         			  }
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
           }
    }
   catch ( Exception e ){
			out.println("Exception " + e);
			//out.println(sqlStr.toString());
			e.printStackTrace();
		}
   
       
       %>       
   </div> 


</div>



</form> 
</section>  

</body>

</html>

