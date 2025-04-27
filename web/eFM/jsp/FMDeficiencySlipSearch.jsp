<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>



<%
	String p_module_id		= "FM" ;
	String p_report_id		= "FMBDEFSL" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
%>
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
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../../eFM/js/FMDeficiencySlipDtl.js' language='javascript'></script>
<script language='javascript' src='../../eFM/js/checkSystemDate.js'></script>
</head>
<body OnMouseDown='CodeArrest();' onload='document.forms[0].patientid.focus();' onKeyDown = 'lockKey();'>
<%
	Connection conn = ConnectionManager.getConnection(request);
	String facility_id = (String) session.getValue("facility_id");

	Statement stmt=null;
	ResultSet rset=null;
	ResultSet rs=null;
	String sql = "",p_file_no_length="";
	String today ="";
	String smfnd = "";
	String sfn_yn = "";
	String file_type_yn = "";

	try
	{	
		stmt = conn.createStatement();
		int p_patient_id_length		= 0 ;
		String p_separate_file_no_yn = "";
		String p_no_rec_in_facility = "N";
			sql = "select patient_id_length,separate_file_no_yn,FILE_TYPE_APPL_YN from mp_param " ;

		rs = stmt.executeQuery(sql);

	while (rs.next())
	{
		p_patient_id_length = rs.getInt("patient_id_length");
		p_file_no_length		 = rs.getString("separate_file_no_yn");
		file_type_yn		 = rs.getString("FILE_TYPE_APPL_YN");
	}
		if(rs!=null)	rs.close();
		sql = "select separate_file_no_yn from mp_param_for_facility where facility_id = '"+facility_id+"'" ;
		rs = stmt.executeQuery(sql);
		if (rs.next())
		{
			p_separate_file_no_yn = rs.getString("separate_file_no_yn");
			p_no_rec_in_facility = "Y";
		}
		if(rs!=null)	rs.close();
		if(stmt!=null)	stmt.close();
		if (p_no_rec_in_facility.equals("Y"))
		{
			if (p_separate_file_no_yn.equals("N"))
				p_file_no_length =  Integer.toString(p_patient_id_length);
			
		}
		else
		{
			if (p_file_no_length.equals("N"))
				p_file_no_length =  Integer.toString(p_patient_id_length);
			
		}
		sql = "select to_char(sysdate,'dd/mm/yyyy')today from dual";
		stmt = conn.createStatement();
		rset = stmt.executeQuery(sql);
		if (rset.next())
		{
			today = rset.getString("today");
		}
%>
<form name='ManualEntry_form' id='ManualEntry_form' target='messageFrame' action="../../eCommon/jsp/report_options.jsp">
<table border='0' cellpadding='3' cellspacing='0' width='95%' align='center'>
	<tr><td colspan='4'>&nbsp;</td></tr>	
	<tr>
<%
	String mysql = "select SINGLE_OR_MULTI_FILES_IND,SEPARATE_FILE_NO_YN from mp_param"; 
	rs = stmt.executeQuery(mysql);
	if(rs != null && rs.next())
	{
		smfnd = rs.getString("SINGLE_OR_MULTI_FILES_IND");
		sfn_yn = rs.getString("SEPARATE_FILE_NO_YN");
	}
	if(smfnd.equals("M") && sfn_yn.equals("Y"))
	{
%>
		<td class='label' width='25%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'><input type='text' name='patientid' id='patientid' value=''	tabIndex="1" onBlur="ChangeUpperCase(this);CheckPatientExists(this.value);disbutt(this)" onKeyPress='return CheckForSpecChars(event)' size='20' maxlength=<%=p_patient_id_length%> ><input type=button name=search value='?' tabIndex="6"   class=button onClick="callPatientSearch()"><img src='../../eCommon/images/mandatory.gif' align='center'></img>
		</td>
		<td class='label' width='25%'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'><input type=text  name='p_encounter_id' id='p_encounter_id' size="12" maxlength="12" onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="CheckNumVal(this)" align="center"><input type='button' name='encounter_id' id='encounter_id' value='?' class='button' onclick='searchCode(this, p_encounter_id)' disabled>&nbsp;<img src="../../eCommon/images/mandatory.gif"></img></td>
<%
	}
	else
	{
%>
		<td class='label' width='25%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'><input type='text' name='patientid' id='patientid' value=''	tabIndex="1" onBlur="ChangeUpperCase(this);CheckPatientExists(this.value);disbutt(this)" onKeyPress='return CheckForSpecChars(event)' size='20' maxlength=<%=p_patient_id_length%> ><input type=button name=search value='?' tabIndex="6"   class=button onClick="callPatientSearch()">&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>
		</td>
		<td class='label' width='25%' >
						 <%
			 if (file_type_yn.equals("N"))
		{
			 %>
			 <fmt:message key="Common.fileno.label" bundle="${common_labels}"/>
		 <%
	}else{
			 %>
			<fmt:message key="Common.filetype.label" bundle="${common_labels}"/>
		 <%
	}
		 %>
		</td>
		<td class='fields' width='25%' id="fileid"><input type='text' name='fileno' id='fileno' size='20'  tabIndex="2" maxlength='<%=p_file_no_length%>' value='' onKeyPress='return CheckForSpecChars(event)' onBlur="CheckFileExists(this.value);disbutt(this)" ><img src='../../eCommon/images/mandatory.gif' align='center'></img> 
		</td>
	</tr>	
	<tr>
		<td class='label' ><fmt:message key="eFM.VolumeNo.label" bundle="${fm_labels}"/></td>
		<td class='fields'  id="volid"><select name='volumeno' id='volumeno'><option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option></select></td>
	
		<td class='label' ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td class='fields'  ><input type=text  name='p_encounter_id' id='p_encounter_id' size="12" maxlength="12" onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="CheckNumVal(this)" align="center"><input type='button' name='encounter_id' id='encounter_id' value='?' class='button' onclick='searchCode(this, p_encounter_id)' disabled>&nbsp;<img src="../../eCommon/images/mandatory.gif"></img></td>
	</tr>
<%
	}
%>
	<tr><td colspan='4'>&nbsp;</td></tr>
</table>
<%
if(rs!=null)	rs.close();
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
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
<input type="hidden" name="file_type_yn" id="file_type_yn"		value="<%= file_type_yn %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
<input type="hidden" name="today" id="today"				value="<%=today%>">
<input type='hidden' name='validFile' id='validFile' value=''>
<input type='hidden' name='called_from' id='called_from' value='deficiecy_slip'>
<input type='hidden' name='file_type_code' id='file_type_code' value=''>
<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>"> --%>
</form>
</body>
</html>

