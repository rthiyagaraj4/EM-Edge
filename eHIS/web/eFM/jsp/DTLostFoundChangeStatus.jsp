<!DOCTYPE html>
<!--
	Created On	: 6/21/2002
	Created By	: Nanda Kumar R.
	Module		: File Management (FM)
	Function	: Record Lost/Found
-->
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String facilityid 	= (String) session.getValue("facility_id");
%>
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
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src='../../eFM/js/FMLostFound.js'></script>
	<Script language='JavaScript' src='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<!-- <BODY onMouseDown="CodeArrest()" onLoad="showIdentity(this)"> -->
<BODY onMouseDown="CodeArrest()" onKeyDown = 'lockKey();'>
<FORM name = 'fm_change_status_lost_found' action='../../servlet/eFM.FMLostFoundFileServlet' method='post' target='messageFrame'>
<%
	Connection con = ConnectionManager.getConnection(request);
	java.util.Properties p	= (java.util.Properties) session.getValue("jdbc" ) ;
	java.sql.Statement stmt		= null;
	ResultSet rs		= null;

try
{
	stmt				= con.createStatement();
	String addedById	= p.getProperty( "login_user" ) ;
	
	String sql						= "";	
	String p_old_status				= "";
	String p_old_fs_locn			= "";
	String p_old_holder_name		= "";
	String p_curr_date				= "";
//	String p_user_security_yn		= "";
	String p_curr_status			= "";
//	String p_disable_updates		= "";	
	String p_file_no				= "";
	String p_doc_folder_id			= "";	
	String p_volume_no				= "";
	String p_remarks				= "";
	String p_curr_fs_locn_identity	= "";
	String curr_facility_id			= "";
	String fs_locn_identity="", p_patient_id="", p_curr_fs_locn_code="",p_user_name="";
	
	String p_doc_file_no			= request.getParameter("p_doc_file_no");
	String doc_folder_id			= request.getParameter("doc_folder_id");
	String doc_type_code			= request.getParameter("doc_type_code");
	String patient_id				= request.getParameter("patient_id");
//	p_user_security_yn				= request.getParameter("p_user_security_yn");

//	if(p_user_security_yn == null || p_user_security_yn.equals("null")) p_user_security_yn = "N";
	if(doc_type_code == null || doc_type_code.equals("null")) doc_type_code = "";
	if(doc_folder_id == null || doc_folder_id.equals("null")) doc_folder_id = "";
	if(p_doc_file_no == null || p_doc_file_no.equals("null")) p_doc_file_no = "";
	if(patient_id == null || patient_id.equals("null")) patient_id = "";

	rs = stmt.executeQuery("select appl_user_name from sm_appl_user where appl_user_id = '"+addedById+"' ");

	while (rs.next())
	{	
		p_user_name = rs.getString(1);
	}
	if(rs!=null)	rs.close();
	sql = " select a.file_no,a.file_type_code,a.doc_folder_id,a.doc_type_code,a.patient_id pat_id,a.volume_no,to_char(sysdate,'dd/mm/rrrr hh24:mi') curr_date,decode(a.curr_file_status,'I','Inside','O','Outside','L','Lost','A','Archived','T','In Transit','E','External')curr_file_status,a.curr_file_status curr_file_status1,a.curr_fs_locn_short_desc curr_fs_locn_desc, curr_fs_locn_code, nvl(to_char(a.iss_date_time,'dd/mm/rrrr hh24:mi'),'&nbsp;')iss_date_time, nvl(to_char(a.return_date_time,'dd/mm/rrrr hh24:mi'),'&nbsp;') return_date_time,decode(a.curr_fs_locn_identity,'D','Department','T','Practitioner','X','External','C','Clinic','N','Nursing Unit','E','Procedure Unit','Y','Daycare Unit') curr_fs_locn_identity,a.curr_fs_locn_identity fs_locn_identity ,nvl(b.appl_user_name,'&nbsp;')curr_holder_name,nvl(a.remarks,'&nbsp;') remarks,a.curr_facility_id FROM fm_curr_locn_vw a , sm_appl_user b WHERE a.facility_id='"+facilityid+"' and a.file_no = '"+p_doc_file_no+"' and a.curr_file_status not in ('T','R') and a.doc_folder_id='"+doc_folder_id+"' and doc_type_code='"+doc_type_code+"' and a.curr_holder_name=b.appl_user_id(+)  order by a.doc_folder_id";
	
	rs = stmt.executeQuery(sql);

	while (rs.next())
	{
		p_file_no				= rs.getString("file_no");
		p_doc_folder_id			= rs.getString("doc_folder_id");
		p_doc_folder_id			= rs.getString("doc_folder_id");
		p_volume_no				= rs.getString("volume_no");
		p_old_status			= rs.getString("curr_file_status");
		p_old_fs_locn			= rs.getString("curr_fs_locn_desc");
		p_old_holder_name		= rs.getString("curr_holder_name");
		p_curr_date				= rs.getString("curr_date");
		p_curr_status			= rs.getString("curr_file_status1");
		p_remarks				= rs.getString("remarks");
		p_curr_fs_locn_identity = rs.getString("curr_fs_locn_identity");
		fs_locn_identity		= rs.getString("fs_locn_identity");
		p_patient_id			= rs.getString("pat_id");	
		p_curr_fs_locn_code     = rs.getString("curr_fs_locn_code");
		curr_facility_id		= rs.getString("curr_facility_id");
		
		if((p_file_no == null)||(p_file_no.equals("null")))p_file_no="";	
		if((p_doc_folder_id == null)||(p_doc_folder_id.equals("null")))p_doc_folder_id="";	
		if((p_doc_folder_id == null)||(p_doc_folder_id.equals("null")))p_doc_folder_id="";	
		if((p_volume_no == null)||(p_volume_no.equals("null"))) p_volume_no="";
		if((p_old_status == null)||(p_old_status.equals("null"))) p_old_status="";		
		if((p_old_fs_locn == null)||(p_old_fs_locn.equals("null"))) p_old_fs_locn="";		
		if((p_old_holder_name == null)||(p_old_holder_name.equals("null"))) p_old_holder_name="";
		if((p_curr_date == null)||(p_curr_date.equals("null"))) p_curr_date=""; 
		if((p_curr_status == null)||(p_curr_status.equals("null"))) p_curr_status="";
		if((p_remarks == null)||(p_remarks.equals("null"))) p_remarks="";
		if((curr_facility_id == null)||(curr_facility_id.equals("null"))) curr_facility_id="";
		if((p_curr_fs_locn_identity==null)||(p_curr_fs_locn_identity.equals("null")))p_curr_fs_locn_identity="";
		if((fs_locn_identity == null)||(fs_locn_identity.equals("null"))) fs_locn_identity=""; 
		if((p_patient_id == null)||(p_patient_id.equals("null")))p_patient_id="";
		if((p_curr_fs_locn_code == null)||(p_curr_fs_locn_code.equals("null"))) p_curr_fs_locn_code=""; 
		p_curr_fs_locn_identity = "("+p_curr_fs_locn_identity+")";
	}
	if(rs!=null)	rs.close();
	
/*	if (p_user_security_yn.equals("Y"))
	{
		p_disable_updates="disabled";
	}
	else
	{
		p_disable_updates="";
	}*/
		sql = "select appl_user_id,appl_user_name from sm_facility_for_user_vw where facility_id='"+facilityid+"' ";
		rs = stmt.executeQuery(sql);
%>
<TABLE border='0' cellpadding='0' cellspacing='0' width='75%' align='center'>
	<Td class='columnheader' colspan=2><fmt:message key="eFM.CurrentStatusoftheDocument.label" bundle="${fm_labels}"/></Td>
	<TR>
		<td colspan=2>&nbsp;</td>
	</TR>
	<TR>
		<TD width ='30%'   class= 'label'><fmt:message key="Common.status.label" bundle="${common_labels}"/></TD>
		<TD width = '70%'  class='fields'><input type=text readonly value="<%=p_old_status%>">
		</TD>
	</TR>
	<TR>
		<TD width ='30%' class= 'label'><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/></TD>
		<TD width = '70%' class='fields'><input type=text size=30 readonly value="<%=p_old_fs_locn%> <%=p_curr_fs_locn_identity%>">
		</TD>
	</TR>
	<TR>
		<TD width ='30%'  class= 'label'><fmt:message key="eFM.HolderName.label" bundle="${fm_labels}"/></TD>
		<TD width = '70%' class='fields'><input type=text size=30 readonly value="<%=p_old_holder_name%>">
		</TD>
	</TR>
	 <TR>
		<TD width ='30%'   class= 'label'>&nbsp;</TD>
		<TD width = '70%'  class='label'>&nbsp;
		</TD>
	</TR> 
</TABLE>
<TABLE border='0' cellpadding='0' cellspacing='0' width='75%' align='center'>
	<Td class='columnheader' colspan=2 ><fmt:message key="eFM.NewStatusoftheDocument.label" bundle="${fm_labels}"/></Td>
	
	<TR>
		<TD width ='30%'   class= 'label'><fmt:message key="Common.status.label" bundle="${common_labels}"/></TD>
		<TD width = '70%'  class='fields'><select name="p_new_status" id="p_new_status" onChange='showIdentity(this);populateFSLocation(this)'>
			
<%
			if (p_curr_status.equals("I"))
			{
%>
				<option value=''> ---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------- </option>
				<option value='L'><fmt:message key="Common.Lost.label" bundle="${common_labels}"/> </option>
				<option value='A'><fmt:message key="Common.Archived.label" bundle="${common_labels}"/></option>
<%
			}
			else if (p_curr_status.equals("O"))
			{
%>
				<option value=''> ---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------- </option>
				<option value='L'><fmt:message key="Common.Lost.label" bundle="${common_labels}"/></option>
<%
			}
			else if (p_curr_status.equals("L"))
			{
%>
				<option value=''> ---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------- </option>
				<option value='F'><fmt:message key="eFM.Found.label" bundle="${fm_labels}"/></option>
<%
			}
			else if (p_curr_status.equals("A"))
			{
%>
				<option value=''> ---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------- </option>
				<option value='L'><fmt:message key="Common.Lost.label" bundle="${common_labels}"/> </option>
				<option value='R'><fmt:message key="eFM.ReturnFromArchived.label" bundle="${fm_labels}"/></option>
<%
			}
			else if(p_curr_status.equals("T"))
			{
%>
				<option value=''> ---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------- </option>
				<option value='L'><fmt:message key="Common.Lost.label" bundle="${common_labels}"/></option>
<%
			}
			else if(p_curr_status.equals("E"))
			{
%>
				<option value=''> ---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------- </option>
				<option value='L'><fmt:message key="Common.Lost.label" bundle="${common_labels}"/></option>
<%
			}
%>
			</select><img src='../../eCommon/images/mandatory.gif' align='center'></img> 
		</TD>
	</TR>
	<TR>
		<TD width='17%'   class='label'><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/></TD>
		<TD id='td1' width='54%'  class='fields'><select name="fs_locn_idty" id="fs_locn_idty" onChange="PopulateData(this.value)" >
				<option value="">------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
				<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
				<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
				<option value="Y"><fmt:message key="Common.DaycareUnit.label" bundle="${common_labels}"/></option>
				<option value="E"><fmt:message key="Common.ProcedureUnit.label" bundle="${common_labels}"/></option>
				<option value="T"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
				<option value="D"><fmt:message key="Common.department.label" bundle="${common_labels}"/></option>
		</select>&nbsp;/&nbsp;
		<select name=p_fs_location onChange='ChkValue(this.value);'>
		<option value=''>-------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------</option>
		</select>&nbsp;/&nbsp;
				<input type="text" name="locn_desc" id="locn_desc" value="" onChange="getValidRecords(this);" disabled><input type="Hidden" name="locn_code" id="locn_code" value=""><input type="button" name="locn_button" id="locn_button" value="?" class="BUTTON" onClick="getValidRecords(locn_desc);" disabled><IMG src='../../eCommon/images/mandatory.gif' align='center'></IMG>
		</td>
		<TD width = '10%' class='fields'  id="td2" style="display:none"><select name=p_fs_location1>
			<option value=''>-------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------</option>
		</select><img src='../../eCommon/images/mandatory.gif' align='center'></img> 
		</TD>
	</TR>
	<TR>
		<TD width ='30%'  class= 'label'><fmt:message key="eFM.UpdatedDate.label" bundle="${fm_labels}"/></TD>
		<TD width = '70%' class='fields'><input type=text name=p_updated_date value="<%=p_curr_date%>" size=14 readonly >
		</TD>
	</TR>
	<TR>
		<TD width ='30%'   class= 'label'><fmt:message key="eFM.UpdatedBy.label" bundle="${fm_labels}"/></TD>
		<TD width = '70%'  class='fields'><input type=text name=updated_by_name value="<%=p_user_name%>" size=30 readonly><input type=hidden name=p_updated_by value="<%=addedById%>" size=30 readonly><input type=button name=searchcode value='?' class=button onClick="searchUpdatedByCode(p_updated_by,'<%=facilityid%>')">
		</TD>
	</TR>
	<TR>
		<TD width ='30%'  class= 'label'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></TD>
		<TD width = '70%' class='fields'><textarea name=p_remarks cols=34 rows=2 onkeypress="checkMaxLimit(this,100)" onBlur="makeValidString(this); CheckMaxLen('Remarks',this,100,parent.frames[4])"><%=p_remarks%></textarea>
		</TD>
	</TR>
</TABLE>
<%if(p_old_holder_name.equals("&nbsp;"))p_old_holder_name="";%>
<input type='hidden' name=p_facility_id value='<%=facilityid%>'>
<input type='hidden' name=p_store_new_status value=''>
<input type='hidden' name=p_store_fs_location value=''>
<input type='hidden' name=p_store_updated_by value=''>
<input type='hidden' name=functionval value='modify'>
<input type='hidden' name=p_store_file_no value='<%=p_doc_file_no%>'>
<input type='hidden' name=p_store_volume_no value='<%=p_volume_no%>'>
<input type='hidden' name=p_store_doc_type_code value='<%=doc_type_code%>'>
<input type='hidden' name=p_store_doc_folder_id value='<%=doc_folder_id%>'>
<input type='hidden' name='src_fs_locn_code' id='src_fs_locn_code' value='<%=p_curr_fs_locn_code%>'>
<input type='hidden' name='src_locn_identity' id='src_locn_identity' value='<%=fs_locn_identity%>'>
<input type='hidden' name='src_user_id' id='src_user_id' value='<%=p_old_holder_name%>'>
<INPUT type='hidden' name='src_locn_code' id='src_locn_code' value=''>
<input type='hidden' name='patient_id' id='patient_id' value='<%=p_patient_id%>'>
<input type='hidden' name='curr_facility_id' id='curr_facility_id' value='<%=curr_facility_id%>'>
<input type='hidden' name='appl_user_id' id='appl_user_id' value=''>
<input type='hidden' name='all_fs_locn_codes' id='all_fs_locn_codes' value="">
</FORM>
</BODY>
<%
if(stmt!=null) stmt.close();
if(rs!=null)	rs.close();
}
catch(Exception e)
{
	out.println("Exception in main try "+e.toString());
}
finally
{	
	ConnectionManager.returnConnection(con,request);
}
%>
</HTML>

