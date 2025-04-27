<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eFM/js/QueryFMCurrentFileStatus.js' language='javascript'></script>
<script>
function clearAll()
{
//	document.forms[0].reset();
	parent.volumeFrame.location.href='../../eCommon/html/blank.html';
	parent.searchResultFrame.location.href='../../eCommon/html/blank.html';
	parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
}

function changeVal(obj)
{
	if(obj.checked == true)
		obj.value = 'Y';
	else
		obj.value = 'N';
}

</script>
</head>
<body OnMouseDown='CodeArrest();' onLoad='document.ManualEntry_form.patient_id.focus();' onKeyDown = 'lockKey();'>
<%
	Connection connection				= ConnectionManager.getConnection(request);
	java.sql.Statement statement		= null;
	ResultSet resultSet					= null;

	String facility_id			= (String) session.getValue("facility_id");

	String sql					= "";
	String pat_id_max_length	= "";
	String file_type_appl_yn	= "";
	String mntr_fldfcy_inc_fslocn_ntdf_yn = "";
	String incomplete_status	= "";
	
	int appointmentDays			= 0;
	int bookingDays				= 0;
	String dflt_incomplete_fs_locn_code	= "";
	int patient_id_max_length	= 0;
		
	try
	{
		pat_id_max_length	= request.getParameter("patient_id_length");
		file_type_appl_yn	= request.getParameter("file_type_appl_yn");
	
		if(pat_id_max_length == null || pat_id_max_length.equals("null")) pat_id_max_length = "";
		if(!pat_id_max_length.equals(""))
		{
			patient_id_max_length = Integer.parseInt(pat_id_max_length);
		}

		if(file_type_appl_yn == null || file_type_appl_yn.equals("null")) file_type_appl_yn = "N";
		
		statement = connection.createStatement();

		sql = "select DFLT_INCOMPLETE_FS_LOCN_CODE, NO_DAYS_CHECK_APPT_INQUIRY, NO_DAYS_CHECK_BOOK_INQUIRY,MNTR_FLDFCY_INC_FSLOCN_NTDF_YN from fm_parameter where  FACILITY_ID = '" + facility_id + "' ";
		resultSet = statement.executeQuery(sql);
		while (resultSet.next())
		{
			appointmentDays = resultSet.getInt("NO_DAYS_CHECK_APPT_INQUIRY");
			bookingDays		= resultSet.getInt("NO_DAYS_CHECK_BOOK_INQUIRY");
			dflt_incomplete_fs_locn_code	= resultSet.getString("DFLT_INCOMPLETE_FS_LOCN_CODE");
				if(dflt_incomplete_fs_locn_code == null)
					dflt_incomplete_fs_locn_code = "";
            mntr_fldfcy_inc_fslocn_ntdf_yn = resultSet.getString("MNTR_FLDFCY_INC_FSLOCN_NTDF_YN");
			if(mntr_fldfcy_inc_fslocn_ntdf_yn == null)
					mntr_fldfcy_inc_fslocn_ntdf_yn = "";
		 }
		 
		if(mntr_fldfcy_inc_fslocn_ntdf_yn.equals("Y"))
		{
			incomplete_status ="disabled";
		}else if (mntr_fldfcy_inc_fslocn_ntdf_yn.equals("N")){
		    incomplete_status ="";
		}
%>
	<form name='ManualEntry_form' id='ManualEntry_form' method='post' target='messageFrame' action='../../eFM/jsp/QueryFMCurrentFileStatusResult.jsp'>
	<table border='0' cellpadding='3' cellspacing='0' width='98%' align='center'>
	<tr>
	<td class='label' width="25%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td class='fields' width="25%"><input type='text' name='patient_id' id='patient_id' value='' onKeyPress='return CheckForSpecChars(event)' maxlength="<%=patient_id_max_length%>" size="<%=patient_id_max_length+2%>" onBlur='ChangeUpperCase(this);'><input type='button' class='button' name='pat_search' id='pat_search' value='?' align=center onClick='callPatientSearch();'>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
		<td colspan='2'></td>
	</tr>
	<tr>
	<td  class='label' width="25%"><fmt:message key="Common.Include.label" bundle="${common_labels}"/>:</td>
	<td  class='fields' width="25%"><input type='checkbox' name='incomp_chk' id='incomp_chk' value='N' onclick='changeVal(this)' <%=incomplete_status%>>&nbsp;<fmt:message key="Common.incomplete.label" bundle="${common_labels}"/></td>
	<td  class='fields' width="25%"><input type='checkbox' name='lost_chk' id='lost_chk' value='N' onclick='changeVal(this)'>&nbsp;<fmt:message key="Common.Lost.label" bundle="${common_labels}"/></td>
	<td  class='fields' width="25%"><input type='checkbox' name='inact_chk' id='inact_chk' value='N' onclick='changeVal(this)'>&nbsp;<fmt:message key="Common.Inactive.label" bundle="${common_labels}"/></td>
	</tr>
	<tr>
		<td class='label' colspan='3'>&nbsp;</td>
		<td class='fields'><input type='button' name='search' id='search' value='Search' class='button' onclick='checkPatientValue(document.ManualEntry_form.patient_id)'><input type='button' name='clear' id='clear' value='Clear' class='button' onclick='clearAll()'></td>
	</tr>
</table>
<%
if(resultSet!=null)	resultSet.close();
if(statement!=null)	statement.close();
}
catch(Exception e)
{
	out.println("Exception in QueryCurrentFileStatus :"+e);
}
finally
{	
	ConnectionManager.returnConnection(connection,request);
}
%>

<input type='hidden' name='facility' id='facility' value='<%=facility_id%>'>
<input type='hidden' name='dflt_incomplete_fs_locn_code' id='dflt_incomplete_fs_locn_code' value='<%=dflt_incomplete_fs_locn_code%>'>
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
<input type='hidden' name='patient_id_length' id='patient_id_length' value='<%=pat_id_max_length%>'>

</form>
</body>
</html>

