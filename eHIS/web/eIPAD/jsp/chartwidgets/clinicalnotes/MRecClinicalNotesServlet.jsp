<!DOCTYPE html>
<%@page import="java.util.Properties"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="com.ehis.persist.PersistenceHelper" %>
<!-- 
code extracted from RecClinicalNotesServlet
variable names are maintained same as in the RecClinicalNotesServlet.java
 -->
<%
webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)PersistenceHelper.getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);

Properties p = (Properties)session.getAttribute("jdbc") ;
String locale = (String)p.getProperty("LOCALE");

String operation_mode = checkForNull(request.getParameter("operation_mode"));
String clinician_id	= (String)session.getAttribute("ca_practitioner_id");
String clinician_name = (String)session.getAttribute("practitioner_name");
String resp_name = (String)session.getAttribute("resp_name");
String resp_id = (String)session.getAttribute("responsibility_id");
String facility_id = (String)session.getAttribute("facility_id");
String login_user_id = (String)session.getAttribute("login_user_id");
String login_at_ws_no =	checkForNull(p.getProperty("client_ip_address"));
String accession_num = checkForNull(request.getParameter("accession_num")); //empty for new note
String performed_by_id = clinician_id; //Logged in practitioner is the one always in mobile. Other practitioners cannot create on behalf
String forwarded_clinician_id = checkForNull(request.getParameter("forwarded_clinician_id")); //not applicable for record/sign
String action_comment =	checkForNull( request.getParameter("action_comment")); //empty for new note
action_comment = java.net.URLDecoder.decode(action_comment); 
String privilege_type; //TODO take from RecClinincalNotesHeader.jsp line 934
String serv_facl_spec_yn; //TODO take from RecClinincalNotesHeader.jsp line 934
String note_type_desc = checkForNull(request.getParameter("note_type_desc"));
String patient_id;	//TODO get it from patContext object
String episode_type = checkForNull(request.getParameter("episode_type")); //DECODE(a.patient_class,'OP','O','EM' ,'O','I') Episode_type
String encounter_id; //TODO get from patContext
String patient_class; //TODO get from patContext or a query is available in the jsp line 230
String event_type_caption;//TODO -- msgstring Note Type
String note_type = checkForNull(request.getParameter("note_type"));
String service_code;//Medical Anc Service
String event_class; //TODO take from RecClinincalNotesHeader.jsp line 1154
String note_type_security_level; //TODO take from RecClinincalNotesHeader.jsp line 934
String event_date_caption; //TODO take from RecClinincalNotesHeader.jsp line 934
String event_date_time	= checkForNull( request.getParameter("event_date_time"));
event_date_time	= com.ehis.util.DateUtils.convertDate(event_date_time,"DMYHM",locale,"en");
String event_perf_by_caption; //TODO take from RecClinincalNotesHeader.jsp line 934
String event_title_caption; //TODO take from RecClinincalNotesHeader.jsp line 934
String event_title_desc; //TODO take from RecClinincalNotesHeader.jsp line 934
String note_content;//TODO FIND
String event_auth_by_caption; //TODO take from RecClinincalNotesHeader.jsp line 934
String authorized_by_id;//empty for now
String authorized_date_time; //empty for now
String event_status_caption; //TODO take from RecClinincalNotesHeader.jsp line 934
String event_status = checkForNull( request.getParameter("event_status"),"1"); 
if(event_status.equals(""))
	event_status="j"; //More on this variable is done in the RecClinicalNotesServlet TODO
String encntr_date;	//TODO take from RecClinincalNotesHeader.jsp line 1238 visit_adm_date
String contr_mod_accession_num; //empty for new note
String doc_linked_note_yn; //TODO take from RecClinincalNotesHeader.jsp line 934
String forward_mode = "";
String appl_task_id = "CLINICAL_NOTES";
String selection_type = "";
HashMap multiHash = null;
//multiHash = manageEmailBean.returnHashMap(); -- Commented for BUILD ERROR
String function_id = ""; 
String srl_no = ""; //applicable for addendum only
String forwardToFac = "";
String contr_oth_accession_num = "";


%>

<%!
public String checkForNull(String inputString)
{
	return (inputString==null)	?	""	:	inputString;
}
private String checkForNull(String inputString, String defaultValue)
{
	if(inputString==null)inputString ="";
	return ( (inputString.equals("") )	?	defaultValue	:	inputString).trim();
}
%> 
