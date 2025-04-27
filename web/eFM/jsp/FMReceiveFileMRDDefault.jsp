<!DOCTYPE html>
<!--
	Created On	: 6/15/2002
	Created By	: Nanda Kumar R.
	Module		: File Management (FM)
	Function	: Return File to MRD
	
-->
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src='../../eFM/js/FMReturnMRDFile.js'></script>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY onMouseDown="CodeArrest()" onKeyDown = 'lockKey();'>
<FORM name = 'fm_ret_criteria' action='../../servlet/eFM.FMReceiveFileAtMRDServlet' method='post' target='messageFrame'>
<%
	Connection con	= ConnectionManager.getConnection(request);
	Properties p	= (Properties) session.getValue("jdbc" ) ;

	PreparedStatement pstmt = null;
	PreparedStatement pstmt_fn	= null;
	ResultSet rs			= null;
	ResultSet rset_fn				= null;
try
{
	String addedById			= p.getProperty( "login_user" );
	String facilityid 			= (String) session.getValue("facility_id");

	String sql					= "";
	String sql1					= "";
	String sql2					= "";
	String p_user_name			= "";	
	String p_code				= "";
	String p_desc				= "";
	String p_user_security_yn	= "";
	String p_disable_name		= "";
	String p_dflt_narration		= "";
	String p_curr_date			= "";
	String p_access_all			= "";
	String doc_or_file					= "";
	String dflt_archive_fs_locn_code	= "";
	String accept_out_intransit_yn =	"";

	StringBuffer ReceiveFSLocnBuffer = null;
	StringBuffer NarrationBuffer	 = null;
	ReceiveFSLocnBuffer				 = new StringBuffer();
	NarrationBuffer					 = new StringBuffer();


	pstmt_fn	= con.prepareStatement("select accept_out_intransit_yn from fm_parameter where facility_id='"+facilityid+"'");
	rset_fn		= pstmt_fn.executeQuery();
	if(rset_fn.next())
	{
		accept_out_intransit_yn=rset_fn.getString("accept_out_intransit_yn");
	}
	if(accept_out_intransit_yn==null)
		accept_out_intransit_yn="N";

	session.putValue("accept_out_intransit_yn",accept_out_intransit_yn);
	int p_count	= 0;
	
	doc_or_file					= request.getParameter("doc_or_file") == null ? "" : request.getParameter("doc_or_file");	
	p_user_security_yn			= request.getParameter("user_security_yn") == null ? "" : request.getParameter("user_security_yn");
	p_dflt_narration			= request.getParameter("dflt_narr_code_for_note_rtn") == null ? "" : request.getParameter("dflt_narr_code_for_note_rtn");
	p_access_all				= request.getParameter("accessAll") == null ? "" : request.getParameter("accessAll");
	dflt_archive_fs_locn_code	= request.getParameter("dflt_archive_fs_locn_code") == null ? "" : request.getParameter("dflt_archive_fs_locn_code");
	//sql = "select appl_user_name,to_char(sysdate,'dd/mm/rrrr hh24:mi') curr_date from sm_appl_user where appl_user_id = ?";
	sql = "SELECT"
      +"  appl_user_name"
      +"  ,TO_CHAR(sysdate,'dd/mm/rrrr hh24:mi') curr_date "
      +"FROM"
      +"  sm_appl_user_LANG_VW "
      +"WHERE appl_user_id = ? "
      +"  AND Language_Id = ?";
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1,addedById);
	pstmt.setString(2,localeName);
	rs = pstmt.executeQuery();
	while(rs != null && rs.next())
	{
		p_user_name = rs.getString("appl_user_name");
		p_curr_date	= rs.getString("curr_date");
	}
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	
	if (p_user_security_yn.equals("Y"))
	{
		p_disable_name = "disabled";
	}
	else
	{
		p_disable_name = "";
	}
	
	
	if (p_user_security_yn.equals("Y"))
	{
		
		if (p_access_all.equals("*ALL"))
		{
			//sql2 = "select a.fs_locn_code,a.short_desc short_desc from fm_storage_locn a where a.eff_status='E' and a.facility_id='"+facilityid+"' and a.permanent_file_area_yn='Y' order by 2";
			sql2 = "SELECT"
					  +"  fs_Locn_Code"
					  +"  ,fm_get_desc.fm_storage_locn (facility_id,fs_Locn_Code,'"+localeName+"',2 ) Short_desc "
					  +"FROM"
					  +"  fm_Storage_Locn "
					  +"WHERE Facility_Id = '"+facilityid+"' "
					  +"  AND Permanent_File_Area_yn = 'Y' "
					  +"  AND eff_status='E' "
					//  +"  AND Language_Id = '"+localeName+"' "
					  +"ORDER BY"
					  +"  2";
		}
		else
		{
			//sql2 = "select a.fs_locn_code,a.short_desc ,a.narration_code from fm_storage_locn a , fm_user_access_rights b where a.eff_status='E' and a.facility_id=b.facility_id and a.fs_locn_code=b.fs_locn_code and b.appl_user_id='"+addedById+"' and b.facility_id='"+facilityid+"' and b.receive_file_yn='Y' order by 2";
			sql2 = "SELECT"
							  +"  a.fs_Locn_Code"
							  +"  , fm_get_desc.fm_storage_locn (a.facility_id,a.fs_Locn_Code,'"+localeName+"',2 ) Short_desc"
							  +"  , a.Narration_Code "
							  +"FROM"
							  +"  fm_Storage_Locn a"
							  +"  , fm_User_Access_Rights b "
							  +"WHERE a.eff_Status = 'E' "
							  +"  AND a.Facility_Id = b.Facility_Id(+) "
							  +"  AND a.fs_Locn_Code = b.fs_Locn_Code(+) "
							  +"  AND b.apPl_User_Id = '"+addedById+"' "
							  +"  AND b.Facility_Id = '"+facilityid+"' "
							  +"  AND b.Receive_File_yn = 'Y' "
							//  +"  AND a.Language_id = '"+localeName+"' "
							  +"ORDER BY"
							  +"  2";

		}
	}
	else
	{
				sql2 = "SELECT"
					  +"  fs_Locn_Code"
					  +"  , fm_get_desc.fm_storage_locn (facility_id,fs_Locn_Code,'"+localeName+"',2 )  Short_desc "
					  +"FROM"
					  +"  fm_Storage_Locn "
					  +"WHERE Facility_Id = '"+facilityid+"' "
					  +"  AND Permanent_File_Area_yn = 'Y' "
					  +"  AND eff_status='E' "
				//	  +"  AND Language_Id = '"+localeName+"' "
					  +"ORDER BY"
					  +"  2";
	}

	pstmt = con.prepareStatement(sql2);
	rs = pstmt.executeQuery();
	while(rs != null && rs.next())
	{
		p_code = rs.getString("fs_locn_code");
		p_desc = rs.getString("short_desc");

		ReceiveFSLocnBuffer.append("<option value='"+p_code+"'>"+p_desc+"</option>");
		p_count++;
	}
	if(rs!=null)	rs.close();
	if(pstmt!=null) pstmt.close();

	sql1    = "";
	//sql1	= "select narration_code,short_desc from fm_narration where eff_status='E' order by 2";
	sql1	= "select narration_code,short_desc from fm_narration_LANG_VW where eff_status='E' AND Language_Id = '"+localeName+"' order by 2";
	pstmt	= con.prepareStatement(sql1);
	rs		= pstmt.executeQuery();

	while (rs != null && rs.next())
	{
		p_code = rs.getString("narration_code");
		p_desc = rs.getString("short_desc");

		if(p_dflt_narration.equals(p_code))
		{
			NarrationBuffer.append("<option value='"+p_code+"' selected>"+p_desc+"</option>");
		}
		else
		{
			NarrationBuffer.append("<option value='"+p_code+"'>"+p_desc+"</option>");
		}
	}
%>
<TABLE border='0' cellpadding='2' cellspacing='0' width='100%' align='center'>
<tr><th class='columnheader' align="left" colspan="4"><fmt:message key="eFM.ReceivedDetails.label" bundle="${fm_labels}"/></td></tr>
<TR>
	<TD width ='25%'   class= 'label'><fmt:message key="eFM.ReceivingFSLocation.label" bundle="${fm_labels}"/></TD>
	<TD width = '25%'  class='fields' ><select name="p_curr_fs_loc" id="p_curr_fs_loc" onChange="ChangeOutstanding()" tabindex=1><option value=''>-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
		<%=ReceiveFSLocnBuffer.toString()%>
		</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
	</TD>
	<TD width ='25%' class= 'label'><fmt:message key="Common.ReceivedBy.label" bundle="${common_labels}"/></TD>
	<TD width ='25%' class='fields' ><input tabindex=2 type=text size=30 maxlength=30 name=p_ret_by_name readonly value="<%=p_user_name%>"><input type=hidden size=40 maxlength=30 name=p_ret_by <%=p_disable_name%> readonly value=<%=addedById%>><input type=button name=searchcode value='?' class=button onClick="searchCode(p_ret_by,'<%=facilityid%>')" <%=p_disable_name%>>
	</TD>
</TR>
<TR>
	<TD width ='25%'   class= 'label'><fmt:message key="eFM.Narration.label" bundle="${fm_labels}"/></TD>
	<TD width = '25%'  class='fields' ><select name =p_narration tabindex=3>
		<option 	value=''>-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
		<%=NarrationBuffer.toString()%>
	</select>
	</TD>
	<% if(doc_or_file.equals("D")){	%>
	<TD width ='25%'   class= 'label'><fmt:message key="eFM.DocumentStatus.label" bundle="${fm_labels}"/></TD>
	<% }else {%>
	<TD width ='25%'   class= 'label'><fmt:message key="eFM.FileStatus.label" bundle="${fm_labels}"/></TD>
	<% } %>
	<TD   class='fields' ><select onchange='confrmtransit();' name="FILE_STAT" id="FILE_STAT" tabindex=4>
			<option value=''>-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
			<option value='T'><fmt:message key="eFM.Transit.label" bundle="${fm_labels}"/></option>
			<option value='L'><fmt:message key="Common.Lost.label" bundle="${common_labels}"/></option>
			<option value='A'><fmt:message key="Common.Archived.label" bundle="${common_labels}"/></option>
			<option value='O'><fmt:message key="Common.Outside.label" bundle="${common_labels}"/></option>
			<%if(!accept_out_intransit_yn.equals("Y")) {%>
			 <option value='R' Selected><fmt:message key="Common.returned.label" bundle="${common_labels}"/></option> 
			<%} else {%>
				<option value='R'><fmt:message key="Common.returned.label" bundle="${common_labels}"/></option>
			<%}%>
			
		</select>
	</TD>
</TR>
</TABLE>
	<input type="Hidden" name="p_return_date_time" id="p_return_date_time" value='<%=p_curr_date%>' >
	<input type='hidden' name='file_nos' id='file_nos' value=''>
	<input type='hidden' name='p_select_values' id='p_select_values' value=''>
	<input type='hidden' name='p_deselect_values' id='p_deselect_values' value=''>
	<input type='hidden' name='p_patient_file_no' id='p_patient_file_no' value=''>
	<input type='hidden' name='p_valtype' id='p_valtype' value=''>
	<input type='hidden' name='p_load_select' id='p_load_select' value=''>
	<input type='hidden' name='p_load_deselect' id='p_load_deselect' value=''>
	<input type='hidden' name='p_total_records' id='p_total_records' value=''>
	<input type='hidden' name='p_select_files' id='p_select_files' value=''>
	<input type='hidden' name='p_deselect_files' id='p_deselect_files' value=''>
	<input type='hidden' name='p_returndatetime' id='p_returndatetime' value=''>
	<input type='hidden' name='p_returned_by' id='p_returned_by' value=''>
	<input type='hidden' name='p_narration_code' id='p_narration_code' value=''>
	<input type='hidden' name='p_file_nos' id='p_file_nos' value=''>
	<input type='hidden' name='rem_recnum_value' id='rem_recnum_value' value=''>
	<input type='hidden' name='functionval' id='functionval' value='modify'>
	<input type='hidden' name="doc_or_file" id="doc_or_file" value='<%=doc_or_file%>'>
	<input type='hidden' name="user_security_yn" id="user_security_yn" value='<%=p_user_security_yn%>'>
	<input type='hidden' name="dflt_narr_code_for_note_rtn" id="dflt_narr_code_for_note_rtn" value='<%=p_dflt_narration%>'>
	<input type='hidden' name="accessAll" id="accessAll" value='<%=p_access_all%>'>
	<input type='hidden' name="dflt_archive_fs_locn_code" id="dflt_archive_fs_locn_code" value='<%=dflt_archive_fs_locn_code%>'>
	<input type='hidden' name="accept_out_intransit_yn" id="accept_out_intransit_yn" value='<%=accept_out_intransit_yn%>'>
	<input type='hidden' name='p_outst_facility' id='p_outst_facility' value=''>
</FORM>
</BODY>
<%
	if((NarrationBuffer != null) && (NarrationBuffer.length() > 0))
	{
		NarrationBuffer.delete(0,NarrationBuffer.length());
	}
	if((ReceiveFSLocnBuffer != null) && (ReceiveFSLocnBuffer.length() > 0))
	{
		ReceiveFSLocnBuffer.delete(0,ReceiveFSLocnBuffer.length());
	}
if(rs!=null)	rs.close();
if(pstmt!=null) pstmt.close();
}catch(Exception e){out.println("Exception e :"+e);}
finally
{	
	ConnectionManager.returnConnection(con,request);
}
%>
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

