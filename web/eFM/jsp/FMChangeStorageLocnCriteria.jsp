<!DOCTYPE html>
<!--
	Developed by 	:	Prakash.S
	Created on 		:	10/06/2002
	Module			:	FM - Change File Store Location
	Function		:	This function is used for Search Criteria.
-->
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	Connection con				= null;
	java.sql.Statement stmt		= null;
	PreparedStatement pstmt		= null;
	ResultSet	rs				= null;
	ResultSet	rs1				= null;

	String login_user	=	(String)session.getValue("login_user");
	String facility_id	=	(String)session.getValue("facility_id");
	
	String fs_locn_code			= "", fs_desc = "";
	String user_security_yn		= "";
	String fs_location			= "";
	String p_access_all			= "";
	String maintain_doc_or_file = "";
	String mysql				= "";
	StringBuffer SelectSqlBuffer = null;
	SelectSqlBuffer				 = new StringBuffer();
	int count = 0;
	try
	{
		con		=	ConnectionManager.getConnection(request);
		stmt = con.createStatement();
     user_security_yn	= request.getParameter("user_security_yn");
		p_access_all		= request.getParameter("p_access_all");
    	if(user_security_yn == null || user_security_yn.equals("null"))user_security_yn = "N";
		if(p_access_all == null || p_access_all.equals("null"))p_access_all = "";
		if(user_security_yn.equals("Y"))
		{
			if(p_access_all.equals("1"))
			{
				//fs_location = "select a.fs_locn_code,a.short_desc fs_locn_desc,a.narration_code from fm_storage_locn a  where a.eff_status='E' and a.facility_id = ? and permanent_file_area_yn='Y' order by 2";
				fs_location = "SELECT a.fs_Locn_Code , fm_Get_desc.Fm_storage_locn('"+facility_id+"',a.fs_Locn_Code,'"+localeName+"',2) fs_Locn_desc ,  a.Narration_Code  FROM  FM_STORAGE_LOCN a WHERE a.eff_Status = 'E' AND  a.Facility_Id = ?  AND Permanent_File_Area_yn = 'Y' ORDER BY  2";


				pstmt = con.prepareStatement(fs_location);
				pstmt.setString(1,facility_id);
			}
			else
			{
				//fs_location = "select a.fs_locn_code,a.short_desc fs_locn_desc,a.narration_code from fm_storage_locn a , fm_user_access_rights b where a.eff_status='E' and a.facility_id=b.facility_id and a.fs_locn_code=b.fs_locn_code and b.appl_user_id = ? and b.facility_id = ? and change_fs_locn_yn='Y'  order by 2";
				fs_location = "SELECT  a.fs_Locn_Code , a.Short_desc fs_Locn_desc , a.Narration_Code FROM  FM_STORAGE_LOCN_LANG_VW a  , fm_User_Access_Rights b  WHERE a.eff_Status = 'E'   AND A.LANGUAGE_ID='"+localeName+"' AND a.Facility_Id = b.Facility_Id AND fs_Locn_Code = b.fs_Locn_Code  AND b.apPl_User_Id = ? AND b.Facility_Id = ?   AND Change_fs_Locn_yn = 'Y' ORDER BY 2 ";
				
				
				if(pstmt != null) pstmt.close();
				pstmt = con.prepareStatement(fs_location);
				pstmt.setString(1,login_user);
				pstmt.setString(2,facility_id);
			}	
		}
		else
		{
			//fs_location = "select a.fs_locn_code,a.short_desc fs_locn_desc from fm_storage_locn a where a.eff_status='E' and  permanent_file_area_yn='Y' and a.facility_id='"+facility_id+"' order by 2";
			fs_location = "SELECT  a.fs_Locn_Code  , fm_Get_desc.Fm_storage_locn('"+facility_id+"',a.fs_Locn_Code,'"+localeName+"',2) fs_Locn_desc FROM  FM_STORAGE_LOCN a WHERE a.eff_Status = 'E'  AND Permanent_File_Area_yn = 'Y'  AND a.Facility_Id =?  ORDER BY 2";

			
			if(pstmt != null) pstmt.close();
			pstmt = con.prepareStatement(fs_location);
			pstmt.setString(1,facility_id);
		}
		
		rs1 = pstmt.executeQuery();
		while(rs1 != null && rs1.next())
		{
			count++;
			fs_locn_code	=	rs1.getString("fs_locn_code");
			fs_desc			=	rs1.getString("fs_locn_desc");
			SelectSqlBuffer.append("<option value ='"+fs_locn_code+"'>"+fs_desc+"</option>");
		} if(rs1 != null) rs1.close(); if(pstmt != null) pstmt.close();

		mysql	= "SELECT maintain_doc_or_file FROM mp_param";
		rs		= stmt.executeQuery(mysql);
		if(rs != null && rs.next())
		{
			maintain_doc_or_file = rs.getString("maintain_doc_or_file");
		} 
%>
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
    <Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></Script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eFM/js/FMChangeStorageLocn.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad='FocusFirstElement();' onMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>
<form name='FMChngStrLocnCriteriaForm' id='FMChngStrLocnCriteriaForm' action='' method=''>
<table cellpadding='1' cellspacing='0' border='0' width='100%' >
	<tr>
		<%if(maintain_doc_or_file.equals("F")){%>
		<td class='label' width='25%'><fmt:message key="Common.TerminalDigit.label" bundle="${common_labels}"/></td>
		<td class='fields'  width='25%'><input type='text' name='terminal_digit' id='terminal_digit' value='' size='10' maxlength='10' onBlur='ChangeUpperCase(this);' onKeyPress='return CheckForSpecChars(event)'></td>
		<%}else if(maintain_doc_or_file.equals("D")){%><td width='25%'>&nbsp;</td><td width='25%'>&nbsp;</td><%}%>
		<td class='label' width='25%'><fmt:message key="eFM.PermanentFSLocation.label" bundle="${fm_labels}"/></td>
		<td class='fields' width='25%'><select name='fs_locn_code' id='fs_locn_code' onchange='clearvalues(this.value);'>
		<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
		<%=SelectSqlBuffer.toString()%></select></td>

		<%
		if((SelectSqlBuffer != null) && (SelectSqlBuffer.length() > 0))
		{
			SelectSqlBuffer.delete(0,SelectSqlBuffer.length());
		}
		
		%>
</tr>
	<tr><td colspan="4">
		<jsp:include page="../../eFM/jsp/FMFileSearchComponentValues.jsp" ><jsp:param name="flush" value="true" />
			<jsp:param name="frame_name" value="parent.f_query_add_mod.FMChngStrLocnCriteriaFrame"/>
			<jsp:param name="frame_name1" value="parent.FMChngStrLocnCriteriaFrame"/>
			<jsp:param name="form_name" value="FMChngStrLocnCriteriaForm"/>
			<jsp:param name="messageframe_name" value="parent.parent.messageFrame"/>
			<jsp:param name="patientid_name" value="patient_id"/>
			<jsp:param name="fileno_name" value="file_no"/>
			<jsp:param name="filetype_name" value="file_type_code"/>
			<jsp:param name="document_type_name" value="doc_type_code"/>
			<jsp:param name="document_folder_id_name" value="doc_folder_id"/>
			<jsp:param name="volumeno_name" value="volume_no"/>
			<jsp:param name="table_width" value="100"/>
			<jsp:param name="tablealign" value="CENTER"/>
			<jsp:param name="locn_code" value="fs_locn_code"/>
			<jsp:param name="file_mandatory_yn" value="Y"/>
			<jsp:param name="patientid_mandatory_yn" value="N"/>
		</jsp:include>
	</td>
	</tr>
	<tr>
	<%if(maintain_doc_or_file.equals("F")){%>
		<td class='label'><fmt:message key="eFM.FileCreationDate.label" bundle="${fm_labels}"/>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='text' name='file_date' id='file_date' value='' size='10' maxlength='10' onBlur='validDateObj(this,"DMY","<%=localeName%>");setDate(this);checkdate(this);'><img tabindex=-1 src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('file_date');"></td>
		<td class='label'><fmt:message key="eFM.FileCreationDate.label" bundle="${fm_labels}"/>&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='text'  name='to_file_date' id='to_file_date' value='' size='10' maxlength='10' onBlur='validDateObj(this,"DMY","<%=localeName%>");setDate(this);checkdate(this);'><img tabindex=-1 src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('to_file_date');"></td>
			<%}else if(maintain_doc_or_file.equals("D")){%>
			<td colspan='2'></td>
			<%}%>
	</tr>
	<tr>
		<td class='label' ><b><fmt:message key="Common.change.label" bundle="${common_labels}"/></b></td>
		<td class='fields' colspan='2'><table width="70%" style="width:62%;border-collapse: collapse;margin: 20px 0;border: 2px solid black; float: left;">
						  <tr>
							<td class="oaBorder"   ><span class='label'><input type='radio' name='tdlocn'  value='P' checked id='tdlocn' onClick='clearVal();'><fmt:message key="eFM.PermanentFSLocation.label" bundle="${fm_labels}"/>&nbsp;&nbsp;&nbsp;<input type='radio' name='tdlocn'  value='C' id='tdlocn' onClick='clearVal();'><fmt:message key="eFM.CurrentFSLocation.label" bundle="${fm_labels}"/></span></td>
							<td width='15%'>&nbsp;</td>
						  </tr>
						</table></td>
		<td class='label'></td>
	</tr>
	<tr>
		<td colspan='1' ></td>
		<td class='fields'  ></td>
		<td colspan='2' ></td>
	</tr>
	<tr>
		<td colspan='4' class='button' style="text-align:right;"><input type='button' class='button' name='search_dtl' id='search_dtl' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick='return fetchResults();'><input type='button' class='button' name='reset1' id='reset1' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick='clearVal()'><td>
	</tr>
</table>
<script>
var val = '<%=fs_locn_code%>';
if ('<%=count%>' == 1)
{
	document.forms[0].fs_locn_code.value = '<%=fs_locn_code%>';
}
</script>
	<input type='hidden' name='user_security_yn' id='user_security_yn' value='<%=user_security_yn%>' >
	<input type='hidden' name='p_access_all' id='p_access_all' value='<%=p_access_all%>' >
    <input type='hidden' name='status' id='status' value=''>
    <input type='hidden' name='fileno' id='fileno' value=''>
    <input type='hidden' name='volno' id='volno' value=''>
    <input type='hidden' name='whereClause1' id='whereClause1' value=''>
  <input type='hidden' name='row_cnt' id='row_cnt' value=''>
   <input type='hidden' name='added_temp_codekey' id='added_temp_codekey' value=''>
</form>
<%
	if(rs!=null)	  rs.close();
	if(rs1!=null)	  rs1.close();
	if(stmt!= null)   stmt.close();
	if(pstmt!= null)  pstmt.close();
	}
	catch(Exception e1)
	{
		out.println("Exception e1 :"+e1);
	}
	finally
	{		
		ConnectionManager.returnConnection(con, request);
	}
%>
</body>
</html>

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

