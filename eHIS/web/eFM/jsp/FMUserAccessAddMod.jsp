<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eFM/js/FMUserAccess.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<BODY onMouseDown="CodeArrest()" onKeyDown = 'lockKey();'>
<FORM name = 'fm_user_access_form' action='../../servlet/eFM.FMUserAccessServlet' method='post' target='messageFrame'>
<%
	Connection con				= ConnectionManager.getConnection(request);
	java.sql.Statement stmt		= null;
	ResultSet rs				= null;
	java.sql.Statement stmt1	= null;
	ResultSet rs1				= null;
	String maintain_doc_or_file = "";
	String mysql				= "SELECT maintain_doc_or_file FROM mp_param";
	stmt1 = con.createStatement();
		rs1   =  stmt1.executeQuery(mysql);
		if(rs1 != null && rs1.next())
		{
			maintain_doc_or_file = rs1.getString("maintain_doc_or_file");
		}

	String operation = request.getParameter("operation");

	String facilityid 			= (String) session.getValue("facility_id");
	
	String p_appl_user_id = request.getParameter( "appl_user_id" );
	String p_fs_locn_code = request.getParameter("fs_locn_code");

	if (p_fs_locn_code == null) p_fs_locn_code = "";

	String checkbox_checked				= "";
	String sql							= "";
	String appl_user_id					= "";
	String fs_locn_code					= "";
	String fs_locn_desc					= "";
//	String locn_id_desc					= "";
	String assign_fs_locn				= "";
	String change_fs_locn				= "";
	String req_yn						= "";
	String req_across_facilities_yn		= "";
	String iss_yn						= "";
	String iss_across_facilities_yn		= "";
	String change_return_date_yn		= "";
	String deficiency_check_yn			= "";
	String file_lost_found_yn			= "";
	String track_out_to_opd_yn			= "";
	String track_out_to_ipw_yn			= "";
	String receive_file_yn				= "";
	String return_file_yn				= "";
	String confirm_receipt_file_yn		= "";
	String transfer_file_yn				= "";
//	String p_fs_locn_code				= "";	
	String in_mode						= "";
	//String req_status					= "";
//	String iss_status					= "";
	String manual_request_yn			= "";
	String cancel_request_yn			= "";
	String CREATE_FILE_VOLUME_YN	= "";

	String locn_identity				="";
	String perm_file_area_yn			="";
	String transfer_file_prop			="";
	String assign_fs_locn_prop			="";
	String receive_file_prop			="";
	String change_fs_locn_prop			="";
	String deficiency_check_prop		="";
	String track_out_to_opd_prop		="";
	String track_out_to_ipw_prop		="";
	String iss_prop						="";
	String req_across_facilities_prop	="";
	String iss_across_facilities_prop	="";

	String change_return_date_prop		= "";
	String file_lost_found_prop			 = "";
	String confirm_receipt_file_prop	= "";
	String req_prop						= "";
	String cancel_request_prop			= "";
	String create_file_volume_prop	= "";
	String return_file_prop	= "";
	String manual_request_prop			= "",p_disp_identity="";

try
{

	stmt						= con.createStatement();


	if (operation.equals("modify"))
	{

		sql = " SELECT APPL_USER_NAME,FS_LOCN_CODE,FS_LOCN_SHORT_DESC,LOCN_IDENTITY_DESC,ASSIGN_FS_LOCN,CHANGE_FS_LOCN,REQ_YN,REQ_ACROSS_FACILITIES_YN,ISS_YN,ISS_ACROSS_FACILITIES_YN,CHANGE_RETURN_DATE_YN,DEFICIENCY_CHECK_YN,CHANGE_FILE_STATUS_YN,TRACK_OUT_TO_OPD,TRACK_OUT_TO_IPW,RECEIVE_FILE_YN,RETURN_FILE_YN, CONFIRM_RECEIPT_FILE_YN, TRANSFER_FILE_YN, locn_identity, PERMANENT_FILE_AREA_YN, manual_request_yn,cancel_request_yn,CREATE_FILE_VOLUME_YN FROM FM_USER_ACCESS_RIGHTS_VW WHERE FACILITY_ID='"+facilityid+"' and appl_user_id='"+p_appl_user_id+"' and fs_locn_code='"+p_fs_locn_code+"' ";

		rs = stmt.executeQuery(sql);
	if(rs != null)
	{
	  if(rs.next())
	  {
		appl_user_id				= rs.getString("APPL_USER_NAME");
		fs_locn_code				= rs.getString("fs_locn_code");
		fs_locn_desc				= rs.getString("FS_LOCN_SHORT_DESC");
//		locn_id_desc				= rs.getString("LOCN_IDENTITY_DESC");
		assign_fs_locn				= rs.getString("assign_fs_locn");
		change_fs_locn				= rs.getString("change_fs_locn");
		req_yn						= rs.getString("req_yn");
		req_across_facilities_yn	= rs.getString("req_across_facilities_yn");
		iss_yn						= rs.getString("iss_yn");
		iss_across_facilities_yn	= rs.getString("iss_across_facilities_yn");
		change_return_date_yn		= rs.getString("change_return_date_yn");
		deficiency_check_yn			= rs.getString("deficiency_check_yn");
		file_lost_found_yn			= rs.getString("change_file_status_yn");
		track_out_to_opd_yn			= rs.getString("track_out_to_opd");
		track_out_to_ipw_yn			= rs.getString("track_out_to_ipw");
		receive_file_yn				= rs.getString("RECEIVE_FILE_YN");
		return_file_yn				= rs.getString("RETURN_FILE_YN");
		confirm_receipt_file_yn		= rs.getString("CONFIRM_RECEIPT_FILE_YN");
		transfer_file_yn			= rs.getString("TRANSFER_FILE_YN");
		locn_identity				= rs.getString("locn_identity");
		perm_file_area_yn			= rs.getString("permanent_file_area_yn");
		manual_request_yn			= rs.getString("manual_request_yn");
		cancel_request_yn			= rs.getString("cancel_request_yn");
		CREATE_FILE_VOLUME_YN	= rs.getString("CREATE_FILE_VOLUME_YN");

		in_mode="disabled";


		/*if(req_yn.equals("N")) req_status="disabled";
		else req_status="";*/

		/*if(iss_yn.equals("N")) iss_status="disabled";
		else iss_status="";*/


		if(locn_identity == null)
		{
			locn_identity = "X";
		}

		if(locn_identity.equals("D"))
		{
			if(perm_file_area_yn.equals("Y"))
			{
				transfer_file_prop			="disabled";
			}
			else
			{
			//	transfer_file_prop			= "disabled";
				assign_fs_locn_prop			= "disabled";
				change_fs_locn_prop			= "disabled";
				req_across_facilities_prop	= "disabled";
				iss_prop					= "disabled";
				iss_across_facilities_prop	= "disabled";
				deficiency_check_prop		= "disabled";
				track_out_to_opd_prop		= "disabled";
				track_out_to_ipw_prop		= "disabled";
				receive_file_prop			= "disabled";			
				change_return_date_prop		= "disabled";
				file_lost_found_prop		= "disabled";
				create_file_volume_prop	= "disabled";
			}
		}
		else if(locn_identity.equals("X"))
		{
			assign_fs_locn_prop			= "disabled";
			change_fs_locn_prop			= "disabled";
			req_prop					= "disabled";
			req_across_facilities_prop	= "disabled";
			confirm_receipt_file_prop   = "disabled";
			iss_prop					= "disabled";
			iss_across_facilities_prop	= "disabled";
			deficiency_check_prop		= "disabled";
			track_out_to_opd_prop		= "disabled";
			track_out_to_ipw_prop		= "disabled";
			receive_file_prop			= "disabled";
			return_file_prop			= "disabled";
			change_return_date_prop		= "disabled";
			file_lost_found_prop		= "disabled";
			transfer_file_prop			= "disabled";
			manual_request_prop			= "disabled";
			cancel_request_prop			= "disabled";
			create_file_volume_prop	= "disabled";
		}
		else
		{
			assign_fs_locn_prop			= "disabled";
			change_fs_locn_prop			= "disabled";
			req_across_facilities_prop	= "disabled";
			iss_prop					= "disabled";
			iss_across_facilities_prop	= "disabled";
			deficiency_check_prop		= "disabled";
			track_out_to_opd_prop		= "disabled";
			track_out_to_ipw_prop		= "disabled";
			receive_file_prop			= "disabled";		
			change_return_date_prop		= "disabled";
			file_lost_found_prop		= "disabled";
			create_file_volume_prop	= "disabled";
		 //	transfer_file_prop			="disabled";
			
		
		}

		
			
			if (locn_identity.equals("D") && perm_file_area_yn.equals("Y"))
		    {
				p_disp_identity = "Permanent Department";
		    }
			else if (locn_identity.equals("D") && perm_file_area_yn.equals("N"))
		    {
				p_disp_identity = "Non-Permanent Department";
		    }
			else if (locn_identity.equals("C") )
		    {
				p_disp_identity = "Clinic";
		    }
			else if (locn_identity.equals("N") )
		    {
				p_disp_identity = "Nursing Unit";
		    }
			else if (locn_identity.equals("T") )
		    {
				p_disp_identity = "Practitioner";
		    }
			else if (locn_identity.equals("E") )
		    {
				p_disp_identity = "Procedure Unit";
		    }
			else if (locn_identity.equals("Y") )
		    {
				p_disp_identity = "Daycare Unit";
		    }
			else
		    {
				p_disp_identity = "*ALL";
		    }

	  }
	}
 }
 if(rs!=null) rs.close();
 if(stmt!=null) stmt.close();
}
catch(Exception e)
{
	out.println("Exception e :"+e.toString());
}

if(assign_fs_locn==null) assign_fs_locn="N";
if(change_fs_locn==null) change_fs_locn="N";
if(req_yn==null) req_yn="N";
if(manual_request_yn==null) manual_request_yn="N";
if(cancel_request_yn==null) cancel_request_yn="N";
if(req_across_facilities_yn==null) req_across_facilities_yn="N";
if(iss_yn==null) iss_yn="N";
if(iss_across_facilities_yn==null) iss_across_facilities_yn="N";
if(CREATE_FILE_VOLUME_YN==null) CREATE_FILE_VOLUME_YN="N";
if(change_return_date_yn==null) change_return_date_yn="N";
if(deficiency_check_yn==null) deficiency_check_yn="N";
if(file_lost_found_yn==null) file_lost_found_yn="N";
if(track_out_to_opd_yn==null) track_out_to_opd_yn="N";
if(track_out_to_ipw_yn==null) track_out_to_ipw_yn="N";
if(receive_file_yn==null) receive_file_yn="N";
if(return_file_yn==null) return_file_yn="N";
if(confirm_receipt_file_yn==null) confirm_receipt_file_yn="N";
if(transfer_file_yn==null) transfer_file_yn="N";

sql = "SELECT APPL_USER_ID,APPL_USER_NAME FROM SM_FACILITY_FOR_USER_VW where FACILITY_ID='"+facilityid+"' ORDER BY APPL_USER_ID ";
stmt = con.createStatement();
rs = stmt.executeQuery(sql);
%>
<TABLE border='0' cellpadding='3' cellspacing='0' width='85%' align='center'>
<TR>
	<TD  class= 'label' width='30%' ><fmt:message key="Common.user.label" bundle="${common_labels}"/></TD>
	<TD  class='fields' colspan='2'>
	<%
	if (operation.equals("insert"))
	{
	%>
		<input type=text name=user1 size=30 maxlength=30 value='' onblur="if(this.value != ''){searchCode(this,'<%=facilityid%>')}"><input type=hidden name=user size=40 maxlength=30 value='' readonly><input type=button name=searchcode value='?' class=button onClick="searchCode(user1,'<%=facilityid%>')"><img src='../../eCommon/images/mandatory.gif' align='center'></img>

		<%}else{%><input type=text name=user1 size='40' maxlength='30' readonly value="<%=appl_user_id%>" readonly><input type=hidden name=user size='40' maxlength='30' value="<%=p_appl_user_id%>" ><img src='../../eCommon/images/mandatory.gif' align='center'></img>
		<%}%></TD>
		<td class= 'label'>&nbsp;</td>
</TR>
<TR>
	<TD  class= 'label'><fmt:message key="eFM.AccesstoallFSLocations.label" bundle="${fm_labels}"/></TD>
	<TD  class='fields' colspan='2' >
	<input type=checkbox name='access_all' id='access_all' value='Y' <%=in_mode%> onClick="checkbox_all_locn(this)" >
	</TD>
	<td class= 'label'>&nbsp;</td>
</TR>
<TR>
	<TD  class= 'label' ><fmt:message key="eFM.FSLocationIdentity.label" bundle="${fm_labels}"/></TD>
	<TD  class='fields' colspan='2' >
	<%
	try{
	if (operation.equals("insert"))
	{
	
	%>
	<select name ="locn_identity" onChange="javascript:PopulateData(this.value)">
	<option value="AID">-- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -- </option>
	<option value="P"> <fmt:message key="eFM.PermanentDepartment.label" bundle="${fm_labels}"/> </option>
	<option value="D"> <fmt:message key="eFM.NonPermanentDepartment.label" bundle="${fm_labels}"/> </option>
	<option value="C"> <fmt:message key="Common.clinic.label" bundle="${common_labels}"/> </option>
	<option value="N"> <fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/> </option>
	<option value="T" ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option> 
	<option value="E"> <fmt:message key="Common.ProcedureUnit.label" bundle="${common_labels}"/> </option>
	<option value="Y"> <fmt:message key="Common.DaycareUnit.label" bundle="${common_labels}"/> </option>
	</select>
	<%
	  }
	  else
	  {
	%>
		<input type='text' size=26 name='locn_identity' id='locn_identity' value='<%=p_disp_identity%>' readonly>
	<%
		}
	}
	catch(Exception e)
	{
		out.println("Exception e :"+e.toString());
	}
	%>
	</TD>
	<td class= 'label'>&nbsp;</td>
</TR>
<TR>
	<TD  class= 'label' ><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/></TD>
	<TD  class='fields' colspan='2' >
	<%
	try{
	if (operation.equals("insert"))
	{
	%>
		<select name=storage_location onChange="populate(this)">
		<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
		</select><%}else{%><input type=text name=storage_location1 size='30' maxlength='30' value="<%=fs_locn_desc%>" readonly ><input type=hidden name=storage_location size='30' maxlength='30' value="<%=fs_locn_code%>" ><%}%><img src='../../eCommon/images/mandatory.gif' id='str_loc_img' style='visibility:visible' align='center'></img>
	</TD>
	<td class= 'label'>&nbsp;</td>
</TR>
<TR>
	<Th colspan = '4' class='columnheader' align='left'><fmt:message key="Common.AccessRights.label" bundle="${common_labels}"/></Th>
</TR>
<!-- </TABLE>

<TABLE border='1' cellpadding='0' cellspacing='0' width='85%' align='center'> -->
<TR>
	<TD class= 'label' width='30%'><fmt:message key="eFM.AssignFSLocation.label" bundle="${fm_labels}"/></TD>
	<TD  width='20%' class='fields'>
	<%
		if (assign_fs_locn.equals("Y"))
		{
			checkbox_checked="checked";
		}
		else
		{
			checkbox_checked="";
		}
	%>
	<input align='right' type=checkbox name=assign_fs_locn value='<%=assign_fs_locn%>' <%=checkbox_checked%>  <%=assign_fs_locn_prop%> onClick="checkbox_value(this)" >
	</TD>
	<TD  class= 'label' width='30%'> <fmt:message key="eFM.ChangeFSLocation.label" bundle="${fm_labels}"/></TD>
	<TD  class='fields' width='20%'>
	<%
		if (change_fs_locn.equals("Y"))
		{
			checkbox_checked="checked";
		}
		else
		{
			checkbox_checked="";
		}
	%>
	<input  type=checkbox name=change_fs_locn value='<%=change_fs_locn%>' <%=checkbox_checked%> <%=change_fs_locn_prop%> onClick="checkbox_value(this)" >
	</TD>
</TR>

<TR>
	<TD class= 'label'><fmt:message key="Common.change.label" bundle="${common_labels}"/> <%
			if(maintain_doc_or_file.equals("D"))
			{
		%>Document <%
		}
		else
		{
	%>File<%		
		}
	%> Return Date</TD>
	<TD class='fields'>
	<%
		if (change_return_date_yn.equals("Y"))
		{
			checkbox_checked="checked";
		}
		else
		{
			checkbox_checked="";
		}
	%>
	<input  type=checkbox name=change_return_date_yn value='<%=change_return_date_yn%>' <%=checkbox_checked%> <%=change_return_date_prop%> onClick="checkbox_value(this)" >
	</TD>
	<TD  class= 'label'><fmt:message key="eFM.MonitorDeficiency.label" bundle="${fm_labels}"/></TD>
	<TD  class='fields'>
	<%
		if (deficiency_check_yn.equals("Y"))
		{
			checkbox_checked="checked";
		}
		else
		{
			checkbox_checked="";
		}
	%>
	<input  type=checkbox name=deficiency_check_yn value='<%=deficiency_check_yn%>' <%=checkbox_checked%> <%=deficiency_check_prop%> onClick="checkbox_value(this)" >
	</TD>
</TR>

<TR>
	<!--  -->
	<TD  class= 'label'><fmt:message key="eFM.TrackoutfilestoOPD.label" bundle="${fm_labels}"/></TD>
	<TD  class='fields'>
	<%
		if (track_out_to_opd_yn.equals("Y"))
		{
			checkbox_checked="checked";
		}
		else
		{
			checkbox_checked="";
		}
	%>
	<input type=checkbox name=track_out_to_opd_yn value='<%=track_out_to_opd_yn%>' <%=checkbox_checked%> <%=track_out_to_opd_prop%> onClick="checkbox_value(this)" >
	</TD>
	<TD  class= 'label'><fmt:message key="eFM.TrackoutfilestoIPW.label" bundle="${fm_labels}"/></TD>
	<TD  class='fields'>
	<%
		if (track_out_to_ipw_yn.equals("Y"))
		{
			checkbox_checked="checked";
		}
		else
		{
			checkbox_checked="";
		}
	%>
	<input type=checkbox name=track_out_to_ipw_yn value='<%=track_out_to_ipw_yn%>' <%=checkbox_checked%> <%=track_out_to_ipw_prop%> onClick="checkbox_value(this)" >
	</TD>

</TR>

<TR>
	<TD  class= 'label'><fmt:message key="eFM.Receive.label" bundle="${fm_labels}"/> <%
			if(maintain_doc_or_file.equals("D"))
			{
		%>Document <%
		}
		else
		{
	%>File<%		
		}
	%></TD>
	<TD class='fields'>
	<%
		if (receive_file_yn.equals("Y"))
		{
			checkbox_checked="checked";
		}
		else
		{
			checkbox_checked="";
		}
	%>
	<input type=checkbox name=receive_file_yn value='<%=receive_file_yn%>' <%=checkbox_checked%> <%=receive_file_prop%> onClick="checkbox_value(this)" >
	</TD>	
	 
	 <TD  class= 'label'><fmt:message key="eFM.ConfirmReceipt.label" bundle="${fm_labels}"/></TD>
	<TD  class='fields'>
	<%
		if (confirm_receipt_file_yn.equals("Y"))
		{
			checkbox_checked="checked";
		}
		else
		{
			checkbox_checked="";
		}
	%>
	<input  type=checkbox name=confirm_receipt_yn value='<%=confirm_receipt_file_yn%>' <%=checkbox_checked%> <%=confirm_receipt_file_prop%> onClick="checkbox_value(this)" > 
	</TD> 
</TR>

<TR>
	<TD class= 'label'><fmt:message key="Common.Return.label" bundle="${common_labels}"/> <%
			if(maintain_doc_or_file.equals("D"))
			{
		%>Document <%
		}
		else
		{
	%>File<%		
		}
	%></TD>
	<TD class='fields'>
	<%
		if (return_file_yn.equals("Y"))
		{
			checkbox_checked="checked";
		}
		else
		{
			checkbox_checked="";
		}
	%>
	<input type=checkbox name=return_file_yn value='<%=return_file_yn%>' <%=checkbox_checked%> <%=return_file_prop%> onClick="checkbox_value(this)" >
	</TD>
	<TD  class= 'label' nowrap><fmt:message key="Common.Transfer.label" bundle="${common_labels}"/> <%
			if(maintain_doc_or_file.equals("D"))
			{
		%>Document <%
		}
		else
		{
	%>File<%		
		}
	%></TD>
	<TD  class='fields'>
	<%
		if (transfer_file_yn.equals("Y"))
		{
			checkbox_checked="checked";
		}
		else
		{
			checkbox_checked="";
		}
	
	%>
	<input type=checkbox name=transfer_file_yn value='<%=transfer_file_yn%>' <%=checkbox_checked%>  <%=transfer_file_prop%> onClick="checkbox_value(this)" >
	</TD>
</TR>
<TR>
<TD class= 'label'><fmt:message key="Common.change.label" bundle="${common_labels}"/> <%
			if(maintain_doc_or_file.equals("D"))
			{
		%>Document <%
		}
		else
		{
	%>File<%		
		}
	%> Status</TD>
	<TD class='fields'>
	<%
		if (file_lost_found_yn.equals("Y"))
		{
			checkbox_checked="checked";
		}
		else
		{
			checkbox_checked="";
		}
	%>
	<input type=checkbox name=file_lost_found_yn value='<%=file_lost_found_yn%>' <%=checkbox_checked%> <%=file_lost_found_prop%> onClick="checkbox_value(this)" >
	</TD>
<TD>&nbsp;</TD>
<TD>&nbsp;</TD>
</TR>

<TR>
	<TD  class= 'label'><b><fmt:message key="Common.Request.label" bundle="${common_labels}"/> <%
			if(maintain_doc_or_file.equals("D"))
			{
		%>Doc <%
		}
		else
		{
	%>File<%		
		}
	%> : </b><fmt:message key="eFM.WithInFacility.label" bundle="${fm_labels}"/></TD>
	<TD class='fields'>
	<%
		if (req_yn.equals("Y"))

		{
			checkbox_checked="checked";
		}
		else
		{
			checkbox_checked="";
		}
	%>
	<input type=checkbox name=req_yn value='<%=req_yn%>' <%=checkbox_checked%>  <%=req_prop%> onClick="checkbox_value(this);" >
	</TD>
	<TD  class= 'label'><fmt:message key="eFM.FromOtherFacilities.label" bundle="${fm_labels}"/></TD>
	<TD  class='fields'>
	<%
		if (req_across_facilities_yn.equals("Y"))
		{
			checkbox_checked="checked";
		}
		else
		{
			checkbox_checked="";
		}
	%>
	<input type=checkbox name=req_across_facilities_yn value='<%=req_across_facilities_yn%>' <%=req_across_facilities_prop%> <%=checkbox_checked%>  onClick="checkbox_value(this)" >
	</TD>
</TR>
<TR>
	<TD  class= 'label'><fmt:message key="eFM.ManualRequest.label" bundle="${fm_labels}"/></TD>
	<TD class='fields'>
	<%
		if (manual_request_yn.equals("Y"))
		{
			checkbox_checked="checked";
		}
		else
		{
			checkbox_checked="";
		}
	%>
	<input type=checkbox name=manual_request_yn value='<%=manual_request_yn%>' <%=checkbox_checked%> <%=manual_request_prop%>   onClick="checkbox_value(this)" >
	</TD>	
	<TD   class= 'label'><fmt:message key="Common.CancelRequest.label" bundle="${common_labels}"/></TD>
	<TD  class='fields'>
	<%
		if (cancel_request_yn.equals("Y"))
		{
			checkbox_checked="checked";
		}
		else
		{
			checkbox_checked="";
		}
	%>
	<input type=checkbox name="cancel_request_yn" id="cancel_request_yn" value='<%=cancel_request_yn%>' <%=checkbox_checked%> <%=cancel_request_prop%>   onClick="checkbox_value(this)" >
	</TD>
	<TD class= 'label'></TD>
	<TD class='label'></TD>
</TR>
<TR>
	<TD  class= 'label'><b><fmt:message key="Common.Issue.label" bundle="${common_labels}"/> <%
			if(maintain_doc_or_file.equals("D"))
			{
		%>Doc <%
		}
		else
		{
	%>File<%		
		}
	%> : </b>With In Facility</TD>
	<TD class='fields'>
	<%
		if (iss_yn.equals("Y"))
		{
			checkbox_checked="checked";
		}
		else
		{
			checkbox_checked="";
		}
	%>
	<input type=checkbox name=iss_yn value='<%=iss_yn%>' <%=iss_prop%> <%=checkbox_checked%>  onClick="checkbox_value(this)" >
	</TD>
	<TD   class= 'label'><fmt:message key="eFM.ToOtherFacilities.label" bundle="${fm_labels}"/></TD>
	<TD class='fields'>
	<%
		if (iss_across_facilities_yn.equals("Y"))
		{
			checkbox_checked="checked";
		}
		else
		{
			checkbox_checked="";
		}
	%>
	<input type=checkbox name="iss_across_facilities_yn" id="iss_across_facilities_yn" value='<%=iss_across_facilities_yn%>' <%=iss_across_facilities_prop%> <%=checkbox_checked%> onClick="checkbox_value(this)" >
	</TD>
	
</TR>
<TR>
	<TD   class= 'label'><fmt:message key="eFM.CreateFileVolume.label" bundle="${fm_labels}"/></TD>
	<TD   class='fields'>
	<%
		if (CREATE_FILE_VOLUME_YN.equals("Y"))
		{
			checkbox_checked="checked";
		}
		else
		{
			checkbox_checked="";
		}
	%>
	<input type=checkbox name="CREATE_FILE_VOLUME_YN" id="CREATE_FILE_VOLUME_YN" value='<%=CREATE_FILE_VOLUME_YN%>' <%=checkbox_checked%>   onClick="checkbox_value(this)" <%=create_file_volume_prop%> >
	</TD>
	
<TD>&nbsp;</TD>
<TD>&nbsp;</TD>

</TR>
</TABLE>


<input type='hidden' name='mode' id='mode' value='<%=operation%>'>
<input type='hidden' name='all_fs_locn_codes' id='all_fs_locn_codes' value="">
</FORM>
</BODY>
<%
	if(rs!=null)	rs.close();
	if(stmt!=null) stmt.close();
	if(rs1!=null)	rs1.close();
	if(stmt1!=null) stmt1.close();
}
catch(Exception e)
{
	out.println("Exception e :"+e.toString());
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>
</HTML>

