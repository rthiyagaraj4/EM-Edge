<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,java.io.*,eIPAD.*,eIPAD.HealthObjects.*, eCA.ChartRecording.*,javax.rmi.*,webbeans.eCommon.MessageManager,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%
request.setCharacterEncoding("UTF-8");

String locale = "en";
String facility_id= "";
String clinicianId = "" ;
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
if(request.getParameter("FilterBy") != null)
{
	strFilterBy = request.getParameter("FilterBy");
}


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
/*
if(strPostBack != null && strPostBack.equals("true"))
{
	strPatientClass = request.getParameter("hdnPatientClass");
	strFilterBy = request.getParameter("hdnFilterBy");
	strNoteType = request.getParameter("hdnNoteType");
}
*/
oCreateNotesReq.setFilterBy(strFilterBy);
oCreateNotesReq.setPatientClass(strPatientClass);
oCreateNotesReq.setNoteType(strNoteType);
NoteTypeResponse oNoteTypeResponse = null;
List<NoteTypeHO> oNoteTypeList = null;
NoteTypeHO oNoteTypeHO = null;
NotesDetail bean = new NotesDetail();

int nLoopCount = 0;
int nListSize = 0;
try {
  	  oNoteTypeResponse = bean.getNoteType(oCreateNotesReq);
        if(oNoteTypeResponse != null && oNoteTypeResponse.getLstNoteType() != null)
        {
      	  oNoteTypeList = oNoteTypeResponse.getLstNoteType();
      	  if(oNoteTypeList != null)
      	  {
      		  nListSize = oNoteTypeList.size();
      	  }
      	  if(nListSize > 0)
      	  {
      		  for(nLoopCount = 0 ; nLoopCount < nListSize;nLoopCount ++)
      		  {
      			  oNoteTypeHO = oNoteTypeList.get(nLoopCount);
      			  if(oNoteTypeHO != null)
      			  {
      				  %>
      				   <option value = "<%=oNoteTypeHO.getNoteType()%>"><%=oNoteTypeHO.getNoteTypeDesc()%></option>
      				  <% 
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
