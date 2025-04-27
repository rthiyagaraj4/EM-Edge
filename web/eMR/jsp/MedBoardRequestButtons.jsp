<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<% 
	Connection con = null;
	PreparedStatement stmt = null;
	PreparedStatement pstmt=null;
	ResultSet rs = null;
	String Facility_Id = (String) session.getValue("facility_id");
%>
<html>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String locale			= (String)session.getAttribute("LOCALE");
	String call_function= checkForNull(request.getParameter("call_function"));
	String PatientId	= checkForNull(request.getParameter("PatientId"));
	String request_id	= checkForNull(request.getParameter("request_id"));
	String called_from	= checkForNull(request.getParameter("called_from"));
	String patient_class=""; String encounter_id="";
	String accession_num	=""; String event_status ="";
%>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src="../../eMR/js/MedBoardReqButtons.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
String facility_name = "";
String patient_line	= "";
String location_code	= "";
String specialty_code	= "";
try
{
	try
	{
		con = ConnectionManager.getConnection(request);
		String facilitySql = " select facility_name, get_patient.get_line_detail(?,?) patient_line from SM_FACILITY_PARAM where facility_id = ? ";

		stmt = con.prepareStatement(facilitySql);
		stmt.setString(1,PatientId);
		stmt.setString(2,locale);
		stmt.setString(3,Facility_Id);
		rs	=	stmt.executeQuery();

		if (rs.next() && rs != null)
		{
			facility_name	= rs.getString("facility_name");
			patient_line	= rs.getString("patient_line");
		}
		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();
		
		StringBuffer sqlBuff=new StringBuffer();
		sqlBuff.append("select a.event_status, a.accession_num from CA_ENCNTR_NOTE a ");
		sqlBuff.append(" where a.patient_id=? and a.ACCESSION_NUM= ");
		sqlBuff.append("(select ACCESSION_NUM from MR_REPORT_REQUEST_HDR where ");
		sqlBuff.append("facility_id=? and patient_id =?");
		sqlBuff.append(" and REQUEST_ID = ?)");
		
		pstmt = con.prepareStatement(sqlBuff.toString());
		pstmt.setString(1,PatientId);
		pstmt.setString(2,Facility_Id);
		pstmt.setString(3,PatientId);
		pstmt.setString(4,request_id);
		rs	=pstmt.executeQuery();

		if (rs.next() && rs != null)
		{
			accession_num = rs.getString("ACCESSION_NUM")==null?"":rs.getString("ACCESSION_NUM");
			event_status= rs.getString("EVENT_STATUS")==null?"":rs.getString("EVENT_STATUS");
		}
		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();

		////Fetching patient_calss from pr_encounter for Record..
		String pat_class_slq=" select a.PATIENT_CLASS,b.ENCOUNTER_ID,a.PAT_CURR_LOCN_CODE,a.SPECIALTY_CODE from PR_ENCOUNTER a,MR_REPORT_REQUEST_DTL b where  a.facility_id = ? and a.PATIENT_ID=b.PATIENT_ID and a.facility_id=b.facility_id and b.patient_id=? and b.REQUEST_ID=?";
		stmt = con.prepareStatement(pat_class_slq);
		stmt.setString(1,Facility_Id);
		stmt.setString(2,PatientId);
		stmt.setString(3,request_id);
		rs	=	stmt.executeQuery();

		while(rs.next())
		{
			patient_class = rs.getString("PATIENT_CLASS");
			encounter_id = rs.getString("ENCOUNTER_ID");
			location_code = rs.getString("PAT_CURR_LOCN_CODE")==null?"":rs.getString("PAT_CURR_LOCN_CODE");
			specialty_code = rs.getString("SPECIALTY_CODE")==null?"":rs.getString("SPECIALTY_CODE");
		}

	if(rs!=null)
		rs.close();
	if(stmt!=null)
		stmt.close();

	}catch(Exception exp)
	{
		//out.println(" Err in tryCatch 5: "+exp.toString());
		exp.printStackTrace();
	}
%>
<body onKeyDown='lockKey()'>
<form name='recordButton_form' id='recordButton_form'>
<table align='center' border="0" width="100%" cellpadding='0' cellspacing='0'>
<tr align="right">
<%	if(call_function.equals("PREPARE_MEDICAL_BOARD") || call_function.equals("DELIVER_MEDICAL_BOARD"))
	{	
		if(call_function.equals("PREPARE_MEDICAL_BOARD") && called_from.equals("CA"))
		{	%>				
			<td class='button' width="90%" ><input type='button' name='Notes' id='Notes' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.RecordNotes.label","mr_labels")%>' class='button' onclick='openCAModal()'></td>
	<%	}else{	%>
			<td class=label width="50%" >&nbsp;</td>
	<%	}	%>
			<td class='button' width="50%" ><input type='button' name='print' id='print' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ViewMedicalReport.label","mr_labels")%>' class='button' onclick='printReport();' ><input type='button' class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' name='record' onclick="apply();"><input type='button' class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' name='close' onclick="closeME();"></td>
<%	}else if(!call_function.equals("MEDICAL_BOARD_COMPLETED"))
	{	%>
			<td class='button' width="100%" ><input type='button' class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' name='record' onclick="apply();"><input type='button' class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' name='close' onclick="closeME();"></td>
<%	}else if(call_function.equals("MEDICAL_BOARD_COMPLETED") || call_function.equals("MEDICAL_REPORT_COMPLETED") ){	%>
			<td class='button' width="100%"><input type='button' class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' name='close' onclick="closeME();"></td>
<%	}	%>
	</tr>
<!-- 	<tr><td colspan="4" class='label' height=5>&nbsp;</td></tr> -->
</table>
<input type="hidden" name="facility_name" id="facility_name"	value="<%=facility_name%>">
<input type="hidden" name="PatientId" id="PatientId"		value="<%=PatientId%>">
<input type="hidden" name="patient_line" id="patient_line"	value="<%=patient_line%>">
<input type="hidden" name="patient_class" id="patient_class"	value="<%=patient_class%>">
<input type="hidden" name="encounter_id" id="encounter_id"	value="<%=encounter_id%>">
<input type="hidden" name="accession_num" id="accession_num"	value="<%=accession_num%>">
<input type="hidden" name="event_status" id="event_status"	value="<%=event_status%>">
<input type="hidden" name="request_id" id="request_id"		value="<%=request_id%>">
<input type="hidden" name="call_function" id="call_function"	value="<%=call_function%>">
<input type="hidden" name="specialty_code" id="specialty_code"	value="<%=specialty_code%>">
<input type="hidden" name="location_code" id="location_code"	value="<%=location_code%>">

	<%	/*
	if(called_from.equals("CA"))
	{
	out.println("<script>if(document.forms[0].print)document.forms[0].print.disabled = false;</script>");
	}
	else
	{
	if(!accession_num.equals("") && ( event_status.equals("4") || event_status.equals("5") ) )
	{
	out.println("<script>if(document.forms[0].print)document.forms[0].print.disabled = false;</script>");
	}
	else
	{
	out.println("<script>if(document.forms[0].print)document.forms[0].print.disabled = true;</script>");
	}
	}
	*/
}
catch(Exception e)
{
	//out.println("Exception @ try 1 "+e.toString());
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>
</form>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	? "" : inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	? defaultValue : inputString;
	}
%>

