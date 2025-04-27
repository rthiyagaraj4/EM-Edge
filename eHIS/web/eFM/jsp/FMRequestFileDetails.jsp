<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
	<script language='javascript' src='../../eFM/js/FMPractitionerComponent.js'></script>
	<script language='javascript' src='../../eFM/js/FMRequestFile.js'></script>
	<Script language="JavaScript" src="../../eCommon/js/CommonLookup.js" ></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String facilityid 	= (String) session.getValue("facility_id");
	String doc_or_file  = request.getParameter("doc_or_file")==null?"F":request.getParameter("doc_or_file");
	String p_user_security_yn  = request.getParameter("p_user_security_yn")==null?"N":request.getParameter("p_user_security_yn");
	String p_access_all  = request.getParameter("p_access_all")==null?"":request.getParameter("p_access_all");
	///added for calling from other modules
	String fs_locn_iden	= request.getParameter("fs_locn_iden");
	String fs_locn	= request.getParameter("fs_locn");
	String fs_locn_id	= request.getParameter("fs_locn_id");
	String patient_id	= request.getParameter("patient_id");
	if((fs_locn_iden == null) || (fs_locn_iden.equals("null"))) fs_locn_iden = "";	
	if((fs_locn == null) || (fs_locn.equals("null"))) fs_locn = "";
	if((fs_locn_id == null) || (fs_locn_id.equals("null"))) fs_locn_id = "";
	if((patient_id == null) || (patient_id.equals("null"))) patient_id = "";
	String selectidenC ="";
	String selectidenN ="";
	if (fs_locn_iden.equals("C"))
	{
		selectidenC="selected";
		selectidenN="";
	}else if (fs_locn_iden.equals("N"))
	{
		selectidenN="selected";
		selectidenC="";
	}

	//ends here
%>
</head>

<BODY onMouseDown="CodeArrest()" onLoad="document.request_file_details.FS_LOCN_ID.focus()"  onKeyDown = 'lockKey();'>

<FORM name = 'request_file_details' id= 'request_file_details' action='../../servlet/eFM.FMRequestOfFileServlet' method='post' target='messageFrame' >
<%
	Connection con = null;
	java.util.Properties p	= (java.util.Properties) session.getValue("jdbc" ) ;

	String addedById	= p.getProperty( "login_user" ) ;

	java.sql.Statement stmt		= null;
	java.sql.Statement stmt1	= null;	
	ResultSet rs				= null;
	ResultSet rs1				= null;		

try
{
	con = ConnectionManager.getConnection(request);
	stmt						= con.createStatement();
	stmt1						= con.createStatement();	

	String sql					= "";
	String sql1					= "";
	String p_code			= "";
	String p_desc			= "";	
	String p_appl_user_name = "";
	sql =  "select appl_user_name from sm_appl_user_lang_vw where appl_user_id = '"+addedById+"' and language_id='"+localeName+"'" ;

	rs  = stmt.executeQuery(sql);

	while (rs.next()) {
		p_appl_user_name	= rs.getString("appl_user_name");
	}
	if(rs!=null)	rs.close();
	
%>
<TABLE border='0' cellpadding='2' cellspacing='0' width='100%'  align='left'>
<TR>
	<Td COLSPAN='4' class='COLUMNHEADER'><fmt:message key="eFM.RequestFrom.label" bundle="${fm_labels}"/></Td>
</TR>

<TR>
	<TD width='25%' class= 'label'><fmt:message key="eFM.FSLocationIdentity.label" bundle="${fm_labels}"/></TD>
	<TD width='25%' class='fields' >
		<select name="FS_LOCN_ID" id="FS_LOCN_ID"  onChange="PopulateData(this.value)">
			<option value="">---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
			<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
			<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
			<option value="Y"><fmt:message key="Common.DaycareUnit.label" bundle="${common_labels}"/></option>
			<option value="E"><fmt:message key="Common.ProcedureUnit.label" bundle="${common_labels}"/></option>
			<option value="T"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
			<option value="D"><fmt:message key="Common.department.label" bundle="${common_labels}"/></option> 
		</select></td>
	<TD width='25%' class= 'label'><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/> </TD>
	<TD width='25%' class='fields' >
		<select name="req_location" id="req_location" onChange="PopulateIdentity(this)">
			<option value=''>---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
		</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
	</TD>
</TR>
<TR>
	<TD class= 'label'><fmt:message key="eFM.Requesting.label" bundle="${fm_labels}"/>&nbsp;<font id='id1'></font></TD>
	<TD  class='fields' >
		<input type=text size=30 maxlength=30 name='requesting' id='requesting' disabled onblur="chksearch_id();"><input type='button' class='button' name='requesting_btn' id='requesting_btn' value='?' disabled  onClick="search_id(requesting_btn,requesting);" onkeypress="search_id(requesting_btn,requesting);"><img src='../../eCommon/images/mandatory.gif' align='center' id="mandatory1"></img><input type='hidden' name='requesting_code' id='requesting_code'> 
	</TD>
<!-- Below lines enableReason() method added by Venkatesh.s against ML-MMOH-CRF-0393 -->
	<TD  class= 'label'><fmt:message key="eFM.ReasonForBorrowing.label" bundle="${fm_labels}"/></TD>
	<TD  class='fields' >
		<select name='req_narration' id='req_narration' onchange='enableReason(this)'>
			<option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>

		<%
			sql1 = "select narration_code,short_desc from fm_narration_lang_vw where eff_status='E' and  language_id='"+localeName+"' order by 2";

			rs1 = stmt1.executeQuery(sql1);

			while (rs1.next())
			{
				p_code = rs1.getString("narration_code");
				p_desc = rs1.getString("short_desc");
		%>
			<option value='<%=p_code%>'><%=p_desc%></option>
		<%	}
		%>
		</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
	</TD>
	
</TR>

<TR>
	<TD class= 'label'><fmt:message key="Common.name.label" bundle="${common_labels}"/></TD>
	<TD class='fields' >
	<input type=text size=30 maxlength=30 name=req_name1 value="<%=p_appl_user_name%>" readonly><input type=hidden size=40 maxlength=30 name=req_name value="<%=addedById%>" readonly><input type=button name=searchcode value='?' class=button onClick="searchCode(req_name,'<%=facilityid%>')">
	</TD>
	<%
		if (p_user_security_yn.equals("Y"))
		{
	%>
		<script>
			document.forms[0].req_name.disabled=true;
			document.forms[0].searchcode.disabled=true;
		</script>
	<%	}
		else
		{
	%>
		<script>
			document.forms[0].req_name.disabled=false;
			document.forms[0].searchcode.disabled=false;
		</script>
	<%	}
	%>
		<!-- Below lines added by Venkatesh.s against ML-MMOH-CRF-0393 -->
		<td class='label' ><label id='remark_visible'  style='visibility:hidden'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></label></td> 
		<td class='field'> 
    		 <textarea  name='reason' rows='1' cols='24'  align='left'  onblur='makeValidString(this);checkMaxLen(this);' onkeypress="return checkMaxLimit(this,'100', event.keyCode);" style='visibility:hidden'></textarea><img src='../../eCommon/images/mandatory.gif' align='center' id="mandatory" style='visibility:hidden'></img> </td> 
			 <!--end ML-MMOH-CRF-0393 -->  
<TD class= 'label'>&nbsp;</TD>
<TD class= 'label'>&nbsp;</TD>  
</TR>

</TABLE>

<input type='hidden' name=functionval value='insert'>
<input type='hidden' name=p_file_nos value=''>
<input type='hidden' name=p_req_facility value='<%=facilityid%>'>
<input type='hidden' name=p_req_location value=''>
<input type='hidden' name=p_req_name value=''>
<input type='hidden' name=p_req_narration value=''>
<input type='hidden' name=p_req_to_facility value=''>
<input type='hidden' name=p_rem_recnum value=''>
<input type='hidden' name='p_patient_id' id='p_patient_id' value=''>
<input type='hidden' name='p_volume_nos' id='p_volume_nos' value=''>
<input type='hidden' name='p_file_type_code' id='p_file_type_code' value=''>
<input type='hidden' name="p_doc_folder_id" id="p_doc_folder_id" value=''>
<input type='hidden' name="p_doc_type_code" id="p_doc_type_code" value=''>
<input type='hidden' name="p_file_required_on" id="p_file_required_on" value=''>
<input type='hidden' name="tot_count" id="tot_count" value="">
<input type='hidden' name="print_req_slip" id="print_req_slip" value="">
<input type='hidden' name="perm_fs_locn_code" id="perm_fs_locn_code" value="">
<input type='hidden' name="doc_or_file" id="doc_or_file" value='<%=doc_or_file%>'>
<input type='hidden' name="p_user_security_yn" id="p_user_security_yn" value='<%=p_user_security_yn%>'>
<input type='hidden' name="p_access_all" id="p_access_all" value='<%=p_access_all%>'>
</FORM>
</BODY>
<%
if(stmt!=null) stmt.close();
if(rs!=null)	rs.close();
if(stmt1!=null) stmt1.close();
if(rs1!=null)	rs1.close();
}
catch(Exception e)
{

}
finally
{		
	ConnectionManager.returnConnection(con,request);
}
%>
</HTML>

