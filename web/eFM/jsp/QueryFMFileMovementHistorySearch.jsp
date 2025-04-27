<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eFM/js/QueryFMFileMovementHistroy.js'></script>
<script language='javascript' src='../../eFM/js/checkSystemDate.js'></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>

</head>

<body OnMouseDown='CodeArrest();' onKeyDown = 'lockKey();'>
<%
	Connection conn		= ConnectionManager.getConnection(request);
	String facility_id	= (String) session.getValue("facility_id");

	Statement stmt	= null;
	ResultSet rset	= null;	
	String sql	  = "";
	String today  ="";
	
	try
	{
		stmt = conn.createStatement();
		sql = "select to_char(sysdate,'dd/mm/yyyy')today from dual";		
		rset = stmt.executeQuery(sql);
		if (rset.next())
		{
			today = rset.getString("today");
		}
%>
<form name='ManualEntry_form' id='ManualEntry_form' method='post' target='messageFrame' action='../../eFM/jsp/QueryFMFileMovementHistorySearchResult.jsp'>
<table border='0' cellpadding='2' cellspacing='0' width='100%' align='center'>
	<tr><td colspan="4">
		<jsp:include page="../../eFM/jsp/FMFileSearchComponentValues.jsp" ><jsp:param name="flush" value="true" />
			<jsp:param name="frame_name" value="parent.searchFrame"/>
			<jsp:param name="form_name" value="ManualEntry_form"/>
			<jsp:param name="messageframe_name" value="parent.messageFrame"/>
			<jsp:param name="patientid_name" value="patient_id"/>
			<jsp:param name="fileno_name" value="file_no"/>
			<jsp:param name="filetype_name" value="file_type_code"/>
			<jsp:param name="document_type_name" value="doc_type_code"/>
			<jsp:param name="document_folder_id_name" value="doc_folder_id"/>
			<jsp:param name="volumeno_name" value="volume_no"/>
			<jsp:param name="table_width" value="100"/>
			<jsp:param name="tablealign" value="center"/>
			<jsp:param name="volume_mandatory_yn" value="Y"/>
			<jsp:param name="locn_code" value="f_curr_fs_locn"/>
			<jsp:param name="file_mov_flag" value="Y"/>
		</jsp:include>
		</td>
	</tr>
	<tr>
		<td class='label' width='25%'><fmt:message key="Common.IssueDate.label" bundle="${common_labels}"/></td>
		<td width='25%' class='fields'><input type='text' id="date_from" name='from' id='from' size='10' maxlength='10' tabIndex="3" value='' onBlur='validDateObj(this,"DMY","<%=localeName%>");'><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('date_from');">&nbsp;-&nbsp;<input type='text' id="date_to" name='to' id='to' size='10' maxlength='10' value='' tabIndex="4" onBlur='validDateObj(this,"DMY","<%=localeName%>");'><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('date_to');"></td>

		<td class='label' width='25%' >&nbsp;</td>
		<td class='button' width='25%' ><input type='button' class='button' name='search' id='search'  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' tabIndex="5" onClick='searchResult();'>
		</td>
	</tr>
</table>
<%
	if(rset!=null)	rset.close();
	if(stmt!=null)	stmt.close();
}
catch(Exception e)
{
	out.println(e);
}
finally
{	
	ConnectionManager.returnConnection(conn,request);
}
%>

<input type='hidden' name='facility' id='facility' value='<%=facility_id%>'>
<input type='hidden' name='currfilelocn' id='currfilelocn' value=''>
<input type='hidden' name='ManualReq' id='ManualReq' value='Y'>
<input type='hidden' name='Req_on' id='Req_on' value=''>
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
<input type='hidden' name='Curr_locn_code' id='Curr_locn_code' value=''>
<input type='hidden' name='Curr_locn_iden' id='Curr_locn_iden' value=''>
<input type='hidden' name='Curr_locn_mr_locn' id='Curr_locn_mr_locn' value=''>
<input type='hidden' name='Pat_line' id='Pat_line' value=''>
<input type='hidden' name='currIdDesc' id='currIdDesc' value=''>
<input type='hidden' name='currStatDesc' id='currStatDesc' value=''>
<input type='hidden' name='Curr_locn_desc' id='Curr_locn_desc' value=''>
<input type='hidden' name='validFile' id='validFile' value=''>
<input type='hidden' name='CURR_FACILITY_NAME' id='CURR_FACILITY_NAME' value=''>
<input type='hidden' name='today' id='today' value='<%=today%>'>
<input type='hidden' name='f_curr_fs_locn' id='f_curr_fs_locn' value=''>
</form>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

