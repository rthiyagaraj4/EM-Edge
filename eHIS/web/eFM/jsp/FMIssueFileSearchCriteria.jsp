<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<SCRIPT src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eFM/js/FMIssueFiles.js"></SCRIPT>
	<SCRIPT src="../../eCommon/js/CommonLookup.js" language="JavaScript"></SCRIPT>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<%
	Connection con				= ConnectionManager.getConnection(request);
	java.sql.Statement stmt		= null;
	ResultSet rs				= null;

	String facility_id		= (String) session.getValue("facility_id");
//	Properties prop			= (Properties) session.getValue("jdbc" );

	String userSecurity  = request.getParameter("userSecurity")==null?"":request.getParameter("userSecurity");
	String access_all  = request.getParameter("access_all")==null?"":request.getParameter("access_all");

	String sql					= "";
	String NarrationCode		= "";
	String NarationShortDesc	= "";
	String sys_date				= "";	

	StringBuffer ReasonForBurrowBuffer	= null;
	ReasonForBurrowBuffer				= new StringBuffer();

	try 
	{
		stmt = con.createStatement();		
		
		String sys_date_query			= "";			
		
		sql = "";
		//sql = "select narration_code,short_desc from fm_narration where eff_status='E' order by 2";
		sql = "SELECT Narration_Code, Short_desc FROM fm_narration_lang_vw WHERE eff_Status = 'E' AND LANGUAGE_ID='"+localeName+"' ORDER BY 2";
		rs 	= stmt.executeQuery(sql);
		while(rs != null && rs.next())
		{
			NarrationCode			= rs.getString("narration_code");
			NarationShortDesc	= rs.getString("short_desc");
			ReasonForBurrowBuffer.append("<OPTION value='"+NarrationCode+"'>"+NarationShortDesc+"</OPTION>");
		} if(rs != null) rs.close();

		sys_date_query="select to_char(sysdate,'dd/mm/yyyy')from dual";
		rs 	= stmt.executeQuery(sys_date_query);
		if(rs != null && rs.next())
		{
			sys_date = rs.getString(1);
		} if(rs != null) rs.close();

		if(sys_date == null || sys_date.equals("null")) sys_date = "";


%>
<BODY STYLE="overflow-y:hidden"  onKeyDown = 'lockKey()' onLoad="FocusFirstElement();">
	<FORM name="FMIssueFileLookup" id="FMIssueFileLookup" METHOD="post" TARGET="messageFrame">
		<BR>
		<table border='0' cellpadding='2' cellspacing='0' width='95%' align='center'>
			<td colspan='7' class='columnheader'><fmt:message key="eFM.RequestedFileDetails.label" bundle="${fm_labels}"/></td>
			<tr>
				<td colspan="7">
					<jsp:include page="../../eFM/jsp/FMFileSearchComponentValues.jsp" ><jsp:param name="flush" value="true" />
						<jsp:param name="frame_name" value="parent.issue_header"/>
						<jsp:param name="form_name" value="FMIssueFileLookup"/>
						<jsp:param name="messageframe_name" value="parent.messageFrame"/>
						<jsp:param name="patientid_name" value="patient_id"/>
						<jsp:param name="fileno_name" value="file_no"/>
						<jsp:param name="filetype_name" value="file_type"/>
						<jsp:param name="volumeno_name" value="volume_no"/>
						<jsp:param name="table_width" value="100"/>
						<jsp:param name="patline_yn" value="Y"/>
						<jsp:param name="patientid_mandatory_yn" value="N"/>
						<jsp:param name="file_mandatory_yn" value="N"/>
						<jsp:param name="patline_ID" value="patLineID"/>
						<jsp:param name="locn_code" value="f_curr_fs_locn"/>
					</jsp:include></td>
			</tr>
			<tr>
				<td id="patLineID" colspan="7" class="OTHLANGLABEL" style="font-weight:Bolder;"></td>
			</tr>
		</table>
		<TABLE BORDER="0" CELLPADDING="3" CELLSPACING="0" WIDTH="95%" ALIGN="center">
		<TR>
			<TD WIDTH="25%" CLASS="label"><fmt:message key="eFM.FSLocationIdentity.label" bundle="${fm_labels}"/></TD>
			<TD WIDTH="75%" class='fields'><SELECT name="fs_locn_id" id="fs_locn_id" onChange="PopulateData(this.value)" TABINDEX="4">
					<OPTION VALUE="">---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</OPTION>
					<OPTION VALUE="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="Y"><fmt:message key="Common.DaycareUnit.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="E"><fmt:message key="Common.ProcedureUnit.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="T"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="D"><fmt:message key="Common.department.label" bundle="${common_labels}"/></OPTION>
				</SELECT>
			</TD>
		</TR>
		<TR>
			<TD  CLASS="label"><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/></TD>
			<TD class='fields'><SELECT name="fs_locn_name" id="fs_locn_name" onChange="PopulateIdentity(this)" TABINDEX="5">
					<OPTION VALUE="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</OPTION>
				</SELECT>
			</TD>
		</TR>
		<TR>
			<TD CLASS="label"><fmt:message key="eFM.ReasonForBorrowing.label" bundle="${fm_labels}"/></TD>
			<TD class='fields'><SELECT name="fs_narration" id="fs_narration" TABINDEX="6">
					<OPTION VALUE=''>-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</OPTION>
					<%=ReasonForBurrowBuffer.toString()%>
				</SELECT>
			</TD>
		</TR>
		<TR>
			<TD CLASS="label"><fmt:message key="eFM.RequestedOnDate.label" bundle="${fm_labels}"/></TD>
			<TD class='fields'><INPUT TYPE="text" id='issuefiledate' name="request_date" id="request_date" SIZE="10" MAXLENGTH="10" TABINDEX="7" onBlur="validDateObj(this,'DMY',localeName)"><input type="image" src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('issuefiledate');">
			</TD>
		</TR>
		<TR>
			<TD CLASS="label"><fmt:message key="Common.RequestedBy.label" bundle="${common_labels}"/></TD>
			<TD class='fields'><INPUT TYPE="text" name="request_by_name" id="request_by_name" SIZE="30" MAXLENGTH="60" value="" TABINDEX="8"  onKeyPress="return CheckForSpecChars(event);" onChange="searchRequestedByUser('<%= facility_id %>')" ><INPUT TYPE="button" name="searchuser" id="searchuser" value="?" class="button" valign="center" TABINDEX="9" onClick="searchRequestedByUser('<%= facility_id %>')">
				<INPUT TYPE="hidden" name="request_by_id" id="request_by_id" VALUE="">
			</TD>
		</TR>
		</TABLE><BR>
		<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="95%" ALIGN="center" BORDER="0">
		<TR>
			<TD CLASS="button" COLSPAN="2" ><INPUT TYPE="button" CLASS="button" name="okbutton" id="okbutton" VALUE="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" onClick="submitAllDetails()">
				<INPUT TYPE="button" CLASS="button" name="cancelbutton" id="cancelbutton" VALUE="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" onClick="window.close()">
			</TD>
		</TR>
		</TABLE>
	<%
	if((ReasonForBurrowBuffer != null) && (ReasonForBurrowBuffer.length() > 0))
	{
		ReasonForBurrowBuffer.delete(0,ReasonForBurrowBuffer.length());
	}
	if(rs!=null)	rs.close();
	if(stmt!=null) stmt.close();
	}catch(Exception e)
	{
		out.println("Exception e :"+e);
	}
	finally 
	{		
		ConnectionManager.returnConnection(con,request);
	}
%>
	<input type="Hidden" name="patient_file_type" id="patient_file_type" value="" >
	<input type="Hidden" name="sys_date" id="sys_date" value="<%=sys_date%>" >
	<input type="Hidden" name="access_all" id="access_all" value="<%=access_all%>" >
	<input type="Hidden" name="userSecurity" id="userSecurity" value="<%=userSecurity%>" >
	<input type='hidden' name='f_curr_fs_locn' id='f_curr_fs_locn' value=''>
</FORM>
</BODY>
</HTML>

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

