<!DOCTYPE html>
<!--
	Created On	: 6/21/2002
	Created By	: Nanda Kumar R.
	Module		: File Management (FM)
	Function	: File Lost/Found Status
-->
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
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
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eFM/js/FMLostFound.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY onMouseDown="CodeArrest()" onLoad="document.fm_lost_found_criteria.f_curr_fs_locn.focus();" onKeyDown = 'lockKey();'> 
<FORM name = 'fm_lost_found_criteria' action='' method='post' target='messageFrame'>
<%

	Properties p	= (Properties) session.getValue("jdbc" ) ;

	Connection con				= ConnectionManager.getConnection(request);
	java.sql.Statement stmt		= null;
	PreparedStatement pstmt		= null;
	ResultSet rs				= null;
	
	String p_code				= "";
	String p_desc				= "";	
	String appl_user_name		= "";
	String p_access_all			= "";
	String maintain_doc_or_file = "";
	String sql					= "";
	String SelectSql			= "";
	String p_user_security_yn	= "N";
	
	int count	=	0;
		
	try {
		
		String addedById			= p.getProperty( "login_user" ) ;
		String facilityid 			= (String) session.getValue("facility_id");

		p_access_all = request.getParameter("p_access_all");
		p_user_security_yn = request.getParameter("p_user_security_yn");

		if(p_access_all == null || p_access_all.equals("null")) p_access_all = "";
		if(p_user_security_yn == null || p_user_security_yn.equals("null")) p_user_security_yn = "N";
		
		stmt	= con.createStatement();

		sql = "SELECT maintain_doc_or_file from mp_param";
		rs	  = stmt.executeQuery(sql);
		if(rs != null && rs.next()) {
			maintain_doc_or_file = rs.getString("maintain_doc_or_file");
		} if(rs!=null)	rs.close();

		sql   = "";
		//sql = "select appl_user_name from sm_appl_user where appl_user_id = ?";
		sql = "select appl_user_name from sm_appl_user_LANG_VW where appl_user_id = ? AND LANGUAGE_ID = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,addedById);
		pstmt.setString(2,localeName);
		rs = pstmt.executeQuery();
		while(rs != null && rs.next()) {
			appl_user_name = rs.getString(1);
		} 
		if(rs!=null)	rs.close();
		if(pstmt!=null)	pstmt.close();
		
		if(p_user_security_yn.equals("Y")) 
		{
			sql = "";
			if(p_access_all.equals("1")) {
				//SelectSql = "select a.fs_locn_code,a.short_desc fs_locn_desc,a.narration_code from fm_storage_locn a  where a.eff_status='E' and a.facility_id = ? and a.permanent_file_area_yn='Y' order by 2";
				SelectSql = "SELECT a.fs_Locn_Code,  fm_Get_desc.Fm_storage_locn('"+facilityid+"',a.fs_Locn_Code,'"+localeName+"',2) fs_Locn_desc,  a.Narration_Code FROM FM_STORAGE_LOCN a WHERE a.eff_Status = 'E'   AND a.Facility_Id = ?  AND a.Permanent_File_Area_yn = 'Y' ORDER BY 2";
				
				pstmt = con.prepareStatement(SelectSql);
				pstmt.setString(1,facilityid);
			//	pstmt.setString(2,localeName);

		} else {
			//SelectSql = "select a.fs_locn_code,a.short_desc fs_locn_desc,a.narration_code from fm_storage_locn a , fm_user_access_rights b where a.eff_status='E' and a.facility_id=b.facility_id and a.fs_locn_code=b.fs_locn_code and b.appl_user_id = ? and b.facility_id = ? and b.change_file_status_yn='Y'   order by 2";
			SelectSql = "SELECT a.fs_Locn_Code,  a.Short_desc fs_Locn_desc,  a.Narration_Code FROM FM_STORAGE_LOCN_LANG_VW a,  fm_User_Access_Rights b WHERE a.eff_Status = 'E'  AND a.Facility_Id = b.Facility_Id  AND a.fs_Locn_Code = b.fs_Locn_Code  AND b.apPl_User_Id = ?  AND b.Facility_Id = ?    AND A.LANGUAGE_ID=?  AND b.Change_File_Status_yn = 'Y' ORDER BY 2";
			
			if(pstmt!=null)	pstmt.close();

			pstmt = con.prepareStatement(SelectSql);
			pstmt.setString(1,addedById);
			pstmt.setString(2,facilityid);
			pstmt.setString(3,localeName);
		}
	} else {
		//SelectSql = "select fs_locn_code, short_desc fs_locn_desc from fm_storage_locn  where eff_status='E' and facility_id = ? and permanent_file_area_yn='Y' order by 2";
		SelectSql = "SELECT fs_Locn_Code,  fm_Get_desc.Fm_storage_locn('"+facilityid+"',fs_Locn_Code,'"+localeName+"',2) fs_Locn_desc FROM FM_STORAGE_LOCN WHERE eff_Status = 'E'  AND Facility_Id = ?   AND Permanent_File_Area_yn = 'Y' ORDER BY 2";

		if(pstmt!=null)	pstmt.close();

		pstmt = con.prepareStatement(SelectSql);
		pstmt.setString(1,facilityid);
	//	pstmt.setString(2,localeName);
	}
	rs = pstmt.executeQuery();
%>
<TABLE border='0' cellpadding='1' cellspacing='0' width='100%' align='center'>
	<tr>
		<TD class= 'label' width="25%"><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/></TD>
		<TD width="25%" class='fields'><select name="f_curr_fs_locn" id="f_curr_fs_locn"  onchange='clearvalues(this.value);' tabindex=1 >	
				<option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
				<%
				while(rs != null && rs.next()) {
					p_code = rs.getString("fs_locn_code");
					p_desc = rs.getString("fs_locn_desc");

					count++;
				%>
				<option value=<%=p_code%> ><%=p_desc%></option>
				<% } %>
			</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
		</TD>
		<td class= 'label' width="25%"><fmt:message key="Common.Changedby.label" bundle="${common_labels}"/></td>
		<!--Below line modifed for this SCF ML-MMOH-SCF-0361 -->
		<td width='25%' class='fields'>
		<% if(p_user_security_yn.equals("Y")) {	%><input type='text' name='appl_user_id1' id='appl_user_id1' value="<%=appl_user_name%>" size='30' readonly ><input type='hidden' name='appl_user_id' id='appl_user_id' value='<%=addedById%>' size='40' readonly maxlength=30 disabled><input type=button name=searchcode value='?' class=button onClick="searchCode(appl_user_id,'<%=facilityid%>')" disabled></td>
		<%} else { %><input type='text' name='appl_user_id1' id='appl_user_id1' value="<%=appl_user_name%>" size='30' readonly  ><input type='hidden' name='appl_user_id' id='appl_user_id' value='<%=addedById%>' size='40' readonly maxlength=30><input type=button name=searchcode value='?' class=button onClick="searchCode(appl_user_id,'<%=facilityid%>')"></td>
	 <% } %>
	</TR>
	<tr><td colspan="4">
		<jsp:include page="../../eFM/jsp/FMFileSearchComponentValues.jsp" ><jsp:param name="flush" value="true" />
			<jsp:param name="frame_name" value="parent.search_criteria"/>
			<jsp:param name="form_name" value="fm_lost_found_criteria"/>
			<jsp:param name="messageframe_name" value="parent.messageFrame"/>
			<jsp:param name="patientid_name" value="patient_id"/>
			<jsp:param name="fileno_name" value="file_no"/>
			<jsp:param name="filetype_name" value="file_type_code"/>
			<jsp:param name="document_type_name" value="doc_type_code"/>
			<jsp:param name="document_folder_id_name" value="doc_folder_id"/>
			<jsp:param name="volumeno_name" value="volume_no"/>			
			<jsp:param name="table_width" value="100"/>
			<jsp:param name="tablealign" value="center"/>
			<jsp:param name="locn_code" value="f_curr_fs_locn"/>
		</jsp:include>
		</td>
	</tr>
	<tr>
		<td class='button'  colspan="4" align="right">
		<input  type=button name="Add" id="Add" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")%>'  class=button onClick="addFiles()"><input align='right' type=button name="Clear" id="Clear" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>'  class=button onClick="Clearval()"></TD>
	</tr>
</TABLE>
	<% if(maintain_doc_or_file.equals("D")) { %>
		<TABLE border='1' cellpadding='0' cellspacing='0' width='100%' align='left' id ="hdr_tab1" style="visibility: hidden;">
			<tr><td class='COLUMNHEADER' width='25%' id="ParamID"><fmt:message key="eFM.DocumentFolderDetails.label" bundle="${fm_labels}"/></td>
				<td class='COLUMNHEADER' width='14%' id="file_type_ID"><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='10%' id="file_type_ID"><fmt:message key="Common.documentdetails.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='8%'><fmt:message key="eFM.DocumentStatus.label" bundle="${fm_labels}"/></td>
				<td class='COLUMNHEADER' width='14%'><fmt:message key="eFM.CurrentFSLocation.label" bundle="${fm_labels}"/></td>
				<td class='COLUMNHEADER' width='14%'><fmt:message key="Common.issueddate.label" bundle="${common_labels}"/></td>
				<!--Modified by Ashwini on 18-Jul-2017 for ML-MMOH-SCF-0763-->
				<td class='COLUMNHEADER' width='15%'><fmt:message key="eFM.ReturnDueDateTime.label" bundle="${fm_labels}"/></td></tr>
		</TABLE>
<%
	} else if(maintain_doc_or_file.equals("F")) { %>
		<TABLE border='1' cellpadding='0' cellspacing='0' width='100%' align='left' id ="hdr_tab" style="visibility: hidden;">	
			<tr><td class='COLUMNHEADER' width='33%' id="ParamID"><fmt:message key="eFM.FileNoPatientDetails.label" bundle="${fm_labels}"/></td>
			<td class='COLUMNHEADER' width='16%' id="file_type_ID"><fmt:message key="eFM.VolumeNo.label" bundle="${fm_labels}"/></td>
			<td class='COLUMNHEADER' width='8%'><fmt:message key="eFM.FileStatus.label" bundle="${fm_labels}"/></td>
			<td class='COLUMNHEADER' width='14%'><fmt:message key="eFM.CurrentFSLocation.label" bundle="${fm_labels}"/></td>
			<td class='COLUMNHEADER' width='14%'><fmt:message key="Common.issueddate.label" bundle="${common_labels}"/></td>
			<!--Modified by Ashwini on 18-Jul-2017 for ML-MMOH-SCF-0763-->
			<td class='COLUMNHEADER' width='15%'><fmt:message key="eFM.ReturnDueDateTime.label" bundle="${fm_labels}"/></td></tr>
			<script>
				if (document.forms[0].file_type_appl_yn.value=="Y")
				{
					document.getElementById("ParamID").innerText=getLabel("Common.PatientDetails.label","common");
					document.getElementById("file_type_ID").innerHTML=getLabel("Common.filetype.label","common")+" / " + getLabel("eFM.VolumeNo.label","FM");
				}
				</script>
		</TABLE>
	<%}%>
	<input type='hidden' name='p_select_values' id='p_select_values' value=''>
	<input type='hidden' name='p_deselect_values' id='p_deselect_values' value=''>
	<input type='hidden' name='p_patient_file_no' id='p_patient_file_no' value=''>
	<input type='hidden' name='p_valtype' id='p_valtype' value=''>
	<input type='hidden' name='p_load_select' id='p_load_select' value=''>
	<input type='hidden' name='p_load_deselect' id='p_load_deselect' value=''>
	<input type='hidden' name='p_total_records' id='p_total_records' value=''>
	<input type='hidden' name='p_select_files' id='p_select_files' value=''>
	<input type='hidden' name='p_deselect_files' id='p_deselect_files' value=''>
	<input type='hidden' name='p_total_select' id='p_total_select' value=''>
	<input type='hidden' name='p_maintain_doc_or_file' id='p_maintain_doc_or_file' value='<%=maintain_doc_or_file%>'>
	<input type='hidden' name='appl_user_name' id='appl_user_name' value="<%=appl_user_name%>">  <!--Below line modifed for this SCF ML-MMOH-SCF-0361 -->
	<input type='hidden' name='p_user_security_yn' id='p_user_security_yn' value='<%=p_user_security_yn%>'>
	<input type='hidden' name='p_access_all' id='p_access_all' value='<%=p_access_all%>'>
</FORM>
	<script>
		if("<%=count%>" == 1) {
			fm_lost_found_criteria.f_curr_fs_locn.options(1).selected = true;
		}
	</script>
</BODY>
<%
if(rs!=null)	rs.close();
if(stmt!=null)  stmt.close();
if(pstmt!=null) pstmt.close();
}catch(Exception e){out.println("Exceptiopn e :"+e);}
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

