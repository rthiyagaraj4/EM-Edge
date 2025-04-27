<!DOCTYPE html>
<!--
	Created On	: 6/21/2002
	Created By	: Nanda Kumar R.
	Module		: File Management (FM)
	Function	: Record Lost/Found
-->
<!-- by Meghanath -->
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD> 
	<!-- <LINK rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
	<%
	
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<SCRIPT language='javascript' src='../../eCommon/js/common.js'></SCRIPT>
	<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js'></SCRIPT>
	<script language='javascript' src='../../eFM/js/FMPractitionerComponent.js'></script>
	<SCRIPT language='javascript' src='../../eFM/js/FMLostFound.js'></SCRIPT>
	<Script language='JavaScript' src='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY onMouseDown="CodeArrest()" onKeyDown = 'lockKey();'>
<FORM name = 'fm_change_status_lost_found' action='../../servlet/eFM.FMLostFoundFileServlet' method='post' target='messageFrame'>
<%
	java.util.Properties p	= (java.util.Properties) session.getValue("jdbc");

	Connection con				= ConnectionManager.getConnection(request);
	PreparedStatement pstmt		= null;
	ResultSet rs				= null;
		
	String facilityid 	= (String) session.getValue("facility_id");
	String addedById	= p.getProperty("login_user");

	try {

		StringBuffer SelectSqlBuffer = null;
		SelectSqlBuffer				 = new StringBuffer();

		String p_old_status				= "";
		String p_old_fs_locn			= "";
		String p_old_holder_name		= "";
		String p_curr_date				= "";		
		String p_curr_status			= "";
		String p_file_no				= "";
		String p_file_type_code			= "";
		String p_volume_no				= "";
		String p_remarks				= "";
		String p_curr_fs_locn_identity	= "";
		String volumeCriteria           = "";
		String filetypeCriteria         = "";
		String doc_type_code			= "";
		String doc_folder_id	        = "";
		String curr_facility_id	        = "";
		String sql						= "";
		String fs_locn_identity			= "", p_patient_id="", p_curr_fs_locn_code="";
		String archive_yn="";
		String curr_holder_user_id="";

		String p_patient_file_no		= request.getParameter("p_patient_file_no");
		String p_patient_file_type_code	= request.getParameter("p_patient_file_type");
		String file_type_appl_yn		= request.getParameter("file_type_appl_yn");
		String volume_no		        = request.getParameter("volume_no");
		String p_user_name		        = request.getParameter("appl_user_name");
		
		if(p_patient_file_type_code == null || p_patient_file_type_code.equals("null")) 					p_patient_file_type_code = "";
		if(p_user_name == null || p_user_name.equals("null")) p_user_name = "";
		
		if(file_type_appl_yn.equals("Y")) {
			if(p_patient_file_type_code != null && !(p_patient_file_type_code.equals(""))) {
				filetypeCriteria =  " AND a.file_type_code = '"+p_patient_file_type_code+"' ";
			}
		}

		if(volume_no == null || volume_no.equals("null") || volume_no.equals("")) { 
			
			////Reteriving the the Volume No If volume No is not selected and clicked on "Add" in the criteria page.
			
			sql="SELECT max(a.volume_no) volume_no from fm_curr_locn a where a.facility_id = ? and a.file_no = ? AND a.file_type_code = '"+p_patient_file_type_code+"'  and a.curr_file_status not in ('T','R') ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facilityid);
			pstmt.setString(2,p_patient_file_no);
			rs = pstmt.executeQuery();

			if(rs != null && rs.next()) {
				volume_no = rs.getString("volume_no");
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

			if(volume_no == null || volume_no.equals("null")) volume_no = "";
		}
		
		if((volume_no != null) && !(volume_no.equals(""))) {
			volumeCriteria = " AND a.volume_no = "+volume_no+" ";
		}
		
		/*(sql = "";
		sql = "select appl_user_name from sm_appl_user_LANG_VW where appl_user_id = ? AND LANGUAGE_ID = ?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,addedById);
		pstmt.setString(2,localeName);
		rs = pstmt.executeQuery();

		while(rs != null && rs.next()) {	
			p_user_name = rs.getString(1);
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();*/

		SelectSqlBuffer.append("SELECT" );
		SelectSqlBuffer.append("  (select appl_user_name from sm_appl_user_LANG_VW where appl_user_id = '"+addedById+"' AND LANGUAGE_ID = '"+localeName+"') p_user_name, a.File_No" );
		SelectSqlBuffer.append("  , a.File_Type_Code" );
		SelectSqlBuffer.append("  , a.Doc_Type_Code" );
		SelectSqlBuffer.append("  , a.Doc_Folder_Id" );
		SelectSqlBuffer.append("  , a.Patient_Id Pat_Id" );
		SelectSqlBuffer.append("  , Get_patient_line(a.Patient_Id,'"+localeName+"') Patient_Line" );
		SelectSqlBuffer.append("  , TO_CHAR(sysDate,'dd/mm/rrrr hh24:mi') Curr_Date" );
		SelectSqlBuffer.append("  , a.Curr_File_Status Curr_File_Status" );
		SelectSqlBuffer.append("  , a.Curr_File_Status Curr_File_Status1" );
		SelectSqlBuffer.append("  , fm_Get_desc.Fm_storage_locn('"+facilityid+"',a.Curr_fs_Locn_Code,'"+localeName+"',2) Curr_fs_Locn_desc" );
		SelectSqlBuffer.append("  , Curr_fs_Locn_Code" );
		SelectSqlBuffer.append("  , Nvl(TO_CHAR(a.Iss_Date_Time,'dd/mm/rrrr hh24:mi'),'') Iss_Date_Time" );
		SelectSqlBuffer.append("  , Nvl(TO_CHAR(a.Return_Date_Time,'dd/mm/rrrr hh24:mi'),'') Return_Date_Time" );
		SelectSqlBuffer.append("  , a.Curr_fs_Locn_Identity Curr_fs_Locn_Identity" );
		SelectSqlBuffer.append("  , Curr_fs_Locn_Identity fs_Locn_Identity" );
		SelectSqlBuffer.append("  , A.CURR_HOLDER_USER_ID CURR_HOLDER_USER_ID" );
		SelectSqlBuffer.append("  , SM_GET_DESC.SM_APPL_USER(A.CURR_HOLDER_USER_ID,'"+localeName+"','1') curr_holder_name" );
		SelectSqlBuffer.append("  , Nvl(a.Remarks,'') Remarks" );
		SelectSqlBuffer.append("  , a.Volume_No" );
		SelectSqlBuffer.append("  , a.Curr_Facility_Id " );
		SelectSqlBuffer.append("  , a.ARCHIVE_YN " );
		SelectSqlBuffer.append("FROM" );
		SelectSqlBuffer.append("  fm_Curr_Locn a " );
		SelectSqlBuffer.append("WHERE a.Facility_Id = ? " );
		SelectSqlBuffer.append("  AND a.File_No = ? " );
		SelectSqlBuffer.append(volumeCriteria  );
		SelectSqlBuffer.append("  AND a.Curr_File_Status NOT IN ('T', 'R') " );
		SelectSqlBuffer.append(filetypeCriteria );
		SelectSqlBuffer.append("ORDER BY" );
		SelectSqlBuffer.append("  a.file_no" );

		pstmt = con.prepareStatement(SelectSqlBuffer.toString());
		pstmt.setString(1,facilityid);
		pstmt.setString(2,p_patient_file_no);
		rs = pstmt.executeQuery();

		while(rs != null && rs.next())
		{
			p_file_no				= rs.getString("file_no");
			p_file_type_code		= rs.getString("file_type_code");
			p_volume_no				= rs.getString("volume_no");
			p_old_status			= rs.getString("curr_file_status");
			p_old_fs_locn			= rs.getString("curr_fs_locn_desc");
			p_old_holder_name		= rs.getString("curr_holder_name");
			p_curr_date				= rs.getString("curr_date");
			
			p_curr_status			= rs.getString("curr_file_status1");
			p_remarks				= rs.getString("remarks");
			p_curr_fs_locn_identity = rs.getString("curr_fs_locn_identity");
			fs_locn_identity		= rs.getString("fs_locn_identity");

			curr_holder_user_id		= rs.getString("CURR_HOLDER_USER_ID");

			p_patient_id			= rs.getString("pat_id");	
			p_curr_fs_locn_code     = rs.getString("curr_fs_locn_code");
			doc_type_code		    = rs.getString("doc_type_code");
			doc_folder_id			= rs.getString("doc_folder_id");
			curr_facility_id		= rs.getString("curr_facility_id");

			archive_yn				= rs.getString("ARCHIVE_YN");
			p_user_name				= rs.getString("p_user_name");
		
		// below codde added for icn: 19967

			if(!p_old_status.equals("L"))
					 p_remarks = "";
			
		
			
			if(!p_curr_fs_locn_identity.equals(""))
			{
				switch(p_curr_fs_locn_identity.charAt(0))
				{
					case 'D' : p_curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels"); break;

					case 'C' : p_curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); break;

					case 'N' : p_curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"); break;

					case 'T' : p_curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"); break;

					case 'X' : p_curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels"); break;

					case 'E' : p_curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels"); break;

					case 'Y' : p_curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"); break;
			
				}
			}

			if(!p_old_status.equals(""))
			{
				switch(p_old_status.charAt(0))
				{
					case 'T' : p_old_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileInTransit.label","fm_labels"); break;

					case 'I' : p_old_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisInside.label","fm_labels"); break;

					case 'L' : p_old_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisLost.label","fm_labels"); break;

					case 'A' : p_old_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisArchived.label","fm_labels"); break;

					case 'O' : p_old_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisOutside.label","fm_labels"); break;

					case 'E' : p_old_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels"); break;
			
				}
			}

			if((p_file_no == null)||(p_file_no.equals("null")))p_file_no = "";	
			if((p_file_type_code == null)||(p_file_type_code.equals("null")))p_file_type_code = "";
			if((p_volume_no == null)||(p_volume_no.equals("null"))) p_volume_no = "";
			if((p_old_status == null)||(p_old_status.equals("null"))) p_old_status = "";		
			if((p_old_fs_locn == null)||(p_old_fs_locn.equals("null"))) p_old_fs_locn = "";		
			if((p_old_holder_name == null)||(p_old_holder_name.equals("null"))) p_old_holder_name = "";

			if((curr_holder_user_id == null)||(curr_holder_user_id.equals("null"))) curr_holder_user_id = "";


			//if(p_old_holder_name.equals("&nbsp;")) p_old_holder_name = "";



			if((p_curr_date != null))
			{
				p_curr_date=DateUtils.convertDate(p_curr_date,"DMYHM","en",localeName);
			}
			else
				p_curr_date = ""; 
			if((p_curr_status == null)||(p_curr_status.equals("null"))) p_curr_status = "";
			if((p_remarks == null)||(p_remarks.equals("null"))) p_remarks = "";
			if((doc_type_code == null)||(doc_type_code.equals("null"))) doc_type_code = "";
			if((doc_folder_id == null)||(doc_folder_id.equals("null"))) doc_folder_id = "";
			if((curr_facility_id == null)||(curr_facility_id.equals("null"))) curr_facility_id = "";
			if((p_curr_fs_locn_identity==null)||(p_curr_fs_locn_identity.equals("null")))
				p_curr_fs_locn_identity = "";
			if((fs_locn_identity == null)||(fs_locn_identity.equals("null"))) fs_locn_identity = ""; 
			if((p_patient_id == null) || (p_patient_id.equals("null"))) p_patient_id = "";
			if((p_curr_fs_locn_code == null)||(p_curr_fs_locn_code.equals("null"))) 
				p_curr_fs_locn_code = ""; 
			p_curr_fs_locn_identity = "("+p_curr_fs_locn_identity+")";
		}

		if((SelectSqlBuffer != null) && (SelectSqlBuffer.length() > 0)) {
			SelectSqlBuffer.delete(0,SelectSqlBuffer.length());
		}
	
	%>
	<TABLE border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
		<Td class='columnheader' colspan='4'><fmt:message key="eFM.CurrentStatusoftheFile.label" bundle="${fm_labels}"/></Td>
		<TR>
			<TD width ='25%'  class= 'label'><fmt:message key="Common.status.label" bundle="${common_labels}"/></TD>
			<TD width = '25%' class='fields'><INPUT type=text readonly value="<%=p_old_status%>" size='30'>
			</TD>
		<!-- </TR>
		<TR> -->
			<TD width ='25%' class= 'label'><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/></TD>
			<TD width = '25%' class='fields'><INPUT type=text size=30 readonly value="<%=p_old_fs_locn%><%=p_curr_fs_locn_identity%>">
			</TD>
		</TR>
		<TR>
			<TD class= 'label'><fmt:message key="eFM.HolderName.label" bundle="${fm_labels}"/></TD>
			<TD class='fields'><INPUT type=text size=30 readonly value="<%=p_old_holder_name%>">
			</TD>
	<!-- 	</TR>
		 <TR> -->
			<TD class= 'label'></TD>
			<TD class='label'></TD>
		</TR> 
	<!-- </TABLE>
	<TABLE border='0' cellpadding='0' cellspacing='0' width='100%' align='center'> -->
		<Td class='columnheader' colspan='4' ><fmt:message key="eFM.NewStatusoftheFile.label" bundle="${fm_labels}"/></Td>
		<TR>
			<TD class= 'label'><fmt:message key="Common.status.label" bundle="${common_labels}"/></TD>
			<TD class='fields' colspan='3'>
				<SELECT name="p_new_status" id="p_new_status" onChange='showIdentity(this);populateFSLocation(this)'>
				<% if(p_curr_status.equals("I")) { %>
					<OPTION value=''>---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</OPTION>
					<OPTION value='L'><fmt:message key="Common.Lost.label" bundle="${common_labels}"/> </OPTION>
					<OPTION value='A'><fmt:message key="Common.Archived.label" bundle="${common_labels}"/> </OPTION>
					<% if(archive_yn.equals("Y")){ %>
					<OPTION value='NA'><fmt:message key="eFM.NeverTobeArchived.label" bundle="${fm_labels}"/>
					</OPTION>
					<%}%>
				<% } else if (p_curr_status.equals("O")) { %>
					<OPTION value=''>---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</OPTION>
					<OPTION value='L'><fmt:message key="Common.Lost.label" bundle="${common_labels}"/></OPTION>
				<% } else if (p_curr_status.equals("L")) { %>
					<OPTION value=''>---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</OPTION>
					<OPTION value='F'><fmt:message key="eFM.Found.label" bundle="${fm_labels}"/></OPTION>
				<% } else if (p_curr_status.equals("A")) { %>
					<OPTION value=''>---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</OPTION>
					<OPTION value='L'><fmt:message key="Common.Lost.label" bundle="${common_labels}"/> </OPTION>
					<OPTION value='R'><fmt:message key="eFM.ReturnFromArchived.label" bundle="${fm_labels}"/></OPTION>
				<% } else if(p_curr_status.equals("T")) { %>
					<OPTION value=''>---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</OPTION>
					<OPTION value='L'><fmt:message key="Common.Lost.label" bundle="${common_labels}"/></OPTION>
				<% } else if(p_curr_status.equals("E")) { %>
					<OPTION value=''>---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</OPTION>
					<OPTION value='L'><fmt:message key="Common.Lost.label" bundle="${common_labels}"/></OPTION>
				<% } %>
				</SELECT><IMG src='../../eCommon/images/mandatory.gif' align='center'></IMG> 
			</TD>
		</TR>
		<TR> 
			<TD class='label'><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/></TD>
			<TD id='td1' class='fields' colspan='3'><SELECT name="fs_locn_idty" id="fs_locn_idty" onChange="PopulateData(this.value)" >
					<OPTION value="">---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</OPTION>
					<OPTION value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></OPTION>
					<OPTION value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></OPTION>
					<OPTION value="Y"><fmt:message key="Common.DaycareUnit.label" bundle="${common_labels}"/></OPTION>
					<OPTION value="E"><fmt:message key="Common.ProcedureUnit.label" bundle="${common_labels}"/></OPTION>
					<OPTION value="T"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></OPTION>
					<OPTION value="D"><fmt:message key="Common.department.label" bundle="${common_labels}"/></OPTION>
			</SELECT>&nbsp;/&nbsp;<SELECT name=p_fs_location onChange='ChkValue(this.value);'>
			<OPTION value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
			</SELECT>&nbsp;/&nbsp;<input type="text" name="locn_desc" id="locn_desc" value="" onChange="getValidRecords(this);" disabled><input type="Hidden" name="locn_code" id="locn_code" value=""><input type="button" name="locn_button" id="locn_button" value="?" class="BUTTON" onClick="getValidRecords(locn_desc);" disabled><IMG src='../../eCommon/images/mandatory.gif' align='center'></IMG>
			</TD>
			<TD class='fields'  id="td2" style="display:none" colspan='3'>
			<SELECT name=p_fs_location1>
				<OPTION value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
			</SELECT>
			</TD>
		</TR>
		<TR>
			<TD class= 'label'><fmt:message key="eFM.UpdatedDate.label" bundle="${fm_labels}"/></TD>
			<TD class='fields'><INPUT type=text name=p_updated_date value="<%=p_curr_date%>" size=14 readonly>
			</TD>
		<!-- </TR>
		<TR> -->
			<TD class= 'label'><fmt:message key="eFM.UpdatedBy.label" bundle="${fm_labels}"/></TD>
			<TD class='fields'><INPUT type=text name=updated_by_name value="<%=p_user_name%>" onChange="searchUpdatedByCode(p_updated_by,'<%=facilityid%>')" size=30 ><INPUT type=hidden name=p_updated_by value="<%=addedById%>" size=30 readonly><INPUT type=button name='searchcode' id='searchcode' value='?' class=button onClick="searchUpdatedByCode(p_updated_by,'<%=facilityid%>')">
			</TD>
		</TR>
		<TR>
			<TD class= 'label'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></TD>
			<TD class='fields' colspan='3'>
				<TEXTAREA name=p_remarks cols=34 rows=2 onkeypress="checkMaxLimit(this,100)" onBlur="makeValidString(this); CheckMaxLen('Remarks',this,100,parent.frames[4])"><%=p_remarks%></TEXTAREA>
			</TD>
		</TR>
	</TABLE>
<%	
	if(p_old_holder_name.equals("")) p_old_holder_name="";
%>
	<INPUT type='hidden' name=p_facility_id value='<%=facilityid%>'>
	<INPUT type='hidden' name=p_store_new_status value=''>
	<INPUT type='hidden' name=p_store_fs_location value=''>
	<INPUT type='hidden' name=p_store_updated_by value=''>
	<INPUT type='hidden' name=functionval value='modify'>
	<INPUT type='hidden' name=p_store_file_no value='<%=p_file_no%>'>
	<INPUT type='hidden' name=p_store_file_type_code value='<%=p_file_type_code%>'>
	<INPUT type='hidden' name=p_store_volume_no value='<%=p_volume_no%>'>
	<INPUT type='hidden' name=p_store_doc_folder_id value='<%=doc_folder_id%>'>
	<INPUT type='hidden' name=p_store_doc_type_code value='<%=doc_type_code%>'>
	<INPUT type='hidden' name='src_fs_locn_code' id='src_fs_locn_code' value='<%=p_curr_fs_locn_code%>'>
	<INPUT type='hidden' name='src_locn_identity' id='src_locn_identity' value='<%=fs_locn_identity%>'>
	<INPUT type='hidden' name='src_locn_code' id='src_locn_code' value=''>
	<INPUT type='hidden' name='src_user_id' id='src_user_id' value='<%=curr_holder_user_id%>'>
	<INPUT type='hidden' name='patient_id' id='patient_id' value='<%=p_patient_id%>'>
	<INPUT type='hidden' name='curr_facility_id' id='curr_facility_id' value='<%=curr_facility_id%>'>
	<INPUT type='hidden' name='appl_user_id' id='appl_user_id' value=''>
	<INPUT type='hidden' name='all_fs_locn_codes' id='all_fs_locn_codes' value="">
	<INPUT type='hidden' name='NevertoArchive' id='NevertoArchive' value="">
	<INPUT type='hidden' name='p_curr_status' id='p_curr_status' value="<%=p_curr_status%>">
	<INPUT type='hidden' name='archive_yn' id='archive_yn' value="<%=archive_yn%>">
	</FORM>
	</BODY>
<%
if(rs!=null)	rs.close();
if(pstmt!=null)	pstmt.close();
}catch(Exception e){out.println("Exception in main try "+e.toString());
e.printStackTrace();
}
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

