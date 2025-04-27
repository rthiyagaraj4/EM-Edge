<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eFM/js/QueryFMCurrentFileStatus.js' language='javascript'></script>
<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
</head>

<body OnMouseDown='CodeArrest();' onKeyDown = 'lockKey();'>
<%
	Connection connection		= ConnectionManager.getConnection(request);
	String facility_id	= (String) session.getValue("facility_id");
	String sql			= "";
	String file_type_appl_yn = "N";
	String doc_or_file = request.getParameter("doc_or_file")==null?"F":request.getParameter("doc_or_file");
	
	int appointmentDays = 0;
	int bookingDays = 0;
//	int patient_id_max_length	=	0;

	Statement statement =	null;
	ResultSet resultSet =	null;
		
	try
	{
		statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
			 sql = "select NO_DAYS_CHECK_APPT_INQUIRY, NO_DAYS_CHECK_BOOK_INQUIRY from fm_parameter where  FACILITY_ID='" + facility_id + "'" ;
		 resultSet = statement.executeQuery(sql);
		 while (resultSet.next())
		 {
			appointmentDays =resultSet.getInt("NO_DAYS_CHECK_APPT_INQUIRY");
			bookingDays		=resultSet.getInt("NO_DAYS_CHECK_BOOK_INQUIRY");
		 }
		 if(resultSet!=null)	resultSet.close();
		if(statement!=null)	statement.close();

		statement	=	connection.createStatement();
		resultSet	=	null;
		resultSet	=	statement.executeQuery("SELECT patient_id_length, file_type_appl_yn FROM mp_param ");
		if((resultSet != null) && (resultSet.next()))
		{
		//	patient_id_max_length	=	resultSet.getInt("patient_id_length");
			file_type_appl_yn		=	resultSet.getString("file_type_appl_yn");
		}
		if(file_type_appl_yn == null || file_type_appl_yn.equals("null"))
			file_type_appl_yn = "N";
%>
<form name='query_doc_criteria_form' id='query_doc_criteria_form' method='post' target='messageFrame' action='../../eFM/jsp/QueryFMCurrentFileStatusResult.jsp'>
	<table border='0' cellpadding='0' cellspacing='0' width='98%' align='center'>
		<tr>
	<td >		
<jsp:include page="../../eFM/jsp/FMFileSearchComponentValues.jsp" flush="true">
	<jsp:param name="frame_name" value="parent.searchFrame"/>
	<jsp:param name="form_name" value="query_doc_criteria_form"/>
	<jsp:param name="messageframe_name" value="parent.messageFrame"/>
	<jsp:param name="patientid_name" value="p_patient_id"/>
	<jsp:param name="fileno_name" value="p_file_no"/>
	<jsp:param name="filetype_name" value="file_type"/>
	<jsp:param name="volumeno_name" value="volume_no"/>
	<jsp:param name="doctype_appl_yn" value="Y"/>
	<jsp:param name="table_width" value="100"/>
	<jsp:param name="locn_code" value="f_curr_fs_locn"/>
</jsp:include></td>	
		<TD class='button'><input type=button name=Add value='Search ' class=button onClick="checkDocumentValue(p_file_no)">
			&nbsp;
			</TD>
	</tr>
</table>
<%
	if(resultSet!=null)	resultSet.close();
	if(statement!=null)	statement.close();
}
catch(Exception e)
{
	out.println(e);
}
finally
{	
	ConnectionManager.returnConnection(connection,request);
}
%>

<input type='hidden' name='facility' id='facility' value='<%=facility_id%>'>
<input type='hidden' name='file_type_appl_yn' id='file_type_appl_yn' value='<%=file_type_appl_yn%>'>
<input type='hidden' name='currfilelocn' id='currfilelocn' value=''>
<input type='hidden' name='ManualReq' id='ManualReq' value='Y'>
<input type='hidden' name='Req_fac_id' id='Req_fac_id' value=''>
<input type='hidden' name='Req_fac_name' id='Req_fac_name' value=''>
<input type='hidden' name='Req_locn_code' id='Req_locn_code' value=''>
<input type='hidden' name='Req_locn_desc' id='Req_locn_desc' value=''>
<input type='hidden' name='Req_locn_iden' id='Req_locn_iden' value=''>
<input type='hidden' name='Req_locn_mr_locn' id='Req_locn_mr_locn' value=''>
<input type='hidden' name='No_Of_Days' id='No_Of_Days' value=''>
<input type='hidden' name='Req_by' id='Req_by' value=''>
<input type='hidden' name='Req_by_name' id='Req_by_name' value=''>
<input type='hidden' name='Narration_code' id='Narration_code' value=''>
<input type='hidden' name='Narration_desc' id='Narration_desc' value=''>
<input type='hidden' name='Pat_line' id='Pat_line' value=''>

<input type='hidden' name='validFile' id='validFile' value=''>
<input type='hidden' name='currStatDesc' id='currStatDesc' value=''>
<input type='hidden' name='currIdDesc' id='currIdDesc' value=''>
<input type='hidden' name='Curr_locn_desc' id='Curr_locn_desc' value=''>
<input type='hidden' name='Req_on' id='Req_on' value=''>
<input type='hidden' name='Curr_locn_code' id='Curr_locn_code' value=''>
<input type='hidden' name='Curr_locn_iden' id='Curr_locn_iden' value=''>
<input type='hidden' name='Curr_locn_mr_locn' id='Curr_locn_mr_locn' value=''>

<input type='hidden' name='appointmentDays' id='appointmentDays' value='<%=appointmentDays%>'>
<input type='hidden' name='bookingDays' id='bookingDays' value='<%=bookingDays%>'>
<input type='hidden' name='doc_or_file' id='doc_or_file' value='<%=doc_or_file%>'>
<input type='hidden' name='f_curr_fs_locn' id='f_curr_fs_locn' value=''>
</form>
</body>
</html>

