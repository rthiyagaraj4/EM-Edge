<!DOCTYPE html>
<%@page import="eIPAD.chartsummary.clinicalnotes.response.ClinicalNotesMapResponse"%>
<%@page import="eIPAD.chartsummary.clinicalnotes.bc.ClinicalNotesBC"%>
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@page import="java.util.*,java.sql.*,java.io.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}" /> 
<%
request.setCharacterEncoding("UTF-8");

String locale = "en";
StringBuffer sqlStr = new StringBuffer("");

String accession_num = request.getParameter("accession_num");
String notesHeader = "header"; //request.getParameter("notesHeader");
String notes_content = "";

java.sql.Clob clob_notes_content = null;
java.io.Reader content_reader = null;
java.io.BufferedReader bf_content_reader = null;
String note_type = "";
String noteTime = "";
String note_type_desc = "";
String pract_name = "";
String event_status_code = "";
String event_status = "";
String encounter_id = "";
PatContext patientContext = (PatContext) session.getAttribute("PatientContext");

sqlStr.append("SELECT TO_CHAR (a.EVENT_DATE_TIME, 'HH24:MI') EVENT_DATE_TIME,a.ENCOUNTER_ID, a.note_content,a.note_type, a.event_status, CA_GET_DESC.CA_NOTE_TYPE(a.note_type,'" + locale + "' ,'1') note_type_desc, am_get_desc.am_practitioner (a.performed_by_id, '" + locale + "', 2 ) pract_name FROM ca_encntr_note a where  a.accession_num= '" + accession_num + "'");

Statement stmt = null;
ResultSet rs = null;

Statement stmt1 = null;
ResultSet rs1 = null;
Connection conn = null;

int i = 1;
String strRowCount = "";
try {
 conn = ConnectionManager.getConnection(request);
 stmt = conn.createStatement();
 stmt1 = conn.createStatement();
 if (rs != null) rs.close();
 rs = stmt.executeQuery(sqlStr.toString());

 if (rs != null && rs.next()) {
  clob_notes_content = (java.sql.Clob) rs.getObject("note_content");
  pract_name = rs.getString("pract_name") == null ? "" : rs.getString("pract_name"); // performed by
  note_type_desc = rs.getString("note_type_desc") == null ? "" : rs.getString("note_type_desc"); // note type
  note_type = rs.getString("note_type") == null ? "" : rs.getString("note_type"); // note type
  noteTime = rs.getString("EVENT_DATE_TIME") == null ? "" : rs.getString("EVENT_DATE_TIME"); // note time
  event_status_code = rs.getString("event_status") == null ? "" : rs.getString("event_status");
  encounter_id = rs.getString("ENCOUNTER_ID") == null ? "" : rs.getString("ENCOUNTER_ID");

  if (event_status_code.equals("1")) {
   event_status = "In Progress";
  } else if (event_status_code.equals("2")) {
   event_status = "Transcribed";
  } else if (event_status_code.equals("3")) {
   event_status = "Unauthorized";
  } else if (event_status_code.equals("4")) {
   event_status = "Authorized";
  } else if (event_status_code.equals("5")) {
   event_status = "Modified";
  } else if (event_status_code.equals("9")) {
   event_status = "In Error";
  }

  if (clob_notes_content != null) {
   try {
    content_reader = clob_notes_content.getCharacterStream();
    bf_content_reader = new java.io.BufferedReader(content_reader);
    char[] arr_notes_content = new char[(int) clob_notes_content.length()];
    bf_content_reader.read(arr_notes_content, 0, (int) clob_notes_content.length());
    notes_content = new String(arr_notes_content);
    bf_content_reader.close();
   } catch (Exception e) {
    out.println("Exception@2-readCLOB : " + e);
   }

   if (!notes_content.equals("")) {
    int nIndex = notes_content.indexOf("<BODY>");
    int nIndex1 = notes_content.lastIndexOf("</BODY>");

    if (nIndex != -1 && nIndex1 != -1)
     notes_content = notes_content.substring(nIndex + 6, nIndex1);
   }
  } 
 }

} catch (Exception e) {
 out.println("Exception " + e);
 e.printStackTrace();
} finally {
 if (rs != null) rs.close();
 if (rs1 != null) rs1.close();
 if (stmt1 != null) stmt1.close();
 if (stmt != null) stmt.close();

 ConnectionManager.returnConnection(conn, request);
}

ClinicalNotesBC bc = new ClinicalNotesBC();
ClinicalNotesMapResponse operationsAllowedResp = bc.getApplicableNoteOperations(patientContext, accession_num);
HashMap operationsHash = operationsAllowedResp.getMap();
String operations_allowed = (String) operationsHash.get("operations_allowed");
String amendment_type = (String) operationsHash.get("ammendment_type");
StringTokenizer stoken = new java.util.StringTokenizer(operations_allowed, "|");
HashMap arrFunctions = new HashMap();
while (stoken.hasMoreTokens()) {
 String button_name = (String) stoken.nextToken();
 arrFunctions.put(button_name, button_name);
}	
%>
</head>
<div class="note-heading">
  <span class="time">
    <%=noteTime%>
  </span>
  <span class="text">
    <%=note_type_desc%>
  </span>
  <span class="ECText">
    Encounter Id
  </span>
  <span class="ECNum">
    <%=encounter_id%>
  </span>
</div>
<div class="note">
  <%=notes_content%>          
</div>
        			

