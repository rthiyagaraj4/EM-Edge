<!DOCTYPE html>
<%@ page import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>

<%
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
	String surgery_date = "";

	String  sql_patient = "SELECT PATIENT_ID CODE, decode ('"+locale+"','en',PATIENT_NAME, NVL(PATIENT_NAME_LOC_LANG,PATIENT_NAME)) DESCRIPTION FROM MP_PATIENT WHERE  UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PATIENT_ID) LIKE UPPER(?) ORDER BY 2";

	if(facility_id == null) facility_id="";

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
		rst = pstmt.executeQuery();
		while(rst.next()){
			surgery_date = rst.getString("CURRENT_DATE");
		}
	}
	catch(Exception e){
		System.err.println("Err Msg OperationNotesReports.jsp "+e.getMessage());
	}finally{
		if(rst!=null)rst.close();
		if(rst!=null)pstmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request);
  }

%>
<html>
<head><title></title>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eOT/js/OtReports.js" ></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='OtReportOptionsForm' id='OtReportOptionsForm'  action="../../eOT/jsp/callNotes.jsp"  target="messageFrame">
<table border='0' cellpadding=3  cellspacing='0'   align = "center"    width='100%'>

<tr>

<td class='field'  width="25%">
<input type="textarea" name="oper_notes" id="oper_notes" rows = 50 cols = 4 value="">	
</td>

</tr>
	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
	<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
	<input type="hidden" name="p_report_id" id="p_report_id" value="OTRNOTES">
	<input type="hidden" name="pgm_id" id="pgm_id" value="OTRNOTES">
	<input type="hidden" name="sql_text" id="sql_text" value="<%=sql_patient%>" disabled>
	<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="0" disabled>
	<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1" disabled>
	<input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="param1##Operation Date" disabled>
    <input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="param2" disabled>
	<input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="0" disabled>
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>

