<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,java.io.*,webbeans.eCommon.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html> 
<title></title>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCA/js/RecClinicalNotesFileUpload.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
//out.println("<script>alert('"+request.getQueryString()+"')</script>");
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

String query_string = "";
String accession_num = "";
String note_type = "";
String operation_mode				= "";
String performed_by_id				= "";
String privilege_type					= "";
String function_id						= "";
String field_ref							= "";
String window_close					= "";
String patient_id						= "";
String episode_type					= "";
String encounter_id					= "";
String patient_class					= "";
String event_type_caption			= "";
String service_code					= "";
String event_class						= "";
String note_type_security_level = "";
String event_date_caption			= "";
String event_date_time				= "";
String event_perf_by_caption	= "";
String event_title_caption			= "";
String event_title_desc				= "";
String note_content					= "";
String event_auth_by_caption	= "";
String authorized_by_id				= "";
//String authorized_date_time		= "";
String event_status_caption		= "";
String event_status					= "";
String encntr_date						= "";
String contr_mod_accession_num = "";
String serv_facl_spec_yn			= "";
String visit_adm_date				= "";
String amendment_type			= "";
String appl_task_id					= "";
String security_level					= "";
//String login_at_ws_no				= "";
String remarks							= "";
String forwarded_clinician_id		= "";
String uploadremarks					= "";
String sys_date_time					= "";
String note_type_desc				= "";
String note_header_desc          = "";
String discharge_summary_text = "";
String note_group						 ="";
String from_date_time						 ="";
String to_date_time						 ="";

//String default_value						 ="";
String change_mode						 ="";
String display_file						 ="";
String call_from						 ="";
StringBuffer fileExtn = new StringBuffer();
String call_mode						 ="";
String called_from						 ="";
String insertAuditLogYN = "";

StringBuffer doc_type = new StringBuffer();

int count = 0;

	call_from = request.getParameter("call_from")==null?"":request.getParameter("call_from");
	//out.println("<script>alert('CN06$0000000000024841"+call_from+"')</script>");
	accession_num = request.getParameter("accession_num")==null?"":request.getParameter("accession_num");
	note_type = request.getParameter("note_type")==null?"":request.getParameter("note_type");	
	note_group = request.getParameter("note_group")==null?"":request.getParameter("note_group");	
	operation_mode = request.getParameter("operation_mode")==null?"":request.getParameter("operation_mode");	
	performed_by_id = request.getParameter("performed_by_id")==null?"":request.getParameter("performed_by_id");	
	privilege_type = request.getParameter("privilege_type")==null?"":request.getParameter("privilege_type");	
	function_id = request.getParameter("function_id")==null?"":request.getParameter("function_id");	
	field_ref = request.getParameter("field_ref")==null?"":request.getParameter("field_ref");	
	window_close = request.getParameter("window_close")==null?"":request.getParameter("window_close");	
	patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");	
	episode_type = request.getParameter("episode_type")==null?"":request.getParameter("episode_type");	
	encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");	
	patient_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");	
	event_type_caption = request.getParameter("event_type_caption")==null?"":request.getParameter("event_type_caption");	
	service_code = request.getParameter("service_code")==null?"":request.getParameter("service_code");	
	event_class = request.getParameter("event_class")==null?"":request.getParameter("event_class");	
	note_type_security_level = request.getParameter("note_type_security_level")==null?"":request.getParameter("note_type_security_level");	
	event_date_time = request.getParameter("event_date_time")==null?"":request.getParameter("event_date_time");	
	note_content = request.getParameter("note_content")==null?"":request.getParameter("note_content");	
	authorized_by_id = request.getParameter("authorized_by_id")==null?"":request.getParameter("authorized_by_id");	
	event_status = request.getParameter("event_status")==null?"":request.getParameter("event_status");	
	encntr_date = request.getParameter("encntr_date")==null?"":request.getParameter("encntr_date");	
	contr_mod_accession_num = request.getParameter("contr_mod_accession_num")==null?"":request.getParameter("contr_mod_accession_num");	
	serv_facl_spec_yn = request.getParameter("serv_facl_spec_yn")==null?"":request.getParameter("serv_facl_spec_yn");	
	visit_adm_date = request.getParameter("visit_adm_date")==null?"":request.getParameter("visit_adm_date");	
	amendment_type = request.getParameter("amendment_type")==null?"":request.getParameter("amendment_type");	
	appl_task_id = request.getParameter("appl_task_id")==null?"":request.getParameter("appl_task_id");	
	security_level = request.getParameter("security_level")==null?"":request.getParameter("security_level");	
	remarks = request.getParameter("remarks")==null?"":request.getParameter("remarks");	
	forwarded_clinician_id = request.getParameter("forwarded_clinician_id")==null?"":request.getParameter("forwarded_clinician_id");	
	query_string = request.getParameter("query_string")==null?"":request.getParameter("query_string");	
	from_date_time = request.getParameter("from_date_time")==null?"":request.getParameter("from_date_time");	
	to_date_time = request.getParameter("to_date_time")==null?"":request.getParameter("to_date_time");	
	called_from = request.getParameter("called_from")==null?"":request.getParameter("called_from");	
	insertAuditLogYN = request.getParameter("insertAuditLogYN")==null?"N":request.getParameter("insertAuditLogYN");
	

try
{
	con = ConnectionManager.getConnection(request);

	String qry_cr_enctr_dtl_obj = "";
	qry_cr_enctr_dtl_obj = "SELECT EVENT_TITLE FROM CR_ENCOUNTER_DETAIL_OBJ WHERE ACCESSION_NUM = ? AND CONTR_SYS_EVENT_CODE = ?";
	pstmt = con.prepareStatement(qry_cr_enctr_dtl_obj);
	pstmt.setString(1,accession_num);
	pstmt.setString(2,note_type);
	rs = pstmt.executeQuery();

	while(rs.next())
	{
		uploadremarks = rs.getString("EVENT_TITLE")==null?"":rs.getString("EVENT_TITLE");
		count = 1;
	}
	/*added by kishore kumar N for the CRF SRR - 500*/
	if(rs!=null)
		rs.close();
	if(pstmt!=null)
		pstmt.close();

	String fileExtQry = "SELECT DISTINCT FILE_EXTN FROM CA_APPL_LINKED_OBJ_TYPE WHERE APPLICABLE_YN='Y'";
	pstmt = con.prepareStatement(fileExtQry);
	rs = pstmt.executeQuery();
	
	while(rs.next())
	{			
		if(fileExtn.equals(""))
		{	 
			fileExtn.append(rs.getString(1)==null?"":rs.getString(1));
		}
		else
		{	 			
			fileExtn.append(","); 
			fileExtn.append(rs.getString(1)==null?"":rs.getString(1)); 
		}		
	}
		
	if(rs!=null)
		rs.close();
	if(pstmt!=null)
		pstmt.close();

	
/*ends here.*/	

}
catch(Exception e)
{
	e.printStackTrace();
	
}
finally
{

	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}

if(operation_mode.equals("Update") || count > 0)
{
	change_mode = "display:none";
	display_file = "display";

}
else
{
	change_mode = "display:none";
	display_file = "display";
}

if(count > 0)
	call_mode = "update";
else
	call_mode = "";

//out.println("<script>document.fileuploadid.value="+default_value+"</script>");
%>
</head>
	<body  class='CONTENT' onKeyDown="lockKey()">

		<form name='RecClinicalNotesFileUploadForm' id='RecClinicalNotesFileUploadForm'  action="../../servlet/eCA.RecClinicalNotesFileUploadServlet" method='post' enctype='multipart/form-data' target='messageFrame'>
		<table border='0' width='90%' cellpadding='0' cellspacing='0' align='center'>
			<tr  id='change_fileid' style='<%=change_mode%>'>
				<td class = 'label'  ><fmt:message key="eCA.ChangeFileReference.label" bundle="${ca_labels}"/>&nbsp;</td>
				<td class = 'fields' ><input type='checkbox' name='changefile' id='changefile' value='N' onClick="ShowFileRef(this)"><input type='hidden' name='change_file_ref' id='change_file_ref' value="N" ></td>
			</tr>
		
			<tr id='file_id' style='<%=display_file%>'>
				<td class='label' id='fileref' ><fmt:message key="eCA.FileReference.label" bundle="${ca_labels}"/>&nbsp;</td><td class = 'fields'  >
				<div id="uploadFile_div"><input type='file' name='fileupload' id='fileupload' id = 'fileuploadid' size='30' onMouseDown=' return checkFilevalue(this)' onKeyDown='return checkFilevalue(this);' onKeyPress =' return checkFilevalue(this);' onContextMenu ='return false;' onclick='disableBtns(this,"<%=called_from%>");' ><img src='../../eCommon/images/mandatory.gif'></div>&nbsp;</td>
			</tr>
			<tr>
				<td class='label' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;</td>
				<td class = 'fields' ><textarea name='uploadremarks' rows='3' cols='55' onKeyPress='checkMaxLimit(this,200);' onBlur='checkMaxLimitnew(this,200);'></textarea></td>
			</tr>
		</table>

		<!--   Hidden Fields    -->
		<input type="hidden" name="note_type" id="note_type" value="<%=note_type%>">
		<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
		<input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>">
		<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
		<input type="hidden" name="visit_adm_date" id="visit_adm_date" value="<%=visit_adm_date%>">
		<input type="hidden" name="sys_date_time" id="sys_date_time" value="<%=sys_date_time%>">
		<input type="hidden" name="operation_mode" id="operation_mode" value="<%=operation_mode%>">
		<input type="hidden" name="amendment_type" id="amendment_type" value="<%=amendment_type%>">
		<input type="hidden" name="accession_num" id="accession_num"	value="<%=accession_num%>">
		<input type="hidden" name="event_class" id="event_class"	value="<%=event_class%>">
		<input type="hidden" name="privilege_type" id="privilege_type"	 value="<%=privilege_type%>">
		<input type="hidden" name="note_type_desc" id="note_type_desc"	value="<%=note_type_desc%>">
		<input type="hidden" name="event_type_caption" id="event_type_caption" value="<%=event_type_caption%>">
		<input type="hidden" name="note_type_security_level" id="note_type_security_level" value="<%=note_type_security_level%>">
		<input type="hidden" name="event_date_caption" id="event_date_caption"		value="<%=event_date_caption%>">
		<input type="hidden" name="event_perf_by_caption" id="event_perf_by_caption"		value="<%=event_perf_by_caption%>">
		<input type="hidden" name="event_title_caption" id="event_title_caption"			value="<%=event_title_caption%>">
		<input type="hidden" name="event_auth_by_caption" id="event_auth_by_caption"		value="<%=event_auth_by_caption%>">
		<input type="hidden" name="event_status_caption" id="event_status_caption"			value="<%=event_status_caption%>">
		<input type="hidden" name="serv_facl_spec_yn" id="serv_facl_spec_yn"	value="<%=serv_facl_spec_yn%>">
		<input type="hidden" name="forwarded_clinician_id" id="forwarded_clinician_id" value="<%=forwarded_clinician_id%>">
		<input type="hidden" name="function_id" id="function_id"	value="<%=function_id%>">
		<input type="hidden" name="appl_task_id" id="appl_task_id" value="<%=appl_task_id%>">	

		<input type="hidden" name="event_date_time" id="event_date_time" value="<%=event_date_time%>">	
		<input type="hidden" name="sys_date_time" id="sys_date_time" value="<%=sys_date_time%>">	
		<input type="hidden" name="note_header_desc" id="note_header_desc" value="<%=note_header_desc%>">	
		<input type="hidden" name="discharge_summary_text" id="discharge_summary_text" value="<%=discharge_summary_text%>">	
		<input type="hidden" name="note_group" id="note_group" value="<%=note_group%>">	
		<input type="hidden" name="performed_by_id" id="performed_by_id" value="<%=performed_by_id%>">	
		<input type="hidden" name="event_title_desc" id="event_title_desc" value="<%=event_title_desc%>">	
		<input type="hidden" name="service_code" id="service_code" value="<%=service_code%>">	
		<input type="hidden" name="event_title_desc" id="event_title_desc" value="<%=event_title_desc%>">	
		<input type="hidden" name="event_title_desc" id="event_title_desc" value="<%=event_title_desc%>">	
		<input type="hidden" name="queryString" id="queryString" value="<%=query_string%>">	
		<input type="hidden" name="episode_type" id="episode_type" value="<%=episode_type%>">	
		<input type="hidden" name="from_date_time" id="from_date_time" value="<%=from_date_time%>">	
		<input type="hidden" name="to_date_time" id="to_date_time" value="<%=to_date_time%>">	
		<input type="hidden" name="call_from" id="call_from" value="<%=call_from%>">	
		<input type="hidden" name="call_mode" id="call_mode" value="<%=call_mode%>">	
		<input type="hidden" name="doc_type" id="doc_type" value="<%=doc_type%>">	
		<input type="hidden" name="previewMode" id="previewMode" value="">	
		<input type="hidden" name="fileExtn" id="fileExtn" value="<%=fileExtn.toString()%>">	
		<input type="hidden" name="image_name" id="image_name" value="">	
		<input type="hidden" name="called_from" id="called_from" value="<%=called_from%>">	
		<input type="hidden" name="insertAuditLogYN" id="insertAuditLogYN" value="<%=insertAuditLogYN%>">	
		<input type="hidden" name="contr_mod_accession_num" id="contr_mod_accession_num" value="<%=contr_mod_accession_num%>">	


		</form>
			
	</body>
</html>

